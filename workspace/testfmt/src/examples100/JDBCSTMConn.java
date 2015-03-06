package examples100;

import java.sql.*;

/**
 * Title: JDBC�������ݿ� Description: ��ʵ����ʾ���ʹ��JDBC����Oracle���ݿ⣬����ʾ������ݺͲ�ѯ���ݡ� :
 * Filename: JDBCSTMConn.java
 * 
 * 
 */
public class JDBCSTMConn {
	private static String url = "";
	private static String username = "";
	private static String password = "";

	/**
	 * ����˵��������������� ��������� �������ͣ�Connection ���Ӷ���
	 */
	public Connection conn() {
		try {
			// ����JDBC����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// �������ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.50.119.22:1521:biware1", "bestvwh",
					"whbRqt59s");
			return con;
		} catch (ClassNotFoundException cnf) {
			System.out.println("driver not find:" + cnf);
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
	 * ����˵�������ô洢���̣��쿴���ݽ�� ���������Connection con ���ݿ����� ���������String sql Ҫִ�е�SQL���
	 * �������ͣ�
	 */
	public void execute(Connection con) {
		CallableStatement toesUp = null;
		try {
			con.setAutoCommit(false);
			// ���ô洢����
			toesUp = con.prepareCall("{call p_test(?)}");
			// ���ݲ������洢����
			toesUp.setInt(1, 6);
			// ִ�д洢����
			toesUp.executeQuery();

			Statement stmt = con.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM TEST");
			while (rs.next()) {
				String ID = rs.getString(1);
				String NAME = rs.getString(2);
				System.out.println(ID + " " + NAME);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
			try {
				toesUp.close();
				con.close();
			} catch (Exception es) {
				System.out.println(es);
			}
		}
	}

	/**
	 * ����˵����ʵ����ʾ ��������� �������ͣ�
	 */
	public void demo() {
		try {
			JDBCSTMConn oc = new JDBCSTMConn();
			Connection conn = oc.conn();
			oc.execute(conn);
			conn.close();
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] arg) {
		if (arg.length != 3) {
			System.out.println("use: java JDBCSTMConn url username password");
			return;
		}
		JDBCSTMConn oc = new JDBCSTMConn();
		oc.url = arg[0];
		oc.username = arg[1];
		oc.password = arg[2];
		oc.demo();
	}
}
