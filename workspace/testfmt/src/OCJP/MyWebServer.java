package OCJP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(9999);

			while (true) {
				Socket s = ss.accept();

				System.out.println("wait linking at 9999");
				OutputStream os = s.getOutputStream();

				BufferedReader br = new BufferedReader(new FileReader(
						"E:\\国外计算机\\韩顺平servlet视频\\hello.html"));

				String buf = "";
				while ((buf = br.readLine()) != null) {
					os.write(buf.getBytes());
				}

				br.close();
				os.close();
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}
