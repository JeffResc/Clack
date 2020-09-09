package data;

public class MessageClackData extends ClackData {
	
	// ClackData variables
	String message;
	
	// Constructors
	public MessageClackData(String userName, String message, Integer type) {
		super(userName, type);
		this.message = message;
	}
	public MessageClackData() {
		this("Anon", null, -1);
	}
	public String getData() {
		return message;
	}
	
	@Override
	public boolean equals (Object other) {
		if ( other == null) return false; // makes sure the other object isnt null
		if ( !(other instanceof MessageClackData)) return false; // makes sure that the other object points to an object of the same type
		
		MessageClackData otherMessageClackData = (MessageClackData)other; // creates a circle object and sets it = to the other object
		
		return this.message == otherMessageClackData.getData();
	}
	
	@Override
	public String toString() { // when you print out an object it looks for the toString method which is overridden from the super class Object 
		return "message: " + message; 
	}
}
