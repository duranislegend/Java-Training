package cc.ccs.chap11;

 class Producer implements Runnable  {
	 private Clerk clerk;
	 public Producer(Clerk clerk){
		 this.clerk = clerk;
	 }
	 @Override
	 public void run(){
		 System.out.println("生产者生产开始：");
		 for(int product = 1; product <= 10; product++){
			 try{
				 Thread.sleep((int)Math.random() * 3000);
			 }catch(InterruptedException e){
				 throw new RuntimeException(e);
			 }
			 clerk.setProduct(product);
		 }
	 }

}
