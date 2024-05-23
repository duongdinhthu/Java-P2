package testMVC.controller;

import testMVC.entity.Product;
import testMVC.model.ProductDAOImpl;

import java.sql.SQLException;

public class Controller {

    private static ProductDAOImpl productDAO;

    static {
        try {
            productDAO = new ProductDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createProduct(Product product) throws SQLException {
        productDAO.createProduct(product);
    }
}
