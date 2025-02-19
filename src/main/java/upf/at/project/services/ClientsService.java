package upf.at.project.services;

import javax.ws.rs.*;

import upf.at.project.clients.Clients;

@Path("/clients")
public class ClientsService {
	
	static Clients clients = new Clients();
	@POST
	@Path("/subscribe")
	//Consumes the client number, telegram token and list of stations ids
	public int subscribe(Clients client) {
		return 0;
	}
	
	@GET
	@Path("/getClients")
	//Consumes the client number
	//Produces telegram token and stations ids
	public int getClients() {
		return 0;
	}
}
