package examples100;

import java.io.*;
import java.net.*;

/**
 * Title: WEB服务器 Description: 使用Socket创建一个WEB服务器，本程序是多线程系统以提高反应速度。 Filename:
 * WebServer.java
 */
class WebServer {
	public static String WEBROOT = "";// 默认目录
	public static String defaultPage = "index.htm";// 默认文件

	public static void main(String[] args) throws IOException {// 使用输入的方式通知服务默认目录位置，可用./root表示。
		if (args.length != 1) {
			System.out.println("USE: java WebServer ./rootdir");
			return;
		} else {
			WEBROOT = args[0];
		}
		System.out.println("Server starting...\n");
		// 使用8000端口提供服务
		ServerSocket server = new ServerSocket(8000);
		while (true) {
			// 阻塞，直到有客户连接
			Socket sk = server.accept();
			System.out.println("Accepting Connection...\n");
			// 启动服务线程
			new WebThread(sk).start();
		}
	}
}

/**
 * Title: 服务子线程 Description: 使用线程，为多个客户端服务
 * 
 * Filename:
 */
class WebThread extends Thread {
	private Socket sk;

	WebThread(Socket sk) {
		this.sk = sk;
	}

	/**
	 * 方法说明：线程体 输入参数： 返回类型：
	 */
	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = sk.getInputStream();
			out = sk.getOutputStream();
			// 接收来自客户端的请求。
			Request rq = new Request(in);
			// 解析客户请求
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
			// 最后释放资源
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