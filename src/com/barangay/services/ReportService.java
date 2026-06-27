package com.barangay.services;

import com.barangay.interfaces.Reportable;
import com.barangay.models.PaymentTransaction;
import java.util.List;

public class ReportService implements Reportable {
    private PaymentService paymentService;

    public ReportService(PaymentService paymentService) {
        this.paymentService = paymentService;
    
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

        for (PaymentTransaction transaction : transactions) {
            System.out.println(transaction);
            totalAmount += transaction.getAmount();
        }

        System.out.println("------------------------------------");
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("Total Amount Collected: " + totalAmount);
        System.out.println("====================================");
    }
}
    
