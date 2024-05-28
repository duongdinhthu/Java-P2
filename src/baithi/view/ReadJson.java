package baithi.view;


import baithi.entity.Student;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadJson {
    public void readJson() throws IOException, ParseException {
        FileReader reader = new FileReader("getAll_Student.json");
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);
        List<Student> list = new ArrayList<>();
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                Student student = new Student(element);
                list.add(student);
            }
        } else {
            System.out.println("Invalid JSON format: Not a JsonArray");
        }
        for (Student l : list) {
            System.out.println(l.toString());
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
        List<Student> list = new ArrayList<>();
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                Student student = new Student(element);
                if (student.getName().equals(nameSearch)) {
                    list.add(student);
                }
            }
        } else {
            System.out.println("Invalid JSON format: Not a JsonArray");
        }
        for (Student l : list) {
            System.out.println(l.toString());
        }
        reader.close();
    }

    public void searchEmail() throws ParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the email search:");
        String emailSearch = scanner.nextLine();

        FileReader reader = new FileReader("getAll_Student.json");
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);
        List<Student> list = new ArrayList<>();
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement element : jsonArray) {
                Student student = new Student(element);
                if (student.getEmail().equals(emailSearch)) {
                    list.add(student);
                }
            }
        } else {
            System.out.println("Invalid JSON format: Not a JsonArray");
        }
        for (Student l : list) {
            System.out.println(l.toString());
        }
        reader.close();
    }
}