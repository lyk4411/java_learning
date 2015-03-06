package examples100;

import java.util.*;
import java.io.*;

/**
 * Title: 标注输入输出 Description: 接收标准的键盘输入，和输出到屏幕。 Filename: standerdIO.java
 */
public class standerdIO {
	/**
	 * 方法说明：主方法 输入参数： 返回类型：
	 */
	public static void main(String[] args) {
		Vector<Object> vTemp = new Vector<Object>();
		boolean flag = true;
		while (flag) {
			System.out.print("input>");
			String sTemp = "";
			// 读取输入,System.in表示接收键盘输入流
			BufferedReader stdin = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				// 读取一行输入
				sTemp = stdin.readLine();
			} catch (IOException ie) {
				System.err.println("IO error!");
			}
			// 解析输入命令
			String sCMD = "";
			String sContext = "";
			int point = sTemp.indexOf(":");
			if (point == -1) {
				sCMD = sTemp.trim();
			} else {
				sCMD = sTemp.substring(0, point);
				sContext = sTemp.substring(point + 1);
			}
			// 添加数据
			if (sCMD.equalsIgnoreCase("in")) {
				if (sContext.equals("")) {
					System.err.println("this command format is errer!");
				} else {
					vTemp.addElement(sContext);
				}
			}// 查看结果
			else if (sCMD.equalsIgnoreCase("out")) {
				for (int i = 0; i < vTemp.size(); i++) {
					System.out.println(i + ":" + vTemp.elementAt(i));
				}
			}// 结束
			else if (sCMD.equalsIgnoreCase("quit")) {
				flag = false;
			} else {
				System.err.println("this command don't run!");
				System.out.print("use:   in:command");
				System.out.print("use:   out");
			}
		}
	}
}