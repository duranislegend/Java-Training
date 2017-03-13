/**
 * 
 */
package lcy.ccdn.note;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author congyang
 *
 */
public class ScheduledExecutorServiceDemo {
	public static void main(String... args){
		Date date = new Date();
		System.out.println(date);
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		/*scheduledExecutorService.scheduleWithFixedDelay(new Runnable(){
			@Override
			public void run(){
				Date date = new Date();
				System.out.println(date);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 2000, 1000, TimeUnit.MILLISECONDS);*/
		scheduledExecutorService.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run(){
				System.out.println(new java.util.Date());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 1000, 3000, TimeUnit.MILLISECONDS);
	}
}
