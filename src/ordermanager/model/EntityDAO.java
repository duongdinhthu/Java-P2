package ordermanager.model;

import ordermanager.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface EntityDAO<T extends Entity<?>> {
    public boolean insert(T entity) throws SQLException, IllegalAccessException;
    public boolean update(T entity) throws SQLException, IllegalAccessException;
    public boolean delete(T entity) throws SQLException,IllegalAccessException;
    public List<T> getAll(T entity) throws SQLException;

}

