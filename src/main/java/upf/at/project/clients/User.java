package upf.at.project.clients;

import java.util.*;

public class User {
	private int phone;
	private List<Integer> subStationsId;
	private String telegramToken;
	
	//Constructors
	public User() {
		
	}
	
	public User(int phone, List<Integer> subStationsId, String telegramToken) {
		this.phone = phone;
		this.subStationsId = subStationsId;
		this.telegramToken = telegramToken;
	}
	
	//Getters
	public int getPhone(){
		return phone;
	}
	
	public List<Integer> getSubStationsId() {
		return subStationsId;
	}

	public String getTelegramToken() {
		return telegramToken;
	}
	
	//Setters
	public void setPhone(int phone) {
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
		return "\"Client\" : [phone=" + phone + ", subStationsId=" + subStationsId + ", telegramToken=" + telegramToken + "]";
	}
}
