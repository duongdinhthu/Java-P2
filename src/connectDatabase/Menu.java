package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.MenuClient.menuClient;
import static connectDatabase.MenuColumn.menuColumn;
import static connectDatabase.MenuData.menuCRUD;
import static connectDatabase.MenuTable.menuTable;

public class Menu {
    public static void menu()throws SQLException {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            menuClient();
            int chose = scanner.nextInt();
            try {
                switch (chose) {
                    case 1:
                        System.out.println("Menu data");
                        menuCRUD();
                        break;
                    case 2:
                        System.out.println("Menu Column");
                        menuColumn();
                        break;
                    case 3:
                        System.out.println("Menu table");
                        menuTable();
                        break;
                    case 0:
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Khong co lua chon nay");
                        break;
                }
            }catch (Exception e){
                System.out.println("da bi loi!");
            }
        }
    }

}
