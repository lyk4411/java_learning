package examples100;

import java.sql.*;

/**
 * Title: JDBC�������ݿ� Description: ��ʵ����ʾ���ʹ��JDBC����Oracle���ݿ⣬����ʾ������ݺͲ�ѯ���ݡ� :
 * Filename: JDBCConn.java
 * 
 * 
 */
public class JDBCConn {
	private String url = "";
	private String username = "";
	private String password = "";

	/**
	 * ����˵��������������� ��������� �������ͣ�Connection ���Ӷ���
	 */
	public Connection conn() {
		try {
			// ����JDBC����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// �������ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.50.119.22:1521:biware1", "bestvwh", "whbRqt59s");
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
	 * ����˵����ִ�в�ѯSQL��� ���������Connection con ���ݿ����� ���������String sql Ҫִ�е�SQL��� �������ͣ�
	 */
	public void query(Connection con, String sql) {
		try {
			if (con == null) {
				throw new Exception("database connection can't use!");
			}
			if (sql == null)
				throw new Exception(
						"check your parameter: 'sql'! don't input null!");
			// �������
			Statement stmt = con.createStatement();
			// ִ�в�ѯ
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rmeta = rs.getMetaData();
			// ��������ֶθ���
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
			System.out.println("execute error: sql = " + sql);
			System.out.println(e);
		}
	}

	/**
	 * ����˵����ʵ����ʾ ��������� �������ͣ�
	 */
	public void demo() {
		try {
			JDBCConn oc = new JDBCConn();
			Connection conn = oc.conn();
			String sql = "insert into userinfo(name,address)values('switc11111h','ne1111w York')";
			oc.execute(conn, sql);
			sql = "select * from userinfo";
			oc.query(conn, sql);
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
			System.out.println("use: java JDBCConn url username password");
			return;
		}
		JDBCConn oc = new JDBCConn();
		oc.url = arg[0];
		oc.username = arg[1];
		oc.password = arg[2];
		oc.demo();
	}
}
