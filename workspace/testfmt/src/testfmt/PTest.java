package testfmt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 实现properties文件的读取
 * 
 * @author bbflyerwww
 * @date 2006-08-02
 */
public class PTest {
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			InputStream is = new FileInputStream("conf.properties");
			Properties p = new Properties();
			p.load(is);
			is.close();
			System.out.println("SIZE : " + p.size());
			System.out.println("homepage : " + p.getProperty("homepage"));
			System.out.println("author : " + p.getProperty("author"));
			System.out.println("school : " + p.getProperty("school"));
			System.out.println("date : " + p.getProperty("date"));
			long end = System.currentTimeMillis();
			System.out.println("Cost : " + (end - start));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}