package com.barangay.interfaces;

import com.barangay.exception.ExceptionHandling;

public interface Payment {
    void processPayment(double amount) throws ExceptionHandling;
}