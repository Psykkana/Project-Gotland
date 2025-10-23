/*
 *  Address Class
 *      The actual display unit in the supermarket
 *      The actual display unit in the supermarket
 *      Contains several Products
 *      Can be multi-tiered
 *      Has an address and capacity
 *
 */

public class Address {
    
    private String floor;           // ex: GF or 2F
    private String grouping;        // ex: aisle or wall
    private int groupNum;     
    private int displayNum;
    private int xAxis;
    private int yAxis;

    // Constructor
    public Address(String floor, String grouping, int groupNum, int displayNum, int xAxis, int yAxis) {
        this.floor = floor;
        this.grouping = grouping;
        this.groupNum = groupNum;
        this.displayNum = displayNum;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public String getFloor() {
        return this.floor;
    }

    public String getGrouping() {
        return this.grouping;
    }

    public int getGroupNum() {
        return this.groupNum;
    }

    public int getDisplayNum() {
        return this.displayNum;
    }

    public int getRow() {
        return this.xAxis;
    }

    public int getCol() {
        return this.yAxis;
    }

}
