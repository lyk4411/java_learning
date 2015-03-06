package examples100;

//文件名：myZip.java  
import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * Title: 文件压缩和解压 Description: 使用ZipInputStream和ZipOutputStream对文件 和目录进行压缩和解压处理
 * Filename: myZip.java
 */
public class myZip {
	/**
	 * 方法说明：实现文件的压缩处理 输入参数：String[] fs 压缩的文件数组 返回类型：
	 */
	public void ZipFiles(String[] fs) {
		try {
			String fileName = fs[0];
			FileOutputStream f = new FileOutputStream(fileName + ".zip");
			// 使用输出流检查
			CheckedOutputStream cs = new CheckedOutputStream(f, new Adler32());
			// 声明输出zip流
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
					cs));
			// 写一个注释
			out.setComment("A test of Java Zipping");
			// 对多文件进行压缩
			for (int i = 1; i < fs.length; i++) {
				System.out.println("Write file " + fs[i]);
				BufferedReader in = new BufferedReader(new FileReader(fs[i]));
				out.putNextEntry(new ZipEntry(fs[i]));
				int c;
				while ((c = in.read()) != -1)
					out.write(c);
				in.close();
			}
			// 关闭输出流
			out.close();
			System.out.println("Checksum::" + cs.getChecksum().getValue());
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * 方法说明：解压缩Zip文件 输入参数：String fileName 解压zip文件名 返回类型：
	 */
	public void unZipFile(String fileName) {
		try {
			System.out.println("读取ZIP文件........");
			// 文件输入流
			FileInputStream fi = new FileInputStream(fileName + ".zip");
			// 输入流检查
			CheckedInputStream csi = new CheckedInputStream(fi, new Adler32());
			// 输入流压缩
			ZipInputStream in2 = new ZipInputStream(
					new BufferedInputStream(csi));
			ZipEntry ze;
			System.out.println("Checksum::" + csi.getChecksum().getValue());
			// 解压全部文件
			while ((ze = in2.getNextEntry()) != null) {
				System.out.println("Reading file " + ze);
				int x;
				while ((x = in2.read()) != -1)
					// 这里是写文件，write是以byte方式输出。
					System.out.write(x);
			}
			in2.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * 方法说明：读取Zip文件列表 输入参数：String fileName zip文件名 返回类型：Vector 文件列表
	 */
	@SuppressWarnings("unchecked")
	public Vector<Object> listFile(String fileName) {
		try {
			@SuppressWarnings("unused")
			String[] aRst = null;
			Vector<Object> vTemp = new Vector<Object>();
			// zip文件对象
			ZipFile zf = new ZipFile(fileName + ".zip");
			Enumeration e = zf.entries();
			while (e.hasMoreElements()) {
				ZipEntry ze2 = (ZipEntry) e.nextElement();
				System.out.println("File: " + ze2);
				vTemp.addElement(ze2);
			}
			return vTemp;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	/**
	 * 方法说明：主方法 输入参数： 返回类型：
	 */
	public static void main(String[] args) {
		try {
			String fileName = args[0];
			myZip myZip = new myZip();
			myZip.ZipFiles(args);
			myZip.unZipFile(fileName);
			Vector<Object> dd = myZip.listFile(fileName);
			System.out.println("File List: " + dd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
