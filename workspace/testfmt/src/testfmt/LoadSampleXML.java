package testfmt;

import java.util.*;
import java.io.*;

public class LoadSampleXML {
	public static void main(String args[]) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Users\\liu.yongkai\\"
				+ "workspace\\testfmt\\sampleprops.xml");
		prop.loadFromXML(fis);
		prop.list(System.out);
		System.out.println("\nThe foo property:hhhhhh "
				+ prop.getProperty("foo"));
	}
}