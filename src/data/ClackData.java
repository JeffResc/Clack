package data;

import java.util.Date;

public abstract class ClackData {

	/**
	 * A representative constant meaning the default type for the type variable.
	 */
	public static final int CONSTANT_DEFAULT_TYPE = -1;

	/**
	 * A representative constant meaning "List users" for the type variable.
	 */
	public static final int CONSTANT_LISTUSERS = 0;

	/**
	 * A representative constant meaning "Logout" for the type variable.
	 */
	public static final int CONSTANT_LOGOUT = 1;

	/**
	 * A representative constant meaning "Send message" for the type variable.
	 */
	public static final int CONSTANT_SENDMESSAGE = 2;

	/**
	 * A representative constant meaning "Send file" for the type variable.
	 */
	public static final int CONSTANT_SENDFILE = 3;

	/**
	 * String representing name of client user. Can only be set during class construction and can be retrieved using the getUserName() method.
	 */
	private String userName;
	
	/**
	 * See class constants for additional resources on the type variable. Can only be set during class construction and can be retrieved using the getType() method.
	 */
	private Integer type;
	
	/**
	 *  Date object representing date when ClackData object was created. Can only be set during class construction and can be retrieved using the getDate() method.
	 */
	private Date date;

	/**
	 * Constructor that accepts a userName and type.
	 * 
	 * @param userName userName
	 * @param type type
	 */
	public ClackData(String userName, Integer type) {
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}

	/**
	 * Constructor that accepts a type.
	 * 
	 * @param type type
	 */
	public ClackData(Integer type) {
		this("Anon", type);
	}

	/**
	 * Default constructor.
	 */
	public ClackData() {
		this(CONSTANT_DEFAULT_TYPE);
	}

	/**
	 * Returns type.
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Returns userName.
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns date.
	 * 
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the data contained in ClackData.
	 * 
	 * @return data
	 */
	public abstract String getData();
	
}
