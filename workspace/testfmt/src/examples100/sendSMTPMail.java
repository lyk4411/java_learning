package examples100;

import java.net.*;
import java.io.*;

/**
 * Title: ʹ��SMTP�����ʼ� Description: ��ʵ��ͨ��ʹ��socket��ʽ������SMTPЭ�鷢���ʼ� Copyright:
 * Copyright (c) 2003 Filename: sendSMTPMail.java
 */
public class sendSMTPMail {
	/**
	 * ����˵���������� ���������1��������ip��2���Է��ʼ���ַ �������ͣ�
	 */
	

	public static void main(String[] arges) {
		if (arges.length != 2) {
			System.out.println("use java sendSMTPMail hostname | mail to");
			return;
		}
		sendSMTPMail t = new sendSMTPMail();
		t.sendMail(arges[0], arges[1]);
	}

	/**
	 * ����˵���������ʼ� ���������String mailServer �ʼ����շ����� ���������String recipient �����ʼ��ĵ�ַ
	 * �������ͣ�
	 */
	public void sendMail(String mailServer, String recipient) {
		try {
			// ��Socket��25�˿�
			Socket s = new Socket(mailServer, 25);
			// ������������
			BufferedReader in = new BufferedReader(new InputStreamReader(
					s.getInputStream(), "8859_1"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					s.getOutputStream(), "8859_1"));
			// ������HELLO�������ʾ�Է��������ʺ�
			send(in, out, "HELLO theWorld");
			// ���߷������ҵ��ʼ���ַ����Щ������ҪУ�������ַ
			send(in, out, "MAIL FROM: <213@qq.com>");
			// ʹ�á�RCPT TO��������߷����������ʼ����ʼ���ַ
			send(in, out, "RCPT TO: " + recipient);
			// ����һ����DATA����ʾ���潫���ʼ�����
			send(in, out, "DATA");
			// ʹ��Subject�����ע�ʼ�����
			send(out, "Subject: ����һ�����Գ���");
			// ʹ�á�From����ע�ʼ�����Դ
			send(out, "From: riverwind <213@qq.com>");
			send(out, "\n");
			// �ʼ�����
			send(out, "����һ��ʹ��SMTPЭ�鷢�͵��ʼ������������ɾ����");
			send(out, "\n.\n");
			// ���͡�QUIT���˿��ʼ���ͨѶ
			send(in, out, "QUIT");
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����˵����������Ϣ�������ջ��� ��������� �������ͣ�
	 */
	public void send(BufferedReader in, BufferedWriter out, String s) {
		try {
			out.write(s + "\n");
			out.flush();
			System.out.println(s);
			s = in.readLine();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����˵�������ط�������socketд����Ϣ ���������BufferedWriter out ��������� ���������String s д�����Ϣ
	 * �������ͣ�
	 */
	public void send(BufferedWriter out, String s) {
		try {
			out.write(s + "\n");
			out.flush();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}