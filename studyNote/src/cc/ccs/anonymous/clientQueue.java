package cc.ccs.anonymous;
import java.util.ArrayList;
public class clientQueue{
	ArrayList<client> clients = new ArrayList();
	ArrayList<clientListener> listeners = new ArrayList();
	public void addListener(clientListener listener){
		listeners.add(listener);
	}
	public void add(client client){
		clients.add(client);
		clientEvent cvent = new clientEvent(client);
		for(clientListener listener : listeners){
			listener.clientAdded(cvent);
		}
	}
	public void remove(client client){
		clients.remove(client);
		clientEvent cvent = new clientEvent(client);
		for(clientListener listener : listeners){
			listener.clientRemoved(cvent);
		}
	}
}