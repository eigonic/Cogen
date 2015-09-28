package net.sf.cogen.model;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.cogen.app.StringUtil;

public class DBTable
{
	String name;

	String propertyName;

	String className;
	String friendlyName;

	ArrayList<DBColumn> columns = new ArrayList<DBColumn>();
	HashMap<String, DBFK> fks = new HashMap<String, DBFK>();

	ArrayList<DBColumn> pks = new ArrayList<DBColumn>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
		this.propertyName = StringUtil.convertUnderscoreNameToPropertyName(this.name);
		this.className = StringUtil.convertUnderscoreNameToClassName(this.name);
		this.friendlyName = StringUtil.convertUnderscoreNameToFriendlyName(this.name);
	}

	public ArrayList<DBColumn> getColumns()
	{
		return columns;
	}

	public void setColumns(ArrayList<DBColumn> columns)
	{
		this.columns = columns;
	}

	public ArrayList<DBColumn> getPks()
	{
		return pks;
	}

	public void addPk(DBColumn pk)
	{
		if (!pks.contains(pk))
			pks.add(pk);
	}

	public HashMap<String, DBFK> getFks()
	{
		return fks;
	}

	public void setFks(HashMap<String, DBFK> fks)
	{
		this.fks = fks;
	}

	public String getClassName()
	{
		return className;
	}

	public String getFriendlyName()
	{
		return friendlyName;
	}

	public String getPropertyName()
	{
		return propertyName;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("DBTable [name=");
		builder.append(name);
		builder.append(", columns=");
		builder.append(columns);
		builder.append(", fks=");
		builder.append(fks);
		builder.append(", pk=");
		builder.append(pks.size());
		builder.append("]");
		return builder.toString();
	}

}
