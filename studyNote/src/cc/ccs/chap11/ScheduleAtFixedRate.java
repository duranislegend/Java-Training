package cc.ccs.chap11;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRate {
	public static void main(String[] args){
		System.out.println(new java.util.Date());
		java.util.concurrent.ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(new Runnable(){
			public void run(){
				System.out.println(new java.util.Date());
				try{
					Thread.sleep(2000);
				}catch(InterruptedException e){
					System.out.println(e.toString());
				}
			}
		},3, 3, TimeUnit.SECONDS);
	}
}
