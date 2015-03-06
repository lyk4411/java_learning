package examples100;

import java.io.*;

/**
 * Title: ��ȡ����ļ� Description: ��ʾʹ��RandomAccessFile���ȡ�ļ��� Filename: RandFile.java
 */
public class RandFile {
	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] args) {
		String sFile;
		if (args.length < 1) {
			System.out.println("USE:java RandFile fileName");
			return;
		} else {
			sFile = args[0];
		}
		// ����IOException�쳣
		try {
			// ������������ļ���ʹ�ÿɶ�д��ʽ��
			RandomAccessFile rf = new RandomAccessFile(sFile, "rw");
			for (int i = 0; i < 10; i++)
				rf.writeDouble(i * 1.414);
			rf.close();
			// ����һ����������ļ���ʹ��ֻ����ʽ
			rf = new RandomAccessFile(sFile, "rw");
			rf.seek(5 * 8);
			rf.writeDouble(47.0001);
			rf.close();
			// ����һ������ļ������ļ���ʹ��ֻ����ʽ��
			rf = new RandomAccessFile(sFile, "r");
			for (int i = 0; i < 10; i++)
				System.out.println("Value " + i + ": " + rf.readDouble());
			rf.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
