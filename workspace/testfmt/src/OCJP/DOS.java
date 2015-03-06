package OCJP;

import java.io.*;
import java.util.Arrays;

public class DOS {
	public static void main(String[] args) {
		File dir = new File("dir");
		dir.mkdir();
		File f1 = new File(dir, "f1.txt");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			;
		}
		File newDir = new File("newDir");
		dir.renameTo(newDir);
		
		
		String test = "Test A. Test B. Test C.";
		// insert code here
		String regex = "\\.\\s*";
		String[] result = test.split(regex);
		System.out.println(Arrays.toString(result));
	}
}