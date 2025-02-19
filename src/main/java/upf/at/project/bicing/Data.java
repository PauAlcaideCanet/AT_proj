package upf.at.project.bicing;

public class Data {
	private Stations data;
	
	//Constructors
	public Data() {
		
	}
	
	public Data(Stations data) {
		this.data = data;
	}
	
	//Getters
	public Stations getData() {
		return data;
	}
	
	//Setters
	public void setData(Stations data) {
		this.data = data;
	}
	
	//toString
	public String toString() {
		return "Data=" + data;
	}
}
