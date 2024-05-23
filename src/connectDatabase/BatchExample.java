package connectDatabase;

import java.sql.SQLException;
import java.sql.Statement;



import static connectDatabase.CRUDatabase.openConnection;

public class BatchExample {
    public static void main(String[] args) throws SQLException {
        openConnection();
        // xu ly theo batch , cung 1 c chay nhieu cau lenh
        //update , insert
        Statement statement = openConnection().createStatement();
        //query 1
        String query = "update customer set first_name = 'Tran' where customer_id = 1";
        statement.addBatch(query);
        String query2 = "update customer set first_name like 'Ngo' where customer_id = 2";
        statement.addBatch(query2);
        int []count = statement.executeBatch();
        System.out.println("Query1: " + count[0]);
        System.out.println("query2 :" + count[1]);
        openConnection().commit();
    }
}
