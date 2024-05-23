package connectDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class CRUDColumn extends CRUDatabase{
    public static void createColumn(String newColumn,String dataType,String numberCharacter) throws SQLException {
        openConnection();
        String query = "alter table " + tableDB + " add " + newColumn + " " + dataType + "(" + numberCharacter + ")";
        PreparedStatement pstm = connection.prepareStatement(query);
        int rs = pstm.executeUpdate();
        if (rs != -1){
            System.out.println("Create Success!");
        }else {
            System.out.println("Create Failure!");
        }
        closeConnection();
    }
    public static void updateColum(String nameColumn, String newName, String dataType, String numberCharacter) throws SQLException {
        openConnection();
        String query = "ALTER TABLE " + tableDB + " CHANGE COLUMN " + nameColumn + " " + newName + " " + dataType + "(" + numberCharacter + ")";
        PreparedStatement pstm = connection.prepareStatement(query);
        int rs = pstm.executeUpdate();
        if (rs != -1) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
        closeConnection();
    }
    public static void deleteColum(String nameColumn) throws SQLException {
        openConnection();
        String query = "ALTER TABLE " + tableDB + " DROP COLUMN " + nameColumn;
        PreparedStatement pstm = connection.prepareStatement(query);
        int rs = pstm.executeUpdate();
        if (rs!=-1){
            System.out.println("Success!");
        }else {
            System.out.println("Failure!");
        }
        closeConnection();
    }
    public static void getAllColumn()throws SQLException{
        openConnection();
        String query = "SELECT * FROM " + tableDB;
        PreparedStatement pstm = connection.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        System.out.println("Tên các cột trong bảng:");
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            System.out.println("Column " + i + ": " + columnName);
        }
        System.out.println("====================");
        closeConnection();
    }
}
