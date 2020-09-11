package main;

import java.util.Objects;

import data.ClackData;

public class ClackServer {

	/**
	 * Sets default port
	 */
	public static final Integer DEFAULT_PORT = 7000;

	/**
	 * Integer representing port number on server connected to. Can only be set during class construction and can be retrieved using the getPort() method.
	 */
	private Integer port;
	
	/**
	 * Boolean representing whether connection is closed or not. This is exclusively an internal variable and cannot be set or retrieved using any methods.
	 */
	private Boolean closeConnection;
	
	/**
	 * ClackData object representing data received from the client. This is exclusively an internal variable and cannot be set or retrieved using any methods.
	 */
	private ClackData dataToReceieveFromClient;
	
	/**
	 * ClackData object representing data sent to client. This is exclusively an internal variable and cannot be set or retrieved using any methods.
	 */
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
		return Objects.hash(closeConnection, dataToReceieveFromClient, dataToSendToClient, port);
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
		return Objects.equals(closeConnection, other.closeConnection)
				&& Objects.equals(dataToReceieveFromClient, other.dataToReceieveFromClient)
				&& Objects.equals(dataToSendToClient, other.dataToSendToClient) && Objects.equals(port, other.port);
	}

	@Override
	public String toString() {
		return "ClackServer [port=" + port + ", closeConnection=" + closeConnection + ", dataToReceieveFromClient="
				+ dataToReceieveFromClient + ", dataToSendToClient=" + dataToSendToClient + "]";
	}
	
}
