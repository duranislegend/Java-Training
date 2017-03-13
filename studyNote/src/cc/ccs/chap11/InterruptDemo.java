package cc.ccs.chap11;





public class InterruptDemo {
	public static void main(String[] args){
		Thread thread = new Thread(){
			@Override
			public void run(){
				try{
					Thread.sleep(10);
					}
				catch(InterruptedException i){
					System.out.println("xx");
				}
				
			}
		};
		thread.start();
		thread.interrupt();
	}

}
