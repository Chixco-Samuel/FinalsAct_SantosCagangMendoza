package com.barangay.services;

import interfaces.Payment;
import models.PaymentTransaction;
import java.util.ArrayList;
import java.util.List;

public class PaymentService implements Payment {
    private List<PaymentTransaction> transactions;

    public PaymentService() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        
        String generatedId = "TXN-" + (transactions.size() + 1);
        PaymentTransaction newTxn = new PaymentTransaction(generatedId, "UNKNOWN", "General Payment", amount, "COMPLETED");
        transactions.add(newTxn);
        System.out.println("Payment processed successfully! ID: " + generatedId);
    }

    public void addTransaction(PaymentTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        transactions.add(transaction);
    }

    public List<PaymentTransaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
