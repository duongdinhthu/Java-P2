package ordermanager.model;

import ordermanager.connectDTB.MySqlConnect;
import ordermanager.entity.Entity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;


public class EntityDAOImpl<T extends Entity<?>> implements EntityDAO{

    public static Connection connection;
    public static Connection openConnection() throws SQLException {
        connection = MySqlConnect.getMySQLConnection();
        return connection;
    }
    public static PreparedStatement pstm;
    public static PreparedStatement openPrepareStatement(String query) throws SQLException{
        pstm = openConnection().prepareStatement(query);
        return pstm;
    }
    public static void exUpdate() throws SQLException{
        pstm.executeUpdate();
    }
    public static ResultSet exQuery()throws SQLException{
        ResultSet rs = pstm.executeQuery();
        return rs;
    }
    @Override
    public boolean insert(Entity entity) throws SQLException, IllegalAccessException {
            String tableName = getTableName(entity.getClass());

            StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
            queryBuilder.append(tableName).append(" (");
            Field[] fields = entity.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (i > 0) {
                    queryBuilder.append(", ");
                }
                queryBuilder.append(fields[i].getName());
            }
            queryBuilder.append(") VALUES (");
            for (int i = 0; i < fields.length; i++) {
                if (i > 0) {
                    queryBuilder.append(", ");
                }
                queryBuilder.append("?");
            }
            queryBuilder.append(")");//INSERT INTO TABLE_NAME(...) VALUES(?,?...)
                PreparedStatement statement = openPrepareStatement(queryBuilder.toString());
                int parameterIndex = 1;
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    statement.setObject(parameterIndex++, value);
                }
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;

        }
    private String getTableName(Class<?> entityClass) {
        String tableName = entityClass.getSimpleName();

        return tableName;
    }

    @Override
    public boolean update(Entity entity) throws SQLException, IllegalAccessException {
        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("update ");
        queryBuilder.append(tableName).append(" set ");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            if (i > 1) {
                queryBuilder.append(", ");
            }
            queryBuilder.append(fields[i].getName()).append(" = ?");
        }
        queryBuilder.append(" where ").append(fields[0].getName()).append(" = ?");
        System.out.println(entity);
        System.out.println(queryBuilder.toString());
        PreparedStatement statement = openPrepareStatement(queryBuilder.toString());

        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(entity);
            statement.setObject(i, value);
            System.out.println(value);
            System.out.println(fields[i]);
        }
        fields[0].setAccessible(true);
       Object value1 = fields[0].get(entity);
        statement.setObject(fields.length,value1);
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    @Override
    public boolean delete(Entity entity) throws SQLException, IllegalAccessException {
        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("delete from ");
        queryBuilder.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        queryBuilder.append(fields[0].getName()).append(" = ?");
        System.out.println(entity);
        System.out.println("ok");
        PreparedStatement statement = openPrepareStatement(queryBuilder.toString());
        fields[0].setAccessible(true);
        Object value = fields[0].get(entity);
        statement.setObject(1, value);
        System.out.println(value);
        System.out.println(fields[0]);

        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }



    @Override
    public List<T> getAll(Entity entity) throws SQLException {
        List<T> entities = new ArrayList<>();
        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(tableName);

        try {
            PreparedStatement preparedStatement = openPrepareStatement(queryBuilder.toString());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                T newEntity = createEntityFromResultSet(rs, entity);
                entities.add(newEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return entities;
    }

    private T createEntityFromResultSet(ResultSet rs, Entity entity) throws SQLException {
        try {
            // Sử dụng reflection để lấy danh sách trường của đối tượng entity
            Field[] fields = entity.getClass().getDeclaredFields();

            // Duyệt qua từng trường và gán dữ liệu từ ResultSet vào đối tượng entity
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();

                // Kiểm tra xem trường có trong ResultSet không
                if (fieldType == int.class) {
                    int value = rs.getInt(fieldName);
                    field.set(entity, value);
                } else if (fieldType == String.class) {
                    String value = rs.getString(fieldName);
                    field.set(entity, value);
                }
                // Thêm các kiểu dữ liệu khác tùy theo nhu cầu

                field.setAccessible(false);
            }

            // Ép kiểu đối tượng entity thành kiểu T
            return (T) entity;
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error creating entity from ResultSet");
        }
    }
}
