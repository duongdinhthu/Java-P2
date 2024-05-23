package ordermanager.view;

import ordermanager.controller.Controller;
import ordermanager.entity.*;
import ordermanager.model.EntityDAOImpl;
import ordermanager.model.Model;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    Controller controller = new Controller<>(new Model<>());

    Model<Customer> customerModel = new Model<>();
    Model<Product> productModel = new Model<>();
    Model<Orders> ordersModel = new Model<>();
    Model<OrderDetail> orderDetailModel = new Model<>();
    private Controller<Customer> customerController = new Controller<>(customerModel);
    private Controller<Product> productController = new Controller<>(productModel);
    private Controller<Orders> ordersController = new Controller<>(ordersModel);
    private Controller<OrderDetail> orderDetailController = new Controller<>(orderDetailModel);
    private Scanner scanner = new Scanner(System.in);

    public View(Controller<Customer> customerController) {
        this.customerController = customerController;
        this.scanner = new Scanner(System.in);
    }

    public View() {

    }



    public void addCustomer() throws SQLException, IllegalAccessException {
        try {
            System.out.println("Enter customer details:");
            System.out.print("Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from the buffer
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            int phone = scanner.nextInt();
            Customer customer = new Customer(customerId, firstName, lastName, email, phone);
            customerController.addEntity(customer);
            System.out.println("Customer added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the buffer
        }
    }
    public void updateCustomer() throws SQLException, IllegalAccessException {

        System.out.println("Enter the first name");
        String name = scanner.nextLine();
        System.out.println("Enter the last name");
        String lname = scanner.nextLine();
        System.out.println("Enter the email");
        String email = scanner.nextLine();
        System.out.println("Enter the phone");
        int phone = scanner.nextInt();
        System.out.println("Enter the id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(id,name,lname,email,phone);
        customerController.updateEntity(customer);
    }
    public void deleteCustomer()throws SQLException,IllegalAccessException{
        System.out.println("Enter the id delete:");
        int id = scanner.nextInt();
        Customer customer = new Customer(id,null,null,null,0);
        customerController.deleteEntity(customer);
    }
    public void addProduct() throws SQLException, IllegalAccessException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhap vao product id:");
        int id = scanner1.nextInt();
        scanner1.nextLine();
        System.out.println("nhap ten san pham:");
        String name = scanner1.nextLine();
        System.out.println("Nhap desc: ");
        String desc = scanner1.nextLine();
        System.out.println("Nhap vao gia:");
        int price = scanner1.nextInt();
        Product product = new Product(id,name,desc,price);
        productController.addEntity(product);
    }



    // Method to convert Customer object to String for display


    // Implement other methods for updating, deleting, and searching customers similarly...
}
