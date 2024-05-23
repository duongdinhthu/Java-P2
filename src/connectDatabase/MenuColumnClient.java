package connectDatabase;

import static connectDatabase.CRUDatabase.tableDB;

public class MenuColumnClient {
    public static void menuColumnClient(){
        if(tableDB!=null){
            System.out.println("Bạn đang thao tác với bảng " + tableDB);
        }
        System.out.println("Lua chon cua ban : ");
        if (tableDB==null){
            System.out.println("9.Chọn bảng để thao tác với cột trong bảng đó, nếu không hệ thống sẽ khng  biết bạn mun làm việc với bảng nào");
        }else {
            System.out.println("9.Thay đổi sang bảng khác");
        }
        System.out.println("1.Show column");
        System.out.println("2.Add column");
        System.out.println("3.Update column");
        System.out.println("4.Delete column");
        System.out.println("0.Back");
        }
}
