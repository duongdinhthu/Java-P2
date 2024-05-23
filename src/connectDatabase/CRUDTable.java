package connectDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDTable extends CRUDatabase {
    public static void getAllTab() throws SQLException {
        openConnection();
        String query = "show tables";
        PreparedStatement pstm = connection.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

                String name = rs.getString(1);
                System.out.println("===============");
                System.out.println("Table name : " + name);

        }
        closeConnection();
    }
    public static void deleteTaB(String deleteNameTB) throws SQLException {
        openConnection();
        String query = "DROP TABLE " + deleteNameTB;
        PreparedStatement pstm = connection.prepareStatement(query);
        int rs = pstm.executeUpdate();
        if (rs!=-1){
            System.out.println("Success!");
        }else {
            System.out.println("Failure!");
        }
        closeConnection();
    }
    public static void createTab(ArrayList<String> listColumn, String name) throws SQLException {
        openConnection();
        StringBuilder createTableQuery = new StringBuilder("CREATE TABLE " + name + " (");
        for (String column : listColumn) {
            createTableQuery.append(column).append(" VARCHAR(255), "); // Mặc định kiểu dữ liệu là VARCHAR(255)
        }
        createTableQuery.delete(createTableQuery.length() - 2, createTableQuery.length()); // Xóa dấu phẩy cuối cùng
        createTableQuery.append(");");

        String query = createTableQuery.toString();
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.executeUpdate();
            System.out.println("Table " + name + " created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }

        closeConnection();
    }

    public static void updateTab(String name,String newName) throws SQLException {
        openConnection();
        String query = "ALTER TABLE " + name + " RENAME " + newName;
        PreparedStatement pstm = connection.prepareStatement(query);
        int rs = pstm.executeUpdate();
        if (rs != -1){
            System.out.println("Success!");
        }else {
            System.out.println("Failure!");
        }
        closeConnection();
    }
    public static void searchTable(String name) throws SQLException {
        openConnection();
        String query = "SELECT * FROM information_schema.tables WHERE table_name = ?";
        PreparedStatement pstm = connection.prepareStatement(query);

        pstm.setString(1, name); // Thiết lập giá trị cho tham số truy vấn

        // Thực thi truy vấn và xử lý kết quả (nếu cần)
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            tableDB = name;
        }else {
            System.out.println("khong co bang nay");
        }
        closeConnection();
    }
}
