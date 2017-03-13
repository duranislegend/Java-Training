package cc.ccs.chap11;

public class Clerk {
	private int product = -1;
	public synchronized void setProduct(int product){
		while(this.product != -1){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.product = product;
		System.out.printf("生产者设定：%d\n",product);
		notify();
	}
	
	public synchronized int getProduct(){
		while(this.product == -1){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		int p = this.product;
		System.out.printf("消费者设定：%d\n", p);
		product = -1;
		notify();
		return p;
	}

}
