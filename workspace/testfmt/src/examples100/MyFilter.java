package examples100;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * Title: �ļ���������ʾ Description: FileChooserDemo�ļ�ʹ�õ��ļ������� Filename: MyFilter.java
 */

public class MyFilter extends FileFilter {
	@SuppressWarnings("unused")
	private String files;

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = getExtension(f);
		if (extension != null) {

			if (extension.equals("java")) {// �������Java�ļ�
				return true;
			} else {
				return false;
			}

		}

		return false;
	}

	// ����������
	public String getDescription() {
		return "Java";
	}

	/**
	 * ����˵������ȡ�ļ���չ��
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}