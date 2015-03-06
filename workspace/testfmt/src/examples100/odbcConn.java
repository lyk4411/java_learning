package examples100;

import java.sql.*;

/**
 * Title: ODBC�������ݿ� Description: ��ʵ����ʾ���ʹ��JDBC-ODBC�Ų������ݿ⡣ : Filename:
 * odbcConn.java
 * 
 * 
 */
public class odbcConn {
	private String url = "";
	private String username = "";
	private String password = "";

	/**
	 * ����˵��������������� ��������� �������ͣ�Connection ���Ӷ���
	 */
	public Connection conn() {
		try {

			String username = "bestvwh";
			String password = "whbRqt59s";
			String url = "jdbc:oracle:thin:@10.50.119.22:1521:biware1";
			String driver = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username,
					password);

			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��ȡ����
			// Connection con = DriverManager.getConnection(
			// "jdbc:oracle:thin:@10.50.119.22:1521:biware1", "bestvwh",
			// "whbRqt59s");
			return con;
		} catch (SQLException sqle) {
			System.out.println("can't connection db:" + sqle);
			return null;
		} catch (Exception e) {
			System.out.println("Failed to load JDBC/ODBC driver.");
			return null;
		}
	}

	/**
	 * ����˵����ִ�в�ѯSQL��� ���������Connection con ���ݿ����� ���������String sql Ҫִ�е�SQL��� �������ͣ�
	 */
	public void query(Connection con, String sql) {
		try {
			if (con == null)
				return;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rmeta = rs.getMetaData();
			int numColumns = rmeta.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < numColumns; i++) {
					String sTemp = rs.getString(i + 1);
					System.out.print(sTemp + "  ");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("query error:" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
			}
		}
	}

	/**
	 * ����˵����ִ�в��롢���¡�ɾ����û�з��ؽ������SQL��� ���������Connection con ���ݿ����� ���������String sql
	 * Ҫִ�е�SQL��� �������ͣ�
	 */
	public void execute(Connection con, String sql) {
		try {
			if (con == null)
				return;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("query error:" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
			}
		}
	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] arg) {
		if (arg.length != 3) {
			System.out.println("use: java odbcConn url username password");
			return;
		}
		odbcConn oc = new odbcConn();
		oc.url = arg[0];
		oc.username = arg[1];
		oc.password = arg[2];
		oc.execute(oc.conn(),
				"insert into userinfo(name,address)values('switch','new York')");
		oc.query(oc.conn(), "select * from userinfo");
	}
}
