package fetchApiExample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchDataFromAPI {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://664e9c3dfafad45dfae092c1.mockapi.io/EmployeeAPI");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JsonArray jsonArray = new JsonArray();
            // Chuyển chuỗi JSON thành mảng JSON
            jsonArray = new Gson().fromJson(content.toString(), JsonArray.class);
            // thuc hien ghi file json
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("api.json");
            gson.toJson(jsonArray, writer);
            writer.close();
            System.out.println("Data has been fetched from the API and written to api.json successfully.");

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}