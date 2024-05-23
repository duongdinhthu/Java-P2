package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDatabase.*;

public class Create {
    public static void create() throws SQLException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the new ID:");
            String id = scanner.nextLine();
            System.out.println("Enter the First name: ");
            String fname = scanner.nextLine();
            System.out.println("Enter the Last name: ");
            String lname = scanner.nextLine();
            System.out.println("Enter the email: ");
            String email = scanner.nextLine();
        try {
            createCustomer(id,fname,lname,email);
        }catch (SQLException e){
            System.out.println("Sai dinh dang");
        }
        }
}
