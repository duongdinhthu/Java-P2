package connectDatabase;

import java.util.Scanner;


import static connectDatabase.CreateColumn.addColumn;
import static connectDatabase.DeleteColumn.deleteColumn;
import static connectDatabase.GetColumn.getCL;
import static connectDatabase.Menu.menu;
import static connectDatabase.MenuColumnClient.menuColumnClient;
import static connectDatabase.SearchTab.searchTab;
import static connectDatabase.UpdateColumn.updateColumn;

public class MenuColumn {
    public static void menuColumn(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            menuColumnClient();
            int chose = scanner.nextInt();
            try{
                switch (chose) {
                    case 1:
                        System.out.println("Show column");
                        getCL();
                        break;
                    case 2:
                        System.out.println("Create column");
                        addColumn();
                        break;
                    case 3:
                        System.out.println("Update column");
                        updateColumn();
                        break;
                    case 4:
                        System.out.println("Delete column");
                        deleteColumn();
                        break;
                    case 0:
                        menu();
                        exit = true;
                        break;
                    case 9:
                            System.out.println("Name Table");
                            searchTab();
                            break;


                    default:
                        System.out.println("Khong co lua chon nay");
                        break;
                }
            }catch (Exception e){
                System.out.println("Moi nhap lai!");
            }
        }
    }
}
