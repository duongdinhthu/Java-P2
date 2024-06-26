package jsonClassGson;


import com.google.gson.JsonObject;

import java.util.List;

public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_email;

    private List<Orders> orders;
    private String country;

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", orders=" + orders +
                ", country=" + country +
                ", customer_address='" + customer_address + '\'' +
                ", customer_phone=" + customer_phone +
                '}';
    }
    public Customer(int customer_id, String customer_name, String customer_email, List<Orders> orders, String country, String customer_address, int customer_phone) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.orders = orders;
        this.country = country;
        this.customer_address = customer_address;
        this.customer_phone = customer_phone;
    }
    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String customer_address;
    private int customer_phone;
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("customer_name", customer_name);
        jsonObject.addProperty("customer_email", customer_email);
        jsonObject.addProperty("customer_address", customer_address);
        jsonObject.addProperty("customer_phone", customer_phone);
        jsonObject.addProperty("country", country);

        return jsonObject;
    }
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public int getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(int customer_phone) {
        this.customer_phone = customer_phone;
    }

    public Customer(int customer_id, String customer_name, String customer_email, String customer_address, int customer_phone) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_phone = customer_phone;
    }

    public Customer() {
    }
}
