package testfmt;

import java.io.*;

import java.util.*;

public class ReadProperties

{

	public static void main(String[] args) {

		File pFile = new File("test.properties"); // properties文件放在e盘下（windows）
		FileInputStream pInStream = null;
		try {
			pInStream = new FileInputStream(pFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		Properties p = new Properties();

		try {
			p.load(pInStream); // Properties 对象已生成，包括文件中的数据
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		Enumeration enu = p.propertyNames(); // 取出所有的key

		// 输出--1

		p.list(System.out); // System.out可以改为其他的输出流（包括可以输出到文件）

		System.out.println(enu.toString());
		//System.out.println(enu.hasMoreElements());
		//System.out.println(enu.nextElement());

		// 输出--2
		while (enu.hasMoreElements()) {
			String aa = (String)enu.nextElement();
			System.out.println("key=" + aa);
			System.out.println("value="
					+ p.getProperty(aa));
		}

	}

}