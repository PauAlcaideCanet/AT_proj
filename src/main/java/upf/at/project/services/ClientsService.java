package upf.at.project.services;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import upf.at.project.clients.User;
import upf.at.project.clients.Users;

@Path("/clients")
public class ClientsService {
	
	static Users clients = new Users();
	@POST
	@Path("/subscribe")
	@Consumes(MediaType.APPLICATION_JSON)
	//Consumes the client number, telegram token and list of stations ids
	public Response subscribe(User client) {
		try {
			clients.subscribeClient(client);
			return Response.ok("You have successfully subscribed!").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						   .entity("There has been a problem in the subscription process")
						   .build();
		}
	}
	
	@GET
	@Path("/getClients")
	@Produces(MediaType.APPLICATION_JSON)
	//Produces telegram token and stations ids
	public List<User> getClients() {
		return clients.getClients();
	}
}
