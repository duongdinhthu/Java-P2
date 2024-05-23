package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDColumn.createColumn;

public class CreateColumn {
    public static void addColumn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new column name: ");
        String newColumn = scanner.nextLine();
        System.out.println("Enter the data type :");
        String dataType = scanner.nextLine();
        System.out.println("Enter the number of characters: ");
        String numberCharacter = scanner.nextLine();
        createColumn(newColumn,dataType,numberCharacter);
    }
}
