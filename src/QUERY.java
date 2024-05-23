//public class QUERY {
//    private String getTableName(Class<?> entityClass) {
//        String tableName = entityClass.getSimpleName();
//        return tableName;
//    }
//
//    public boolean insert(T entity) {
//        String tableName = getTableName(entity.getClass());
//
//        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
//        queryBuilder.append(tableName).append(" (");
//        Field[] fields = entity.getClass().getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            if (i > 0) {
//                queryBuilder.append(", ");
//            }
//            queryBuilder.append(fields[i].getName());
//        }
//        queryBuilder.append(") VALUES (");
//        for (int i = 0; i < fields.length; i++) {
//            if (i > 0) {
//                queryBuilder.append(", ");
//            }
//            queryBuilder.append("?");
//        }
//        queryBuilder.append(")");//INSERT INTO TABLE_NAME(...) VALUES(?,?...)
//
//        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
//             PreparedStatement statement = conn.prepareStatement(queryBuilder.toString())) {
//            int parameterIndex = 1;
//            for (Field field : fields) {
//                field.setAccessible(true);
//                Object value = field.get(entity);
//                statement.setObject(parameterIndex++, value);
//            }
//            int rowsInserted = statement.executeUpdate();
//            return rowsInserted > 0;
//        } catch (SQLException | IllegalAccessException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
