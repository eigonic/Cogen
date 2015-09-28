/**
 * 
 */
package net.sf.cogen.parser;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.cogen.app.Settings;
import net.sf.cogen.model.DB;
import net.sf.cogen.model.DBColumn;
import net.sf.cogen.model.DBFK;
import net.sf.cogen.model.DBTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * parser for connecting to the DB directly.
 * @author Amr.ElAdawy
 *
 */
public class DBParser
{
	private static final Logger logger = LoggerFactory.getLogger(DBParser.class);

	/**
	 * 
	 */
	public DBParser()
	{
	}

	public static DB parseTables()
	{
		logger.debug("parseTables() - start");

		DB db = new DB();
		db.setModelPackage(Settings.DB_MODEL_PACKAGE);
		ArrayList<DBTable> dbTables = new ArrayList<DBTable>();
		db.setDbTables(dbTables);
		try
		{
			Connection dbConn = getConnection(Settings.DB_URL, Settings.DB_USERNAME, Settings.DB_PASSWORD);

			DatabaseMetaData meta = dbConn.getMetaData();
			String schema = Settings.DB_SCHEMA == "" ? null : Settings.DB_SCHEMA;
			ResultSet tableRes = meta.getTables(null, schema, null, new String[]
			{ "TABLE" });
			while (tableRes.next())
			{
				String tableName = tableRes.getString("TABLE_NAME"), tableCat = tableRes.getString("TABLE_CAT"), tableSchema = tableRes
						.getString("TABLE_SCHEM");
				DBTable dbTable = new DBTable();
				dbTable.setName(tableName);

				HashMap<String, Integer> pks = new HashMap<String, Integer>();
				ResultSet pkRes = meta.getPrimaryKeys(null, null, tableName);
				while (pkRes.next())
				{
					pks.put(pkRes.getString("COLUMN_NAME"), 1);
				}
				try
				{
					pkRes.close();
				}
				catch (Throwable t)
				{

				}

				ResultSet colRes = meta.getColumns(tableCat, tableSchema, tableName, null);
				while (colRes.next())
				{
					DBColumn dbColumn = new DBColumn();
					dbColumn.setName(colRes.getString("COLUMN_NAME"));
					dbColumn.setPrimaryKey(pks.containsKey(dbColumn.getName()));
					if (dbColumn.isPrimaryKey())
						dbTable.addPk(dbColumn);
					dbColumn.setRequired("yes".equalsIgnoreCase(colRes.getString("IS_NULLABLE")));
					dbColumn.setSize(Integer.parseInt(colRes.getString("COLUMN_SIZE")));
					dbColumn.setType(colRes.getString("TYPE_NAME"));

					dbTable.getColumns().add(dbColumn);
				}
				try
				{
					colRes.close();
				}
				catch (Throwable t)
				{

				}

				ResultSet fkRes = meta.getImportedKeys(tableCat, tableSchema, tableName);
				while (fkRes.next())
				{
					DBFK dbfk = new DBFK();
					dbfk.setForeign(fkRes.getString("PKCOLUMN_NAME"));
					dbfk.setForeignTable(fkRes.getString("PKTABLE_NAME"));
					dbfk.setLocal(fkRes.getString("FKCOLUMN_NAME"));
					dbTable.getFks().put(dbfk.getLocal(), dbfk);
				}

				dbTables.add(dbTable);
			}
			try
			{
				tableRes.close();
			}
			catch (Throwable t)
			{

			}
		}
		catch (Exception e)
		{
			logger.warn("parseTables() - exception ignored", e);

		}

		logger.debug("parseTables() - end");
		return db;
	}

	private static Connection getConnection(String url, String username, String password) throws Exception
	{
		logger.debug("getConnection(url={}, username={}, password={}) - start", url, username, password);

		if (url.toLowerCase().contains("oracle"))
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		else if (url.toLowerCase().contains("mysql"))
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		else if (url.toLowerCase().contains("postgresql"))
			DriverManager.registerDriver(new org.postgresql.Driver());
		else if (url.toLowerCase().contains("sqlserver"))
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		else
			throw new RuntimeException("DB is not supported : " + url);

		return DriverManager.getConnection(url, username, password);
	}
}
