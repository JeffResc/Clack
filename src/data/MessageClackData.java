package data;

public class MessageClackData extends ClackData {

	// ClackData variables
	String message;

	// Constructors
	public MessageClackData(String userName, String message, Integer type) {
		super();
		this.userName = userName;
		this.type = type;
	}

	public MessageClackData() {
		// MessageClackData();
	}
}
