package ordermanager.controller;

import ordermanager.entity.Entity;
import ordermanager.model.EntityDAOImpl;
import ordermanager.model.Model;

import java.sql.SQLException;
import java.util.List;

public class Controller<T extends Entity<?>> {
    private Model<T> model;
    private EntityDAOImpl entityDAO = new EntityDAOImpl();

    public Controller(Model<T> model) {
        this.model = model;
    }
    public void addEntity(T entity) throws SQLException, IllegalAccessException {
        entityDAO.insert(entity);
    }

    public List<T> getAllEntity() throws SQLException {
        return model.getAllEntity();
    }
    public List<T> getAll(){
        return model.getALlEntity1();
    }

    public void updateEntity(T entity) throws SQLException, IllegalAccessException {
        entityDAO.update(entity);
    }
    public void deleteEntity(T entity) throws SQLException, IllegalAccessException {
        entityDAO.delete(entity);
    }
    public T getEntityById(int entityId){
        return model.getEntityById(entityId);
    }
    public List<T> getAll(T entity) throws SQLException {
       return entityDAO.getAll(entity);
    }
}
