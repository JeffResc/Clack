package data;

public class MessageClackData extends ClackData {
	
	// ClackData variables
	String message;

	/**
	 * Constructor that accepts a userName, message and type
	 */
	public MessageClackData(String userName, String message, Integer type) {
		super(userName, type);
		this.message = message;
	}

	/**
	 * Default constructor
	 */
	public MessageClackData() {
		this("Anon", null, CONSTANT_DEFAULT_TYPE);
	}
	
	/**
	 * Returns the method
	 * @return
	 */
	public String getData() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageClackData other = (MessageClackData) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() { // when you print out an object it looks for the toString method which is overridden from the super class Object 
		return "message: " + message; 
	}
}
