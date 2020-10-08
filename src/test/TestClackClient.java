package test;

import main.ClackClient;

public class TestClackClient {

	public static void main(String[] args) {
		System.out.println("ClackClient1:");
		try {
			ClackClient ClackClient1 = new ClackClient();
			System.out.println(ClackClient1.getUserName());
			System.out.println(ClackClient1.getHostName());
			System.out.println(ClackClient1.getPort());
			System.out.println(ClackClient1.toString());
			System.out.println(ClackClient1.hashCode());
			System.out.println("");
			ClackClient1.start();

			System.out.println("ClackClient2:");
			ClackClient ClackClient2 = new ClackClient("Anon");
			System.out.println(ClackClient2.getUserName());
			System.out.println(ClackClient2.getHostName());
			System.out.println(ClackClient2.getPort());
			System.out.println(ClackClient2.toString());
			System.out.println(ClackClient2.equals(ClackClient1));
			System.out.println(ClackClient2.hashCode());
			System.out.println("");

			System.out.println("ClackClient3:");
			ClackClient ClackClient3 = new ClackClient("Jeff", "server.jeffresc.dev");
			System.out.println(ClackClient3.getUserName());
			System.out.println(ClackClient3.getHostName());
			System.out.println(ClackClient3.getPort());
			System.out.println(ClackClient3.toString());
			System.out.println(ClackClient3.equals(ClackClient1));
			System.out.println(ClackClient3.hashCode());
			System.out.println("");
		} catch (IllegalArgumentException e) {
			System.err.println("Unable to create ClackClient: " + e.getMessage());
		}

		System.out.println("ClackClient4:");
		try {
			ClackClient ClackClient4 = new ClackClient("Jeff", "server.jeffresc.dev", 3000);
			System.out.println(ClackClient4.getUserName());
			System.out.println(ClackClient4.getHostName());
			System.out.println(ClackClient4.getPort());
			System.out.println(ClackClient4.toString());
			System.out.println(ClackClient4.hashCode());
			System.out.println("");
		} catch (IllegalArgumentException e) {
			System.err.println("Unable to create ClackClient: " + e.getMessage());
		}

		System.out.println("ClackClient5:");
		try {
			ClackClient ClackClient5 = new ClackClient("Jeff", null);
			System.out.println(ClackClient5.toString());
		} catch (IllegalArgumentException e) {
			System.err.println("Unable to create ClackClient: " + e.getMessage());
		}

		System.out.println("ClackClient6:");
		try {
			ClackClient ClackClient6 = new ClackClient("Jeff", "server.jeffresc.dev", 1000);
			System.out.println(ClackClient6.toString());
		} catch (IllegalArgumentException e) {
			System.err.println("Unable to create ClackClient: " + e.getMessage());
		}
	}
}
