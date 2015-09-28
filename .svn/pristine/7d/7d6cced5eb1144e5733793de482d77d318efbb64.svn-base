/**
 * 
 */
package net.sf.cogen.parser;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.cogen.model.DB;
import net.sf.cogen.model.DBColumn;
import net.sf.cogen.model.DBFK;
import net.sf.cogen.model.DBTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Parser for the Roo DBRE XML file.
 * @author Amr.ElAdawy
 *
 */
public class DBREParser
{
	private static final Logger logger = LoggerFactory.getLogger(DBREParser.class);

	public static DB parseTables(InputStream is)
	{
		logger.debug("parseTables(is=" + is + ") - start");

		DB db = new DB();
		ArrayList<DBTable> dbTables = new ArrayList<DBTable>();
		db.setDbTables(dbTables);
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			db.setModelPackage(((Element) doc.getDocumentElement()).getAttribute("package"));
			NodeList tableList = doc.getElementsByTagName("table");
			for (int i = 0; i < tableList.getLength(); i++)
			{
				Node tableNode = tableList.item(i);
				if (tableNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) tableNode;
					DBTable dbTable = new DBTable();
					dbTable.setName(eElement.getAttribute("name"));

					NodeList columnsList = tableNode.getChildNodes();
					for (int j = 0; j < columnsList.getLength(); j++)
					{
						Node columnNode = columnsList.item(j);
						if (columnNode.getNodeType() == Node.ELEMENT_NODE)
						{
							Element colElement = (Element) columnNode;
							if (colElement.getNodeName().equalsIgnoreCase("column"))
							{
								DBColumn dbColumn = new DBColumn();
								dbColumn.setName(colElement.getAttribute("name"));
								dbColumn.setPrimaryKey(Boolean.parseBoolean(colElement.getAttribute("primaryKey")));
								if (dbColumn.isPrimaryKey())
									dbTable.addPk(dbColumn);
								dbColumn.setRequired(Boolean.parseBoolean(colElement.getAttribute("required")));
								dbColumn.setScale(Integer.parseInt(colElement.getAttribute("scale")));
								dbColumn.setSize(Integer.parseInt(colElement.getAttribute("size")));
								dbColumn.setType(colElement.getAttribute("type"));

								dbTable.getColumns().add(dbColumn);
							}
							else if (colElement.getNodeName().equalsIgnoreCase("foreign-key"))
							{
								DBFK dbfk = new DBFK();
								dbfk.setForeignTable(colElement.getAttribute("foreignTable"));

								Element refElement = (Element) colElement.getElementsByTagName("option").item(0);
								// check that this is imported forigen key. 
								if ("exported".equalsIgnoreCase(refElement.getAttribute("key"))
										&& "false".equalsIgnoreCase(refElement.getAttribute("value")))
								{
									refElement = (Element) colElement.getElementsByTagName("reference").item(0);
									dbfk.setForeign(refElement.getAttribute("foreign"));
									dbfk.setLocal(refElement.getAttribute("local"));
									dbTable.getFks().put(dbfk.getLocal(), dbfk);
								}
							}
						}
					}
					dbTables.add(dbTable);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.warn("parseTables(is=" + is + ") - exception ignored", e);
		}

		logger.debug("parseTables(is) - end");
		return db;
	}
}
