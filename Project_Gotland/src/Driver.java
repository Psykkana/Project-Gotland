import java.util.Scanner;

/*
 * PROJECT GOTLAND  (subject to change later)
 * 
 * The CCPROG3 MACHINE PROJECT - A SUPERMARKET SIMULATOR
 * 
 */

public class Driver {
    public static void displayDivider() {
        System.out.println("=================================================");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println();
        displayDivider();
        System.out.println("\tProject Gotland");
        System.out.println("\tCCPROG3 MC01 Machine Project");        
        displayDivider();

        String shopperName = null;
        int shopperAge = 0;

        // Ask for shopper's details
        System.out.println("Hello, please enter your details:");
        System.out.print("    Name: ");
        shopperName = scanner.nextLine();
        
        boolean validAge = false;       // assume invalid age
        System.out.print("    Age: ");
       
        while (!validAge) {
        shopperAge = scanner.nextInt();             
            if (shopperAge > 0) {
                validAge = true;
            } else {
                System.out.println("Error: Please input a valid age");
                System.out.print("    Age: ");
            }
        }

        displayDivider();

        // Create shopper
        // Shopper shopper = new Shopper(shopperName, shopperAge);

        // Create and initialize supermarket
        Supermarket supermarket = new Supermarket();

        // Start simulation loop



        scanner.close();    
    }
}
