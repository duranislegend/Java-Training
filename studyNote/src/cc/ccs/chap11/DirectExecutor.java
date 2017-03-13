package cc.ccs.chap11;

import java.util.concurrent.Executor;

class DirectExecutor implements Executor {
	//主线程逐一执行指定的页面下载
	public void execute(Runnable r){
		r.run();
	}

}