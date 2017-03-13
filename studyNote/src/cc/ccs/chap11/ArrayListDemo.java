package cc.ccs.chap11;

import java.text.SimpleDateFormat;
import java.util.Date;

import cc.ccs.chap6.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args){
	final ArrayList list = new ArrayList();
	final SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD HH-MM-SS");
	
	Thread thread1 = new Thread(){
		@Override
		public void run(){
			int i = 10;
			while(i-- > 0){
				synchronized(list){
					list.add(1);
					System.out.printf("1 %s\n",df.format(new Date()));
				}
			}
		}
	};
	Thread thread2 = new Thread(){
		@Override
		public void run(){
			int j = 10;
			while(j-- > 0){
				synchronized(list){
					list.add(2);
					System.out.printf("2 %s\n",df.format(new Date()));
				}
			}
		}
	};
	thread1.start();
	try {
		thread1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	thread2.start();
	
	try {
		thread2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.printf("size:%d\n",list.size());
	System.out.println("list:");
	for(int i = 0; i < list.size(); i ++){
		System.out.println(list.get(i));
	}

	}
}

