/*
 * Supermarket Class
 * Controls the overall simulation of the supermarket.
 * Responsible for initializing floors, displays, products, and services.
 */

import java.util.Scanner;

public class Supermarket {

    // Fields
    private Floor floor;       // The supermarket floor
    private boolean running;   // Indicates if the simulation is active
    private final int xSpawnPoint = 11;
    private final int ySpawnPoint = 20;

    // Constructor
    public Supermarket() {
        this.running = false;
    }

    public static void displayDivider() {
        System.out.println("=================================================");
    }

    // Initialize supermarket and contents
    public void initialize() {
        System.out.println("Initializing Supermarket Simulation...");
        displayDivider();

        // Create floor
        floor = new Floor("Ground Floor");
        System.out.println("Creating floor layout...");
        floor.initializeMap(1);

        // Create display types
        DisplayType shelfType = new DisplayType("Shelf", 4, 5);
        DisplayType fridgeType = new DisplayType("Refrigerator", 3, 4);
        DisplayType wallType = new DisplayType("Wall Display", 2, 6);

        // Create product types
        
        // === PRODUCT TYPES ===
        ProductType fruitType   = new ProductType("FRU", "Fruit", shelfType, false, true, true, false);
        ProductType meatType    = new ProductType("MEA", "Meat", fridgeType, false, true, true, false);
        ProductType dairyType   = new ProductType("DAI", "Dairy", fridgeType, false, true, true, false);
        ProductType cannedType  = new ProductType("CAN", "Canned Goods", shelfType, false, true, true, false);
        ProductType snackType   = new ProductType("SNA", "Snack", shelfType, false, true, true, false);
        ProductType drinkType   = new ProductType("DRI", "Drink", fridgeType, false, true, false, true);
        ProductType veggieType  = new ProductType("VEG", "Vegetable", shelfType, false, true, true, false);
        ProductType cleanType   = new ProductType("CLN", "Cleaning Supply", shelfType, false, false, false, false);

        // Create products
        Product apple    = new Product("FRU001", "Apple", 15.0f, fruitType);
        Product banana   = new Product("FRU002", "Banana", 12.0f, fruitType);
        Product orange   = new Product("FRU003", "Orange", 10.0f, fruitType);

        Product pork     = new Product("MEA001", "Pork", 120.0f, meatType);
        Product beef     = new Product("MEA002", "Beef", 160.0f, meatType);
        Product chicken  = new Product("MEA003", "Chicken", 100.0f, meatType);

        Product milk     = new Product("DAI001", "Milk", 50.0f, dairyType);
        Product cheese   = new Product("DAI002", "Cheese", 80.0f, dairyType);
        Product yogurt   = new Product("DAI003", "Yogurt", 45.0f, dairyType);

        Product tuna     = new Product("CAN001", "Tuna", 40.0f, cannedType);
        Product beans    = new Product("CAN002", "Baked Beans", 30.0f, cannedType);
        Product corned   = new Product("CAN003", "Corned Beef", 55.0f, cannedType);

        Product chips    = new Product("SNA001", "Chips", 25.0f, snackType);
        Product cookies  = new Product("SNA002", "Cookies", 35.0f, snackType);
        Product biscuits = new Product("SNA003", "Biscuits", 30.0f, snackType);

        Product soda     = new Product("DRI001", "Soda", 20.0f, drinkType);
        Product juice    = new Product("DRI002", "Juice", 25.0f, drinkType);
        Product water    = new Product("DRI003", "Water", 15.0f, drinkType);

        Product lettuce  = new Product("VEG001", "Lettuce", 18.0f, veggieType);
        Product tomato   = new Product("VEG002", "Tomato", 22.0f, veggieType);
        Product carrot   = new Product("VEG003", "Carrot", 20.0f, veggieType);

        Product soap     = new Product("CLN001", "Soap", 40.0f, cleanType);
        Product detergent= new Product("CLN002", "Detergent", 70.0f, cleanType);
        Product bleach   = new Product("CLN003", "Bleach", 90.0f, cleanType);

        Display fruitDisplay   = new Display(shelfType, new Address("GF", "Aisle", 12, 1), 13, 18); // fruits
        Display snackDisplay   = new Display(shelfType, new Address("GF", "Aisle", 11, 1), 13, 14); // snacks
        Display dairyDisplay   = new Display(fridgeType, new Address("GF", "Aisle", 10, 1), 12, 10); // dairy
        Display cleanDisplay   = new Display(shelfType, new Address("GF", "Aisle", 9, 1), 12, 6);   // cleaning
        Display cannedDisplay  = new Display(shelfType, new Address("GF", "Aisle", 8, 1), 12, 2);   // canned
        Display drinkDisplay   = new Display(wallType, new Address("GF", "Wall", 1, 1), 1, 17);     // drinks
        Display meatDisplay    = new Display(fridgeType, new Address("GF", "Wall", 2, 1), 1, 9);    // meats
        Display veggieDisplay  = new Display(shelfType, new Address("GF", "Wall", 3, 1), 1, 3);     // vegetables

        fruitDisplay.addProduct(apple);
        fruitDisplay.addProduct(banana);
        fruitDisplay.addProduct(orange);

        snackDisplay.addProduct(chips);
        snackDisplay.addProduct(cookies);
        snackDisplay.addProduct(biscuits);

        dairyDisplay.addProduct(milk);
        dairyDisplay.addProduct(cheese);
        dairyDisplay.addProduct(yogurt);

        cleanDisplay.addProduct(soap);
        cleanDisplay.addProduct(detergent);
        cleanDisplay.addProduct(bleach);

        cannedDisplay.addProduct(tuna);
        cannedDisplay.addProduct(beans);
        cannedDisplay.addProduct(corned);

        drinkDisplay.addProduct(soda);
        drinkDisplay.addProduct(juice);
        drinkDisplay.addProduct(water);

        meatDisplay.addProduct(pork);
        meatDisplay.addProduct(beef);
        meatDisplay.addProduct(chicken);

        veggieDisplay.addProduct(lettuce);
        veggieDisplay.addProduct(tomato);
        veggieDisplay.addProduct(carrot);

        floor.addDisplay(fruitDisplay);
        floor.addDisplay(snackDisplay);
        floor.addDisplay(dairyDisplay);
        floor.addDisplay(cleanDisplay);
        floor.addDisplay(cannedDisplay);
        floor.addDisplay(drinkDisplay);
        floor.addDisplay(meatDisplay);
        floor.addDisplay(veggieDisplay);

        // Create services
        Address checkoutAddr = new Address("GF", "Front", 0, 1);
        Address basketStationAddr = new Address("GF", "Entrance", 0, 2);
        Address exitAddr = new Address("GF", "Front", 0, 3);

        Service checkout = new Service("Checkout", checkoutAddr);
        Service basketStation = new Service("Basket Station", basketStationAddr);
        Service exit = new Service("Exit", exitAddr);

        floor.addService(checkout);
        floor.addService(basketStation);
        floor.addService(exit);

        // Print map
        floor.printMap();

        System.out.println("\nSupermarket initialized successfully!");
        running = true;
    }

