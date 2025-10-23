
/* 
 *  Supermarket Class
 *      Does the initialization of the actual supermarket
 *      Floors, displays, products all work through this
 *      Effectively the backbone of the simulation
 *      
 */

public class Supermarket {
    
    private Floor GroundFloor;
    // Shopper declaration here
    private boolean running;   

    public static void displayDivider() {
        System.out.println("=================================================");
    }

    public Supermarket() {
        running = true;
    }

    public void initialize() {
        // Create Map
        System.out.println("Initializing Supermarket Simulation...");
        GroundFloor = new Floor(); 
        GroundFloor.initializeMap(1);   // Initialize Floor 1
        // Generate shopper here
        System.out.println("Creating Shopper Profile...");

    }

    // Start simulation
    public void startSimulation() {
        // Spawn shopper at X = 11, Y = 20
        GroundFloor.setTile(11, 20, 'U');

        System.out.println("Generating Map...");  
        displayDivider();      

        while (running) {
            GroundFloor.printMap();        // Print Floor 1
            System.out.println("    W/A/S/D to Move, I/J/K/L to Look");
        }


    }

    private void handleInput(char input) {
        

    }

}
