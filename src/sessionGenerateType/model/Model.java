package sessionGenerateType.model;

import sessionGenerateType.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Model<T extends Entity<?>>  {//<T extends Entity<?>> la cu phap mac dinh
    private List<T> entities = new ArrayList<>();// T dai dien cho cac thuc the entity( Product, Customer....)
    public void addEntity(T entity){
        entities.add(entity);

    }
    public List<T> getAllEntities(){
         return entities;
    }
    public void updateEntity(T entity){
        entities.add(entity);
    }

}
