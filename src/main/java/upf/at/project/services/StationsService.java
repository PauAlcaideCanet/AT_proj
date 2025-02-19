package upf.at.project.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import upf.at.project.bicing.*;
import upf.at.project.clients.StationsRestClient;

@Path("/stations")
public class StationsService {
	
	static Data data = new Data();
	@GET
	@Path("/get")
	//Produces cached bicing information, if no cache, recover from bicing API
	@Produces(MediaType.APPLICATION_JSON)
	public Data getStations() {
		data = StationsRestClient.getData();
		return data;
	}
}
