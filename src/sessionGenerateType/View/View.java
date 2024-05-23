package sessionGenerateType.View;

import sessionGenerateType.controller.Controller;
import sessionGenerateType.entity.Customer;
import sessionGenerateType.entity.Order;
import sessionGenerateType.entity.OrderDetail;
import sessionGenerateType.entity.Product;
import sessionGenerateType.model.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class View {
    public static void startView(){
        // create Model
        Model<Customer> customerModel = new Model<>();
        Model<Product> productModel = new Model<>();
        Model<Order> orderModel = new Model<>();
        Model<OrderDetail> orderDetailModel = new Model<>();
        //create Controller
        Controller<Customer> customerController = new Controller<>(customerModel);
        Controller<Product> productController = new Controller<>(productModel);
        Controller<Order> orderController = new Controller<>(orderModel);
        Controller<OrderDetail> orderDetailController = new Controller<>(orderDetailModel);
        Customer customer = new Customer(1);
        customer.setName("Gia binh");
        customer.setAddress("HP");
        customer.setPhone("2131231");
        customer.setEmail("ok@gmail.com");

        Product product = new Product(1);
        product.setName("nokia");
        product.setDesc("moi nhat");
        product.setPrice(9.99);

        Order order = new Order(1);
        order.setCustomerId(1);
        order.setTotal(500);
        LocalDate localDate = LocalDate.of(2024, 10, 10);

// Chuyển đổi LocalDate thành Date
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

// Đặt thời gian tạo đơn hàng bằng đối tượng Date đã chuyển đổi
        order.setCreateAt(date);

        OrderDetail orderDetail = new OrderDetail(1);
        orderDetail.setOrder_id(1);
        orderDetail.setPrice(9.99);
        orderDetail.setProduct_id(1);
        LocalDate localDate1 = LocalDate.of(2024, 10, 10);

// Chuyển đổi LocalDate thành Date
        Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        orderDetail.setCreateAt(date1);

        orderDetailController.addEntityController(orderDetail);
        orderController.addEntityController(order);
        productController.addEntityController(product);
        customerController.addEntityController(customer);
        List<Customer> customers = customerController.getAllEntityController();
        List<Product> products = productController.getAllEntityController();
        List<Order>orders = orderController.getAllEntityController();
        List<OrderDetail > orderDetails = orderDetailController.getAllEntityController();
        for (Customer customer1 : customers){
            System.out.println(customer1);
        }
        for (Product product1: products){
            System.out.println(product1);
        }
        for (Order order1:orders){
            System.out.println(order1);
        }
        for (OrderDetail orderDetail1:orderDetails){
            System.out.println(orderDetail1);
        }
    }
}
