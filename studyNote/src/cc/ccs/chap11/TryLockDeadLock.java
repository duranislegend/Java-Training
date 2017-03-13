package cc.ccs.chap11;

import java.util.concurrent.locks.*;

class ResourceN {
	private Lock lock = new ReentrantLock();
	private String name;
	private int age;

	ResourceN(String name, int age) {
		this.name = name;
		this.age = age;
	}

	int getAge() {
		System.out.println(age);
		return ++age;
	}

	void cooperate(ResourceN res) {
		while (true) {
			boolean thisLock = this.lock.tryLock();
			boolean resLock = res.lock.tryLock();
			try {
				if (thisLock && resLock) {
					res.getAge();
					System.out.printf("ÎÒ  %s ÕûºÏ Äã %s \n", this.name, res.name);
					break;
				}
			} finally {
				if (thisLock)
					this.lock.unlock();
				if (resLock)
					res.lock.unlock();

			}
		}

	}
}

public class TryLockDeadLock {
	public static void main(String[] args) {
		final ResourceN res1 = new ResourceN("ka", 10);
		final ResourceN res2 = new ResourceN("kaka", 20);
		Thread thr1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++)
					res1.cooperate(res2);
			}
		};
		Thread thr2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++)
					res2.cooperate(res1);
			}
		};
		thr1.start();
		thr2.start();

	}

}
