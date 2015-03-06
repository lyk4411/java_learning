package examples100;

//�ļ�����myZip.java  
import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * Title: �ļ�ѹ���ͽ�ѹ Description: ʹ��ZipInputStream��ZipOutputStream���ļ� ��Ŀ¼����ѹ���ͽ�ѹ����
 * Filename: myZip.java
 */
public class myZip {
	/**
	 * ����˵����ʵ���ļ���ѹ������ ���������String[] fs ѹ�����ļ����� �������ͣ�
	 */
	public void ZipFiles(String[] fs) {
		try {
			String fileName = fs[0];
			FileOutputStream f = new FileOutputStream(fileName + ".zip");
			// ʹ����������
			CheckedOutputStream cs = new CheckedOutputStream(f, new Adler32());
			// �������zip��
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
					cs));
			// дһ��ע��
			out.setComment("A test of Java Zipping");
			// �Զ��ļ�����ѹ��
			for (int i = 1; i < fs.length; i++) {
				System.out.println("Write file " + fs[i]);
				BufferedReader in = new BufferedReader(new FileReader(fs[i]));
				out.putNextEntry(new ZipEntry(fs[i]));
				int c;
				while ((c = in.read()) != -1)
					out.write(c);
				in.close();
			}
			// �ر������
			out.close();
			System.out.println("Checksum::" + cs.getChecksum().getValue());
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * ����˵������ѹ��Zip�ļ� ���������String fileName ��ѹzip�ļ��� �������ͣ�
	 */
	public void unZipFile(String fileName) {
		try {
			System.out.println("��ȡZIP�ļ�........");
			// �ļ�������
			FileInputStream fi = new FileInputStream(fileName + ".zip");
			// ���������
			CheckedInputStream csi = new CheckedInputStream(fi, new Adler32());
			// ������ѹ��
			ZipInputStream in2 = new ZipInputStream(
					new BufferedInputStream(csi));
			ZipEntry ze;
			System.out.println("Checksum::" + csi.getChecksum().getValue());
			// ��ѹȫ���ļ�
			while ((ze = in2.getNextEntry()) != null) {
				System.out.println("Reading file " + ze);
				int x;
				while ((x = in2.read()) != -1)
					// ������д�ļ���write����byte��ʽ�����
					System.out.write(x);
			}
			in2.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * ����˵������ȡZip�ļ��б� ���������String fileName zip�ļ��� �������ͣ�Vector �ļ��б�
	 */
	@SuppressWarnings("unchecked")
	public Vector<Object> listFile(String fileName) {
		try {
			@SuppressWarnings("unused")
			String[] aRst = null;
			Vector<Object> vTemp = new Vector<Object>();
			// zip�ļ�����
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
	 * ����˵���������� ��������� �������ͣ�
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
