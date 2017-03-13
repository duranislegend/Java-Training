package cc.ccs.anonymous;
public class clientEvent{
	private client client;
	public clientEvent(client client){
		this.client = client;
	}
	public String getName(){
		return client.name;
	}
	public String getIp(){
		return client.ip;
	}
}