package testfmt;

import java.io.*;
import java.util.Properties;

/**
 * Properties����� User: xiaohui Date: 2008-11-4 21:04:54
 */
public class TestProperties {
	public static void main(String args[]) throws IOException {
		testProperties();
		//test1();
	}

	public static void testProperties() throws IOException {
		System.out.println("------------testProperties-------------");
		// ��properties�ļ����ص������ֽ�����
		InputStream is = new FileInputStream(
				"D:\\Users\\liu.yongkai\\workspace\\testfmt\\ttt.properties");
		// ����һ��Properties����
		Properties prop = new Properties();
		// �����м���properties�ļ���Ϣ
		prop.load(is);
		// ѭ�����������Ϣ
		for (Object key : prop.keySet()) {
			System.out.println(key + "==" + prop.get(key));
		}

		// ����һ�������
		OutputStream os1 = new FileOutputStream("C:\\ttt.xml");
		OutputStream os2 = new FileOutputStream("C:\\ttt.properties");

		// ��Properties���󵼳�������xml
		prop.storeToXML(os1, "�Ҵ�properties������XML�����ļ�");
		// ��Properties���󵼳�properties�ļ�
		prop.store(os2, "�Ҵ�properties������XML�����ļ�");

		is.close();
		os1.close();
		os2.close();

		// ��xml����������Ϣ�����Properties����
		prop.loadFromXML(new FileInputStream("C:\\ttt.xml"));
		// ѭ�����������Ϣ
		System.out.println("�Ҵӵ�����xml���������ļ���Ϣ��");
		for (Object key : prop.keySet()) {
			System.out.println(key + "=" + prop.get(key));
		}

		// �޸�Properties���󣬲��־û���һ���ļ�
		prop.put("�ǺǺ�", "�¸¸�");
		OutputStream os3 = new FileOutputStream("C:\\ttt1.xml");
		prop.storeToXML(os3, "�Ҵ�properties������XML�����ļ�");
		os3.close();
	}

	/**
	 * �����·����ʽ����properties�ļ�
	 * 
	 * @throws IOException
	 */
	public static void test1() throws IOException {
		System.out.println("------------test1-------------");
		Properties p = new Properties();
		p.load(TestProperties.class.getResourceAsStream("/ttt.properties"));
		for (Object key : p.keySet()) {
			System.out.println(key + "=" + p.get(key));
		}
	}
}