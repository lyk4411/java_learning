package BookStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDAO {
	
	
	public List listBook() {
		// TODO Auto-generated method stub
		ConnectionUtil conU = new ConnectionUtil();
		Connection con = null;
		List<Book> list = new ArrayList<Book>();
		try {
			con = conU.getConnection();
			String QuerySQL = "select * from book";
			PreparedStatement ps = con.prepareStatement(QuerySQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookWriter(rs.getString(3));
				list.add(book);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public Boolean save(Book book) {
		// TODO Auto-generated method stub
		ConnectionUtil conU = new ConnectionUtil();
		Connection con = null;
		Boolean flag = false;
		try {
			con = conU.getConnection();

			String InsertSQL = "insert into book values(" + book.getBookID() + ",'"
					+ book.getBookName() + "','" + book.getBookWriter() + "')";
			PreparedStatement ps = con.prepareStatement(InsertSQL);
			flag = ps.execute();
			return flag;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
}
