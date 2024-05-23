package productManager.model;


import productManager.connect.MySqlConnect;
import productManager.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    public static Connection connection;
    public static Connection openConnection() throws SQLException{
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
    private final String GET_ALL_PRODUCT = "select * from products";
    private final String GET_PRODUCT_BY_ID = "select * from products where product_id = ?";
    private final String UPDATE_PRODUCT = "UPDATE products set product_name = ?, product_price = ?, product_quantity = ?, product_quantity_sold = ?,product_quantity_sold_out = ? where product_id = ?";
    private final String GET_PRODUCT_QUANTITY = "select * from products where product_id = ? ";
    private final String DELETE_PRODUCT = "delete from products where product_id =?";
    private final String CREATE_PRODUCT = "insert into products values(?,?,?,?,?,?)";
    private final String GET_PRODUCT_QUANTITY_SOLD = "SELECT * FROM products ORDER BY product_quantity_sold DESC LIMIT 1";
    private final String UPDATE_PRODUCT_QUANTITY_SOLD_OUT = "UPDATE products set product_quantity_sold_out = product_quantity - product_quantity_sold";
    private final String GET_PRODUCT_QUANTITY_SOLD_OUT_BY_ID = "SELECT * FROM products WHERE product_quantity_sold_out= (SELECT MIN(product_quantity_sold_out) FROM products);";
    @Override
    public void createProduct(Product product) throws SQLException {
        openPrepareStatement(CREATE_PRODUCT);
        pstm.setInt(1,product.getProductId());
        pstm.setString(2,product.getProductName());
        pstm.setDouble(3,product.getProductPrice());
        pstm.setInt(4,product.getProductQuantity());
        pstm.setInt(5,product.getProductQuantitySold());
        pstm.setInt(6,product.getProductSoldOut());
        exUpdate();

    }

    @Override
    public ArrayList<Product> getAllProduct() throws SQLException {
        ArrayList<Product> listProduct = new ArrayList<>();
        openPrepareStatement(GET_ALL_PRODUCT);
        ResultSet rs = exQuery();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setProductPrice(rs.getDouble(3));
            product.setProductQuantity(rs.getInt(4));
            product.setProductQuantitySold(rs.getInt(5));
            product.setProductSoldOut(rs.getInt(6));
            listProduct.add(product);
        }
        return listProduct;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Product product = new Product();
        openPrepareStatement(GET_PRODUCT_BY_ID);
        pstm.setInt(1,productId);
        ResultSet rs = exQuery();
        while (rs.next()){
            product.setProductId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setProductPrice(rs.getDouble(3));
            product.setProductQuantity(rs.getInt(4));
            product.setProductQuantitySold(rs.getInt(5));
            System.out.println(product.toString());
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        PreparedStatement pstm = openPrepareStatement(UPDATE_PRODUCT);
        pstm.setString(1,product.getProductName());
        pstm.setDouble(2,product.getProductPrice());
        pstm.setInt(3,product.getProductQuantity());
        pstm.setInt(4,product.getProductQuantitySold());
        pstm.setInt(5,product.getProductSoldOut());
        pstm.setInt(6,product.getProductId());
        exUpdate();
    }

    @Override
    public boolean deleteProduct(int productId) throws SQLException {
        PreparedStatement pstm = openPrepareStatement(DELETE_PRODUCT);
        pstm.setInt(1,productId);

        int check = pstm.executeUpdate();
        if (check>0){
            System.out.println("Delete success!");
            return true;

        }else {
            System.out.println("Delete Failure!");
            return false;
        }
    }
    @Override
    public Product getProductQuantitySold() throws SQLException {
        Product product = new Product();
        openPrepareStatement(GET_PRODUCT_QUANTITY_SOLD);
        ResultSet rs = exQuery();
        while(rs.next()){
            product.setProductQuantitySold(rs.getInt(5));
            product.setProductName(rs.getString(2));
            System.out.println(product.toString());
        }
        return product;
    }

    @Override
    public Product getProductSoldOut() throws SQLException {
        Product product = new Product();
        openPrepareStatement(UPDATE_PRODUCT_QUANTITY_SOLD_OUT);
        exUpdate();
        openPrepareStatement(GET_PRODUCT_QUANTITY_SOLD_OUT_BY_ID);
        ResultSet rs = exQuery();
        while (rs.next()){
            product.setProductSoldOut(rs.getInt(6));
            product.setProductId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            System.out.println(product.toString());
        }
        return product;
    }
}
