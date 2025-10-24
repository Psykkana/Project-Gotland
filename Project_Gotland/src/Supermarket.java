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

        // Create product types
        ProductType fruitType = new ProductType("FRU", "Fruit", shelfType, false, true, true, false);
        ProductType meatType = new ProductType("MEA", "Meat", fridgeType, false, true, true, false);

        // Create products
        Product apple = new Product("FRU001", "Apple", 15.0f, fruitType);
        Product banana = new Product("FRU002", "Banana", 12.0f, fruitType);
        Product pork = new Product("MEA001", "Pork", 120.0f, meatType);

        // Create displays with addresses
        Address fruitAddr = new Address("GF", "Aisle", 1, 1);
        Address meatAddr = new Address("GF", "Aisle", 2, 1);

        Display fruitDisplay = new Display(shelfType, fruitAddr);
        Display meatDisplay = new Display(fridgeType, meatAddr);

        fruitDisplay.addProduct(apple);
        fruitDisplay.addProduct(banana);
        meatDisplay.addProduct(pork);

        floor.addDisplay(fruitDisplay);
        floor.addDisplay(meatDisplay);

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
            System.out.println("    W/A/S/D to Move, I/J/K/L to Look");
            System.out.print("    Enter Action > ");
            String input = scanner.nextLine().trim().toUpperCase(); // Make inputs uppercase

            // Check user input
            if (input.isBlank()) {
                continue;   // Jumps to next iteration (ie restarts loop)
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
