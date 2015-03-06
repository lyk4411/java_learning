package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 
 * @author outofmemory.cn
 */
public class Main {

	/**
	 * LineNumberReader 类使用示例
	 */
	public void readFromFile(String filename) {

		LineNumberReader lineNumberReader = null;

		try {

			// 构造LineNumberReader实例
			lineNumberReader = new LineNumberReader(new FileReader(filename));

			String line = null;

			while ((line = lineNumberReader.readLine()) != null) {

				System.out.println("Line " + lineNumberReader.getLineNumber()
						+ ": " + line);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// 关闭lineNumberReader
			try {
				if (lineNumberReader != null) {
					lineNumberReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new Main().readFromFile("a.txt");
	}
}