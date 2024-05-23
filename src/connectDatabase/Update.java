package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDatabase.updateCustomer;

public class Update {
    public static void update()throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID update:");
        String id = scanner.nextLine();
        System.out.println("Enter the new ID: ");
        String newID = scanner.nextLine();
        System.out.println("Enter the new First Name:");
        String newFName = scanner.nextLine();
        System.out.println("Enter the new Last Name:");
        String newLName = scanner.nextLine();
        System.out.println("Enter the new email: ");
        String newEmail = scanner.nextLine();
        try {
            updateCustomer(id,newID,newFName,newLName,newEmail);
        }catch (SQLException e){
            System.out.println("Nhap sai dinh dang");
        }

    }
}
