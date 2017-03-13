package cc.ccs.chap11;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleWithFiexedDelay {
	public static void main(String[] args){
		System.out.println(new Date());
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleWithFixedDelay(new Runnable(){
			public void run(){
				System.out.println(new Date());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},1000,1000,TimeUnit.MILLISECONDS);
	}

}
