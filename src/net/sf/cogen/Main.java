/**
 * 
 */
package net.sf.cogen;

import java.io.File;

import net.sf.cogen.app.Generator;
import net.sf.cogen.model.DB;
import net.sf.cogen.parser.DBParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Amr.ElAdawy
 *
 */
public class Main
{
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	/**
	 * 
	 */
	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		logger.debug("main(args=" + args + ") - start");

		try
		{
			Long start = System.currentTimeMillis();
			File file = new File("D:\\FL\\daroo2\\src\\main\\resources\\dbre.xml");
			//			DB db = DBREParser.parseTables(new FileInputStream(file));
			DB db = DBParser.parseTables();
			new Generator().generateArtifacts(db);
			System.out.println("done in " + (System.currentTimeMillis() - start));
		}
		catch (Exception e)
		{
			logger.error("main(args=" + args + ")", e);
		}

		logger.debug("main(args) - end");
	}
}
