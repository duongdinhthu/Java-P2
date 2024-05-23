package productManager.controller;


import productManager.entity.Product;
import productManager.model.ProductDAO;
import productManager.model.ProductDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    ProductDAO productDAO = new ProductDAOImpl();
    public void createProductController(Product product)throws SQLException {
        productDAO.createProduct(product);
    }
    public Product getProductById(int productId) throws SQLException{
        return productDAO.getProductById(productId);
    }
    public ArrayList<Product> getAllProduct() throws SQLException{
        return productDAO.getAllProduct();
    }
    public void updateProduct(Product product) throws Exception{
        productDAO.updateProduct(product);
    }
    public boolean deleteProduct(int productId) throws SQLException{
        return productDAO.deleteProduct(productId);
    }



    public Product getProductQuantitySold() throws SQLException {
        return productDAO.getProductQuantitySold();
    }
    public Product getProductSoldOut() throws SQLException{
        return productDAO.getProductSoldOut();
    }
}
