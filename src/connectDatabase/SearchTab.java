package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDTable.searchTable;


public class SearchTab {
    public static void searchTab() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the table name: ");
            String name = scanner.nextLine();
            searchTable(name);
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm bảng: " + e.getMessage());
        }
    }
}
