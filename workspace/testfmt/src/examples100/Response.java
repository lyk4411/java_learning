package examples100;

import java.io.*;

/**
 * Title: 发现HTTP内容和文件内容 Description: 获得用户请求后将用户需要的文件读出，添加上HTTP应答头。发送给客户端。
 * Filename: Response.java
 */
public class Response {
	OutputStream out = null;

	/**
	 * 方法说明：发送信息 输入参数：String ref 请求的文件名 返回类型：
	 */
	@SuppressWarnings("deprecation")
	public void Send(String ref) throws IOException {
		byte[] bytes = new byte[2048];
		FileInputStream fis = null;
		try {
			// 构造文件
			File file = new File(WebServer.WEBROOT, ref);
			if (file.exists()) {
				// 构造输入文件流
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, 2048);
				// 读取文件
				String sBody = new String(bytes, 0);
				// 构造输出信息
				String sendMessage = "HTTP/1.1 200 OK\r\n"
						+ "Content-Type: text/html\r\n" + "Content-Length: "
						+ ch + "\r\n" + "\r\n" + sBody;
				// 输出文件
				out.write(sendMessage.getBytes());
			} else {
				// 找不到文件
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Content-Length: 23\r\n" + "\r\n"
						+ "<h1>File Not Found</h1>";
				out.write(errorMessage.getBytes());
			}

		} catch (Exception e) {
			// 如不能实例化File对象，抛出异常。
			System.out.println(e.toString());
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	/**
	 * 方法说明：构造器，获取输出流 输入参数： 返回类型：
	 */
	public Response(OutputStream output) {
		this.out = output;
	}
}