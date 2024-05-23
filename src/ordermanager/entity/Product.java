package ordermanager.entity;

public class Product extends Entity<Integer>{
    private int product_id;
    private String product_name;
    private String description;
    private int price;

    public Product(Integer id) {
        super(id);
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Product() {
    }

    public Product(int product_id, String product_name, String description, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }

    public Product(Integer id, int product_id, String product_name, String description, int price) {
        super(id);
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
