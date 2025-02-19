package upf.at.project.clients;

import java.util.*;

public class Client {
	private String phone;
	private List<Integer> subStationsId;
	private String telegramToken;
	
	//Constructors
	public Client() {
		
	}
	
	public Client(String phone, List<Integer> subStationsId, String telegramToken) {
		this.phone = phone;
		this.subStationsId = subStationsId;
		this.telegramToken = telegramToken;
	}
	
	//Getters
	public String getPhone(){
		return phone;
	}
	
	public List<Integer> getSubStationsId() {
		return subStationsId;
	}

	public String getTelegramToken() {
		return telegramToken;
	}
	
	//Setters
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSubStationsId(List<Integer> subStationsId) {
		this.subStationsId = subStationsId;
	}
	
	public void setTelegramToken(String telegramToken) {
		this.telegramToken = telegramToken;
	}
	
	//toString
	@Override
	public String toString() {
		return "Client [phone=" + phone + ", subStationsId=" + subStationsId + ", telegramToken=" + telegramToken + "]";
	}
}
