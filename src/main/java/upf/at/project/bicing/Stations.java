package upf.at.project.bicing;

import java.util.*;

public class Stations {
	private List<Station> stations;
	
	//Constructors
	public Stations() {
		
	}
	
	public Stations(List<Station> stations) {
		this.stations = stations;
	}
	
	//Getters
	public List<Station> getStations(){
		return stations;
	}
	
	//Setters
	public void setStations(List <Station> stations) {
		this.stations = stations;
	}
	
	//toString
	public String toString() {
		return "Stations=" + stations;
	}
}
