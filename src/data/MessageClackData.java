package data;

import java.util.Objects;

public class MessageClackData extends ClackData {

	/**
	 * String representing instant message. Can only be set during class construction and can be retrieved using the getData() method.
	 */
	private String message;

	/**
	 * Constructor that accepts a userName, message and type.
	 * 
	 * @param userName userName
	 * @param message message
	 * @param type type
	 */
	public MessageClackData(String userName, String message, Integer type) {
		super(userName, type);
		this.message = message;
	}

	/**
	 * Default constructor.
	 */
	public MessageClackData() {
		this("Anon", null, CONSTANT_DEFAULT_TYPE);
	}

	/**
	 * Returns the method.
	 * 
	 * @return message
	 */
	public String getData() {
		return message;
	}

	/**
	 * Implements hashCode() functionality for this class and it's superclass' variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(message, getUserName(), getType(), getDate());
	}

	/**
	 * Implements equals() functionality for this class and it's superclass' variables.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageClackData other = (MessageClackData) obj;
		return Objects.equals(message, other.message) && Objects.equals(getUserName(), other.getUserName()) && Objects.equals(getType(), other.getType()) && Objects.equals(getDate(), other.getDate());
	}

	/**
	 * Implements toString() functionality for this class' variables.
	 */
	@Override
	public String toString() {
		return "MessageClackData [message=" + message + ", userName=" + getUserName() + ", type=" + getType() + "]";
	}
	
}
