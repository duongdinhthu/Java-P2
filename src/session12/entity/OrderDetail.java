package session12.entity;

import java.util.Date;

public class OrderDetail extends Entity<Integer> {
    private int orderId;
    private Date createdAt;
    private Date updatedAt;
    private int productId;
    private double price;
    private int quantity;

    public OrderDetail(Integer id) {
        super(id);
    }

}
