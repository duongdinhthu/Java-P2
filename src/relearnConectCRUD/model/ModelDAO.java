package relearnConectCRUD.model;

import relearnConectCRUD.entity.Entity;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface ModelDAO <T extends Entity<?>> {
    public int insert(Entity entity) throws SQLException, IllegalAccessException;
    public void insertAll(List entity) throws SQLException, IllegalAccessException;

    public boolean update(Entity entity) throws SQLException, IllegalAccessException;

    public boolean delete(Entity entity) throws IllegalAccessException, SQLException;

    public List getEntityById(Entity entity) throws SQLException, IllegalAccessException, InstantiationException, IOException;

    public List getAll(Class entityClass) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException;

}
