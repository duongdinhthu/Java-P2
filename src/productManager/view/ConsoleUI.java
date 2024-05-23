package productManager.view;

import productManager.controller.Controller;
import productManager.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    private static Scanner scanner = new Scanner(System.in);
    private static Product product = new Product();
    private static Controller controller = new Controller();
    public static void menu(){
        System.out.println("1.Create Product");
        System.out.println("2.Get product by id");
        System.out.println("3.Get all product");
        System.out.println("4.Update product");
        System.out.println("5.Delete product");
        System.out.println("6.Show products that are out of stock");
        System.out.println("7.Show best-selling products");
        System.out.println("0.Exit");
    }
    public static void createProduct() throws SQLException {

        System.out.println("Enter the new product id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new product name:");
        String name = scanner.nextLine();
        System.out.println("Enter the new product price:");
        Double price = scanner.nextDouble();
        System.out.println("Enter the new product quantity:");
        int quantity = scanner.nextInt();
        System.out.println("Enter the quantity sold:");
        int sold = scanner.nextInt();
        int soldOut = quantity - sold;
        product.setProductId(id);
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductQuantity(quantity);
        product.setProductQuantitySold(sold);
        product.setProductSoldOut(soldOut);
        controller.createProductController(product);
    }
    public static void getProductById() throws SQLException {

        System.out.println("Enter the product id");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.getProductById(id);
    }
    public static void getAllProduct() throws SQLException {
        ArrayList<Product> listProduct = controller.getAllProduct();
        for (Product product1 : listProduct){
            System.out.println(product1.toString());
        }
//        listProduct.forEach(product -> System.out.println("Product id:"+product.getProductId()+"\nProduct name:" + product.getProductName()+"\nProduct price"+product.getProductPrice()+"\nProduct quantity "+product.getProductQuantity()+"\nProduct quan tity sold "+product.getProductQuantitySold()+"\nProduct quantity sold out "+product.getProductSoldOut()+"\n================================")
//        );
        //hoac cach viet thu 2

    }
    public static void updateProduct() throws Exception {
        System.out.println("Enter the product id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the product name:");
        String name = scanner.nextLine();
        System.out.println("Enter the price:");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the quantity sold");
        int quantitySold = scanner.nextInt();
        scanner.nextLine();
        int quantitySoldOut=quantity-quantitySold;
        Product product1 = new Product(id,name,price,quantity,quantitySold,quantitySoldOut);
        controller.updateProduct(product1);

    }
    public static void deleteProduct() throws SQLException {
        System.out.println("Enter the product id delete: ");
        int id = scanner.nextInt();
        controller.deleteProduct(id);
    }
    public static void showProductBestSelling() throws SQLException {
        controller.getProductQuantitySold();
    }
    public static void showProductStock() throws SQLException {
        controller.getProductSoldOut();
    }
    public static void start() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true){
            menu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Create product");
                    createProduct();
                    break;
                case 2:
                    System.out.println("Get product by id");
                    getProductById();
                    break;
                case 3:
                    System.out.println("Get all product");
                    getAllProduct();
                    break;
                case 4:
                    System.out.println("Update product");
                    updateProduct();
                    break;
                case 5:
                    System.out.println("Delete product");
                    deleteProduct();
                    break;
                case 6:
                    System.out.println("Show products that are out of stock");
                    showProductStock();
                    break;
                case 7:
                    System.out.println("Show best-selling products");
                    showProductBestSelling();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
