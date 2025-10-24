/*
 *  DisplayType Class
 *      Defines the type of display (Table, Chilled Counter, Refrigerator, Shelf)
 *
 */

public class DisplayType {

    // Fields
    private String typeName;        // ex: "Table", "Chilled Counter"
    private int tiers;
    private int capacityPerTier;

    // Constructor
    public DisplayType(String typeName, int tiers, int capacityPerTier) {
        this.typeName = typeName;
        this.tiers = tiers;
        this.capacityPerTier = capacityPerTier;
    }


    // Getter
    public String getType() {
        return this.typeName;
    }

    public int getTiers() {
        return this.tiers;
    }

    public int getTotalCapacity() {
        return tiers * capacityPerTier;
    }

    public String toString() {
        return typeName + " (" + tiers + " tiers, " + capacityPerTier + " capacity/tier)";
    }

}
