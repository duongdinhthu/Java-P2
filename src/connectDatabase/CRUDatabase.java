package connectDatabase;



import java.sql.*;

public class CRUDatabase {

    public static  String tableDB = null;
    public static void setTableDB(String tableDB) {
        CRUDatabase.tableDB = tableDB;
    }
    public static Connection connection;



    public static Connection openConnection() throws SQLException {
        connection = MySqlConnect.getMySQLConnection();
        return connection;
    }

    public static Statement statement;

    public static Statement openStatement() throws SQLException {
        statement = openConnection().createStatement();
        return statement;
    }

    public static void setStatementUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public static void createCustomer(String id, String fname, String lname, String email) throws SQLException {
        openConnection();

        String query = "INSERT INTO " + tableDB + " (customer_id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setString(1, id);
        pstm.setString(2, fname);
        pstm.setString(3, lname);
        pstm.setString(4, email);

        int create = pstm.executeUpdate(); // Thực thi câu truy vấn
        if (create>0){
            System.out.println("Create success!");
        }else {
            System.out.println("Create failure");
        }
        closeConnection();
    }

    public static void updateCustomer(String id, String newID, String newFName, String newLName, String newEmail) throws SQLException {
        openConnection();

        String query = "UPDATE " + tableDB + " SET first_name = ?, customer_id = ?, last_name = ?, email = ? WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setString(1, newFName);
        pstm.setString(2, newID);
        pstm.setString(3, newLName);
        pstm.setString(4, newEmail);
        pstm.setString(5, id);

        int success = pstm.executeUpdate(); // Thực thi câu truy vấn UPDATE
        if (success>0){
            System.out.println("Update success!");
        }else {
            System.out.println("Update failure!");
        }
        closeConnection();
    }

    public static void deleteCustomer(int id) throws SQLException {
        openConnection();

        String query = "DELETE FROM " + tableDB + " WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setInt(1, id);

        int delete = pstm.executeUpdate();

        if (delete > 0) {
            System.out.println("Delete success!");
        } else {
            System.out.println("Delete failure!");
        }

        closeConnection();
    }
    public static void searchCustomer(String name) throws SQLException {
        openConnection();
        String query = "SELECT * FROM " + tableDB + " WHERE first_name = ?"; // Thêm tên bảng trực tiếp vào câu truy vấn
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setString(1,name);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int pid = rs.getInt("customer_id");
            String fname = rs.getString("first_name");
            String lname = rs.getString("last_name");
            String email = rs.getString("email");

            System.out.println("===============");
            System.out.println("Customer ID : " + pid);
            System.out.println("First name : " + fname);
            System.out.println("Last name : " + lname);
            System.out.println("Email : " + email);
        }

        closeConnection();
    }
    public static void getAll() throws SQLException {
        openConnection();
        String query = "SELECT * FROM " + tableDB; // Thêm tên bảng trực tiếp vào câu truy vấn
        PreparedStatement pstm = connection.prepareStatement(query);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int pid = rs.getInt("customer_id");
            String fname = rs.getString("first_name");
            String lname = rs.getString("last_name");
            String email = rs.getString("email");

            System.out.println("===============");
            System.out.println("Customer ID : " + pid);
            System.out.println("First name : " + fname);
            System.out.println("Last name : " + lname);
            System.out.println("Email : " + email);
        }

        closeConnection();
    }


    public static void closeConnection() throws SQLException {
        connection.close();
    }
}