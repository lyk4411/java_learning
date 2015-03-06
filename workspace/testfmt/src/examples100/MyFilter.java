package examples100;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * Title: 文件过滤器演示 Description: FileChooserDemo文件使用的文件过滤器 Filename: MyFilter.java
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

			if (extension.equals("java")) {// 定义过滤Java文件
				return true;
			} else {
				return false;
			}

		}

		return false;
	}

	// 过滤器描述
	public String getDescription() {
		return "Java";
	}

	/**
	 * 方法说明：获取文件扩展名
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