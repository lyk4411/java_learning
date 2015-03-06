package examples100;

import java.io.*;
import java.net.*;

/**
 * Title: ��ȡһ��URL�ı� Description: ͨ��ʹ��URL�࣬����һ��������󣬲���ȡ�����ݡ� Filename: getURL.java
 */
public class getURL {

	public static void main(String[] arg) {
		if (arg.length != 1) {
			System.out.println("USE java getURL  url");
			return;
		}
		new getURL(arg[0]);
	}

	/**
	 * ����˵���������� ���������String URL ����������ҳ��ַ�� �������ͣ�
	 */
	public getURL(String URL) {
		try {
			// ����һ��URL����
			URL url = new URL(URL);

			// ��ȡ�ӷ��������ص������ı�
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				// ������ı�����
				display(str);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	/**
	 * ����˵������ʾ��Ϣ ��������� �������ͣ�
	 */
	private void display(String s) {
		if (s != null)
			System.out.println(s);
	}
}