/*
 *  Floor class
 *      Prints the floor
 *      Getter and setters for specific tiles
 * 
 */

public class Floor {

    private final int xAxis = 22;
    private final int yAxis = 22;
    private final int TOP_ROW = 0;
    private final int BOT_ROW = 21;
    private final int LEFT_COL = 0;
    private final int RIGHT_ROW = 21;
    private char[][] grid;
    private String floorLevel;

    public Floor() {
        this.floorLevel = floorLevel;
        grid = new char[yAxis][xAxis];
    }

    // Initialize the map for the terminal based map
    public void initializeMap(int floorNum) {
        // Fill 22x22 grid
        for (int x = 0; x < yAxis; x++) {   // for rows
            for (int y = 0; y < xAxis; y++) {   //  for columns
                if (x == TOP_ROW ||          
                    x == BOT_ROW ||   
                    y == LEFT_COL ||           
                    y == RIGHT_ROW) {
                    grid[x][y] = '#';  // the walls
                } else {
                    grid[x][y] = ' ';               
                }
            }
        }

        // Floor 1 (get ready to scroll)
        if (floorNum == 1) {
            grid[yAxis - 1][10] = '^';    // Entrance
            grid[yAxis - 1][11] = 'v';    // Exit

            grid[20][1] = 'B';            // Basket Station
            grid[20][20] = 'P';           // Pushcart Station

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

            grid[15][1] = 'S';            // Stairs
            grid[15][8] = 'i';            // Product Search
            grid[15][13] = 'i';           // Product Search
            grid[15][20] = 'S';           // Stairs

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
        // Place else here for Floor 2

    }

    public void printMap() {
        for (int x = 0; x < xAxis; x++) {
            for (int y = 0; y < yAxis; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }        
    }

    public char getTile(int x, int y) {
        return grid[x][y];
    }

    public void setTile(int x, int y, char setChar) {
        grid[x][y] = setChar;

    }
}