import java.util.ArrayList;
import java.util.Scanner;
/*
 *  Shopper Class
 *      Vital to the function of the whole simulation
 *      Represents the user, and allows them to conduct actions (moving, viewing, etc.)
 * 
 */

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

    // Check the tile the user is facing
    public int[] checkFacingTile() {
        int xFacing = xAxis;
        int yFacing = yAxis;

        switch (facing) {
            case UP:
                yFacing--;
                break;
            case DOWN:
                yFacing++;
                break;
            case LEFT:
                xFacing--;
                break;
            case RIGHT:
                xFacing++;
                break;
        }

        return new int[] {yFacing, xFacing};
    }

    // To let the shopper interact with what they are facing per checkFacingTile
    // Where actions execute
    public void interact(Floor floor) {
    int[] targetTile = checkFacingTile();
    int yFacing = targetTile[0];
    int xFacing = targetTile[1];       

    // Check map boundaries
    if (yFacing < 0 || yFacing >= 22 || xFacing < 0 || xFacing >= 22) {
        System.out.println("You can't interact outside the map!");
        return;
    }

    char tile = floor.getTile(yFacing, xFacing);

    switch (tile) {
        case 'B':   // Basket Station
            System.out.println("You approach a Basket Station.");
            new Service("Basket Station", new Address("GF", "Entrance", 0, 2)).interact(this);
            break;

        case 'P':   // Cart Station
            System.out.println("You approach a Cart Station.");
            new Service("Cart Station", new Address("GF", "Entrance", 0, 3)).interact(this);
            break;

        case 'R':   // Checkout counter
            System.out.println("You approach the Checkout Counter.");
            new Service("Checkout", new Address("GF", "Front", 0, 1)).interact(this);
            break;

        case 'v':   // Exit
            System.out.println("You approach the Exit.");
            new Service("Exit", new Address("GF", "Front", 0, 3)).interact(this);
            if(hasCheckedOut()) {
                System.out.println("Do you want to restart the simulator? Type Y or N: ");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine().trim().toUpperCase();
                if(response.equals("Y")) {
                    Driver.restartGame();
                } else {
                    System.out.println("Thank you for shopping!");
                    System.exit(0);
                }
            }
            break;

        case 's':   // Shelf / display
        case 'T':   // Table
        case 'c':   // Chilled counter
            System.out.println("You check the display for items...");
            interactWithDisplay(floor);
            break;

        default:
            System.out.println("There's nothing interesting here.");
            break;
    }
}

        // Handles display interaction (picking up a product)
    private void interactWithDisplay(Floor floor) {
        int[] facing = checkFacingTile();
        int yFacing = facing[0];
        int xFacing = facing[1];

        Display targetDisplay = null;
        double minDistance = Double.MAX_VALUE;

        // Find the closest display based on (y,x) coordinates
        for (Display d : floor.getDisplays()) {
            int dy = d.getY();
            int dx = d.getX();

            // Compute distance between facing tile and display
            double distance = Math.sqrt(Math.pow(dy - yFacing, 2) + Math.pow(dx - xFacing, 2));

            if (distance < 2.0 && distance < minDistance) { // within 1 tile distance
                targetDisplay = d;
                minDistance = distance;
            }
        }

        if (targetDisplay == null) {
            System.out.println("There's no display in front of you.");
            return;
        }

        if (!targetDisplay.getProducts().isEmpty()) {
            Product product = targetDisplay.getProducts().get(0);
            if (addProduct(product)) {
                System.out.println("You picked up: " + product.getName() +
                        " from " + targetDisplay.getType().getType() +
                        " at " + targetDisplay.getAddress());
                targetDisplay.removeProduct(product);
            }
        } else {
            System.out.println("This display is empty.");
        }
    }
        // Return one product back to the nearest display
    public void dropProduct(Floor floor) {
        int[] facing = checkFacingTile();
        int yFacing = facing[0];
        int xFacing = facing[1];

        Display targetDisplay = null;
        for (Display d : floor.getDisplays()) {
            if (Math.abs(d.getY() - yFacing) <= 1 && Math.abs(d.getX() - xFacing) <= 1) {
                targetDisplay = d;
                break;
            }
        }

        if (targetDisplay == null) {
            System.out.println("No display nearby to return the product to.");
            return;
        }

        Product toReturn = null;
        if (!carriedProducts.isEmpty()) {
            toReturn = carriedProducts.remove(carriedProducts.size() - 1);
        } else if (equipment != null && !equipment.getContents().isEmpty()) {
            ArrayList<Product> contents = equipment.getContents();
            toReturn = contents.remove(contents.size() - 1);
        }

        if (toReturn != null) {
            targetDisplay.addProduct(toReturn);
            System.out.println("Returned " + toReturn.getName() + " to " + targetDisplay.getType().getType());
        } else {
            System.out.println("You have no product to return.");
        }
    }



    // Assign equipment (cart or basket)
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        //transfer hand held items onto equipment
        if(!carriedProducts.isEmpty()) {
            for(Product p : new ArrayList<>(carriedProducts)) {
                if(this.equipment.hasSpace()) {
                    this.equipment.addProduct(p);
                    carriedProducts.remove(p);
                } else {
                    System.out.println("Not enough space in " + this.equipment.getClass().getSimpleName() + " for all hand items." );
                    break;
                }
            }
            System.out.println("Transferred hand-carried items into " + this.equipment.getClass().getSimpleName() + ".");
        }
    }

    // Product related methods
    public boolean addProduct(Product product) {
        if(equipment != null) {
            if(equipment.hasSpace()) {
                return equipment.addProduct(product);
            } else {
                System.out.println("Your " + equipment.getClass().getSimpleName() + " is full!");
                return false;
            }
        }
        if(carriedProducts.size() < 2) {
            carriedProducts.add(product);
            return true;
        } else {
            System.out.println("You can't carry more than 2 products by hand. Please get a basket or cart");
        } return false;


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

        // Returns total item count in hands + equipment
    public int getTotalItemCount() {
        int total = carriedProducts.size();
        if (equipment != null) {
            total += equipment.getContents().size();
        }
        return total;
    }


    public String toString() {
        String equipType = (equipment == null) ? "None" : equipment.getClass().getSimpleName();
        return "Shopper: " + name + " (" + age + " y/o, Equipment: " + equipType + ")";
 
    }

    // VIEW PRODUCTS: Lists all unique items the shopper is carrying or has in their equipment
    public void viewChosenProducts() {
        System.out.println("\n=====================");
        System.out.println("Products in " + (equipment == null ? "hands" : equipment.getClass().getSimpleName().toUpperCase()));
        System.out.println("=====================");

        // Combine all products (hand + equipment)
        ArrayList<Product> allProducts = new ArrayList<>();
        allProducts.addAll(carriedProducts);
        if (equipment != null) {
            allProducts.addAll(equipment.getContents());
        }

        if (allProducts.isEmpty()) {
            System.out.println("No products selected yet.");
            return;
        }

        // Track product counts and subtotals
        java.util.HashMap<String, Integer> quantityMap = new java.util.HashMap<>();
        java.util.HashMap<String, Float> subtotalMap = new java.util.HashMap<>();

        for (Product p : allProducts) {
            String key = p.getName();
            quantityMap.put(key, quantityMap.getOrDefault(key, 0) + 1);
            subtotalMap.put(key, subtotalMap.getOrDefault(key, 0f) + p.getPrice());
        }

        // Print neatly
        System.out.printf("%-25s %-10s %-10s%n", "Product", "Qty", "Subtotal (PHP)");
        System.out.println("---------------------------------------------");

        float total = 0;
        for (String name : quantityMap.keySet()) {
            int qty = quantityMap.get(name);
            float subtotal = subtotalMap.get(name);
            total += subtotal;
            System.out.printf("%-25s %-10d %-10.2f%n", name, qty, subtotal);
        }

        System.out.println("---------------------------------------------");
        System.out.printf("TOTAL: PHP%.2f%n", total);
        System.out.println("=====================\n");
    }

}