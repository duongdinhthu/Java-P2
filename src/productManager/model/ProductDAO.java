package productManager.model;

import productManager.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    public void createProduct(Product product) throws SQLException;
    public ArrayList<Product> getAllProduct() throws SQLException;
    public Product getProductById(int productId) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public boolean deleteProduct(int productId) throws SQLException;

    public Product getProductQuantitySold() throws SQLException;

    public Product getProductSoldOut() throws SQLException;
}
