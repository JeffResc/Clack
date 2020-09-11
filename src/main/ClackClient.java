package main;

import data.ClackData;

public class ClackClient {

	/**
	 * Sets default port.
	 */
	public static final Integer DEFAULT_PORT = 7000;

	/**
	 * String representing name of the client. Can only be set during class construction and can be retrieved using the getUserName() method.
	 */
	private String userName;
	
	/**
	 * String representing name of the computer representing the server. Can only be set during class construction and can be retrieved using the getHostName() method.
	 */
	private String hostName;
	
	/**
	 * Integer representing port number on server connected to. Can only be set during class construction and can be retrieved using the getPort() method.
	 */
	private Integer port;
	
	/**
	 * Boolean representing whether connection is closed or not. This is exclusively an internal variable and cannot be set or retrieved using any methods.
	 */
	private Boolean closeConnection;
	
	/**
	 * ClackData object representing data sent to server. This is exclusively an internal variable and cannot be set or retrieved using any methods.
	 */
	private ClackData dataToSendToServer;
	
	/**
	 * ClackData object representing data received from the server. This is exclusively an internal variable and cannot be set or retrieved using any methods.
	 */
	private ClackData dataToReceieveFromServer;

	/**
	 * Constructor that accepts a userName, hostName and port.
	 */
	public ClackClient(String userName, String hostName, Integer port) {
		this.userName = userName;
		this.hostName = hostName;
		this.port = port;
	}

	/**
	 * Constructor that accepts a userName and hostName.
	 */
	public ClackClient(String userName, String hostName) {
		this(userName, hostName, new Integer(DEFAULT_PORT));
	}

	/**
	 * Constructor that accepts a userName.
	 */
	public ClackClient(String userName) {
		this(userName, "localhost");
	}

	/**
	 * Default constructor.
	 */
	public ClackClient() {
		this("Anon");
	}

	/**
	 * Does not return anything, for now it should have no code, just a declaration.
	 * 
	 * @return
	 */
	public void start() {

	}

	/**
	 * Reads the data from the client, does not return anything, for now it should
	 * have no code, just a declaration.
	 */
	public void readClientData() {

	}

	/**
	 * Sends data to server, does not return anything, for now it should have no
	 * code, just a declaration.
	 */
	public void sendData() {

	}

	/**
	 * Receives data from the server, does not return anything for now it should
	 * have no code, just a declaration.
	 */
	public void receiveData() {

	}

	/**
	 * Prints the received data to standard output, for now it should have no code,
	 * just a declaration.
	 */
	public void printData() {

	}

	/**
	 * Returns userName.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns hostName.
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Returns port.
	 */
	public Integer getPort() {
		return port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closeConnection == null) ? 0 : closeConnection.hashCode());
		result = prime * result + ((dataToReceieveFromServer == null) ? 0 : dataToReceieveFromServer.hashCode());
		result = prime * result + ((dataToSendToServer == null) ? 0 : dataToSendToServer.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		ClackClient other = (ClackClient) obj;
		if (closeConnection == null) {
			if (other.closeConnection != null)
				return false;
		} else if (!closeConnection.equals(other.closeConnection))
			return false;
		if (dataToReceieveFromServer == null) {
			if (other.dataToReceieveFromServer != null)
				return false;
		} else if (!dataToReceieveFromServer.equals(other.dataToReceieveFromServer))
			return false;
		if (dataToSendToServer == null) {
			if (other.dataToSendToServer != null)
				return false;
		} else if (!dataToSendToServer.equals(other.dataToSendToServer))
			return false;
		if (hostName == null) {
			if (other.hostName != null)
				return false;
		} else if (!hostName.equals(other.hostName))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This is a ClackClient with userName = " + getUserName() + ", hostName = " + getHostName() + ", port = "
				+ getPort();
	}
	
}
