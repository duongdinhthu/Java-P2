package sessionGenerateType.entity;

public class Product extends Entity<Integer>{
    private String name;
    private String desc;
    private double price;
    private final String tableName ="product";

    public String getTableName() {
        return tableName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Integer id) {
        super(id);
    }
}
