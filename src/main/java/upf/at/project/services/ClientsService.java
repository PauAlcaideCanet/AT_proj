package upf.at.project.services;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import upf.at.project.clients.User;
import upf.at.project.clients.Users;

@Path("/clients")
public class ClientsService {
	
	static Users clients = new Users();
	@POST
	@Path("/subscribe")
	@Consumes(MediaType.APPLICATION_JSON)
	//Consumes the client number, telegram token and list of stations ids
	public void subscribe(User client) {
		clients.subscribeClient(client);
	}
	
	@GET
	@Path("/getClients")
	@Produces(MediaType.APPLICATION_JSON)
	//Produces telegram token and stations ids
	public List<User> getClients() {
		return clients.getClients();
	}
}
