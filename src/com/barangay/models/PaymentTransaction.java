package com.barangay.models;

import java.util.Date;

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


    public PaymentTransaction(String transactionId, String residentId, String purpose, double amount, String paymentStatus) {
        this.transactionId = transactionId;
        this.residentId = residentId;
        this.purpose = purpose;
        this.amount = amount;
        this.transactionDate = new Date(); 
        this.paymentStatus = paymentStatus;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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