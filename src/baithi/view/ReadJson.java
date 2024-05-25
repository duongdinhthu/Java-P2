package baithi.view;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadJson {
    public  void readJson() throws IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        FileReader reader = new FileReader("getAll_Student.json");
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);

        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject studentObject = element.getAsJsonObject();

                int id = studentObject.get("id").getAsInt();
                String name = studentObject.get("name").getAsString();
                String email = studentObject.get("email").getAsString();
                String address = studentObject.get("address").getAsString();
                String phone = studentObject.get("phone").getAsString();
                String dateString = studentObject.get("dob").getAsString();
                Date dob = dateFormat.parse(dateString);

                System.out.println("Id: "+ id);
                System.out.println("Name: "+ name);
                System.out.println("Email: "+ email);
                System.out.println("Address: "+ address);
                System.out.println("Phone: "+ phone);
                System.out.println("Date:" + dob);
            }
        } else {
            System.out.println("Invalid JSON format: Not a JsonArray");
        }

        reader.close();
    }
    public void searchName() throws ParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name search:");
        String nameSearch = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        FileReader reader = new FileReader("getAll_Student.json");
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);

        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject studentObject = element.getAsJsonObject();

                int id = studentObject.get("id").getAsInt();
                String name = studentObject.get("name").getAsString();
                String email = studentObject.get("email").getAsString();
                String address = studentObject.get("address").getAsString();
                String phone = studentObject.get("phone").getAsString();
                String dateString = studentObject.get("dob").getAsString();
                Date dob = dateFormat.parse(dateString);

                if (nameSearch.equals(name)){
                    System.out.println("Id: "+ id);
                    System.out.println("Name: "+ name);
                    System.out.println("Email: "+ email);
                    System.out.println("Address: "+ address);
                    System.out.println("Phone: "+ phone);
                    System.out.println("Date:" + dob);
                }
            }
        } else {
            System.out.println("Invalid JSON format: Not a JsonArray");
        }

        reader.close();
    }
    public void searchEmail() throws ParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the email search:");
        String emailSearch = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        FileReader reader = new FileReader("getAll_Student.json");
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);

        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject studentObject = element.getAsJsonObject();

                int id = studentObject.get("id").getAsInt();
                String name = studentObject.get("name").getAsString();
                String email = studentObject.get("email").getAsString();
                String address = studentObject.get("address").getAsString();
                String phone = studentObject.get("phone").getAsString();
                String dateString = studentObject.get("dob").getAsString();
                Date dob = dateFormat.parse(dateString);

                if (emailSearch.equals(email)){
                    System.out.println("Id: "+ id);
                    System.out.println("Name: "+ name);
                    System.out.println("Email: "+ email);
                    System.out.println("Address: "+ address);
                    System.out.println("Phone: "+ phone);
                    System.out.println("Date:" + dob);
                }
            }
        } else {
            System.out.println("Invalid JSON format: Not a JsonArray");
        }

        reader.close();
    }
}