package DAO;
import java.util.List;


public interface TaskDAO {
    public int insertTask(Task task);
    public int deleteTask(String taskid);
    public int deleteTask(Task task);
    public int updateTask(Task task);
    public List getTasks();
    public Task selectTask(String taskid);
    public int touchTask(String taskid);
}