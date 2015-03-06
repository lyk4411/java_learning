package BookStore;

public class Book {
    private Integer bookID;
    private String bookName;
    private String bookWriter;
	public void setBookID(int bookID) {
		// TODO Auto-generated method stub
		this.bookID = bookID;
	}
	public void setBookName(String bookName) {
		// TODO Auto-generated method stub
		this.bookName = bookName;
	}
	public void setBookWriter(String bookWriter) {
		// TODO Auto-generated method stub
		this.bookWriter = bookWriter;
	}
	public Integer getBookID() {
		// TODO Auto-generated method stub
		return bookID;
	}
	public String getBookName() {
		// TODO Auto-generated method stub
		return bookName;
	}
	public String getBookWriter() {
		// TODO Auto-generated method stub
		return bookWriter;
	}

	public String toString(){
		return this.bookWriter + " write " + this.bookName;
	}
}
