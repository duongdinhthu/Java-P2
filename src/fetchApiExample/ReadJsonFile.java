package fetchApiExample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            // Đường dẫn của tệp JSON cần đọc
            String filePath = "customer.json";

            // Mở FileReader để đọc tệp JSON
            FileReader reader = new FileReader(filePath);

            // Đọc nội dung của tệp JSON vào chuỗi
            StringBuilder jsonString = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                jsonString.append((char) character);
            }

            // Chuyển đổi chuỗi JSON thành một mảng JsonArray
            JsonArray jsonArray = new Gson().fromJson(jsonString.toString(), JsonArray.class);

            for (JsonElement element : jsonArray) {
                // Xử lý từng phần tử trong mảng JSON ở đây
                System.out.println(element);
            }

            // Đóng FileReader sau khi đọc xong
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}