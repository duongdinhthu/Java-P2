package baithi.entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student extends Entity<Integer>{
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Date dob;

    public Student(int id, String name, String address, String email, String phone, Date dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public Student() {
    }
    public Student(JsonElement object) {
        JsonObject jsonObject = object.getAsJsonObject();
        this.id = jsonObject.get("id").getAsInt();
        this.name = jsonObject.get("name").getAsString();
        this.address = jsonObject.get("address").getAsString();
        this.email = jsonObject.get("email").getAsString();
        this.phone = jsonObject.get("phone").getAsString();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH); // Định dạng ngày tháng đúng
        try {
            this.dob = dateFormat.parse(jsonObject.get("dob").getAsString());
        } catch (ParseException e) {
            e.printStackTrace(); // Xử lý nếu có lỗi parsing ngày tháng
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
