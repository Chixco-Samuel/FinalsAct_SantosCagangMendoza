package com.barangay.ui;

import com.barangay.exception.ExceptionHandling;
import com.barangay.models.Resident;
import com.barangay.services.PaymentService;
import com.barangay.services.ReportService;
import com.barangay.services.ResidentService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ExceptionHandling {
        Scanner scanner = new Scanner(System.in);
        PaymentService paymentService = new PaymentService();
        ResidentService residentService = new ResidentService();
        ReportService reportService = new ReportService(paymentService, residentService);
        boolean running = true;

        System.out.println("=== Barangay Services Management System ===");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Resident Registration");
            System.out.println("2. Payment Processing");
            System.out.println("3. View Statistical Report");
            System.out.println("4. Sort Residents by Last Name");
            System.out.println("5. Search Resident by Last Name");
            System.out.println("6. Exit");
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
                    System.out.println("\n--- RESIDENT REGISTRATION ---");
                    System.out.print("Enter Resident ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = 0;
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Invalid age entered!");
                        scanner.nextLine();
                        break;
                    }
                    try {
                        residentService.registerResident(id, firstName, lastName, age);
                        System.out.println("Resident registered successfully!");
                    } catch (ExceptionHandling e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- PAYMENT PROCESSING ---");
                    System.out.print("Enter payment amount (PHP): ");
                    if (scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        try {
                            paymentService.processPayment(amount);
                        } catch (ExceptionHandling e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid amount entered!");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    try {
                        reportService.generateReport();
                    } catch (ExceptionHandling e) {
                        System.out.println("Error generating report: " + e.getMessage());
                    }
                    break;

                case 4:
                    residentService.sortResidentsByLastName();
                    System.out.println("\n--- RESIDENTS SORTED BY LAST NAME ---");
                    residentService.displayResidents();
                    break;

                case 5:
                    System.out.print("Enter last name to search: ");
                    String keyword = scanner.nextLine();
                    List<Resident> results = residentService.searchByLastName(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No residents found with last name: " + keyword);
                    } else {
                        System.out.println("\n--- SEARCH RESULTS ---");
                        for (Resident r : results) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 6:
                    System.out.println("\nExiting system. Thank you for using Barangay Services!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please pick a number between 1 and 6.");
                    break;
            }
        }
        scanner.close();
    }
}