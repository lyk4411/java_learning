package examples100;

import java.io.*;
import java.net.*;

/**
 * Title: �򵥷������ͻ��� Description: ��������һ���򵥵Ŀͻ��ˣ������ͷ��������� Filename:
 * SampleClient.java
 */
public class SampleClient {
	public static void main(String[] arges) {
		try {
			// ��ȡһ��IP��null��ʾ����
			InetAddress addr = InetAddress.getByName(null);
			// ��8888�˿ڣ����������������
			Socket sk = new Socket(addr, 8888);
			// ��������
			BufferedReader in = new BufferedReader(new InputStreamReader(
					sk.getInputStream()));
			// �������
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(sk.getOutputStream())), true);
			// �������������Ϣ
			out.println("��ð���");
			// ���շ�������Ϣ
			System.out.println(in.readLine());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}