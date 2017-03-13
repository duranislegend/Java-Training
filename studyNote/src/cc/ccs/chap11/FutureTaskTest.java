package cc.ccs.chap11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/*
 * FutureTask����һ��RunnableFuture<V>����ʵ����Runnbale��ʵ����Futrue<V>�������ӿڣ������������԰�װRunnable��Callable<V>��
 * ����һ��������һ���������ˣ�������ͨ��Thread��װ��ֱ��ִ�У�
 * Ҳ�����ύ��ExecuteService��ִ�У����һ�����ͨ��v get()����ִ�н�������߳���û��ִ����ɵ�ʱ�����߳�һֱ�����ȴ���ִ������ֱ�ӷ��ؽ���� */
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
          
        //ֱ��ʹ��Thread�ķ�ʽִ��  
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
          
        //ʹ��Executors��ִ��  
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
 * ִ�н�����£� 

Sleep start.  
Sleep end.  
result = time=1370844662537  
=========  
waiting execute result  
Sleep start.  
Sleep end.  
result = time=1370844672542  */
