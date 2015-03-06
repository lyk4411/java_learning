package examples100;

import java.io.*;
import java.net.*;

/**
 * Title: WEB������ Description: ʹ��Socket����һ��WEB���������������Ƕ��߳�ϵͳ����߷�Ӧ�ٶȡ� Filename:
 * WebServer.java
 */
class WebServer {
	public static String WEBROOT = "";// Ĭ��Ŀ¼
	public static String defaultPage = "index.htm";// Ĭ���ļ�

	public static void main(String[] args) throws IOException {// ʹ������ķ�ʽ֪ͨ����Ĭ��Ŀ¼λ�ã�����./root��ʾ��
		if (args.length != 1) {
			System.out.println("USE: java WebServer ./rootdir");
			return;
		} else {
			WEBROOT = args[0];
		}
		System.out.println("Server starting...\n");
		// ʹ��8000�˿��ṩ����
		ServerSocket server = new ServerSocket(8000);
		while (true) {
			// ������ֱ���пͻ�����
			Socket sk = server.accept();
			System.out.println("Accepting Connection...\n");
			// ���������߳�
			new WebThread(sk).start();
		}
	}
}

/**
 * Title: �������߳� Description: ʹ���̣߳�Ϊ����ͻ��˷���
 * 
 * Filename:
 */
class WebThread extends Thread {
	private Socket sk;

	WebThread(Socket sk) {
		this.sk = sk;
	}

	/**
	 * ����˵�����߳��� ��������� �������ͣ�
	 */
	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = sk.getInputStream();
			out = sk.getOutputStream();
			// �������Կͻ��˵�����
			Request rq = new Request(in);
			// �����ͻ�����
			String sURL = rq.parse();
			System.out.println("sURL=" + sURL);
			if (sURL.equals("/"))
				sURL = WebServer.defaultPage;
			Response rp = new Response(out);
			rp.Send(sURL);
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("Closing Connection...\n");
			// ����ͷ���Դ
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (sk != null)
					sk.close();
			} catch (IOException e) {
			}
		}
	}
}