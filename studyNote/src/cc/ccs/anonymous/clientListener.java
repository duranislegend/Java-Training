package cc.ccs.anonymous;

public interface clientListener {
	//int x = 10;
	void clientAdded(clientEvent cevent);
	void clientRemoved(clientEvent cevent);
}