    public void startSimulation(String shopperName, int shopperAge) {
        Scanner scanner = new Scanner(System.in);
        
        if (!running) {
            System.out.println("Simulation not initialized. Run initialize() first.");
            return;
        }

        // Create new shopper object
        Shopper shopper = new Shopper(shopperName, shopperAge, ySpawnPoint, xSpawnPoint);

        System.out.println("Welcome " + shopperName);        
        displayDivider();

        while (running) {
            floor.printMapAndShopper(shopper);
            System.out.println("    W/A/S/D to Move, I/J/K/L to Look, SPACE to interact, V to view basket, X to drop item");
            System.out.print("    Enter Action > ");
            String input = scanner.nextLine().toUpperCase(); // Make inputs uppercase

            // Check user input
            if (input.equals(" ")) {
                shopper.interact(floor);
                continue;   // Jumps to next iteration (ie restarts loop)
            }
            if(input.isBlank()) {
                continue;
            }

            char cmd = input.charAt(0);
            inputHandler(cmd, shopper);
        }
    }

    private void inputHandler(char input, Shopper shopper) {
        switch (input) {
            // Movement
            case 'W': 
                shopper.moveUP(floor);
                break;
            case 'A':
                shopper.moveLEFT(floor);
                break;
            case 'S':
                shopper.moveDOWN(floor);
                break;
            case 'D':
                shopper.moveRIGHT(floor);
                break;
            // Facing Direction
            case 'I':
                shopper.lookUP();
                break;
            case 'J':
                shopper.lookLEFT();
                break;                
            case 'K':
                shopper.lookDOWN();
                break;
            case 'L':
                shopper.lookRIGHT();
                break; 

            case ' ':
                shopper.interact(floor);
                break;
            case 'V':
                shopper.viewChosenProducts();
                break;
            case 'X':
                shopper.dropProduct(floor);
                break;

            default:
                System.out.println("Error");

        }
    }

    // Run simulation demo (simple sample interaction)
    public void runDemo() {
        if (!running) {
            System.out.println("Simulation not initialized. Run initialize() first.");
            return;
        }

        System.out.println("\n=== Simulation Demo ===");
        Shopper shopper = new Shopper("Anna", 65, ySpawnPoint, xSpawnPoint); // senior shopper

        // Interact with basket station
        for (Service s : floor.getServices()) {
            if (s.getType().equalsIgnoreCase("Basket Station")) {
                s.interact(shopper);
            }
        }

        // Shopper picks a fruit product manually
        Display fruitDisplay = floor.getDisplays().get(0);
        Product chosen = fruitDisplay.getProducts().get(0);
        shopper.addProduct(chosen);
        System.out.println(shopper.getName() + " picked up " + chosen.getName());

        // Interact with checkout
        for (Service s : floor.getServices()) {
            if (s.getType().equalsIgnoreCase("Checkout")) {
                s.interact(shopper);
            }
        }

        // Interact with exit
        for (Service s : floor.getServices()) {
            if (s.getType().equalsIgnoreCase("Exit")) {
                s.interact(shopper);
            }
        }
    }

    // // Main method for testing
    // public static void main(String[] args) {
    //     Supermarket supermarket = new Supermarket();
    //     supermarket.initialize();
    //     supermarket.runDemo();
    // }
}
