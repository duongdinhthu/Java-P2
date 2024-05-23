package session12.entity;

import java.util.Date;
import java.util.List;

public class Order extends Entity<Integer> {
    private int customerId;
    private Date createdAt;
    private Date updatedAt;
    private String paymentType;
    private List<OrderDetail> orderDetails;

    public Order(Integer id) {
        super(id);
    }

    // Constructors, getters và setters
}
