
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

    private String displayName;
    private DisplayType type; 
    private ArrayList<Product> productList;
    private Address address;
    
    // Constructor
    public Display(String displayName, DisplayType type, Address address) {
        this.displayName = displayName;
        this.type = type;
        this.address = address;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }

    public DisplayType getType() {
        return this.type;
    }

    public Address getAddress() {
        return this.address;
    }

    public int getRow() {
        return this.address.getRow();
    }

    public int getCol() {
        return this.address.getCol();
    }
}