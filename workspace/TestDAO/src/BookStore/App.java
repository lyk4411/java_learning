package BookStore;

import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDaoImpl bookDao = new BookDaoImpl();
        Book book = new Book();
        Integer bookID = 13574;// only for easy
        book.setBookID(bookID);
        book.setBookName("C++ primer");
        book.setBookWriter("not me");
        bookDao.save(book);
        
        List bookindatabase = bookDao.listBook();
        for(Iterator<Book> it = bookindatabase.iterator(); it.hasNext();){
        	System.out.println(it.next());
        }
	}

}
