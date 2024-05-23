package relearnConectCRUD.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import relearnConectCRUD.entity.Customer;
import relearnConectCRUD.entity.Entity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EntityToJSON <T extends Entity<?>>{
    public void writeEmployeeToJson(List<T> entity) throws IOException {
        System.out.println("ok123");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(entity.getClass() + ".json");
        gson.toJson(entity, writer);
        writer.close();
    }
}
