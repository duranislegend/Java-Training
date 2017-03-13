package cc.ccs.chap11;

import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor implements Executor{
	//会针对每个网页，启动一个线程去处理。对于每个传入的Runnable实例，会建立一个Thread实例并执行
	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		new Thread(command).start();
		
	}

}
