package relearnConectCRUD.view;

import relearnConectCRUD.controller.Controller;
import relearnConectCRUD.entity.*;
import relearnConectCRUD.model.Model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {
    Model<Customer> customerModel = new Model<>();
    Model<Product> productModel = new Model<>();
    Model<Orders> ordersModel = new Model<>();
    Model<Orderdetail> orderdetailModel = new Model<>();
    Controller<Customer> customerController = new Controller<>(customerModel);
    Controller<Product> productController = new Controller<>(productModel);
    Controller<Orders> ordersController = new Controller<>(ordersModel);
    Controller<Orderdetail> orderdetailController = new Controller<>(orderdetailModel);

    public void menu() {
        System.out.println("  Enter your selection =>");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Orders");
        System.out.println("4. Orders Detail");
        System.out.println("0. Exit");
    }

    public void menuOrders() {
        System.out.println(" Enter your selection =>");
        System.out.println("1. Create");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get All");
        System.out.println("5. Search");
        System.out.println("0. Back");
    }

    public void choiceMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("CUSTOMER");
                    customerChoice();
                    break;
                case 2:
                    System.out.println("PRODUCT");
                    productChoice();
                    break;
                case 3:
                    System.out.println("ORDERS");
                    ordersChoice();
                    break;
                case 4:
                    System.out.println("ONE MORE BUYING FROM NEW CUSTOMERS");
                    insertAll();
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option is not available!");
            }
        }
    }

    public void menuProduct() {
        System.out.println(" Enter your selection =>");
        System.out.println("1. Create");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get All");
        System.out.println("5. Search");
        System.out.println("0. Back");
    }

    public void productChoice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            menuProduct();
            int chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Create");
                    createProduct();
                    break;
                case 2:
                    System.out.println("Update");
                    updateProduct();
                    break;
                case 3:
                    System.out.println("Delete");
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Get all");
                    getAllProduct();
                    break;
                case 5:
                    System.out.println("Search");
                    getProductById();
                    break;
                case 0:
                    choiceMenu();
                    exit = true;
                    break;
                default:
                    System.out.println("This option is not available");
                    break;
            }
        }
    }

    public void ordersChoice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            menuOrders();
            int chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Create");
                    createOrders();
                    break;
                case 2:
                    System.out.println("Update");
                    updateOrders();
                    break;
                case 3:
                    System.out.println("Delete");
                    deleteOrders();
                    break;
                case 4:
                    System.out.println("Get all");
                    getAllOrders();
                    break;
                case 5:
                    System.out.println("Search");
                    getOrdersById();
                    break;
                case 0:
                    choiceMenu();
                    exit = true;
                    break;
                default:
                    System.out.println("This option is not available");
                    break;
            }
        }
    }

    public void menuCustomer() {
        System.out.println(" Enter your selection =>");
        System.out.println("1. Create");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get All");
        System.out.println("5. Search");
        System.out.println("0. Back");
    }

    public void customerChoice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            menuCustomer();
            int chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Create");
                    createCustomer();
                    break;
                case 2:
                    System.out.println("Update");
                    updateCustomer();
                    break;
                case 3:
                    System.out.println("Delete");
                    deleteCustomer();
                    break;
                case 4:
                    System.out.println("Get All");
                    getAllCustomer();
                    break;
                case 5:
                    System.out.println("Search");
                    getCustomerById();
                    break;
                case 0:
                    choiceMenu();
                    exit = true;
                    break;
                default:
                    System.out.println("This option is not available");
                    break;
            }
        }
    }

    public int createCustomer() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first name:");
        String fName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lname = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number:");
        int phone = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(fName, lname, email, phone);
        int key = customerController.insert(customer);
        return key;
    }

    public int createProduct() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Product name:");
        String name = scanner.nextLine();
        System.out.println("Enter the Product DESC:");
        String desc = scanner.nextLine();
        System.out.println("Enter the Product Price:");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        Product product = new Product(name, desc, price);
        int key = productController.insert(product);
        return key;
    }

    public int createOrders(int key) throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the orders total:");
        BigDecimal total = scanner.nextBigDecimal();
        scanner.nextLine();
        int cid = key;
        Date currentDate = new Date(); // Tạo một đối tượng Date mới với ngày và giờ hiện tại
        Orders orders = new Orders(cid, currentDate, total);
        int key1 = ordersController.insert(orders);
        return key1;
    }

    public void createOrders() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Customer Id:");
        int cid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the orders total:");
        BigDecimal total = scanner.nextBigDecimal();
        scanner.nextLine();
        Date currentDate = new Date(); // Tạo một đối tượng Date mới với ngày và giờ hiện tại
        Orders orders = new Orders(cid, currentDate, total);
        int key1 = ordersController.insert(orders);
    }

    public Entity createOrdersDetail(int key) throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Product Id:");
        int pid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the quantity product id " + pid);
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the price product id " + pid);
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        int oid = key;
        Orderdetail orderdetail = new Orderdetail(key, pid, quantity, price);
        orderdetailController.insert(orderdetail);
        return orderdetail;
    }

    public List createOrdersDetailAll(int key) throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Product Id:");
        int pid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the quantity product id " + pid);
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the price product id " + pid);
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        int oid = key;
        Orderdetail orderdetail = new Orderdetail(key, pid, quantity, price);
        List<Orderdetail> list = new ArrayList<>();
        list.add(orderdetail);
        return list;
    }

    public void updateCustomer() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the  Customer Id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the first name:");
        String fName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lname = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number:");
        int phone = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(id, fName, lname, email, phone);
        customerController.update(customer);
    }

    public void updateProduct() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the  Product Id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Product name:");
        String name = scanner.nextLine();
        System.out.println("Enter the product DESC:");
        String desc = scanner.nextLine();
        System.out.println("Enter the Product Price:");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        Product product = new Product(id, name, desc, price);
        productController.update(product);
    }

    public void updateOrders() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the  Orders Id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Customer Id:");
        int cid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Orders total:");
        BigDecimal total = scanner.nextBigDecimal();
        scanner.nextLine();
        Date currentDate = new Date();
        Orders orders = new Orders(id, cid, currentDate, total);
        ordersController.update(orders);
    }

    public void deleteCustomer() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Customer Id delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer();
        customer.setCustomer_id(id);
        customerController.delete(customer);
    }

    public void deleteProduct() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Product Id delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product();
        product.setProduct_id(id);
        productController.delete(product);
    }

    public void deleteOrders() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Orders Id delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Orders orders = new Orders();
        orders.setOrder_id(id);
        ordersController.delete(orders);
    }

    public void getAllCustomer() throws Exception {
        Customer customer = new Customer();
        List<Customer> list = customerController.list(customer);
        for (Customer l : list) {
            System.out.println(l.toString());
        }
    }

    public void getAllProduct() throws Exception {
        Product product = new Product();
        List<Product> list = productController.list(product);
        for (Product l : list) {
            System.out.println(l.toString());
        }
    }

    public void getAllOrders() throws Exception {
        Orders orders = new Orders();
        List<Orders> list = ordersController.list(orders);
        for (Orders l : list) {
            System.out.println(l.toString());
        }
    }

    public void getCustomerById() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id customer search");
        int id = scanner.nextInt();
        Customer customer = new Customer(id, null, null, null, 0);

        List<Customer> entity = customerController.getEntityById(customer);
        for (Customer e : entity) {
            System.out.println(e.toString());
        }
    }

    public void getProductById() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id Product search:");
        int id = scanner.nextInt();
        Product product = new Product(id, null, null, null);

        List<Product> entity = productController.getEntityById(product);
        for (Product p : entity) {
            System.out.println(p.toString());
        }

    }

    public void getOrdersById() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id customer search");
        int id = scanner.nextInt();
        Orders orders = new Orders();
        orders.setOrder_id(id);

        List<Orders> entity = ordersController.getEntityById(orders);
        for (Orders o : entity) {
            System.out.println(o.toString());
        }
    }

    public void insertAll() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ADD 1 COMPLETE ORDER\n==================");
        int key = createCustomer();
        int key1 = createOrders(key);
        System.out.println("How many products are in this order?");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        if (quantity > 1) {
            List<Entity> list = new ArrayList<>();
            for (int i = 0; i < quantity; i++) {
                list.add(createOrdersDetail(key1));
            }
            orderdetailController.insertAll(list);
        } else {
            createOrdersDetail(key1);
        }
        System.out.println("Success!");
    }
}
