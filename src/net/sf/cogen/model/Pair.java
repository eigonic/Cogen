/**
 * 
 */
package net.sf.cogen.model;

import org.apache.openjpa.lib.jdbc.SQLFormatter;

/**
 * @author Amr.ElAdawy
 *
 */
public class Pair
{
	String key, value;

	@Override
	public String toString()
	{
		return new StringBuilder(key).append("=").append(value).toString();
	}

	public Pair(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	public String getXml()
	{
		return new StringBuilder("<entry key=\"").append(key).append("\">\r\n").append("<![CDATA[\r\n")
				.append((formatSql ? new SQLFormatter().prettyPrint(value) : value)).append("\r\n]]>\r\n").append("</entry>").toString();
	}

	boolean formatSql;

	public Pair setFormatSql(boolean formatSql)
	{
		this.formatSql = formatSql;
		return this;
	}

}
