package jsonClassGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class GsonWrite {
    public static void main(String[] args) throws IOException {
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        customer.setCustomer_id(id);
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        customer.setCustomer_name(name);
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        customer.setCustomer_email(email);
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        customer.setCustomer_address(address);
        System.out.println("Enter the phone: ");
        int phone = scanner.nextInt();
        scanner.nextLine();
        customer.setCustomer_phone(phone);
        JsonObject jsonObject = customer.toJsonObject();
        System.out.println("How many orders did this customer buy?");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        JsonArray jsonArray = new JsonArray();
        for (int i = 0 ; i<quantity;i++){
            System.out.println("Enter the id: ");
            int orders1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the price:");
            BigDecimal price = scanner.nextBigDecimal();
            scanner.nextLine();
            Orders orders = new Orders(orders1,price);
            JsonObject jsonObject1 = orders.toJsonObject();
            jsonArray.add(jsonObject1);
        }
        jsonObject.add("orders",jsonArray);
        jsonObject.addProperty("country","Viet nam");
        System.out.println(jsonObject);
        // tạo đối tượng Gson chuyeern đổi từ JSON sang
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("customer.json");
        // Ghi đối tượng JsonObject vào file JSON
        gson.toJson(jsonObject, writer);
        writer.close();
        System.out.println("File JSON đã được tạo thành công.");
    }
}
