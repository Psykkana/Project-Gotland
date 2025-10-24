
import java.util.ArrayList;

/*
 *  Display Class
 *      The actual display unit in the supermarket
 *      The actual display unit in the supermarket
 *      Contains several Products
 *      Can be multi-tiered
 *      Has an address and capacity
 *
 */

public class Display {

    private DisplayType type;
    private Address address;
    private ArrayList<Product> productList;
    private int xPos;
    private int yPos;
    // NOTE: How do we implement an address?
    
    // Constructor
    public Display(DisplayType type, Address address, int yPos, int xPos) {
        this.type = type;
        this.address = address;
        this.yPos = yPos;
        this.xPos = xPos;
        this.productList = new ArrayList<>();
    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;
    }

    public DisplayType getType() {
        return this.type;
    }
    public Address getAddress() {
        return this.address;
    }
    public ArrayList<Product> getProducts() {
        return this.productList;
    }
    public boolean addProduct(Product product) {
        int currentCount = productList.size();
        int maxCapacity = type.getTotalCapacity();

        if(currentCount < maxCapacity) {
            productList.add(product);
            return true;
        } else {
            System.out.println("No more space on this display: " + address);
            return false;
        }
    }
    public void removeProduct(Product product) {
        productList.remove(product);
    }
    public boolean hasSpace() {
        return productList.size() < type.getTotalCapacity();
    }
    public String toString() {
        return "Display at " + address + " (" + type.getType() +") -" + productList.size() + "/" + type.getTotalCapacity() + " items";
    }
}
