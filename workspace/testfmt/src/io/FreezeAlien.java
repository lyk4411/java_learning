package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FreezeAlien {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"files"));
		Alien alien = new Alien();
		out.writeObject(alien);
		// out.close();
	}
}