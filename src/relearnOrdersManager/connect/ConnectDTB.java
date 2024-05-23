package relearnOrdersManager.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDTB {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        String hostName = "127.0.0.1";
        String dbName = "ordermanager";
        String userName= "root";
        String password = "";
        String connectURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        connection = DriverManager.getConnection(connectURL,userName,password);
        return connection;
    }
    }
