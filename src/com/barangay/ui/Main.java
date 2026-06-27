package com.barangay.ui;

import com.barangay.services.PaymentService;
import com.barangay.models.PaymentTransaction;
import java.util.List;
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
            
            int choice;

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
<<<<<<< HEAD
                    System.out.print("\nEnter payment amount (PHP): ");
                    if (scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); 
                        try {
                            paymentService.processPayment(amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error processing payment: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid amount entered!");
                        scanner.nextLine();
                    }
                    break;
                    
                case 2:
                    System.out.println("\n--- TRANSACTION RECORDS ---");
                    List<PaymentTransaction> list = paymentService.getAllTransactions();
                    if (list.isEmpty()) {
                        System.out.println("No records found in current session.");
                    } else {
                        for (PaymentTransaction txn : list) {
                            System.out.println(txn);
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("\nExiting system. Thank you for using Barangay Services!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid option! Please pick a number between 1 and 3.");
=======
                    System.out.print("Enter payment amount: ");

                    if (scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        paymentService.processPayment(amount);

                    } else {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("\n=== ALL TRANSACTIONS ===");

                    if (paymentService.getAllTransactions().isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (PaymentTransaction txn : paymentService.getAllTransactions()) {
                            System.out.println(txn);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting system. Thank you for using Barangay Services!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-3 only.");
    
>>>>>>> cf31a14e6f647bbbb70594847539e303fb05c5cb
            }
        }
        scanner.close();
    }
}