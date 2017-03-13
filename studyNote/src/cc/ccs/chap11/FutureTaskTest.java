package cc.ccs.chap11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/*
 * FutureTask则是一个RunnableFuture<V>，即实现了Runnbale又实现了Futrue<V>这两个接口，另外它还可以包装Runnable和Callable<V>，
 * 所以一般来讲是一个符合体了，它可以通过Thread包装来直接执行，
 * 也可以提交给ExecuteService来执行，并且还可以通过v get()返回执行结果，在线程体没有执行完成的时候，主线程一直阻塞等待，执行完则直接返回结果。 */
public class FutureTaskTest {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        Callable<String> task = new Callable<String>() {  
            public String call() {  
                System.out.println("Sleep start.");  
                try {  
                    Thread.sleep(1000 * 10);  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
                System.out.println("Sleep end.");  
                return "time=" + System.currentTimeMillis();  
            }  
        };  
          
        //直接使用Thread的方式执行  
        FutureTask<String> ft = new FutureTask<String>(task);  
        Thread t = new Thread(ft);  
        t.start();  
        try {  
            System.out.println("waiting execute result");  
            System.out.println("result = " + ft.get());  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
        //使用Executors来执行  
        System.out.println("=========");  
        FutureTask<String> ft2 = new FutureTask<String>(task);  
        Executors.newSingleThreadExecutor().submit(ft2);  
        try {  
            System.out.println("waiting execute result");  
            System.out.println("result = " + ft2.get());  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
}  
/*
 * 执行结果如下： 

Sleep start.  
Sleep end.  
result = time=1370844662537  
=========  
waiting execute result  
Sleep start.  
Sleep end.  
result = time=1370844672542  */
