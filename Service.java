/*
 * Service Class
 * Represents a service area in the supermarket, such as:
 * - Checkout Counter
 * - Cart Station
 * - Basket Station
 * - Exit
 *
 * Each Service has a type (name) and a physical Address.
 * It can interact with a Shopper via the interact() method.
 */

public class Service {

    // Fields
    private String type;     // name of service like basket and cart
    private Address address; // location of these services

    // Constructor
    public Service(String type, Address address) {
        this.type = type;
        this.address = address;
    }

    // Getters
    public String getType() {
        return this.type;
    }

    public Address getAddress() {
        return this.address;
    }

    // Main interaction logic between shopper and service
    public void interact(Shopper shopper) {
        switch (type.toLowerCase()) {
            case "checkout":
                if (shopper.getTotalItemCount() == 0) {
                    System.out.println("🧾 You have no items to checkout.");
                    return;
                }

                if (!shopper.hasCheckedOut()) {
                    float total = shopper.getTotalPrice();
                    float discounted = shopper.getDiscountedPrice();

                    System.out.println(shopper.getName() + " is checking out...");
                    System.out.println("Total: PHP" + total);
                    if (discounted < total) {
                        System.out.println("Senior discount applied! Discounted total: PHP" + discounted);
                    }
                    shopper.checkout();
                } else {
                    System.out.println(shopper.getName() + " has already checked out.");
                }
                break;

            case "basket station":
                if (shopper.getEquipment() != null) {
                    System.out.println("You already have equipment.");
                    return;
                }
                if (shopper.getCarriedProducts().size() > 0) {
                    System.out.println("You can’t pick up a basket while holding items in your hands.");
                    return;
                }
                shopper.setEquipment(new Basket());
                System.out.println(shopper.getName() + " picked up a basket");
                break;

            case "cart station":
                if (shopper.getEquipment() != null) {
                    System.out.println("You already have equipment.");
                    return;
                }
                if (shopper.getCarriedProducts().size() > 0) {
                    System.out.println("You can’t pick up a cart while holding items in your hands.");
                    return;
                }
                shopper.setEquipment(new Cart());
                System.out.println(shopper.getName() + " picked up a cart");
                break;

            case "exit":
                if (shopper.hasCheckedOut()) {
                    System.out.println(shopper.getName() + " exits the supermarket. Thank you!");
                    System.out.println("Do you want to restart the simulator? Type Y or N: ");
                    java.util.Scanner scanner = new java.util.Scanner(System.in);
                    String response = scanner.nextLine().trim().toUpperCase();
                    if (response.equals("Y")) {
                        Driver.restartGame();
                    } else {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                } else {
                    System.out.println(shopper.getName() + " cannot exit without checking out!");
                }
                break;

            default:
                System.out.println("Unknown service type: " + type);
        }
}


    @Override
    public String toString() {
        return "Service: " + type + " at " + address;
    }
}
