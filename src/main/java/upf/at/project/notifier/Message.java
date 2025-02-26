package upf.at.project.notifier;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class Message {
	private long chat_id;
	private String text;
	
	public Message() {
		
	}
	
	public Message(long chat_id, String text) {
		this.chat_id = chat_id;
		this.text = text;
	}

	public long getChat_id() {
		return chat_id;
	}

	public void setChat_id(long chat_id) {
		this.chat_id = chat_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Message [chat_id=" + chat_id + ", text=" + text + "]";
	}

	public void new_message() {
		Client client = ClientBuilder.newClient();
		Message message = new Message(chat_id, text);
		
		WebTarget targetSendMessage = client.target("https://api.telegram.org")
				.path("/bot7876711603:AAG7eo6_kzwJybNvD7RH6TnemkIqehnAwyA/sendMessage");
		
		String response = targetSendMessage.request()
				.post(Entity.entity(message, MediaType.APPLICATION_JSON_TYPE), String.class);
		
		System.out.println("Response: " + response);
	}
}
