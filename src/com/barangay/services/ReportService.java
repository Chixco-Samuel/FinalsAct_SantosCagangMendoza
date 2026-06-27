package com.barangay.services;
import com.barangay.interfaces.Reportable;
import com.barangay.models.PaymentTransaction;
import java.util.List;

public class ReportService implements Reportable {
    private PaymentService paymentService;
    private ResidentService residentService;

    public ReportService(PaymentService paymentService, ResidentService residentService) {
        this.paymentService = paymentService;
        this.residentService = residentService;
    }

    public double getTotalCollected() {
        return paymentService
                .getAllTransactions()
                .stream()
                .mapToDouble(PaymentTransaction::getAmount)
                .sum();
    }

    @Override
    public void generateReport() {
        List<PaymentTransaction> transactions = paymentService.getAllTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No payment transactions available.");
            return;
        }

        double totalAmount = 0;

        System.out.println("\n========== PAYMENT REPORT ==========");

        long completedCount = transactions.stream()
        .filter(t -> "COMPLETED".equals(t.getPaymentStatus()))
        .count();
        System.out.println("Completed Payments: " + completedCount);

        for (PaymentTransaction transaction : transactions) {
            System.out.println(transaction);
            totalAmount += transaction.getAmount();
        }

        System.out.println("------------------------------------");
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("Total Amount Collected: " + totalAmount);
        System.out.println("Total Registered Residents: " + residentService.getAllResidents().size());
        System.out.println("====================================");
    }
}
    
