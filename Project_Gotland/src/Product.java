/*
 *  Product Class
 *      Represents an individual item
 *      Has a serial number, name, price, and ProductType
 *
 */
public class Product {
    
    private String serialNumber;    // ex: FRUXXXXX
    private String name;            // Apple, Orange, Banana
    private float price;
    private ProductType type;

    // Constructor
    public Product(String serialNumber, String name, float price, ProductType type) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // Getters
    public String getSerialNum() {
        return this.serialNumber;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public ProductType getType() {
        return this.type;
    }
}
