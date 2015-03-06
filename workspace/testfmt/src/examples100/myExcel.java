package examples100;

import java.io.File;
import jxl.*;
import jxl.write.*;

/**
 * Title: ����EXCEL�ļ� Description: ��ʵ����ʾʹ��jxl��ʵ�ֶ�excel�ļ��Ĳ��� Filename: myExcel.java
 */
public class myExcel {
	Workbook workbook;
	Sheet sheet;

	/**
	 * ����˵����д���ļ����� ��������� �������ͣ�
	 */
	public void write() {
		try {
			// ����һ����д���excel�ļ�����
			WritableWorkbook workbook = Workbook.createWorkbook(new File(
					"myfile.xls"));
			// ʹ�õ�һ�Ź�������������Ϊ����ͼ�¼��
			WritableSheet sheet = workbook.createSheet("��ͼ�¼", 0);
			// ��ͷ
			Label label0 = new Label(0, 0, "ʱ��");
			sheet.addCell(label0);
			Label label1 = new Label(1, 0, "����");
			sheet.addCell(label1);
			Label label2 = new Label(2, 0, "��ͱ�׼");
			sheet.addCell(label2);
			Label label3 = new Label(3, 0, "ʵ�ʷ���");
			sheet.addCell(label3);
			// ��ʽ������
			jxl.write.DateFormat df = new jxl.write.DateFormat(
					"yyyy-dd-MM  hh:mm:ss");
			jxl.write.WritableCellFormat wcfDF = new jxl.write.WritableCellFormat(
					df);
			jxl.write.DateTime labelDTF = new jxl.write.DateTime(0, 1,
					new java.util.Date(), wcfDF);
			sheet.addCell(labelDTF);
			// ��ͨ�ַ�
			Label labelCFC = new Label(1, 1, "riverwind");
			sheet.addCell(labelCFC);
			// ��ʽ������
			jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##");
			WritableCellFormat wcfN = new WritableCellFormat(nf);
			jxl.write.Number labelNF = new jxl.write.Number(2, 1, 13.1415926,
					wcfN);
			sheet.addCell(labelNF);

			jxl.write.Number labelNNF = new jxl.write.Number(3, 1, 10.50001,
					wcfN);
			sheet.addCell(labelNNF);
			// �رն����ͷ���Դ
			workbook.write();
			workbook.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * ����˵������ȡexcel�ļ�һ������ ���������int rowָ�������� �������ͣ�String�����������
	 */
	public String[] readLine(int row) {
		try {
			// ��ȡ���ݱ�����
			int colnum = sheet.getColumns();
			String[] rest = new String[colnum];
			for (int i = 0; i < colnum; i++) {
				String sTemp = read(i, row);
				if (sTemp != null)
					rest[i] = sTemp;
			}
			return rest;
		} catch (Exception e) {
			System.out.println("readLine err:" + e);
			workbook.close();
			return null;
		}
	}

	/**
	 * ����˵������ȡexcel��ָ����Ԫ���� ��������� �������ͣ�
	 */
	public String read(int col, int row) {
		try {
			// ��õ�Ԫ����
			Cell a2 = sheet.getCell(col, row);
			String rest = a2.getContents();
			return rest;
		} catch (Exception e) {
			System.out.println("read err:" + e);
			workbook.close();
			return null;
		}
	}

	/**
	 * ����˵��������������ʾ������ ��������� �������ͣ�
	 */
	public static void main(String[] arges) {
		try {
			myExcel me = new myExcel();
			// ����һ���ɶ�ȡ��excel�ļ�����
			me.workbook = Workbook.getWorkbook(new File("myfile.xls"));
			// ʹ�õ�һ��������
			me.sheet = me.workbook.getSheet(0);
			// ��һ�м�¼������ʾ����
			String[] ssTemp = me.readLine(1);
			for (int i = 0; i < ssTemp.length; i++)
				System.out.println(ssTemp[i]);
			// д������
			me.write();

			me.workbook.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}