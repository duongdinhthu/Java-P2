package connectDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = MySqlConnect.getMySQLConnection();
        // an di cac cau lenh truy van SQL
        String sql = "{call getCustomer(?,?,?,?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setInt(1, 5);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.registerOutParameter(4, Types.VARCHAR); // Đăng ký tham số đầu ra bằng chỉ mục
        callableStatement.executeUpdate();

        System.out.println("fname:" + callableStatement.getString(2));
        System.out.println("lname:" + callableStatement.getString(3));
        System.out.println("email:" + callableStatement.getString(4));
    }
}