package connectDatabase;

import static connectDatabase.CRUDatabase.tableDB;

public class MenuDataClient {
    public static  void menuData(){
        if(tableDB!=null){
            System.out.println("Bạn đang thao tác với bảng " + tableDB);
        }
        System.out.println("Lua chon cua ban : ");
        if (tableDB==null){
            System.out.println("9.Chọn bảng để thao tác với cột trong bảng đó, nếu không hệ thống sẽ khng  biết bạn mun làm việc với bảng nào");
        }else {
            System.out.println("9.Thay đổi sang bảng khác");
        }
        System.out.println("1.Read  ");
        System.out.println("2.Create");
        System.out.println("3.Update");
        System.out.println("4.Delete");
        System.out.println("5.Search");
        System.out.println("0.Back");
    }
}
