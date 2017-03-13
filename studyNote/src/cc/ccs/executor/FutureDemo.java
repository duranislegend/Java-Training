/**
 * 
 */
package cc.ccs.executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import static java.lang.System.out;

/**
 * @author congyang
 *
 */
class Finaciic {
	static long finaciic(long n){
		if(n <= 1){
			return n;
		}else{
			return finaciic(n - 2) + finaciic(n - 1);
		}
	}
}
class CallOperator implements Callable{
	long n;
	CallOperator(long n){
		this.n = n;
	}
	@Override
	public Long call(){
		return Finaciic.finaciic(n);
	}
}
public class FutureDemo {

	public static void main(String... args) throws InterruptedException, ExecutionException {
		//线程池生成Future
		ExecutorService es = Executors.newCachedThreadPool();
		Future<Long> f = es.submit(new Callable<Long>() {
			@Override
			public Long call() {
				return Finaciic.finaciic(30);
			}
		});
		List<Callable<Long>> lists = new ArrayList<>();
		Callable<Long> c1 = new CallOperator(10);
		Callable<Long> c2 = new CallOperator(15);
		Callable<Long> c3 = new CallOperator(20);
		lists.add(c1);
		lists.add(c2);
		lists.add(c3);
		List<Future<Long>> ls = es.invokeAll(lists);
		Iterator<Future<Long>> it = ls.iterator();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(it.hasNext()){
			Future<Long> future = it.next();
			if(future.isDone()){
				out.printf("费式数：%s%n",future.get());
			}
		}
		//单线程用FutureTask
		/*FutureTask<Long> future = new FutureTask<>(new Callable<Long>() {
			@Override
			public Long call() {
				return Finaciic.finaciic(30);
			}
		});
		out.println("老板，一会来拿三十个斐波拉契数");
		Thread ft = new Thread(future);
		ft.start();
		out.println("忙别的事去了...");*/
		/*
		 * try{ ft.setDaemon(false); }catch(IllegalThreadStateException e){
		 * out.printf("报错：%s%n",e.getMessage()); }
		 */
		/*
		 * try { ft.join(); } catch (InterruptedException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		//if (future.isDone()) {
			// isDone方法生效
			/*try {
				//out.printf("三十个斐波拉契数是:%d", future.get());
				out.printf("三十个斐波拉契数是:%d", f.get());
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				out.println("---");
				e.printStackTrace();
			}*/
		//}
	}
}
