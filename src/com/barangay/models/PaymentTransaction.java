package com.barangay.models;

import com.barangay.exception.ExceptionHandling;
import java.util.Date;
import java.util.Objects;

public class PaymentTransaction {
    private String transactionId;
    private String residentId;     
    private String purpose;        
    private double amount;
    private Date transactionDate;
    private String paymentStatus;  

    public PaymentTransaction() {
        this.transactionDate = new Date(); 
    }

    public PaymentTransaction(String transactionId, String residentId, String purpose, double amount, String paymentStatus) throws ExceptionHandling {
        setTransactionId(transactionId);
        setResidentId(residentId);
        setPurpose(purpose);
        setAmount(amount);
        setPaymentStatus(paymentStatus);
        this.transactionDate = new Date(); 
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) throws ExceptionHandling {
        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new ExceptionHandling("Transaction ID cannot be null or empty.");
        }
        this.transactionId = transactionId;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) throws ExceptionHandling {
        if (residentId == null || residentId.trim().isEmpty()) {
            throw new ExceptionHandling("Resident ID cannot be null or empty.");
        }
        this.residentId = residentId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) throws ExceptionHandling {
        if (purpose == null || purpose.trim().isEmpty()) {
            throw new ExceptionHandling("Purpose cannot be null or empty.");
        }
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws ExceptionHandling {
        if (amount <= 0) {
            throw new ExceptionHandling("Payment amount must be greater than zero. Negative values are not allowed.");
        }
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) throws ExceptionHandling {
        if (transactionDate == null) {
            throw new ExceptionHandling("Transaction date cannot be null.");
        }
        if (transactionDate.after(new Date())) {
            throw new ExceptionHandling("Transaction date cannot be in the future.");
        }
        this.transactionDate = transactionDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) throws ExceptionHandling {
        if (paymentStatus == null || paymentStatus.trim().isEmpty()) {
            throw new ExceptionHandling("Payment status cannot be null or empty.");
        }
        
        String status = paymentStatus.trim().toUpperCase();
        if (status.equals("PENDING") || status.equals("COMPLETED") || status.equals("FAILED")) {
            this.paymentStatus = status;
        } else {
            throw new ExceptionHandling("Invalid status. Must be PENDING, COMPLETED, or FAILED.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentTransaction that = (PaymentTransaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", residentId='" + residentId + '\'' +
                ", purpose='" + purpose + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}