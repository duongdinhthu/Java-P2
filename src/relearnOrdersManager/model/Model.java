package relearnOrdersManager.model;

import relearnOrdersManager.connect.ConnectDTB;
import relearnOrdersManager.entity.Entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model<T extends Entity<?>> implements ModelDAO {
    public Model() {
    }

    private static Connection connection;
    private Object list;

    private static Connection openConnection() throws SQLException {
        connection = ConnectDTB.getConnection();
        return connection;
    }

    private static PreparedStatement pstm;

    private static PreparedStatement openPreparedStatement(String sql) throws SQLException {
        pstm = openConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        return pstm;
    }

    private static ResultSet exQuery() throws SQLException {
        ResultSet rs = pstm.executeQuery();
        return rs;
    }

    private static int exUpdate() throws SQLException {
        int check = pstm.executeUpdate();
        return check;
    }

    private String getTableName(Class<T> entityClass) {
        String tableName = entityClass.getSimpleName();
        return tableName;
    }

    private static String getTableName(Entity entity) {
        String tableName = entity.getClass().getSimpleName();
        return tableName;
    }

    private static String queryInsert(Entity entity) {
        String tableName = getTableName(entity);
        StringBuilder query = new StringBuilder("insert into ");
        query.append(tableName).append(" ( ");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                query.append(", ");
            }
            query.append(fields[i].getName());
        }
        query.append(") values (");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                query.append(", ");
            }
            query.append("?");
        }
        query.append(")");
        return query.toString();
    }

    private static String queryUpdate(Entity entity) {
        String tableName = getTableName(entity);
        StringBuilder query = new StringBuilder("update ");
        query.append(tableName).append(" set ");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            if (i > 1) {
                query.append(", ");
            }
            query.append(fields[i].getName()).append(" = ?");
        }
        query.append(" where ").append(fields[0].getName()).append(" = ?");
        return query.toString();
    }

    private static String queryDelete(Entity entity) {
        String tableName = getTableName(entity);
        StringBuilder query = new StringBuilder("delete from ");
        query.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        query.append(fields[0].getName()).append(" = ?");
        return query.toString();
    }

    private static String queryGetAll(Entity entity) {
        String tableName = getTableName(entity);
        return "select * from " + tableName;
    }

    private static String queryGetEntityById(Entity entity) {
        String tableName = getTableName(entity);
        StringBuilder query = new StringBuilder("select * from ");
        query.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        query.append(fields[0].getName()).append(" = ?");
        return query.toString();
    }

    @Override
    public int insert(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryInsert(entity);
        pstm = openPreparedStatement(query);
        int column = 1;
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(entity);
            pstm.setObject(column++, value);
        }
        int check = exUpdate();
        if (check > 0) {
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int key = rs.getInt(1);
                return key;
            }
        }
        return 0;
    }

    @Override
    public void update(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryUpdate(entity);
        pstm = openPreparedStatement(query);
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(entity);
            pstm.setObject(i, value);
        }
        fields[0].setAccessible(true);
        Object value1 = fields[0].get(entity);
        pstm.setObject(fields.length, value1);
        exUpdate();
    }

    @Override
    public void delete(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryDelete(entity);
        pstm = openPreparedStatement(query);
        fields[0].setAccessible(true);
        Object value = fields[0].get(entity);
        pstm.setObject(1, value);
        exUpdate();
    }

    @Override
    public List getAllEntity(Entity entity) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Entity> list = new ArrayList<>();
        String query = queryGetAll(entity);
        pstm = openPreparedStatement(query);
        ResultSet rs = exQuery();
        while (rs.next()) {
            Entity<T> newEntity = entity.getClass().getDeclaredConstructor().newInstance();
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = rs.getObject(field.getName());
                field.set(newEntity, value);
            }
            list.add(newEntity);
        }
        return list;
    }

    @Override
    public List getEntityById(Entity entity) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        List<Entity> entities = new ArrayList<>();
        String query = queryGetEntityById(entity);
        pstm = openPreparedStatement(query);
        ResultSet rs = exQuery();
        while (rs.next()) {
            Entity<T> newEntity = entity.getClass().getDeclaredConstructor().newInstance();
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = rs.getObject(field.getName());
                field.set(newEntity, value);
            }
            entities.add(newEntity);
        }
        return entities;
    }

    @Override
    public void insertAll(List list) throws SQLException, IllegalAccessException {
        List<Entity> list1 = list;
        for (Entity entity1 : list1) {
            Field[] fields = entity1.getClass().getDeclaredFields();
            String query = queryInsert(entity1);
            pstm = openPreparedStatement(query);
            int parameterIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(entity1);
                pstm.setObject(parameterIndex++, value);
            }
            pstm.addBatch();
        }
        pstm.executeUpdate();
    }
}
