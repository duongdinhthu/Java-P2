package baithi.controller;

import baithi.entity.Entity;
import baithi.model.Model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Controller<T extends Entity<?>> {
    private Model model = new Model<>();

    public Controller(Model model) {
        this.model = model;
    }

    public int insert(Entity entity) throws SQLException, IllegalAccessException {
        return   model.insert(entity);
    }
    public void  update(Entity entity) throws SQLException, IllegalAccessException {
        model.update(entity);
    }
    public void delete(Entity entity) throws SQLException, IllegalAccessException {
        model.delete(entity);
    }
    public List<T> list(Entity entity) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        List<T> list = model.getAll(entity.getClass());
        return list;
    }
    public List<T> getEntityById(Entity entity) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, IOException {

        List<T> entity1 = model.getEntityById(entity);
        return entity1;
    }
    public void insertAll(List<Entity> entities) throws SQLException, IllegalAccessException {
        model.insertAll(entities);
    }
}
