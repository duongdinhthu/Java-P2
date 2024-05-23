package session20.controller;

import session20.entity.AddressBooks;
import session20.entity.Entity;
import session20.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Controller<T extends Entity<?>> {
    private List<T> entities = new ArrayList<>();

    public Controller(Model<T> model) {
        this.entities = model.getAllEntities();
    }

    public void addEntity(T entity){
        entities.add(entity);
    }

    public List<T> getAllEntities(){
        return entities;
    }

    public T getEntityByPhone(int phone){
        for(T entity : entities){
            if(Integer.valueOf(((AddressBooks)entity).getPhoneNumber()).equals(phone)){
                return entity;
            }
        }
        return null;
    }
}