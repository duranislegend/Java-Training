/**
 * 
 */
package cc.ccs.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author congyang
 *
 */
public class ScheduledThreadPoolDemo {
	public static void main(String... args){
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
		System.out.printf("%s%n", sdf.format(date));
		//ses.scheduleWithFixedDelay(new Runnable(){
		  ses.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run(){
				try{
					
					System.out.printf("%s%n", new Date());
					
					Thread.sleep(5000);
					System.out.println("go");
				}catch(InterruptedException e){
					System.out.println(e.getMessage());
				}
			}
		},2000,3000,TimeUnit.MILLISECONDS);
		
	}

}
