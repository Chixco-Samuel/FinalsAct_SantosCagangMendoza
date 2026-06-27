package com.barangay.services;
import com.barangay.interfaces.Payment;
import com.barangay.models.BarangayService;
import com.barangay.models.PaymentTransaction;
import java.util.ArrayList;
import java.util.List;

public class PaymentService extends BarangayService implements Payment {
    private List<PaymentTransaction> transactions;

    public PaymentService() {
        super("PS001", "Payment Processing", "Service for processing payments");
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
