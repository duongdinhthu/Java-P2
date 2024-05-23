package ordermanager.model;


import ordermanager.entity.Customer;
import ordermanager.entity.Entity;
import ordermanager.connectDTB.MySqlConnect;
import ordermanager.entity.Orders;
import ordermanager.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model<T extends Entity<?>>{
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
    private String GET_ALL = "select * from customer";
    private String GET_ALL_PRODUCT = " select * from product";
    private List<T> entity = new ArrayList<>();

    public Model() {
    }


    public void setEntity(List<T> entity) {

        this.entity = entity;
    }
    public void addEntity(T entities) throws SQLException {
        if (entities instanceof Customer) {
            Customer customer = (Customer) entities;
            openPrepareStatement("insert into customer values(?,?,?,?,?)");
            pstm.setInt(1,customer.getCustomer_id());
            pstm.setString(2,customer.getFirst_name());
            pstm.setString(3,customer.getLast_name());
            pstm.setString(4,customer.getEmail());
            pstm.setInt(5,customer.getPhone());
            exUpdate();
            System.out.println("Them khach hàng thanh cong!");
            // Thực hiện cập nhật cho entity Customer
            // Ví dụ: customerModel.updateCustomer(customer);
        } else if (entities instanceof Product) {
            Product product = (Product) entities;
            openPrepareStatement("insert into product values(?,?,?,?)");
            pstm.setInt(1,product.getProduct_id());
            pstm.setString(2,product.getProduct_name());
            pstm.setString(3, product.getDescription());
            pstm.setInt(4,product.getPrice());
            exUpdate();
            System.out.println("Them hang thanh cong!");
            // Thực hiện cập nhật cho entity Product
            // Ví dụ: productModel.updateProduct(product);
        }else if (entities instanceof Orders){

        }
    }
    public List<T> getALlEntity1(){
        return entity;
    }
    public List<T> getAllEntity() throws SQLException {
        List<T> list = new ArrayList<>();

        openPrepareStatement(GET_ALL);
        ResultSet rs = exQuery();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt(1));
            customer.setFirst_name(rs.getString(2));
            customer.setLast_name(rs.getString(3));
            customer.setEmail(rs.getString(4));
            customer.setPhone(rs.getInt(5));
            list.add((T) customer); // Ép kiểu Customer về kiểu T và thêm vào danh sách
        }
        rs.close(); // Đóng ResultSet rs sau khi sử dụng xong

        openPrepareStatement(GET_ALL_PRODUCT);
        ResultSet rs1 = exQuery();
        while (rs1.next()) {
            Product product = new Product();
            product.setId(rs1.getInt(1));
            product.setProduct_name(rs1.getString(2));
            product.setDescription(rs1.getString(3));
            product.setPrice(rs1.getInt(4));

            list.add((T) product); // Ép kiểu Product về kiểu T và thêm vào danh sách
        }
        rs1.close(); // Đóng ResultSet rs1 sau khi sử dụng xong

        return list;
    }
    public void updateEntity(T entities) {
        if (entities instanceof Customer) {
            Customer customer = (Customer) entities;
            // Thực hiện cập nhật cho entity Customer
            // Ví dụ: customerModel.updateCustomer(customer);
        } else if (entities instanceof Product) {
            Product product = (Product) entities;
            // Thực hiện cập nhật cho entity Product
            // Ví dụ: productModel.updateProduct(product);
        }
        // Thêm các loại entity khác tương tự

        // Nếu cần thêm logic chung cho việc cập nhật entity, bạn có thể đưa vào đây
    }

    public void deleteEntity(T entityToDelete) {
        entity.remove(entityToDelete);
    }
    public T getEntityById(int entityId) {
        for (T e : entity) {
            if (e.getId().equals(entityId)) {
                return e;
            }
        }
        return null;
    }
}
