package connectDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static connectDatabase.CRUDTable.createTab;

public class CreateTable {
    public static void createTable() throws SQLException {
        ArrayList<String> listColumn = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new table name:");
        String name = scanner.nextLine();
        System.out.println("Enter the number of column: ");
        int numberColumn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=============");
        for (int i = 0 ; i < numberColumn ; i++ ){
            System.out.println("Enter the column name " + (i+1) + " :");
            String namecolumn = scanner.nextLine();
            listColumn.add(namecolumn);
        }

        createTab(listColumn,name);

    }
}
