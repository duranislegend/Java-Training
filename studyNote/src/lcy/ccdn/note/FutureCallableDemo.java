/**
 * 
 */
package lcy.ccdn.note;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author congyang
 *
 */
public class FutureCallableDemo {
	public static long fibonacii(long n){
		if(n <= 1){
			return n;
		}else{
			return fibonacii(n - 1) + fibonacii(n - 2);
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FutureTask<Long> futureTask = new FutureTask<>(new  Callable<Long>(){
			@Override
			public Long call(){
				return fibonacii(30);
			}
		});
		System.out.println("我一会来拿30个费波拉契数");
		new Thread(futureTask).start();
			try {
				Thread.sleep(5000);
				System.out.printf("数：%d%n", futureTask.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
