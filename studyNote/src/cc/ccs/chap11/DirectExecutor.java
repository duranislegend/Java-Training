package cc.ccs.chap11;

import java.util.concurrent.Executor;

class DirectExecutor implements Executor {
	//���߳���һִ��ָ����ҳ������
	public void execute(Runnable r){
		r.run();
	}

}