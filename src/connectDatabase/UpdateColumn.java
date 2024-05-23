package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDColumn.updateColum;


public class UpdateColumn {
    public static void updateColumn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name column update: ");
        String nameColumn = scanner.nextLine();
        System.out.println("Enter the new name :");
        String newName = scanner.nextLine();
        System.out.println("Enter the new data type :");
        String dataType = scanner.nextLine();
        System.out.println("Enter the number of character :");
        String numberCharacter = scanner.nextLine();
        updateColum(nameColumn,newName,dataType,numberCharacter);
    }

}
