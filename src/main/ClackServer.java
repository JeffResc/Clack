package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
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
	private Boolean closeConnection = false;

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

			outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
			inFromClient = new ObjectInputStream(clientSocket.getInputStream());

			while (!closeConnection) {
				this.receiveData();
				dataToSendToClient = dataToReceieveFromClient; // echo's the data back
				this.sendData();
			}
			sskt.close();
		} catch (UnknownHostException uhe) {
			System.err.println("unknown host");
		} catch (NoRouteToHostException nrthe) {
			System.err.println("no route to host");
		} catch (IOException ioe) {
			System.err.println("io exception");
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

	public static void main(String args[]) {
		try {
			ClackServer server;
			if (args.length > 0) {
				final String input = args[0];
				server = new ClackServer(Integer.parseInt(input));
			} else {
				server = new ClackServer();
			}
			server.start();
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("array out of bounds exception");
		} catch (NumberFormatException nfe) {
			System.err.println("number format exception (port needs to be a number)");
		}
	}

	/**
	 * Implements hashCode() functionality for this class and it's superclass'
	 * variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(closeConnection, port);
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
				&& Objects.equals(port, other.port);
	}

	/**
	 * Implements toString() functionality for this class' variables.
	 */
	@Override
	public String toString() {
		return "ClackServer [port=" + port + ", closeConnection=" + closeConnection + "]";
	}

}
