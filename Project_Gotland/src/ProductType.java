/*
 *  Specifies what kind of item a product is
 *  Includes its display requirements, serial prefix, and restrictions
 * 
 */

public class ProductType {
    
    private String serialPrefix;    //
    private String typeName;        // ex: "FRU", "ALC"
    // Restrictions
    private boolean restrictedUnder18;
    private boolean canDiscount;

}
