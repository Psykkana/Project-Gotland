import java.util.ArrayList;



public class Shopper {

    // Direction enum
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    // Fields
    private String name;
    private int age;
    private Equipment equipment;               // Either a Cart or Basket (or none)
    private ArrayList<Product> carriedProducts; // Products currently held
    private boolean checkedOut;                // True if shopper has completed checkout
    private Direction facing;
    private int xAxis;
    private int yAxis;

    // Constructor
    public Shopper(String name, int age, int yAxis, int xAxis) {
        this.name = name;
        this.age = age;
        this.carriedProducts = new ArrayList<>();
        this.checkedOut = false;
        this.equipment = null; // starts with no equipment (in this case its null)

        // For coordinates and direction
        this.xAxis = xAxis;
        this.yAxis = yAxis;   
        this.facing= Direction.UP;             
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

    // Facing and Location getters
    public int getXAxis() {
        return this.xAxis;
    }

    public int getYAxis() {
        return this.yAxis;
    }

    public Direction getFacing() {
        return this.facing;
    }    

    // Movement methods
    public void moveUP(Floor floor) {
        int moveUP = yAxis - 1;
        if (floor.collisionCheck(moveUP, xAxis, floor)) {
            yAxis = moveUP;
            facing = Direction.UP;            
        }
    }

    public void moveDOWN(Floor floor) {
        int moveDOWN = yAxis + 1;
        if (floor.collisionCheck(moveDOWN, xAxis, floor)) {
            yAxis = moveDOWN;
            facing = Direction.DOWN;            
        }
    }    

    public void moveLEFT(Floor floor) {
        int moveLEFT = xAxis - 1;
        if (floor.collisionCheck(yAxis, moveLEFT, floor)) {
            xAxis = moveLEFT;
            facing = Direction.LEFT;            
        }
    }

    public void moveRIGHT(Floor floor) {
        int moveRIGHT = xAxis + 1;
        if (floor.collisionCheck(yAxis, moveRIGHT, floor)) {
            xAxis = moveRIGHT;
            facing = Direction.RIGHT;            
        }
    }

    // Viewing methods
    public void lookUP() {
        this.facing = Direction.UP;
    }

    public void lookDOWN() {
        this.facing = Direction.DOWN;
    }

    public void lookLEFT() {
        this.facing = Direction.LEFT;
    }

    public void lookRIGHT() {
        this.facing = Direction.RIGHT;
    }

    // Assign equipment (cart or basket)
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    // Product related methods
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
