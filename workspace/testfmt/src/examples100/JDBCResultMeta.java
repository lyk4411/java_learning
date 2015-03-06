package examples100;

import java.sql.*;

/**
 * Title: �����Ԫ���� Description: ʹ�ý����Ԫ���ݶ����ȡ���ݿ���Ϣ�� : Filename: JDBCResultMeta.java
 * 
 * 
 */
public class JDBCResultMeta {
	private String url = "";
	private String username = "";
	private String password = "";

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(java.lang.String[] args) {
		if (args.length != 4) {
			System.out
					.println("use: java JDBCResultMeta url username password tablename");
			return;
		}
		JDBCResultMeta JRM = new JDBCResultMeta();
		JRM.url = args[0];
		JRM.username = args[1];
		JRM.password = args[2];
		JRM.getMeta(JRM.conn(), args[3]);
	}

	/**
	 * ����˵��������������� ��������� �������ͣ�Connection ���Ӷ���
	 */
	public Connection conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.50.119.22:1521:biware1", "bestvwh",
					"whbRqt59s");
			return con;
		} catch (ClassNotFoundException cf) {
			System.out.println("can't find class" + cf);
			return null;
		} catch (SQLException sqle) {
			System.out.println("can't connection db:" + sqle);
			return null;
		} catch (Exception e) {
			System.out.println("Failed to load JDBC/ODBC driver.");
			return null;
		}
	}

	/**
	 * ����˵������ȡ�����Ԫ������Ϣ ���������Connection con ���ݿ����� ���������String table ������ �������ͣ�
	 */
	public void getMeta(Connection con, String table) {
		try {
			Statement Stm = con.createStatement();
			String sql = "select * from " + table;
			ResultSet rs = Stm.executeQuery(sql);
			ResultSetMetaData lineInfo = rs.getMetaData();
			System.out
					.println("*********************RESULT META Comment************************");
			// ��ȡ��������
			int columnCount = lineInfo.getColumnCount();
			System.out.println("Column Count :" + columnCount);
			// ��ȡ����������
			for (int i = 1; i < columnCount + 1; i++) {
				String columeName = lineInfo.getColumnName(i);
				String columeType = lineInfo.getColumnTypeName(i);
				boolean autocol = lineInfo.isAutoIncrement(i);
				System.out.println(columeName + " = " + columeType + "  :::  "
						+ autocol);
			}

		} catch (SQLException se) {
			// ������ݿ����Ӵ�����Ϣ
			System.out.println("SQL Exception: " + se.getMessage());
			se.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException se) {
			}
		}
	}

}