/**
 * 
 */
package cc.ccs.executor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author congyang
 *
 */
public class Param {
	public static String path ;
	private static Properties pro = new Properties();
	private InputStream in;
	
	private static Logger logger = Logger.getLogger(Param.class);
	static {
		getParam();
	};
	public static void getParam() {
		String s = System.getProperty("user.dir") + File.separator + "config" + File.separator + "ds.properties";
		try(InputStream in = new BufferedInputStream(new FileInputStream(s))){
			pro.clear();
			pro.load(in);
			System.out.println(pro.entrySet().iterator().toString());
			if(pro.containsKey("path")){
				path = pro.getProperty("path");
			}
			logger.info("000");
		}
		catch(FileNotFoundException e ){
			logger.info(e.getMessage());
		}catch(IOException ei){
			logger.info(ei.getMessage());
		}
	}

	public static String getPath(){
		return path;
	}

}
