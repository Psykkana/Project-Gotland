
/*
 *  Floor class
 *      Prints the floor
 *      Getter and setters for specific tiles
 * 
 */

public class Floor {

    private final int xAxis = 22;
    private final int yAxis = 22;
    private char[][] grid;

    public Floor() {
        grid = new char[xAxis][yAxis];
        initializeMap();
    }

    public void initializeMap() {

        for (int x = 0; x < xAxis; x++) {   // for Rows
            for (int y = 0; y < yAxis; y++) {
                System.out.print("@");
            }
        }

        // put the important locations here
        // Spawn, exit, 

    }

    public char getTile(int x, int y) {
        return grid[x][y];
    }

    public void setTile(int x, int y, char setChar) {
        grid[x][y] = setChar;

    }
}