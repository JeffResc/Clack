package data;

import java.util.Date;

public abstract class ClackData {

	/**
	 * A representative constant meaning the default type for the type variable
	 */
	public static final int CONSTANT_DEFAULT_TYPE = -1;

	/**
	 * A representative constant meaning "List users" for the type variable
	 */
	public static final int CONSTANT_LISTUSERS = 0;

	/**
	 * A representative constant meaning "Logout" for the type variable
	 */
	public static final int CONSTANT_LOGOUT = 1;

	/**
	 * A representative constant meaning "Send message" for the type variable
	 */
	public static final int CONSTANT_SENDMESSAGE = 2;

	/**
	 * A representative constant meaning "Send file" for the type variable
	 */
	public static final int CONSTANT_SENDFILE = 3;

	// ClackData variables
	String userName;
	Integer type;
	Date date;

	/**
	 * Constructor that accepts a userName and type
	 */
	public ClackData(String userName, Integer type) {
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}

	/**
	 * Constructor that accepts a type
	 */
	public ClackData(Integer type) {
		this("Anon", type);
	}

	/**
	 * Default constructor
	 */
	public ClackData() {
		this(CONSTANT_DEFAULT_TYPE);
	}

	/**
	 * Returns type
	 * 
	 * @return
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Returns userName
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns date
	 * 
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the data contained in ClackData
	 * 
	 * @return
	 */
	public abstract String getData();
}
