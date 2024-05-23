package ordermanager;

import ordermanager.entity.Customer;
import ordermanager.view.View;

import java.sql.SQLException;



public class Application {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        View view = new View();
//        view.updateCustomer();
        view.deleteCustomer();
//        view.addCustomer();
//        view.addProduct();
//        view.getAll();
//        view.getAll1();
    }
}
