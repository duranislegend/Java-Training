package lcy.ccdn.note;
class Clerk{
	//生产者和消费者模型中的过度者--店员，手里只有一个产品
	private int product = -1;
	public synchronized void setProduct(int product){
		//生产者可以调用该方法，存放产品
		while(this.product != -1){
			try{
				//线程有可能私自苏醒，wait()一定要在条件式成立的循环中
				wait();
			}catch(InterruptedException e){
				throw  new RuntimeException(e);
			}
		}
		this.product = product;
		System.out.printf("生产者生产：%d%n",this.product);
		notify();
	}
	public synchronized int getProduct(){
		//消费者可以调用该方法，消费产品
		while(this.product == -1){
			try{
				wait();
			}catch(InterruptedException e){
				throw new RuntimeException(e);
			}
		}
		int p = this.product;
		System.out.printf("消费者消费：%d%n",p);
		this.product = -1;
		notify();
		return p;
	}
}
class Producer implements Runnable{
	private Clerk clerk;
	Producer(Clerk clerk){
		this.clerk = clerk;
	}
	@Override
	public void run(){
		for(int i = 0; i < 10; i++){
			clerk.setProduct(i);
		}
	}
	
}
class Consumer implements Runnable{
	private Clerk clerk;
	Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	@Override
	public void run(){
		for(int j = 0; j < 10; j++){
			clerk.getProduct();
		}
	}
}

public class ProducerConsumerDemo {
	public static void main(String... args){
		Clerk clerk = new Clerk();
		new Thread(new Producer(clerk)).start();
		new Thread(new Consumer(clerk)).start();
	}

}
