package testMVC.view;

import testMVC.controller.Controller;
import testMVC.entity.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

    public static Controller controller =new Controller();
    public static void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        System.out.println("Enter the price");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the description");
        String description = scanner.nextLine();
        System.out.println("Enter the code");
        String code = scanner.nextLine();
        System.out.println("Enter the image");
        String image = scanner.nextLine();
        System.out.println("Enter the status");
        String status = scanner.nextLine();
        Product product = new Product(id,name,price,description,code,image,status);
        controller.createProduct(product);
    }
}
