package testfmt;

import java.util.*;
import java.io.*;

public class StoreXML {
	public static void main(String args[]) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("one-two", "buckle my shoe");
		prop.setProperty("three-four", "shut the door");
		prop.setProperty("five-six", "pick up sticks");
		prop.setProperty("seven-eight", "lay them straight");
		prop.setProperty("nine-ten", "a big, fat hen");
		FileOutputStream fos = new FileOutputStream("rhyme.xml");
		prop.storeToXML(fos, "Rhyme");
		fos.close();
	}
}