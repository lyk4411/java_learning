package examples100;

import java.io.*;

/**
 * Title: 运行系统命令 Description:运行一个系统的命令，演示使用Runtime类。 Filename: CmdExec.java
 */
public class CmdExec {
	/**
	 * 方法说明：构造器，运行系统命令 输入参数：String cmdline 命令字符 返回类型：
	 */
	public CmdExec(String cmdline) {
		try {
			String line;
			// 运行系统命令
			Process p = Runtime.getRuntime().exec(cmdline);
			// 使用缓存输入流获取屏幕输出。
			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			// 读取屏幕输出
			while ((line = input.readLine()) != null) {
				System.out.println("java print:" + line);
			}
			// 关闭输入流
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 方法说明：主方法 输入参数： 返回类型：
	 */
	public static void main(String argv[]) {
		new CmdExec("myprog.bat");
	}
}