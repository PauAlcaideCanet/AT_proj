package upf.at.project.services;

import javax.ws.rs.*;

@Path("/notifier")
public class NotifierService {
	
	@POST
	@Path("/slots")
	//Consumes phone number
	//Produces telegram message with free slots on the suscribed stations
	public int getSlots() {
		return 0;
	}
	
	@POST
	@Path("/airQuality")
	//Consumes client device ip and phone number
	//Produces telegram message with real time air quality information
	public int getAirQuality() {
		return 0;
	}
}
