package cc.ccs.chap12;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GLOBAL_LOGGER_NAME {
	public static void main(String[] args){
		Logger log = Logger.getLogger(GLOBAL_LOGGER_NAME.class.getName());
		Logger global = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		log.setLevel(Level.ALL);
		System.out.println(log.getLevel().intValue());
		System.out.println(global.getLevel());
		System.out.println(log.getParent().getLevel().intValue());
		System.out.println(global.getParent().getLevel().intValue());
		System.out.println(log.getHandlers().length);
		System.out.println(log.getParent().getHandlers().length);
		for(Handler handle : log.getParent().getHandlers()){
			handle.setLevel(Level.FINE);
			System.out.println(handle);
			System.out.println(handle.getLevel());
		}
		log.log(Level.WARNING, "warn:ddd");
		log.log(Level.INFO, "info:xxx");
		log.log(Level.CONFIG,"config:ccc");
		log.log(Level.FINE,"fine:fff");
		
	}

}
