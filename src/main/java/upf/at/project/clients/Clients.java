package upf.at.project.clients;

import java.util.*;

public class Clients {
	private static List<Client> clients = new ArrayList<>();
	
	public void subscribeClient(Client client) {
		clients.add(client);
	}
	
	public List<Client> getClients(){
		return clients;
	}
}
