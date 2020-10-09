package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.rmi.UnknownHostException;
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
	 * String representing name of the client. Can only be set during class
	 * construction and can be retrieved using the getUserName() method.
	 */
	private String userName;

	/**
	 * String representing name of the computer representing the server. Can only be
	 * set during class construction and can be retrieved using the getHostName()
	 * method.
	 */
	private String hostName;

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
	 * ClackData object representing data sent to server. This is exclusively an
	 * internal variable and cannot be set or retrieved using any methods.
	 */
	private ClackData dataToSendToServer;

	/**
	 * ClackData object representing data received from the server. This is
	 * exclusively an internal variable and cannot be set or retrieved using any
	 * methods.
	 */
	private ClackData dataToReceieveFromServer;

	/**
	 * Scanner object for getting input from user
	 */
	private Scanner inFromStd;

	/**
	 * Input stream that receives data packets from the server.
	 */
	private ObjectInputStream inFromServer = null;

	/**
	 * Output stream that sends data packets to the server.
	 */
	private ObjectOutputStream outToServer = null;

	/**
	 * Constructor that accepts a userName, hostName and port.
	 * 
	 * @param userName userName
	 * @param hostName hostName
	 * @param port     port
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
	 * Does not return anything, but starts the connection, reads data from the
	 * client, and prints the data out.
	 */
	public void start() {
		try {
			Socket skt = new Socket(hostName, port);
			inFromServer = new ObjectInputStream(skt.getInputStream());
			outToServer = new ObjectOutputStream(skt.getOutputStream());
			
			inFromStd = new Scanner(System.in);
			this.readClientData();
			inFromStd.close();
			this.sendData();
			this.receiveData();
			this.printData();
			skt.close();
			
		} catch (UnknownHostException uhe) {
			System.err.println("unknown host");
		} catch (NoRouteToHostException nrthe) {
			System.err.println("no route to host");
		} catch (IOException ioe) {
			System.err.println("io exception");
		}
		
	}

	/**
	 * Reads the data from the client, does not return anything.
	 */
	public void readClientData() {
		final String command = inFromStd.next();
		switch (command) {
		case "DONE":
			closeConnection = true;
			break;
		case "SENDFILE":
			dataToSendToServer = new FileClackData(userName, inFromStd.next(), ClackData.CONSTANT_SENDFILE);
			try {
				((FileClackData) dataToSendToServer).readFileContents();
			} catch (IOException ioe) {
				dataToSendToServer = null;
				System.err.println(ioe);
			}
			break;
		default:
			dataToSendToServer = new MessageClackData(userName, command, ClackData.CONSTANT_SENDMESSAGE);
			break;
		}
	}

	/**
	 * Sends data to server, does not return anything.
	 */
	public void sendData() {
		try {
			outToServer.writeObject(dataToSendToServer);
		} catch (UnknownHostException uhe) {
			System.err.println("unknown host");
		} catch (NoRouteToHostException nrthe) {
			System.err.println("no route to host");
		} catch (IOException ioe) {
			System.err.println("io exception");
		}
	}

	/**
	 * Receives data from the server, does not return anything.
	 */
	public void receiveData() {
		try {
			dataToReceieveFromServer = (ClackData) inFromServer.readObject();
		} catch (UnknownHostException uhe) {
			System.err.println("unknown host");
		} catch (NoRouteToHostException nrthe) {
			System.err.println("no route to host");
		} catch (IOException ioe) {
			System.err.println("io exception");
		} catch (ClassNotFoundException cnfe) {
			System.err.println("class not found exception");
		}
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
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns hostName.
	 * 
	 * @return hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Returns port.
	 * 
	 * @return port
	 */
	public Integer getPort() {
		return port;
	}

	public static void main(String args[]) {
		try {
			final Scanner commandin = new Scanner( System.in);
			final String[] commandsplit1;
			final String[] commandsplit2;
			commandin.next(); // java
			commandin.next(); // ClackClient
			if (commandin.hasNext()) {
				commandsplit1 = commandin.next().split("@");
				commandsplit2 = commandsplit1[1].split(":");
				ClackClient client = new ClackClient(commandsplit1[0], commandsplit2[0], Integer.parseInt(commandsplit2[1]));
				client.start();
			}
			commandin.close();
		} catch(ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("array out of bounds exception");
		} catch(NumberFormatException nfe) {
			System.err.println("number format exception (port needs to be a number)");
		}
	}
	
	/**
	 * Implements hashCode() functionality for this class and it's superclass'
	 * variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(closeConnection, dataToReceieveFromServer, dataToSendToServer, hostName, port, userName);
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
