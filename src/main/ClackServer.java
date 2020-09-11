package main;

import data.ClackData;

public class ClackServer {

	/**
	 * Sets default port
	 */
	public static final Integer DEFAULT_PORT = 7000;

	// ClackServer variables
	private Integer port;
	private Boolean closeConnection;
	private ClackData dataToReceieveFromClient;
	private ClackData dataToSendToClient;

	/**
	 * Constructor that accepts a port
	 */
	public ClackServer(Integer port) {
		this.port = port;
	}

	/**
	 * Default constructor
	 */
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closeConnection == null) ? 0 : closeConnection.hashCode());
		result = prime * result + ((dataToReceieveFromClient == null) ? 0 : dataToReceieveFromClient.hashCode());
		result = prime * result + ((dataToSendToClient == null) ? 0 : dataToSendToClient.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
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
		ClackServer other = (ClackServer) obj;
		if (closeConnection == null) {
			if (other.closeConnection != null)
				return false;
		} else if (!closeConnection.equals(other.closeConnection))
			return false;
		if (dataToReceieveFromClient == null) {
			if (other.dataToReceieveFromClient != null)
				return false;
		} else if (!dataToReceieveFromClient.equals(other.dataToReceieveFromClient))
			return false;
		if (dataToSendToClient == null) {
			if (other.dataToSendToClient != null)
				return false;
		} else if (!dataToSendToClient.equals(other.dataToSendToClient))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This is a ClackServer with port = " + getPort();
	}
	
}
