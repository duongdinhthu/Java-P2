package sessionGenerateType.controller;

import sessionGenerateType.entity.Entity;
import sessionGenerateType.model.Model;

import java.util.List;

public class Controller<T extends Entity<?>>{
    private Model<T> model;

    public Controller(Model<T> model) {
        this.model = model;
    }
    public void addEntityController(T entity){
        model.addEntity(entity);
        System.out.println(entity.getId());
    }
    public List<T> getAllEntityController(){
        return model.getAllEntities();
    }
}
