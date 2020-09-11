package data;

import java.util.Objects;

public class MessageClackData extends ClackData {

	/**
	 * String representing instant message. Can only be set during class construction and can be retrieved using the getData() method.
	 */
	private String message;

	/**
	 * Constructor that accepts a userName, message and type.
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
	 * @return
	 */
	public String getData() {
		return message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message);
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
		return Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		/*
		 * Overridden from the super class Object when you print
		 * out an object it looks for the toString method which is
		 */
		return "message: " + message;
	}
	
}
