package productManager.entity;

public class Product {
    private int productId;
    private String productName;
    private Double productPrice;
    private int productQuantity;
    private int productQuantitySold;
    private int productQuantitySoldOut;

    public int getProductSoldOut() {
        return productQuantitySoldOut;
    }

    public void setProductSoldOut(int productQuantitySoldOut) {
        this.productQuantitySoldOut = productQuantitySoldOut;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productQuantitySold=" + productQuantitySold +
                ", productSoldOut=" + productQuantitySoldOut +
                '}';
    }

    public Product(int productId, String productName, Double productPrice, int productQuantity, int productQuantitySold, int productQuantitySoldOut) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productQuantitySold = productQuantitySold;
        this.productQuantitySoldOut = productQuantitySoldOut;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductQuantitySold() {
        return productQuantitySold;
    }

    public void setProductQuantitySold(int productQuantitySold) {
        this.productQuantitySold = productQuantitySold;
    }
}
