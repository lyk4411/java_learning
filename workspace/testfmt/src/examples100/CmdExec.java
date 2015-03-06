package examples100;

import java.io.*;

/**
 * Title: ����ϵͳ���� Description:����һ��ϵͳ�������ʾʹ��Runtime�ࡣ Filename: CmdExec.java
 */
public class CmdExec {
	/**
	 * ����˵����������������ϵͳ���� ���������String cmdline �����ַ� �������ͣ�
	 */
	public CmdExec(String cmdline) {
		try {
			String line;
			// ����ϵͳ����
			Process p = Runtime.getRuntime().exec(cmdline);
			// ʹ�û�����������ȡ��Ļ�����
			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			// ��ȡ��Ļ���
			while ((line = input.readLine()) != null) {
				System.out.println("java print:" + line);
			}
			// �ر�������
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String argv[]) {
		new CmdExec("myprog.bat");
	}
}