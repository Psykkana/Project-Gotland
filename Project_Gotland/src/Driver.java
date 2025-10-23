
/*
 * PROJECT GOTLAND  (subject to change later)
 * 
 * The CCPROG3 MACHINE PROJECT - A SUPERMARKET SIMULATOR
 * 
 */

import java.util.Scanner;

public class Driver {
    public static void displayDivider() {
        System.out.println("=================================================");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        displayDivider();
        System.out.println("Project Gotland");
        System.out.println("CCPROG3 MC01 Machine Project");        
        displayDivider();

        // Ask for shopper's details
        System.out.println("Hello, please enter your details:");
        System.out.print("    Name: ");
        String shopperName = scanner.nextLine();
        System.out.print("    Age: ");
        int shopperAge = scanner.nextInt();

        // Initialize shopper
        Shopper shopper = new Shopper(shopperName, shopperAge);


        
    }
}
