package main;

import data.ClackData;

public class ClackClient {
	
	// ClackData variables
	String userName;
	String hostName;
	Integer port;
	Boolean closeConnection;
	ClackData dataToSendToServer;
	ClackData dataToReceieveFromServer;
	
	// Constructors
	public ClackClient(String userName, String hostName, Integer port) {
		this.userName = userName;
		this.hostName = hostName;
		this.port = port;
	}
	
	public ClackClient(String userName, String hostName) {
		this(userName, hostName, new Integer(7000));
	}
	
	public ClackClient(String userName) {
		this(userName, "localhost");
	}
	
	public ClackClient() {
		this("Anon");
	}
	
	/**
	 * does not return anything, for now it should have no code, just a declaration
	 * @return 
	 */
	public void start() {
		
	}
	
	/**
	 * reads the data from the client, does not return anything, for now it should have no code, just a declaration
	 */
	public void readClientData() {
		
	}
	
	/**
	 * sends data to server, does not return anything, for now it should have no code, just a declaration
	 */
	public void sendData() {
		
	}
	
	/**
	 * receives data from the server, does not return anything for now it should have no code, just a declaration
	 */
	public void receiveData() {
		
	}
	
	/**
	 * prints the received data to standard output, for now it should have no code, just a declaration
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
		return 0x20;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
		if (!(other instanceof ClackClient)) return false;
		
		ClackClient otherClackClient = (ClackClient)other;
		return this.userName == otherClackClient.getUserName() &&
				this.hostName == otherClackClient.getHostName() &&
				this.port == otherClackClient.getPort();
	}
	
	@Override
	public String toString() {
		return "This is a ClackClient with userName = " + getUserName() + ", hostName = " + getHostName() + ", port = " + getPort();
	}
}
