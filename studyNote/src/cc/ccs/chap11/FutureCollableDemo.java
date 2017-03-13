package cc.ccs.chap11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class FutureCollableDemo {
	static long fibonacci(long i){
		if(i <= 1){
			return i;
		}else{
			return fibonacci(i-1) + fibonacci(i-2);
		}
	}
	public static void main(String[] args) {
		FutureTask<Long> future = new FutureTask<>(
				new Callable<Long>(){
					public Long call(){
						return fibonacci(30);
					}
				} );
		System.out.println("来30个菲布拉契数，待会来拿");
		/* 由于FutueTask 也操作了Runnable接口，所以可以指定给Thread创建用
		 * */
		new Thread(future).start();
		try {
			Thread.sleep(5000);
			System.out.printf("finonacci(30):%d\n", future.get());
		} catch (InterruptedException |ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
