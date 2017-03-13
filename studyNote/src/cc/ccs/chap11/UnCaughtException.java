package cc.ccs.chap11;

import java.lang.Thread.UncaughtExceptionHandler;

public class UnCaughtException {
	public static void main(String[] args){
		ThreadGroup threadGroup1   = new ThreadGroup("group1"){
			@Override
			public void uncaughtException(Thread thread, Throwable e){
				System.out.println(String.format("%s,%s", thread.getName(),e.getMessage()));
			}
		};
		
		Thread thread1 = new Thread(threadGroup1,new Runnable(){
			@Override
			public void run(){
				throw new RuntimeException("t1,测试异常");
			}
		});
		thread1.start();
		ThreadGroup threadGroup2   = new ThreadGroup("group1");
		Thread thread2 = new Thread(threadGroup2,new Runnable(){
			@Override
			public void run(){
				throw new RuntimeException("t2,测试异常");
			}
		});
		thread2.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
			@Override
			public void uncaughtException(Thread t,Throwable e){
				System.out.printf("%s,%s%n", t.getName(),e.getMessage());
			}
		});
		thread2.start();
		Thread thread3 = new Thread(threadGroup2,new Runnable(){
			@Override
			public void run(){
				throw new RuntimeException("t3,测试异常");
			}
		});
		thread3.start();
		
		
	}

}
