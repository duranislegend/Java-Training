package cc.ccs.chap11;

 class Consumer implements Runnable  {
	 private Clerk clerk;
	 Consumer(Clerk clerk){
		 this.clerk = clerk;
	 }
	 @Override
	 public void run(){
		 System.out.println("生产者生产开始：");
		 for(int product = 0; product < 10; product++){
			 try{
				 Thread.sleep((int)Math.random() * 3000);
			 }catch(InterruptedException e){
				 throw new RuntimeException(e);
			 }
			 clerk.getProduct();
		 }
	 }

}
