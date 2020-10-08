package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import data.ClackData;

public class ClackServer {

	/**
	 * Sets default port
	 */
	public static final Integer DEFAULT_PORT = 7000;

	/**
	 * Integer representing port number on server connected to. Can only be set
	 * during class construction and can be retrieved using the getPort() method.
	 */
	private Integer port;

	/**
	 * Boolean representing whether connection is closed or not. This is exclusively
	 * an internal variable and cannot be set or retrieved using any methods.
	 */
	private Boolean closeConnection;

	/**
	 * ClackData object representing data received from the client. This is
	 * exclusively an internal variable and cannot be set or retrieved using any
	 * methods.
	 */
	private ClackData dataToReceieveFromClient;

	/**
	 * ClackData object representing data sent to client. This is exclusively an
	 * internal variable and cannot be set or retrieved using any methods.
	 */
	private ClackData dataToSendToClient;

	/**
	 * Input stream that receives data packets from the client.
	 */
	private ObjectInputStream inFromClient = null;

	/**
	 * Output stream that sends data packets to the client.
	 */
	private ObjectOutputStream outToClient = null;

	/**
	 * Constructor that accepts a port
	 * 
	 * @param port port
	 */
	public ClackServer(Integer port) {
		if (port < 1024) {
			throw new IllegalArgumentException("port must be greater than 1024");
		}
		this.port = port;
	}

	/**
	 * Default constructor
	 */
	public ClackServer() {
		this(DEFAULT_PORT);
	}

	/**
	 * Does not return anything, for now it should have no code, just a declaration
	 */
	public void start() {
		try {
			ServerSocket sskt = new ServerSocket(port);
			Socket clientSocket = sskt.accept();
			
			inFromClient = new ObjectInputStream(clientSocket.getInputStream());
			outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * receives data from the server, does not return anything for now it should
	 * have no code, just a declaration
	 */
	public void receiveData() {
		try {
			dataToReceieveFromClient = (ClackData) inFromClient.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * sends data to server, does not return anything, for now it should have no
	 * code, just a declaration
	 */
	public void sendData() {
		try {
			outToClient.writeObject(dataToSendToClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns port
	 * 
	 * @return port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Implements hashCode() functionality for this class and it's superclass'
	 * variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(closeConnection, dataToReceieveFromClient, dataToSendToClient, port);
	}

	/**
	 * Implements equals() functionality for this class and it's superclass'
	 * variables.
	 */
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

	/**
	 * Implements toString() functionality for this class' variables.
	 */
	@Override
	public String toString() {
		return "ClackServer [port=" + port + ", closeConnection=" + closeConnection + ", dataToReceieveFromClient="
				+ dataToReceieveFromClient + ", dataToSendToClient=" + dataToSendToClient + "]";
	}

}
