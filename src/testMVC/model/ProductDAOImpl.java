package testMVC.model;


import testMVC.connection.MySqlConnect;
import testMVC.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO{
    public Connection connection = MySqlConnect.getMySQLConnection();
    public PreparedStatement preparedStatement;
    public void prepareStatementFunction(String sql) throws SQLException {
        preparedStatement =  connection.prepareStatement(sql);
    }
    private void exUpdate() throws SQLException {
        preparedStatement.executeUpdate();
    }
    private void exQuery() throws SQLException {
        preparedStatement.executeQuery();
    }
    private String CREATE_PRODUCT = "insert into product values(?,?,?,?,?,?,?)";
    private String GET_ALL_PRODUCT= "select * from product";
    private String GET_PRODUCT_BY_ID = "select * from product where pid = ?";
    private String UPDATE_PRODUCT = "update product set name = ?, price = ?, description = ?, code = ?, image = ?, status = ? where pid = ?";
    private String DELETE_PRODUCT = "delete from product where pid = ?";

    public ProductDAOImpl() throws SQLException {
    }

    @Override
    public ArrayList<Product> listProduct() throws SQLException {
        return null;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {

    }

    @Override
    public void createProduct(Product product) throws SQLException {
        prepareStatementFunction(CREATE_PRODUCT);
        preparedStatement.setInt(1,product.getPid());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setString(4,product.getDescription());
        preparedStatement.setString(5,product.getCode());
        preparedStatement.setString(6,product.getImage());
        preparedStatement.setString(7,product.getStatus());
        exUpdate();
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {

    }
}
