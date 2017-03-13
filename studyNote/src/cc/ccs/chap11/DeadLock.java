package cc.ccs.chap11;

class Resource{
	private String name;
	private int age;
	public Resource(String name , int age){
		this.name = name;
		this.age = age;
	}
	synchronized 
	int doSome(){
		System.out.println(age);
		return ++age;
	}
	synchronized
	void cooperate(Resource res){
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		res.doSome();
		System.out.printf("��:%s ���� �� :%s\n",this.name,res.name);
		
	}
}

public class DeadLock {
	public static void main(String[] args){
	final Resource res1 = new Resource("kaka",10);
	final Resource res2 = new Resource("duran",20);
	Thread thread1 = new Thread(){
		@Override
		public void run(){
			for(int i = 0; i < 2; i++){
				res1.cooperate(res2);
			}
		}
	};
	Thread thread2 = new Thread(){
		@Override
		public void run(){
			for(int i = 0; i < 2; i++){
				res2.cooperate(res1);
			}
		}
	};
	thread1.start();
	thread2.start();
	}
}
