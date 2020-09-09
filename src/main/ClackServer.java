package main;

import data.ClackData;

public class ClackServer {

	// Constants
	public static final Integer DEFAULT_PORT = 7000;

	// ClackServer variables
	Integer port;
	Boolean closeConnection;
	ClackData dataToReceieveFromClient;
	ClackData dataToSendToClient;

	// Constructors
	public ClackServer(Integer port) {
		this.port = port;
	}

	public ClackServer() {
		this(DEFAULT_PORT);
	}

	/**
	 * does not return anything, for now it should have no code, just a declaration
	 * 
	 * @return
	 */
	public void start() {

	}

	/**
	 * receives data from the server, does not return anything for now it should
	 * have no code, just a declaration
	 */
	public void receiveData() {

	}

	/**
	 * sends data to server, does not return anything, for now it should have no
	 * code, just a declaration
	 */
	public void sendData() {

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
			if (!(other instanceof ClackServer))
				return false;

		ClackServer otherClackServer = (ClackServer) other;
		return this.port == otherClackServer.getPort() && this.closeConnection == otherClackServer.closeConnection
				&& this.dataToReceieveFromClient == otherClackServer.dataToReceieveFromClient
				&& this.dataToSendToClient == otherClackServer.dataToSendToClient;
	}

	@Override
	public String toString() {
		return "This is a ClackServer with port = " + getPort();
	}
}
