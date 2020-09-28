package main;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

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
	 * Scanner object for getting input from user
	 */
	private Scanner inFromStd;

	/**
	 * Constructor that accepts a userName, hostName and port.
	 * 
	 * @param userName userName
	 * @param hostName hostName
	 * @param port port
	 */
	public ClackClient(String userName, String hostName, Integer port) {
		if (userName == null) {
			throw new IllegalArgumentException("userName cannot be null");
		}
		if (hostName == null) {
			throw new IllegalArgumentException("hostName cannot be null");
		}
		if (port < 1024) {
			throw new IllegalArgumentException("port must be greater than 1024");
		}
		this.userName = userName;
		this.hostName = hostName;
		this.port = port;
	}

	/**
	 * Constructor that accepts a userName and hostName.
	 * 
	 * @param userName userName
	 * @param hostName hostName
	 */
	public ClackClient(String userName, String hostName) {
		this(userName, hostName, new Integer(DEFAULT_PORT));
	}

	/**
	 * Constructor that accepts a userName.
	 * 
	 * @param userName userName
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
	 * Does not return anything, but starts the connection, reads data from the client, and prints the data out.
	 */
	public void start() {
		inFromStd = new Scanner(System.in);
		this.readClientData();
		inFromStd.close();
		dataToReceieveFromServer = dataToSendToServer;
		this.printData();
	}

	/**
	 * Reads the data from the client, does not return anything.
	 */
	public void readClientData() {
		switch (inFromStd.next()) {
			case "DONE" :
				closeConnection = true;
				break;
			case "SENDFILE" :
				 dataToSendToServer = new FileClackData(userName, inFromStd.next(), ClackData.CONSTANT_SENDFILE);
				 try {
					 ((FileClackData)dataToSendToServer).readFileContents();
				 } catch(IOException ioe) {
					 dataToSendToServer = null;
					 System.err.println(ioe);
				 }
				 break;
			default :
				dataToSendToServer = new MessageClackData(userName, "", ClackData.CONSTANT_SENDMESSAGE);
				break;
		}
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
	 * Prints the received data to standard output.
	 */
	public void printData() {
		System.out.println(dataToReceieveFromServer.getUserName());
		System.out.println(dataToReceieveFromServer.getType());
		System.out.println(dataToReceieveFromServer.getData());
	}

	/**
	 * Returns userName.
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns hostName.
	 * @return hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Returns port.
	 * @return port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Implements hashCode() functionality for this class and it's superclass' variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(closeConnection, dataToReceieveFromServer, dataToSendToServer, hostName, port, userName);
	}

	/**
	 * Implements equals() functionality for this class and it's superclass' variables.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClackClient other = (ClackClient) obj;
		return Objects.equals(closeConnection, other.closeConnection)
				&& Objects.equals(dataToReceieveFromServer, other.dataToReceieveFromServer)
				&& Objects.equals(dataToSendToServer, other.dataToSendToServer)
				&& Objects.equals(hostName, other.hostName) && Objects.equals(port, other.port)
				&& Objects.equals(userName, other.userName);
	}

	/**
	 * Implements toString() functionality for this class' variables.
	 */
	@Override
	public String toString() {
		return "ClackClient [userName=" + userName + ", hostName=" + hostName + ", port=" + port + ", closeConnection="
				+ closeConnection + ", dataToSendToServer=" + dataToSendToServer + ", dataToReceieveFromServer="
				+ dataToReceieveFromServer + "]";
	}
	
}
