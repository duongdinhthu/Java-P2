package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDatabase.searchCustomer;

public class Search {
    public static void search() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name Search : ");
        String name = scanner.nextLine();
        searchCustomer(name);
    }
}
