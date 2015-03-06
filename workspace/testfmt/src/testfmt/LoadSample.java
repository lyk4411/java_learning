package testfmt;

import java.util.*;
import java.io.*;

public class LoadSample {
	public static void main(String args[]) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Users\\liu.yongkai\\workspace\\testfmt\\ttt.properties");
		prop.load(fis);
		prop.list(System.out);
		System.out.println("\nThe aaa property: " + prop.getProperty("aaa"));
	}
}