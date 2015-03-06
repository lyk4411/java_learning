package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"files"));
		Alien alien1 = (Alien) in.readObject();
		// System.out.println("alien = "+alien1);
		System.out.println("alien = " + alien1.getClass().toString());
	}
}