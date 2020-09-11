package test;

import main.ClackServer;

public class TestClackServer {
	public static void main(String[] args) {
		System.out.println("ClackServer1:");
		ClackServer ClackServer1 = new ClackServer();
		System.out.println(ClackServer1.getPort());
		System.out.println(ClackServer1.toString());
		System.out.println("----------");
		
		System.out.println("ClackServer2:");
		ClackServer ClackServer2 = new ClackServer(3000);
		System.out.println(ClackServer2.getPort());
		System.out.println(ClackServer2.toString());
		System.out.println(ClackServer2.equals(ClackServer1));
		System.out.println("----------");
	}
	
}
