package upf.at.project.clients;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import upf.at.project.bicing.Data;

public class StationsRestClient {
	static Client client = ClientBuilder.newClient();
	static WebTarget targetGet = client.target("https://opendata-ajuntament.barcelona.cat").path("/data/dataset/6aa3416d-ce1a-494d-861b7bd07f069600/resource/1b215493-9e63-4a12-8980-2d7e0fa19f85/download");
	static Data data = targetGet.request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "5fbf9a6fa8f1b0fba915e7891a4b5aa807e6c257520cb8d5ad5e3dfc9846677a").get(new GenericType<Data>() {});
	
	public static Data getData() {
		return data;
	}
}
