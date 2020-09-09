package main;

import data.ClackData;

public class ClackClient {

	// Constants
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
		// Not sure if this implementation is correct, may need to be fixed in the
		// future
		return 0x20;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			if (!(other instanceof ClackClient))
				return false;

		ClackClient otherClackClient = (ClackClient) other;
		return this.userName == otherClackClient.userName && this.hostName == otherClackClient.hostName
				&& this.port == otherClackClient.port && this.closeConnection == otherClackClient.closeConnection
				&& this.dataToSendToServer == otherClackClient.dataToSendToServer
				&& this.dataToReceieveFromServer == otherClackClient.dataToReceieveFromServer;
	}

	@Override
	public String toString() {
		return "This is a ClackClient with userName = " + getUserName() + ", hostName = " + getHostName() + ", port = "
				+ getPort();
	}
}
