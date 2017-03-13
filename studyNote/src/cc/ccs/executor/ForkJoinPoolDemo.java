/**
 * 
 */
package cc.ccs.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author congyang
 *
 */
class ForkJoinTaskOperator extends RecursiveTask<Long>{
	long n ;
	ForkJoinTaskOperator(long n){
		this.n = n;
	}
	@Override
	public Long compute(){
		if(n < 10){
			return fibonacci(n);
		}
		ForkJoinTaskOperator f1 = new ForkJoinTaskOperator(n - 1);
		f1.fork();
		ForkJoinTaskOperator f2 = new ForkJoinTaskOperator(n - 2);
		return f2.compute() + f1.join();
	}
	private Long fibonacci(long n){
		if(n <= 1){
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
public class ForkJoinPoolDemo {
	public static void main(String ... args){
		
		ForkJoinPool es = new ForkJoinPool();
		ForkJoinTaskOperator fjpd = new ForkJoinTaskOperator(30);
		System.out.println(es.invoke(fjpd));
	}
}
