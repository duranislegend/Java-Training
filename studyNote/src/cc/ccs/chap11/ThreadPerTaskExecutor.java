package cc.ccs.chap11;

import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor implements Executor{
	//�����ÿ����ҳ������һ���߳�ȥ��������ÿ�������Runnableʵ�����Ὠ��һ��Threadʵ����ִ��
	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		new Thread(command).start();
		
	}

}
