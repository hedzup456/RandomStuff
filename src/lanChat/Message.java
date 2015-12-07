package lanChat;

import java.io.Serializable;

public class Message implements Serializable{
// The object passed from client to server etc
	protected static final long serialVersionUID = 1112122200L;
	static final int WHOISIN = 0, // Who is in the room
			MESSAGE = 1, // The information is a message
			LOGOUT = 2; // Log me out
	private int type; // Type of the message
	private String message; // The message
	
	// Constructor fam
	public Message(int type, String message) {
		this.type = type;
		this.message = message;
	}
	// Getters fam
	int getType(){
		return type;
	}
	String getMessage(){
		return message;
	}
}
