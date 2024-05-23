package jsonExample;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Write_JSON_simple {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("employee.json"));

        //Tạo đối tượng employee
        JsonObject employee = new JsonObject();
        employee.put("id",1);
        employee.put("name","Gia Binh");
        employee.put("email","binh@gmail.com");
        employee.put("age",20);
        //Tao doi tuong Address
        JsonObject address = new JsonObject();
        address.put("street", "So 8 Ton That Thuyet");
        address.put("city", "Ha Noi");
        //Them dia chi cho nhan vien
        employee.put("address", address);
        //JsonArray
        JsonArray projects = new JsonArray();
        //Tao project so 1
        JsonObject p1 = new JsonObject();
        p1.put("title","Employee management");
        p1.put("budget", 15000);
        JsonObject p2 = new JsonObject();
        p2.put("title","Push Sale");
        p2.put("budget", 5000);
        //Them 2 object vao JsonArray
        projects.addAll(Arrays.asList(p1, p2));
        //Add project to employee
        employee.put("projects", projects);
        //Ghi file JSON
        Jsoner.serialize(employee, writer);
        writer.close();

    }
}