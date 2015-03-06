package examples100;

import java.sql.*;

/**
 * Title: JDBC连接数据库 Description: 本实例演示如何使用JDBC连接Oracle数据库，并演示添加数据和查询数据。 :
 * Filename: JDBCConn.java
 * 
 * 
 */
public class JDBCConn {
	private String url = "";
	private String username = "";
	private String password = "";

	/**
	 * 方法说明：获得数据连接 输入参数： 返回类型：Connection 连接对象
	 */
	public Connection conn() {
		try {
			// 加载JDBC驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 创建数据库连接
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
	 * 方法说明：执行查询SQL语句 输入参数：Connection con 数据库连接 输入参数：String sql 要执行的SQL语句 返回类型：
	 */
	public void query(Connection con, String sql) {
		try {
			if (con == null) {
				throw new Exception("database connection can't use!");
			}
			if (sql == null)
				throw new Exception(
						"check your parameter: 'sql'! don't input null!");
			// 声明语句
			Statement stmt = con.createStatement();
			// 执行查询
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rmeta = rs.getMetaData();
			// 获得数据字段个数
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
	 * 方法说明：执行插入、更新、删除等没有返回结果集的SQL语句 输入参数：Connection con 数据库连接 输入参数：String sql
	 * 要执行的SQL语句 返回类型：
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
	 * 方法说明：实例演示 输入参数： 返回类型：
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
	 * 方法说明：主方法 输入参数： 返回类型：
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
