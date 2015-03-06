package examples100;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: �Լ�����ı�� Description: �̳�AbstractTableModel�࣬ʵ���Լ��ı�� Flename:
 * MyTableDemo.java
 */
public class MyTableDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyTableDemo() {
		super("MyTableDemo");
		// �����Լ��ı�񣬲���ӵ�JTable��
		MyTableModel myModel = new MyTableModel();
		JTable table = new JTable(myModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));

		// �������ӵ��ɹ��������
		JScrollPane scrollPane = new JScrollPane(table);

		// �����������ӵ�����
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		// ��Ӽ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * Title: �����Լ��ı��ģʽ Description: ͨ���̳�AbstractTableModel���������Լ��ı��ģʽ��
	 * ����ʹ�õ������Ժ�ſ��Ա༭
	 */
	class MyTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		// �����ͷ
		final String[] columnNames = { "����", "�Ա�", "ѧ��", "����", "�Ƿ��ѻ�" };
		// ��ʼ��������
		final Object[][] data = {
				{ "����", "��", "��", new Integer(25), new Boolean(false) },
				{ "����", "��", "��", new Integer(33), new Boolean(true) },
				{ "����", "��", "����", new Integer(20), new Boolean(false) },
				{ "��ٻ", "Ů", "��ר", new Integer(26), new Boolean(true) },
				{ "�ܴ�", "��", "��", new Integer(24), new Boolean(false) } };

		/**
		 * ����˵�����̳�AbstractTableModel����ʵ�ֵķ��� ��������� �������ͣ�int ����
		 */
		public int getColumnCount() {
			return columnNames.length;
		}

		/**
		 * ����˵�����̳�AbstractTableModel����ʵ�ֵķ��� ��������� �������ͣ�int ����
		 */
		public int getRowCount() {
			return data.length;
		}

		/**
		 * ����˵�����̳�AbstractTableModel����ʵ�ֵķ��� ��������� �������ͣ�String ����
		 */
		public String getColumnName(int col) {
			return columnNames[col];
		}

		/**
		 * ����˵�����̳�AbstractTableModel����ʵ�ֵķ�������ȡ����е����� ���������int row ���� ���������int
		 * col ���� �������ͣ�Object ���ݶ���
		 */
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/**
		 * ����˵����ʵ���������ʹ�����һ�в�����ʾtrue��false������ʹ�ü��� ��������� �������ͣ�
		 */
		@SuppressWarnings("unchecked")
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/**
		 * ����˵�������������һ����Ҫʵ�֡�������Ϊ�˶���ɱ༭���� ��������� �������ͣ�boolean �Ƿ�ɱ༭
		 */
		public boolean isCellEditable(int row, int col) {
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		/**
		 * ����˵����ʵ�ִ˷�������ñ༭���ݡ� ��������� �������ͣ�
		 */
		public void setValueAt(Object value, int row, int col) {
			System.out
					.println("�޸�����λ�ã� " + row + "," + col + " ������Ϊ�� " + value);

			data[row][col] = value;
			fireTableCellUpdated(row, col);

			System.out.println("���������:");
			printDebugData();

		}

		/**
		 * ����˵�����������е������� ��������� �������ͣ�
		 */
		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    �� " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyTableDemo frame = new MyTableDemo();
		frame.pack();
		frame.setVisible(true);
	}
}