package cc.ccs.chap11;
class ResourceBak{
	private String name;
	private int resource;
	ResourceBak(String name,int resource){
		this.name = name;
		this.resource = resource;
	}
	String getName(){
		return name;
	}
	synchronized int doSome(){
		return resource++;
	}
	synchronized void coorperate(ResourceBak resource){
		resource.doSome();
		System.out.printf("%s:%d ,%s:%d%n ",this.getName(),this.doSome(),resource.getName(),resource.doSome());
		
	} 
}

public class SynchronizedLockDeath {
	public void main(String... args){
		final ResourceBak res1 = new ResourceBak("duran",10);
		final ResourceBak res2 = new ResourceBak("Rose",20);
		Thread th1 = new Thread(){
			@Override
			public void run(){
				res1.coorperate(res2);
			}
		};
		Thread th2 = new Thread(){
			@Override
			public void run(){
				res2.coorperate(res1);
			}
		};
		th1.start();
		th2.start();
		
		
	}

}
