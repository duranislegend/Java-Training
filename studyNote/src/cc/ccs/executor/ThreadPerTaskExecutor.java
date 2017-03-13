/**
 * 
 */
package cc.ccs.executor;

import java.util.concurrent.Executor;

/**
 * @author congyang
 *
 */
public class ThreadPerTaskExecutor  implements Executor{

	@Override
	public void execute(Runnable r) {
		// TODO Auto-generated method stub
		new Thread(r).start();
		
	}

	
}
