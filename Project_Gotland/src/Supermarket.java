/* 
 *  Supermarket Class
 *      Does the initialization of the actual supermarket
 *      Floors, displays, products all work through this
 *      Effectively the backbone of the simulation
 *      
 */

public class Supermarket {
    
    private Floor Floor;
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
        Floor = new Floor("Ground Floor"); 
        Floor.initializeMap(1);   // Initialize Floor 1
        // Generate shopper here
        System.out.println("Creating Shopper Profile...");

    }

    // Start simulation
    public void startSimulation() {
        // Spawn shopper at Y = 20, X = 11
        Floor.setTile(20, 11, 'U');

        System.out.println("Generating Map...");  
        displayDivider();      

        while (running) {
            Floor.printMap();        // Print Floor 1
            System.out.println("    W/A/S/D to Move, I/J/K/L to Look");
            break;  // to be removed when shopper can be integrated
        }


    }

    private void handleInput(char input) {


    }

}
