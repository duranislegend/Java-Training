package cc.ccs.chap11;

import java.util.concurrent.ForkJoinPool;

class Finonacii extends java.util.concurrent.RecursiveTask<Long>{
	final long n;
	Finonacii(long n ){
		this.n = n;
	}
	@Override
	public Long compute() {
		// TODO Auto-generated method stub
		if(n < 10){
			return Finonacii.finonacii(n);
		}
		Finonacii f1 = new Finonacii(n -1);
		f1.fork();
		Finonacii f2 = new Finonacii(n - 2);
		return f2.compute() + f1.join();
	}
	static long finonacii(long n){
		if(n < 0){
			return -1;
		}else if(n <= 1){
			return n;
		}else {
			return finonacii(n -1) + finonacii(n - 2);
		}
	}
	
}
public class RecursiveTask2ForkJoinPool {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Finonacii finonacii = new Finonacii(45);
		System.out.println(forkJoinPool.invoke(finonacii));
	}
	
}
