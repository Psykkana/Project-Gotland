import java.util.ArrayList;

/*
 * Equipment Class (Abstract)
 * Represents containers used by shoppers — carts and baskets.
 * Each equipment has a fixed capacity and can hold multiple products.
 */

public abstract class Equipment {

    // Fields
    private int capacity;                   // Max number of products
    private ArrayList<Product> contents;    // Products inside

    // Constructor
    public Equipment(int capacity) {
        this.capacity = capacity;
        this.contents = new ArrayList<>();
    }

    // Getters
    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Product> getContents() {
        return this.contents;
    }

    // Adds a product if space allows
    public boolean addProduct(Product product) {
        if (contents.size() < capacity) {
            contents.add(product);
            return true;
        } else {
            System.out.println("Equipment full! Cannot add " + product.getName());
            return false;
        }
    }

    // Removes a product
    public void removeProduct(Product product) {
        contents.remove(product);
    }

    // Checks if there’s still space
    public boolean hasSpace() {
        return contents.size() < capacity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + contents.size() + "/" + capacity + " items)";
    }
}
