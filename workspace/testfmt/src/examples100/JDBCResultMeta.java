package examples100;

import java.sql.*;

/**
 * Title: 结果集元数据 Description: 使用结果集元数据对象获取数据库信息。 : Filename: JDBCResultMeta.java
 * 
 * 
 */
public class JDBCResultMeta {
	private String url = "";
	private String username = "";
	private String password = "";

	/**
	 * 方法说明：主方法 输入参数： 返回类型：
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
	 * 方法说明：获得数据连接 输入参数： 返回类型：Connection 连接对象
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
	 * 方法说明：获取结果集元数据信息 输入参数：Connection con 数据库连接 输入参数：String table 表名称 返回类型：
	 */
	public void getMeta(Connection con, String table) {
		try {
			Statement Stm = con.createStatement();
			String sql = "select * from " + table;
			ResultSet rs = Stm.executeQuery(sql);
			ResultSetMetaData lineInfo = rs.getMetaData();
			System.out
					.println("*********************RESULT META Comment************************");
			// 获取数据列数
			int columnCount = lineInfo.getColumnCount();
			System.out.println("Column Count :" + columnCount);
			// 获取数据列类型
			for (int i = 1; i < columnCount + 1; i++) {
				String columeName = lineInfo.getColumnName(i);
				String columeType = lineInfo.getColumnTypeName(i);
				boolean autocol = lineInfo.isAutoIncrement(i);
				System.out.println(columeName + " = " + columeType + "  :::  "
						+ autocol);
			}

		} catch (SQLException se) {
			// 输出数据库连接错误信息
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