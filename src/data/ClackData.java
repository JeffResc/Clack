package data;

import java.util.Date;

public abstract class ClackData {
	
	// Constants
	public static final int CONSTANT_LISTUSERS = 0;
	public static final int CONSTANT_LOGOUT = 1;
	public static final int CONSTANT_SENDMESSAGE = 2;
	public static final int CONSTANT_SENDFILE = 3;
	
	// ClackData variables
	String userName;
	Integer type;
	Date date;
	
	// Constructors
	public ClackData(String userName, Integer type) {
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}
	
	public ClackData(Integer type) {
		this("Anon", type);
	}
	
	public ClackData() {
		this(-1);
	}
	
	/**
	 * Returns type
	 * @return
	 */
	public Integer getType() {
		return type;
	}
	
	/**
	 * Returns userName
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Returns date
	 * @return
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Returns the data contained in ClackData
	 * @return
	 */
	public abstract String getData();
}
