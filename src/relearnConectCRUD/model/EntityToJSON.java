package relearnConectCRUD.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import relearnConectCRUD.entity.Customer;
import relearnConectCRUD.entity.Entity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EntityToJSON <T extends Entity<?>>{
    public void writeEmployeeToJson(List<T> entitties,Class entityClass,String method) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(method+entityClass.getSimpleName() + ".json");
        gson.toJson(entitties, writer);
        writer.close();
        Scanner input = new Scanner(System.in);
        System.out.print("Bạn có muốn lưu dữ liệu vào file XML? (y/n): ");
        String confirmation = input.nextLine();
        JsonToXML jsonToXML = new JsonToXML();
        if (confirmation.equalsIgnoreCase("y")) {
            jsonToXML.jsonToXml(method+entityClass.getSimpleName());
        } else {
            System.out.println("Hành động không được thực hiện.");
        }
    }
}

