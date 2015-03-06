package BookStore;
import java.util.List;

public interface BookDAO {
    public List listBook();
    public Boolean save(Book book);

}