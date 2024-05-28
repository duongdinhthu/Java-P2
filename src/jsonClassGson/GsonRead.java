package jsonClassGson;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.FileReader;
import java.io.IOException;

public class GsonRead {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("customer.json");
        // Chuyển đối dữ liệu JSON thành class Customer
        Customer customer = new Gson().fromJson(reader, Customer.class);
        // Hiển thị thông tin customer

        // Hiển thị danh sách đơn hàng
        reader.close();
        System.out.println(customer.toString());
    }
}