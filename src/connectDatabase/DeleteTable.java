package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDTable.deleteTaB;

public class DeleteTable {
    public static void deleteTable() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the table name delete : ");
        String deleteNameTB = scanner.nextLine();


        System.out.println("Bạn có muốn tiếp tục thực thi không? (y/n)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            deleteTaB(deleteNameTB);
        } else if (!input.equalsIgnoreCase("n")) {
            System.out.println("Vui lòng chỉ nhập 'y' hoặc 'n'.");
        }




    }
}
