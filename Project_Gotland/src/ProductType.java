/*
 *  Specifies what kind of item a product is
 *  Includes its display requirements, serial prefix, and restrictions
 * 
 */

public class ProductType {
    
    private String serialPrefix;        // ex: "FRU", "ALC"
    private String typeName;            // ex: "Fruit", "Alcohol"
    private DisplayType displayType;    // for where it can be displayed
    private boolean restrictedUnderage;
    private boolean discountEligible;
    // For + 60 discount for edible/drinkables (excludes alcohol)
    private boolean foodConsumable;  
    private boolean drinkConsumable;     

    // Constructor
    public ProductType(String serialPrefix, String typeName, DisplayType displayType, 
                        boolean restrictedUnderage, boolean discountEligible,
                        boolean foodConsumable, boolean drinkConsumable) {
        this.serialPrefix = serialPrefix;
        this.typeName = typeName;
        this.displayType = displayType;
        this.restrictedUnderage = restrictedUnderage;
        this.discountEligible = discountEligible;
        this.foodConsumable = foodConsumable;
        this.drinkConsumable = drinkConsumable;
    }
}