package cc.ccs.anonymous;
public class Anonymous{
	public static void main(String args[]){
		clientQueue queue = new clientQueue();
		queue.addListener(new clientListener(){
			@Override
			public void clientAdded(clientEvent cvent){
				System.out.printf("%s 连接到 %s\n", cvent.getName(),cvent.getIp());
			}
			
			@Override
			public void clientRemoved(clientEvent cevent) {
				System.out.printf("%s 从 %s 断开\n", cevent.getName(),cevent.getIp());
				
			}});
		client kaka = new client("Duran","128.196.11.1");
		client monik = new client("huang","家");
		queue.add(kaka);
		queue.add(monik);
		queue.remove(kaka);
		queue.remove(monik);
		//System.out.println(clientListener.x);
	}

}