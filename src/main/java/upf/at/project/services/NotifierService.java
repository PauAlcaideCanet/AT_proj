package upf.at.project.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.*;

import upf.at.project.bicing.Data;
import upf.at.project.bicing.Station;
import upf.at.project.clients.StationsRCBicing;
import upf.at.project.clients.User;
import upf.at.project.notifier.Aqi;
import upf.at.project.notifier.Message;

@Path("/notifier")
public class NotifierService {
	
	static Data data = new Data();
	static StationsRCBicing bicing = new StationsRCBicing();
	long chatID = 6350445136L;
	@GET
	@Path("/slots/{phone}")
	//Consumes phone number
	//@Consumes(MediaType.APPLICATION_JSON)
	//Produces telegram message with free slots on the suscribed stations
	public String getSlots(@PathParam("phone") int phone) {
		
		List<User> clients = ClientsService.clients.getClients();
		User client = null;
		
		for(User u : clients) {
			if(u.getPhone() == phone) {
				client = u;
			}
		}
		
		if (client == null) {
	        System.out.println("User with phone " + phone + " not found.");
	        return "User with phone " + phone + " not found.";
	    }
		
		data = bicing.getData();
		List<Station> stations = data.getData().getStations();
		List<int[]> available = new ArrayList<>();
		
		for(Station station : stations) {
			if(client.getSubStationsId().contains(station.getStation_id())
					&& station.getNum_docks_available() > 0) {
				available.add(new int[]{station.getStation_id(),
						station.getNum_docks_available()});
			}
		}
		
		List<String> formattedAvailable = new ArrayList<>();
		for (int[] pair : available) {
		    formattedAvailable.add(Arrays.toString(pair));
		}
		
		Message message = new Message(chatID, formattedAvailable.toString());
		System.out.println("Avaliable: " + formattedAvailable);
		message.new_message(client.getTelegramToken());
		
		return "Avaliable: " + formattedAvailable;
	}
	
	@GET
	@Path("/airQuality/{ip}/{phone}")
	//Consumes client device ip and phone number
	@Consumes(MediaType.APPLICATION_JSON)
	//Produces telegram message with real time air quality information
	public String getAirQuality(@PathParam("ip") String ip, @PathParam("phone") int phone) {
		
		List<User> clients = ClientsService.clients.getClients();
		User client = null;
		
		for(User u : clients) {
			if(u.getPhone() == phone) {
				client = u;
			}
		}
		
		if (client == null) {
	        System.out.println("User with phone " + phone + " not found.");
	        return "User with phone " + phone + " not found.";
	    }
		
		Aqi aqi = new Aqi();
		// 1. Get City from IP
        String city = aqi.getCityFromIP(ip);
        if (city == null) {
            System.out.println("Failed to get city from IP.");
            return "Failed to get city from IP.";
        }

        // 2. Get AQI from City
        int aqindex = aqi.getAQIFromCity(city);
        if (aqindex == -1) {
            System.out.println("Failed to get AQI for city: " + city);
            return "Failed to get AQI for city: " + city;
        }

        // 3. Translate AQI to Description
        String aqiDescription = aqi.getAQIDescription(aqindex);

        // 4. Send Telegram Message
        String messageText = "City: " + city + ":\n" +
                             "AQI: " + aqindex + " (" + aqiDescription + ")";
                
        Message message = new Message(chatID, messageText);
        message.new_message(client.getTelegramToken());
        System.out.println("Sent AQI message: " + messageText);
        
        return messageText;
	}
}
