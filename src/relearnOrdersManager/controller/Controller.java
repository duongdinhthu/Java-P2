package relearnOrdersManager.controller;

import relearnOrdersManager.entity.Entity;
import relearnOrdersManager.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Controller <T extends Entity<?>> {
    static Model model = new Model<>();
    public static int insert(Entity entity) throws SQLException, IllegalAccessException {
        return model.insert(entity);
    }
    public static void update(Entity entity) throws SQLException, IllegalAccessException {
        model.update(entity);
    }
    public static List getALl(Entity entity) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return model.getAllEntity(entity);
    }
    public static List getEntityById(Entity entity) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        return model.getEntityById(entity);
    }
    public static void insertAll(List list) throws SQLException, IllegalAccessException {
        model.insertAll(list);
    }
}
