package jsonClassGson;

import com.google.gson.JsonObject;

import java.math.BigDecimal;

public class Orders {
    private int id;
    private BigDecimal price;

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("price", price);
        return jsonObject;
    }
    public Orders(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
}
