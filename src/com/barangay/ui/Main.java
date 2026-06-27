package com.barangay.ui;

import com.barangay.services.PaymentService;
import com.barangay.models.PaymentTransaction;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentService paymentService = new PaymentService();
        boolean running = true;
        
        System.out.println("=== Barangay Services Management System ===");
        
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Process New Payment");
            System.out.println("2. View All Transactions");
            System.out.println("3. Exit Application");
            System.out.print("Enter your choice: ");
            
            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
                continue;
            }
            
            switch (choice) {
                case 1:
                    System.out.println("\n[System] Payment processing feature coming up next...");
                    break;
                case 2:
                    System.out.println("\n[System] Transaction history tracking coming up next...");
                    break;
                case 3:
                    System.out.println("\nExiting system. Thank you for using Barangay Services!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please pick a number between 1 and 3.");
            }
        }
        scanner.close();
    }
}