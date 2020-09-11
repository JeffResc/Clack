package main;

import data.ClackData;

public class ClackClient {

	/**
	 * Sets default port
	 */
	public static final Integer DEFAULT_PORT = 7000;

	// ClackData variables
	String userName;
	String hostName;
	Integer port;
	Boolean closeConnection;
	ClackData dataToSendToServer;
	ClackData dataToReceieveFromServer;

	/**
	 * Constructor that accepts a userName, hostName and port
	 */
	public ClackClient(String userName, String hostName, Integer port) {
		this.userName = userName;
		this.hostName = hostName;
		this.port = port;
	}

	/**
	 * Constructor that accepts a userName and hostName
	 */
	public ClackClient(String userName, String hostName) {
		this(userName, hostName, new Integer(DEFAULT_PORT));
	}

	/**
	 * Constructor that accepts a userName
	 */
	public ClackClient(String userName) {
		this(userName, "localhost");
	}

	/**
	 * Default constructor
	 */
	public ClackClient() {
		this("Anon");
	}

	/**
	 * does not return anything, for now it should have no code, just a declaration
	 * 
	 * @return
	 */
	public void start() {

	}

	/**
	 * reads the data from the client, does not return anything, for now it should
	 * have no code, just a declaration
	 */
	public void readClientData() {

	}

	/**
	 * sends data to server, does not return anything, for now it should have no
	 * code, just a declaration
	 */
	public void sendData() {

	}

	/**
	 * receives data from the server, does not return anything for now it should
	 * have no code, just a declaration
	 */
	public void receiveData() {

	}

	/**
	 * prints the received data to standard output, for now it should have no code,
	 * just a declaration
	 */
	public void printData() {

	}

	/**
	 * Returns userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Returns port
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
