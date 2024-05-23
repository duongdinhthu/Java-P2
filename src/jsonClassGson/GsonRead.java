package jsonClassGson;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class GsonRead {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("customer.json");
        StringBuilder jsonString = new StringBuilder();
        int character;
        while ((character = reader.read()) != -1) {
            jsonString.append((char) character);
        }
    // Chuyển đổi chuỗi JSON thành đối tượng JsonObject
        JsonObject jsonObject = new Gson().fromJson(jsonString.toString(), JsonObject.class);
        System.out.println(jsonObject);
        // Đọc các giá trị từ đối tượng JsonObject
        int id = jsonObject.get("id").getAsInt();
        String name = jsonObject.get("name").getAsString();
        String email = jsonObject.get("email").getAsString();
        String address = jsonObject.get("address").getAsString();
        int phone = jsonObject.get("phone").getAsInt();
        String country = jsonObject.get("country").getAsString();
        System.out.println("Id: "+ id);
        System.out.println("Name: "+ name);
        System.out.println("Email: "+ email);
        System.out.println("Address: "+ address);
        System.out.println("Phone: "+ phone);
        // Đọc mảng JSON từ đối tượng JsonObject
        JsonArray ordersArray = jsonObject.getAsJsonArray("orders");
        System.out.println("orders:");
        for (JsonElement orderElement : ordersArray) {
            JsonObject orderObject = orderElement.getAsJsonObject();
            int orderId = orderObject.get("id").getAsInt();
            BigDecimal price = orderObject.get("price").getAsBigDecimal();
            System.out.println("Order ID: " + orderId);
            System.out.println("Price: " + price);
        }
        System.out.println("Country: " + country);
        reader.close();
    }
}
//
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import java.io.FileReader;
//import java.io.IOException;
//import java.math.BigDecimal;
//
//public class GsonRead {
//    public static void main(String[] args) throws IOException {
//        FileReader reader = new FileReader("customer.json");
//        StringBuilder jsonString = new StringBuilder();
//        int character;
//        while ((character = reader.read()) != -1) {
//            jsonString.append((char) character);
//        }
//        // Chuyển đổi chuỗi JSON thành đối tượng JsonObject
//        JsonObject jsonObject = new Gson().fromJson(jsonString.toString(), JsonObject.class);
//        System.out.println(jsonObject);
//
//        // Đọc các giá trị từ đối tượng JsonObject
//        Customer customer = new Gson().fromJson(jsonString.toString(), Customer.class);
//        System.out.println("Id: "+ customer.getId());
//        System.out.println("Name: "+ customer.getName());
//        System.out.println("Email: "+ customer.getEmail());
//        System.out.println("Address: "+ customer.getAddress());
//        System.out.println("Phone: "+ customer.getPhone());
//        System.out.println("Country: "+ customer.getCountry());
//
//        // Đọc mảng JSON từ đối tượng JsonObject
//        JsonArray ordersArray = jsonObject.getAsJsonArray("orders");
//        System.out.println("orders:");
//        for (JsonElement orderElement : ordersArray) {
//            JsonObject orderObject = orderElement.getAsJsonObject();
//            int orderId = orderObject.get("id").getAsInt();
//            BigDecimal price = orderObject.get("price").getAsBigDecimal();
//            System.out.println("Order ID: " + orderId);
//            System.out.println("Price: " + price);
//        }
//
//        reader.close();
//    }
//}