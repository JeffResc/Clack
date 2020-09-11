package test;

import main.ClackClient;

public class TestClackClient {
	
	public static void main(String[] args) {
		System.out.println("ClackClient1:");
		ClackClient ClackClient1 = new ClackClient();
		System.out.println(ClackClient1.getUserName());
		System.out.println(ClackClient1.getHostName());
		System.out.println(ClackClient1.getPort());
		System.out.println(ClackClient1.toString());
		System.out.println("");

		System.out.println("ClackClient2:");
		ClackClient ClackClient2 = new ClackClient("Anon");
		System.out.println(ClackClient2.getUserName());
		System.out.println(ClackClient2.getHostName());
		System.out.println(ClackClient2.getPort());
		System.out.println(ClackClient2.toString());
		System.out.println(ClackClient2.equals(ClackClient1));
		System.out.println("");

		System.out.println("ClackClient3:");
		ClackClient ClackClient3 = new ClackClient("Jeff", "server.jeffresc.dev");
		System.out.println(ClackClient3.getUserName());
		System.out.println(ClackClient3.getHostName());
		System.out.println(ClackClient3.getPort());
		System.out.println(ClackClient3.toString());
		System.out.println(ClackClient3.equals(ClackClient1));
		System.out.println("");

		System.out.println("ClackClient4:");
		ClackClient ClackClient4 = new ClackClient("Jeff", "server.jeffresc.dev", 3000);
		System.out.println(ClackClient4.getUserName());
		System.out.println(ClackClient4.getHostName());
		System.out.println(ClackClient4.getPort());
		System.out.println(ClackClient4.toString());
	}
	
}
