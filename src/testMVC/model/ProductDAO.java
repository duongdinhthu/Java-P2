package testMVC.model;

import testMVC.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    public ArrayList<Product> listProduct() throws SQLException;
    public Product getProductById(int productId) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public void createProduct(Product product) throws SQLException;
    public void deleteProduct(int productId) throws SQLException;

}
