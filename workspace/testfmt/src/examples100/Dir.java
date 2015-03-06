package examples100;

/** 
 * Title: Ŀ¼���� 
 * Description: ��ʾ��Ŀ¼�µ��ļ������ƶ�һ��Ŀ¼ 
 * Filename: Dir.java 
 */
import java.io.*;

public class Dir {
	/**
	 * ����˵����ʵ��Ŀ¼�б� ��������� �������ͣ�
	 */
	public String[] DirList(String pathName) {
		try {
			File path = null;
			String[] fileList;
			// ���û��ָ��Ŀ¼�����г���ǰĿ¼��
			if (pathName.equals(""))
				path = new File(".");
			else
				path = new File(pathName);
			// ��ȡĿ¼�ļ��б�
			if (path.isDirectory())
				fileList = path.list();
			else
				return null;
			return fileList;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	/**
	 * ����˵�����ƶ�һ��Ŀ¼ ���������String sou ԴĿ¼, String obj ��Ŀ¼ �������ͣ�
	 */
	public boolean DirMove(String sou, String obj) {
		try {
			// ���Դ�ļ��Ƿ����
			boolean sexists = (new File(sou)).isDirectory();
			if (!sexists)
				return false;
			boolean oexists = (new File(obj)).isDirectory();
			// Ŀ��Ŀ¼�����ڣ�����һ��
			if (!oexists) {
				(new File(obj)).mkdirs();
			}

			File file = new File(sou);
			File dir = new File(obj);
			// �ƶ�Ŀ¼
			boolean success = file.renameTo(new File(dir, file.getName()));
			if (!success) {
				System.out.println("copy error!");
				return false;
			} else
				return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] args) {
		Dir d = new Dir();
		if (args.length == 0) {
			return;
		} else {
			String cmd = args[0];
			if (cmd.equals("list")) {
				if (args.length != 2)
					return;
				String[] sTemp = d.DirList(args[1]);
				for (int i = 0; i < sTemp.length; i++)
					System.out.println(sTemp[i]);
			} else if (cmd.equals("move")) {
				if (args.length != 3)
					return;
				d.DirMove(args[1], args[2]);
			}

		}
	}
}