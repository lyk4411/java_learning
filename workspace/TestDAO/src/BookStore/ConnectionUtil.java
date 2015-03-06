package BookStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public Connection getConnection() throws ClassNotFoundException, Exception
    {
        String username="bestvwh";
        String password="whbRqt59s";
        String url="jdbc:oracle:thin:@10.50.119.22:1521:biware1";
        String driver="oracle.jdbc.driver.OracleDriver";
        
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}