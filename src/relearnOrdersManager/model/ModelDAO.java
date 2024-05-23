package relearnOrdersManager.model;

import relearnOrdersManager.entity.Entity;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface ModelDAO<T extends Entity<?>> {
    public int insert(Entity entity) throws SQLException, IllegalAccessException;
    public void update(Entity entity) throws SQLException, IllegalAccessException;
    public void delete(Entity entity) throws SQLException, IllegalAccessException;
    public List getAllEntity(Entity entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException;
    public List getEntityById(Entity entity) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException;
    public void insertAll(List<Entity> entities) throws SQLException, IllegalAccessException;
}
