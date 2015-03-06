package io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i = 42;
		double d = Math.PI;
		String FILENAME = "random.dat";
		DataOutputStream os = new DataOutputStream(
				new FileOutputStream(FILENAME));
		os.writeInt(i);
		os.writeDouble(d);
		os.close();
		System.out.println("write " + i + "," + d + " to file " + FILENAME);
	}

}
