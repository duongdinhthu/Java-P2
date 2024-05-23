package session12.controller;

import session12.entity.Entity;
import session12.model.Model;

import java.util.List;

public class Controller<T extends Entity<?>> {
    private Model<T> model;

    public Controller(Model<T> model) {
        this.model = model;
    }

    public void addEntity(T entity) {
        model.addEntity(entity);
    }

    public List<T> getAllEntities() {
        return model.getAllEntities();
    }
}
