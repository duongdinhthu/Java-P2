package connectDatabase;

import java.sql.SQLException;
import java.util.Scanner;

import static connectDatabase.CRUDatabase.*;
import static connectDatabase.Create.create;
import static connectDatabase.Delete.delete;
import static connectDatabase.Menu.menu;
import static connectDatabase.MenuDataClient.menuData;
import static connectDatabase.Search.search;
import static connectDatabase.SearchTab.searchTab;
import static connectDatabase.Update.update;
public class MenuData {
    public static void menuCRUD() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
            while (!exit){
                menuData();
                int chose = scanner.nextInt();
                try {
                    switch (chose) {
                        case 1:
                            System.out.println("Read");
                            getAll();
                            break;
                        case 2:
                            System.out.println("Create");
                            create();
                            break;
                        case 3:
                            System.out.println("Update");
                            update();
                            break;
                        case 4:
                            System.out.println("Delete");
                            delete();
                            break;
                        case 5:
                            System.out.println("Search");
                            search();
                            break;
                        case 9:
                            System.out.println("Name Table");
                            searchTab();
                            break;

                        case 0:
                            menu();
                            exit = true;
                            break;
                        default:
                            System.out.println("Khong co lua chon nay");
                            break;
                    }
                }catch (Exception e){
                    System.out.println("da bi loi data!");
                }
            }
    }
}
