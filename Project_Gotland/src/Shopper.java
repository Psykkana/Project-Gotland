import java.util.ArrayList;



public class Shopper {

    // Fields
    private String name;
    private int age;
    private Equipment equipment;               // Either a Cart or Basket (or none)
    private ArrayList<Product> carriedProducts; // Products currently held
    private boolean checkedOut;                // True if shopper has completed checkout

    // Constructor
    public Shopper(String name, int age) {
        this.name = name;
        this.age = age;
        this.carriedProducts = new ArrayList<>();
        this.checkedOut = false;
        this.equipment = null; // starts with no equipment (in this case its null)
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Equipment getEquipment() {
        return this.equipment;
    }

    public boolean hasCheckedOut() {
        return this.checkedOut;
    }

    public ArrayList<Product> getCarriedProducts() {
        return this.carriedProducts;
    }

    // Assign equipment (cart or basket)
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

  
    public boolean addProduct(Product product) {
        if (equipment != null && equipment.hasSpace()) {
            return equipment.addProduct(product);
        } 
        else if (equipment == null) {
            carriedProducts.add(product);
            return true;
        } else {
            System.out.println("cant carry product. No equipment space.");
            return false;
        }
    }

    public void removeProduct(Product product) {
        if (carriedProducts.contains(product)) {
            carriedProducts.remove(product);
        } else if (equipment != null) {
            equipment.removeProduct(product);
        }
    }

    public void checkout() {
        this.checkedOut = true;
        System.out.println(name + " has checked out successfully.");
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public float getTotalPrice() {
        float total = 0;
        for (Product p : carriedProducts) {
            total += p.getPrice();
        }
        if (equipment != null) {
            for (Product p : equipment.getContents()) {
                total += p.getPrice();
            }
        }
        return total;
    }

    // Apply 20% senior discount if theyre eligible
    public float getDiscountedPrice() {
        float total = getTotalPrice();
        if (age >= 60) {
            total *= 0.8f; 
        }
        return total;
    }

    public String toString() {
        String equipType = (equipment == null) ? "None" : equipment.getClass().getSimpleName();
        return "Shopper: " + name + " (" + age + " y/o, Equipment: " + equipType + ")";
    }
}
