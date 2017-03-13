package cc.ccs.chap12;

import java.io.IOException;
import java.util.logging.*;

public class FileHandle {
	public static void main(String[] args){
		Logger logger = Logger.getLogger(FileHandle.class.getName());
		logger.setLevel(Level.INFO);
		try {
			FileHandler filehandler = new FileHandler("%h/config%g.log");
			filehandler.setLevel(Level.INFO);
			filehandler.setFormatter(new SimpleFormatter());
			logger.addHandler(filehandler);
			logger.log(Level.INFO, "info:xxx");
			logger.config("config");
			logger.info("info2��ccc");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	}

}
