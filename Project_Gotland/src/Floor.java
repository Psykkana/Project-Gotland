import java.util.ArrayList;

/*
 * Floor Class
 * Represents a single supermarket floor.
 * Responsible for maintaining the 22x22 grid, displays, and services.
 */

public class Floor {

    // Fields
    private String floorLevel;              // e.g. "GF", "2F"
    private final int xAxis = 22;           // Columns
    private final int yAxis = 22;           // Rows
    private char[][] grid;                  // Visual representation
    private ArrayList<Display> displays;    // Displays located on this floor
    private ArrayList<Service> services;    // Services like checkout, exit, stations

    // Constructor
    public Floor(String floorLevel) {
        this.floorLevel = floorLevel;
        this.grid = new char[yAxis][xAxis];
        this.displays = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    // Initialize the grid layout
    public void initializeMap(int floorNum) {
        for (int y = 0; y < yAxis; y++) {
            for (int x = 0; x < xAxis; x++) {
                if (y == 0 || y == yAxis - 1 || x == 0 || x == xAxis - 1) {
                    grid[y][x] = '#'; // wall boundary
                } else {
                    grid[y][x] = ' '; // open space
                }
            }
        }

        // Example entry point or floor layout logic
        if (floorNum == 1) {
            grid[yAxis - 1][10] = 'v';    // Exit
            grid[yAxis - 1][11] = '^';    // Entrance

            grid[20][1]  = 'B'; // Basket Station
            grid[20][20] = 'P'; // Pushcart Station
            grid[15][1]  = 'S'; // Stairs (Left)
            grid[15][8]  = 'i'; // Product Search (Left)
            grid[15][13] = 'i'; // Product Search (Right)
            grid[15][20] = 'S'; // Stairs (Right)

            grid[18][1] = '#';            // Wall
            grid[18][2] = 'R';            // Checkout / Register
            grid[18][3] = '#';            // Wall
            grid[18][4] = 'R';            // Checkout / Register  
            grid[18][5] = '#';            // Wall
            grid[18][6] = 'R';            // Checkout / Register
            grid[18][7] = '#';            // Wall
            grid[18][8] = 'R';            // Checkout / Register 

            grid[17][10] = '#';           // Wall
            grid[17][11] = '#';           // Wall
            grid[18][10] = '#';           // Wall
            grid[18][11] = '#';           // Wall            

            grid[18][13] = 'R';           // Checkout / Register
            grid[18][14] = '#';           // Wall
            grid[18][15] = 'R';           // Checkout / Register  
            grid[18][16] = '#';           // Wall
            grid[18][17] = 'R';           // Checkout / Register
            grid[18][18] = '#';           // Wall
            grid[18][19] = 'R';           // Checkout / Register             
            grid[18][20] = '#';           // Wall

            grid[13][2] = 's';            // Shelf
            grid[13][3] = 's';            // Shelf
            grid[13][6] = 's';            // Shelf
            grid[13][7] = 's';            // Shelf
            grid[13][10] = 'T';           // Table
            grid[13][11] = 'T';           // Table
            grid[13][14] = 's';           // Shelf
            grid[13][15] = 's';           // Shelf
            grid[13][18] = 's';           // Shelf
            grid[13][19] = 's';           // Shelf 
                
            grid[12][2] = 's';            // Shelf
            grid[12][3] = 's';            // Shelf
            grid[12][6] = 's';            // Shelf
            grid[12][7] = 's';            // Shelf
            grid[12][10] = 'T';           // Table
            grid[12][11] = 'T';           // Table
            grid[12][14] = 's';           // Shelf
            grid[12][15] = 's';           // Shelf
            grid[12][18] = 's';           // Shelf
            grid[12][19] = 's';           // Shelf        
            
            grid[11][2] = 's';            // Shelf
            grid[11][3] = 's';            // Shelf
            grid[11][6] = 's';            // Shelf
            grid[11][7] = 's';            // Shelf
            grid[11][10] = 'T';           // Table
            grid[11][11] = 'T';           // Table
            grid[11][14] = 's';           // Shelf
            grid[11][15] = 's';           // Shelf
            grid[11][18] = 's';           // Shelf
            grid[11][19] = 's';           // Shelf             

            grid[10][2] = 's';            // Shelf
            grid[10][3] = 's';            // Shelf
            grid[10][6] = 's';            // Shelf
            grid[10][7] = 's';            // Shelf
            grid[10][10] = 'T';           // Table
            grid[10][11] = 'T';           // Table
            grid[10][14] = 's';           // Shelf
            grid[10][15] = 's';           // Shelf
            grid[10][18] = 's';           // Shelf
            grid[10][19] = 's';           // Shelf 
                
            grid[7][2] = 's';             // Shelf
            grid[7][3] = 's';             // Shelf
            grid[7][6] = 's';             // Shelf
            grid[7][7] = 's';             // Shelf
            grid[7][10] = 'T';            // Table
            grid[7][11] = 'T';            // Table
            grid[7][14] = 's';            // Shelf
            grid[7][15] = 's';            // Shelf
            grid[7][18] = 's';            // Shelf
            grid[7][19] = 's';            // Shelf            

            grid[6][2] = 's';             // Shelf
            grid[6][3] = 's';             // Shelf
            grid[6][6] = 's';             // Shelf
            grid[6][7] = 's';             // Shelf
            grid[6][10] = 'T';            // Table
            grid[6][11] = 'T';            // Table
            grid[6][14] = 's';            // Shelf
            grid[6][15] = 's';            // Shelf
            grid[6][18] = 's';            // Shelf
            grid[6][19] = 's';            // Shelf 

            grid[5][2] = 's';             // Shelf
            grid[5][3] = 's';             // Shelf
            grid[5][6] = 's';             // Shelf
            grid[5][7] = 's';             // Shelf
            grid[5][10] = 'T';            // Table
            grid[5][11] = 'T';            // Table
            grid[5][14] = 's';            // Shelf
            grid[5][15] = 's';            // Shelf
            grid[5][18] = 's';            // Shelf
            grid[5][19] = 's';            // Shelf  
                
            grid[4][2] = 's';             // Shelf
            grid[4][3] = 's';             // Shelf
            grid[4][6] = 's';             // Shelf
            grid[4][7] = 's';             // Shelf
            grid[4][10] = 'T';            // Table
            grid[4][11] = 'T';            // Table
            grid[4][14] = 's';            // Shelf
            grid[4][15] = 's';            // Shelf
            grid[4][18] = 's';            // Shelf
            grid[4][19] = 's';            // Shelf 

            grid[1][1] = 's';             // Chilled counter
            grid[1][2] = 's';             // Chilled counter
            grid[1][3] = 's';             // Chilled counter   
            grid[1][4] = 's';             // Chilled counter
            grid[1][5] = 's';             // Chilled counter
            grid[1][6] = 's';             // Chilled counter

            grid[1][8] = 's';             // Chilled counter
            grid[1][9] = 's';             // Chilled counter
            grid[1][10] = 's';            // Chilled counter   
            grid[1][11] = 's';            // Chilled counter
            grid[1][12] = 's';            // Chilled counter
            grid[1][13] = 's';            // Chilled counter

            grid[1][15] = 's';            // Chilled counter
            grid[1][16] = 's';            // Chilled counter
            grid[1][17] = 's';            // Chilled counter   
            grid[1][18] = 's';            // Chilled counter
            grid[1][19] = 's';            // Chilled counter
            grid[1][20] = 's';            // Chilled counter  
        }

        // You can add logic here to place Displays or Services in grid cells.

    }

    // Add a Display to this floor
    public void addDisplay(Display display) {
        displays.add(display);
    }

    // Add a Service to this floor
    public void addService(Service service) {
        services.add(service);
    }

    // Print the floor map
    public void printMap() {
        System.out.println("Floor: " + floorLevel);
        for (int y = 0; y < yAxis; y++) {
            for (int x = 0; x < xAxis; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }

    // Print the floor map + Shopper
    public void printMapAndShopper(Shopper shopper) {
        for (int y = 0; y < yAxis; y++) {
            for (int x = 0; x < xAxis; x++) {
                // if the element matches the coords of the shopper avatar
                if (y == shopper.getYAxis() && x == shopper.getXAxis()) {
                    // Determine user's direction
                    char direction;
                    switch (shopper.getFacing()) {
                        case UP: 
                            direction = '^';
                            break;
                        case DOWN:
                            direction = 'V';                            
                            break;
                        case LEFT:
                            direction = '<';
                            break;
                        case RIGHT:
                            direction = '>';                  
                            break;
                        default: 
                            direction = 'U';
                            break;
                    }
                    System.out.print(direction + " ");
                } else {
                    System.out.print(grid[y][x] + " ");                         
                }         
            }
            System.out.println();
        }
    }        
   

    // Getters
    public String getFloorLevel() {
        return floorLevel;
    }

    public ArrayList<Display> getDisplays() {
        return displays;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    // Get or set specific tile on the grid
    public char getTile(int x, int y) {
        return grid[y][x];
    }

    public void setTile(int x, int y, char setChar) {
        grid[y][x] = setChar;
    }

    // check if the tile is empty
    public boolean collisionCheck(int y, int x, Floor floor) {
        if (y < 0 || y >= 22 || x < 0 || x >= 22) {
            return false;
        }
        char tile = floor.getTile(y, x);
        return tile == ' ';
    }    
}
