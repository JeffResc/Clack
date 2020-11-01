package main;

public class ClientSideServerListener implements Runnable {
	/**
	 * a clackClient object for the recieving and printing of data
	 */
	private ClackClient client = null;

	/**
	 * constructor taking a clackclinet object
	 * @param temp
	 */
	public ClientSideServerListener(ClackClient temp) {
		this.client = temp;
	}

	/**
	 * run method for the runnable interfase runs the thread. recieves data from the server and prints it
	 */
	@Override
	public void run() {
		while(!client.getCloseConnection()) {
			client.receiveData();
			client.printData();
		}	
	}
}