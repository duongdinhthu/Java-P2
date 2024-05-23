package sessionGenerateType.entity;

import java.util.Date;
import java.util.List;

public class Order extends Entity<Integer>{
    private int customerId;
    private double total;
    private Date createAt;
    private final String tableName = "orders";

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerId=" + customerId +
                ", total=" + total +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", paymentType='" + paymentType + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }

    private Date updateAt;
    private String paymentType;
    private List<OrderDetail> orderDetails;
// quan he 1 - nhieu gia order va order detail; tu khoa la ORM
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order(Integer id) {
        super(id);
    }
}
