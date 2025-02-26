package upf.at.project.notifier;

import java.io.StringReader;

import javax.json.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class Aqi {
	
	private static final String IP_API_URL = "http://ip-api.com/json/";
	private static final String AQICN_API_URL = "https://api.waqi.info/feed/";
	private static final String AQICN_API_TOKEN = "6323fb8688353b07cf821ad2e5a9135eaf8399dd";
	
	public String getCityFromIP(String ip) {
		try {
			
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(IP_API_URL + ip + "?fields=status,message,city");
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
    		
            JsonReader reader = Json.createReader(new StringReader(response));
            JsonObject jsonObject = reader.readObject();

            String data = jsonObject.getString("city");
            
            System.out.println("City: " + data);
    		return data;

        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }
        return null;
    }

    public int getAQIFromCity(String city) {
        try {
        	
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(AQICN_API_URL + city + "/?token=" + AQICN_API_TOKEN);
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            
            JsonReader reader = Json.createReader(new StringReader(response));
            JsonObject jsonObject = reader.readObject();

            JsonObject data = jsonObject.getJsonObject("data");
            int aqin = data.getInt("aqi");
            
    		System.out.println("aqi: " + aqin);
            return aqin;

        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }
        return -1;
    }

    public String getAQIDescription(int aqi) {
        if (aqi <= 50) return "Good 🟢";
        else if (aqi <= 100) return "Moderate 🟡";
        else if (aqi <= 150) return "Unhealthy for Sensitive Groups 🟠";
        else if (aqi <= 200) return "Unhealthy 🔴";
        else if (aqi <= 300) return "Very Unhealthy 🟣";
        else return "Hazardous ⚫";
    }
}
