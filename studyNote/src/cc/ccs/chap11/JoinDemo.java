package cc.ccs.chap11;

import java.util.Scanner;

public class JoinDemo {
	public static void main(String[] args){
		System.out.println("Main Thread begin");
		Thread threadB = new Thread(){
			@Override 
			public void run(){
				System.out.println("threadB begin");
				for(int i = 0; i < 5; i++){
						try {
							Thread.sleep(2000);
							System.out.println("please input:");
							Scanner scanner = new Scanner(System.in);
							System.out.println(scanner.nextLine());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println("threadB execute");
				}
				System.out.println("threadB end");
			}
		};
		
		try {
			/*Thread.sleep(2000);
			System.out.println("wait b");
			threadB.join();*/
			Thread.sleep(1000);
			//threadB.interrupt();
			threadB.setDaemon(true);
			threadB.start();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedE");
		}
		System.out.println("Main Thread end");
	}

}
