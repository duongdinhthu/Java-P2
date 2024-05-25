package baithi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import baithi.entity.Entity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EntityToJSON <T extends Entity<?>>{
    public void writeEmployeeToJson(List<T> entitties,Class entityClass,String method) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(method+entityClass.getSimpleName() + ".json");
        gson.toJson(entitties, writer);
        writer.close();
    }
}

