package relearnOrdersManager.entity;

import java.math.BigDecimal;

public class OrderDetail extends Entity<Integer>{
    private int orderDetail_id;
    private int order_id;
    private int product_id;
    private int quantity;
    private BigDecimal unitPrice;

    public OrderDetail(Integer id) {
        super(id);
    }

    public int getOrderDetail_id() {
        return orderDetail_id;
    }

    public void setOrderDetail_id(int orderDetail_id) {
        this.orderDetail_id = orderDetail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetail(int order_id, int product_id, int quantity, BigDecimal unitPrice) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(int orderDetail_id, int order_id, int product_id, int quantity, BigDecimal unitPrice) {
        this.orderDetail_id = orderDetail_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
