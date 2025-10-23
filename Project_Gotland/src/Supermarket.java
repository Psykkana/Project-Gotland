
/* 
 *  Supermarket Class
 *      Does the initialization of the actual supermarket
 *      Floors, displays, products all work through this
 *      
 * 
 */

public class Supermarket {
    
    private Floor floor;

    private boolean running;    

    public void initialize() {
        System.out.println("Initializing Supermarket Simulation...");
        Floor GroundFloor = new Floor();
        System.out.println("Initializing Map...");
        System.out.println("=================================================");        
        GroundFloor.initializeMap(1);   // Floor 1

        GroundFloor.printMap();

    }

}
