/**
 * 
 */
package cc.ccs.executor;

import java.util.concurrent.Executor;

/**
 * @author congyang
 *
 */
public class DircetExecutor implements Executor{
	@Override
	public void execute(Runnable r){
		r.run();
	}

	
}
