package test;


import java.io.IOException;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

public class TestClackData {

	public static void main(String args[]) {
		System.out.println("ClackData1:");
		ClackData ClackData1 = new FileClackData("Jeff", "C:\\Users\\dwarv\\git\\Clack\\src\\Part2_document.txt", 0);
		try {
			((FileClackData)ClackData1).readFileContents();
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
		
		
		ClackData testwrite = new FileClackData("Jeff", "C:\\Users\\dwarv\\desktop\\Part2_testwrite.txt", 0);
		
		try {
			((FileClackData)testwrite).writeFileContents();
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
		
		System.out.println(ClackData1.getType());
		System.out.println(ClackData1.getUserName());
		System.out.println(ClackData1.getDate());
		System.out.println(ClackData1.getData());
		System.out.println(ClackData1.toString());
		System.out.println(ClackData1.hashCode());
		System.out.println("");
		
		System.out.println(testwrite.toString());

		System.out.println("ClackData2:");
		ClackData ClackData2 = new FileClackData();
		System.out.println(ClackData2.getType());
		System.out.println(ClackData2.getUserName());
		System.out.println(ClackData2.getDate());
		System.out.println(ClackData2.getData());
		System.out.println(ClackData2.toString());
		System.out.println(ClackData2.equals(ClackData1));
		System.out.println(ClackData2.hashCode());
		System.out.println("");
		
		System.out.println("ClackData3:");
		ClackData ClackData3 = new MessageClackData("Jeff", "Hello, world!", 0);
		System.out.println(ClackData3.getType());
		System.out.println(ClackData3.getUserName());
		System.out.println(ClackData3.getDate());
		System.out.println(ClackData3.getData());
		System.out.println(ClackData3.toString());
		System.out.println(ClackData3.hashCode());
		System.out.println("");
		
		System.out.println("ClackData4:");
		ClackData ClackData4 = new MessageClackData();
		System.out.println(ClackData4.getType());
		System.out.println(ClackData4.getUserName());
		System.out.println(ClackData4.getDate());
		System.out.println(ClackData4.getData());
		System.out.println(ClackData4.toString());
		System.out.println(ClackData4.equals(ClackData3));
		System.out.println(ClackData4.hashCode());
		System.out.println("");
	}
}
