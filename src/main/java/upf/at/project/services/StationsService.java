package upf.at.project.services;

import javax.ws.rs.*;

@Path("/stations")
public class StationsService {
	
	@GET
	@Path("/get")
	//Consumes
	//Produces cached bicing information, if no cache, recover from bicing API
	public int getStations() {
		return 0;
	}
}
