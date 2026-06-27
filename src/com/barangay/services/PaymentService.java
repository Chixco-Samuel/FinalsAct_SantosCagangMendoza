package com.barangay.services;

import com.barangay.interfaces.Payment;
import com.barangay.models.PaymentTransaction;
import com.barangay.exception.ExceptionHandling;
import java.util.ArrayList;
import java.util.List;

public class PaymentService implements Payment {
    private List<PaymentTransaction> transactions;

    public PaymentService() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public void processPayment(double amount) throws ExceptionHandling {
        if (amount <= 0) {
            throw new ExceptionHandling("Payment amount must be greater than zero.");
        }

        String generatedId = "TXN-" + (transactions.size() + 1);
        // This constructor call now safely passes along the ExceptionHandling rule
        PaymentTransaction newTxn = new PaymentTransaction(generatedId, "UNKNOWN", "General Payment", amount, "COMPLETED");
        transactions.add(newTxn);
        System.out.println("Payment processed successfully! ID: " + generatedId);
    }

    public void addTransaction(PaymentTransaction transaction) throws ExceptionHandling {
        if (transaction == null) {
            throw new ExceptionHandling("Transaction cannot be null.");
        }
        transactions.add(transaction);
    }

    public List<PaymentTransaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}