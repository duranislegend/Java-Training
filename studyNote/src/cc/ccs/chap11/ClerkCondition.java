package cc.ccs.chap11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class ClerkCondition {
	private Lock lock = new ReentrantLock();
	private Condition producerCondition = lock.newCondition();
	private Condition consumerCondition = lock.newCondition();
	int product = -1;
	void in(int product){
		try {
			this.lock.lock();

			while (this.product != -1) {
				try {
					producerCondition.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			this.product = product;
			System.out.printf("生产设定：%d\n", this.product);
			consumerCondition.signal();
		} finally {
			this.lock.unlock();
		}

	}
	int out(){
		try {
			this.lock.lock();

			while (this.product == -1) {
				try {
					consumerCondition.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			int p = this.product;
			System.out.printf("消费设定：%d\n", this.product);
			this.product = -1;
			producerCondition.signal();
			return p;
		} finally {
			this.lock.unlock();
		}
	}

}
