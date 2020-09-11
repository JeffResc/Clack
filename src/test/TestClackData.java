package test;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

public class TestClackData {

	public static void main(String args[]) {
		ClackData fileClackData = new FileClackData();
		fileClackData.getType();
		fileClackData.getUserName();
		fileClackData.getDate();
		fileClackData.getData();

		ClackData messageClackData = new MessageClackData();
		messageClackData.getType();
		messageClackData.getUserName();
		messageClackData.getDate();
		messageClackData.getData();
	}
}
