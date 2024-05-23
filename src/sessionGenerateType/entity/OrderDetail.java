package sessionGenerateType.entity;

import java.util.Date;

public class OrderDetail extends Entity<Integer> {
    private int order_id;
    private Date createAt;
    private Date updateAt;
    private int product_id;
    private double price;
    private int quantity;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }
private final String tableName = "orderdetail";
    @Override
    public String toString() {
        return "OrderDetail{" +
                "order_id=" + order_id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", product_id=" + product_id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetail(Integer id) {
        super(id);
    }
}
