
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
    private ArrayList<Product> productList;
    private Address address;
    
    // Constructor
    public Display(DisplayType type, ArrayList<Product> productList) {
        this.type = type;
        this.productList = productList;
    }
    
}
