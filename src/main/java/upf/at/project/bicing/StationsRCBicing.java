package upf.at.project.bicing;

import java.util.Date;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.apache.log4j.Logger;

public class StationsRCBicing {
	
	private Data data;
    private Date lastUpdateTime;
    private static final long TIMEOUT = 120_000;
    final static Logger logger = Logger.getLogger(StationsRCBicing.class);
	
	public Data getData() {
		
		Client client = ClientBuilder.newClient();
		WebTarget targetGet = client.target("https://opendata-ajuntament.barcelona.cat")
				.path("/data/dataset/6aa3416d-ce1a-494d-861b7bd07f069600/resource/1b215493-9e63-4a12-8980-2d7e0fa19f85/download");
		if(data == null || lastUpdateTime == null || (new Date().getTime() - lastUpdateTime.getTime()) > TIMEOUT) {
			data = targetGet.request(MediaType.APPLICATION_JSON_TYPE).
					header("Authorization", "5fbf9a6fa8f1b0fba915e7891a4b5aa807e6c257520cb8d5ad5e3dfc9846677a")
					.get(new GenericType<Data>() {});
			lastUpdateTime = new Date();
		}
		logger.debug("Stations: " + data);
		return data;
		
	}
}
