package com.barangay.services;
import com.barangay.exception.ExceptionHandling;
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

    public void processPayment(String residentId, String purpose, double amount) throws ExceptionHandling {
    if (amount <= 0) {
        throw new ExceptionHandling("Payment amount must be greater than zero.");
    }
    String generatedId = "TXN-" + (transactions.size() + 1);
    PaymentTransaction newTxn = new PaymentTransaction(generatedId, residentId, purpose, amount, "COMPLETED");
    transactions.add(newTxn);
    System.out.println("Payment processed! Transaction ID: " + generatedId);
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
