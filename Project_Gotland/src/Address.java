public class Address {
    
    private String floor;           // ex: GF or 2F
    private String grouping;        // ex: aisle or wall
    private int groupNum;
    private int displayNum;

    // Constructor
    public Address(String floor, String grouping, int groupNum, int displayNum) [
        this.floor = floor;
        this.grouping = grouping;
        this.groupNum = groupNum;
        this.displayNum = displayNum;
    ]

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

}
