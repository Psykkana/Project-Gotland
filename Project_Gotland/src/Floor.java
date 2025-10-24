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
            grid[yAxis - 1][10] = '^'; // entry marker
            grid[yAxis - 1][11] = 'v'; // maybe an exit marker
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
}
