package testfmt;

import java.io.*;

import java.util.*;

public class ReadProperties

{

	public static void main(String[] args) {

		File pFile = new File("test.properties"); // properties�ļ�����e���£�windows��
		FileInputStream pInStream = null;
		try {
			pInStream = new FileInputStream(pFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		Properties p = new Properties();

		try {
			p.load(pInStream); // Properties ���������ɣ������ļ��е�����
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		Enumeration enu = p.propertyNames(); // ȡ�����е�key

		// ���--1

		p.list(System.out); // System.out���Ը�Ϊ���������������������������ļ���

		System.out.println(enu.toString());
		//System.out.println(enu.hasMoreElements());
		//System.out.println(enu.nextElement());

		// ���--2
		while (enu.hasMoreElements()) {
			String aa = (String)enu.nextElement();
			System.out.println("key=" + aa);
			System.out.println("value="
					+ p.getProperty(aa));
		}

	}

}