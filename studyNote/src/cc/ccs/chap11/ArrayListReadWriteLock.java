package cc.ccs.chap11;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListReadWriteLock {
	private Object[] objects;
	private int next;
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	ArrayListReadWriteLock(int capacity) {
		objects = new Object[capacity];
	}

	ArrayListReadWriteLock() {
		this(16);
	}

	void add(Object o){
		try {
			lock.writeLock().lock();
			if (next == objects.length) {
				objects = Arrays.copyOf(objects, objects.length * 2);
			}
			objects[next++] = o;
		} finally {
			lock.writeLock().unlock();
		}
	}
	Object get(int next){
		try{
			lock.readLock().lock();
			return objects[next];
		}finally{
			lock.readLock().lock();
		}
	}
	int size(){
		try{
			lock.readLock().lock();
			return next;
		}finally{
			lock.readLock().unlock();
		}
	}
}
