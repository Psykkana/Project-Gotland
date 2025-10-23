/*
 *  Floor class
 *      Prints the floor
 *      Getter and setters for specific tiles
 * 
 */

public class Floor {

    private String floorLevel;
    private final int xAxis = 22;
    private final int yAxis = 22;
    private char[][] grid;

    public Floor() {
        this.floorLevel = floorLevel;
        grid = new char[yAxis][xAxis];
    }

    public void initializeMap(int floorNum) {
        // Fill 22x22 grid
        for (int x = 0; x < yAxis; x++) {   // for rows
            for (int y = 0; y < xAxis; y++) {   //  for columns
                if (x == 0 ||           // top
                    x == xAxis - 1 ||   // bottom
                    y == 0 ||           // left
                    y == yAxis -1       // right
                ) {
                    grid[x][y] = '#';  // the walls
                } else {
                    grid[x][y] = ' ';               
                }
            }
        }

        // Floor 1
        if (floorNum == 1) {
            grid[yAxis - 1][10] = '^';  
            grid[yAxis - 1][11] = 'v';    
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