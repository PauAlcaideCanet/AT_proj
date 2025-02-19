package upf.at.project.clients;

import java.util.*;

public class Users {
	private static List<User> clients = new ArrayList<>();
	
	public void subscribeClient(User client) {
		clients.add(client);
	}
	
	public List<User> getClients(){
		return clients;
	}
}
