package connectDatabase;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatement {
    public static void main(String[] args) throws SQLException {
        //get connection
        Connection connection = MySqlConnect.getMySQLConnection();
        String query = "select * from customer where customer_id = ? and first_name like ?";
        //create preparestatement

        PreparedStatement pstm = connection.prepareStatement(query);
        //Gan gia tri cho tham so thao thu tu
        pstm.setInt(1,2);
        pstm.setString(2,"ok");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            System.out.println("=============");
            System.out.println("id" + rs.getInt(1));
            System.out.println("fn" + rs.getInt(2));
            System.out.println("ln" + rs.getInt(3));
            System.out.println("email" + rs.getInt(4));
        }
    }
}
