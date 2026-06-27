package com.barangay.services;

import com.barangay.interfaces.Reportable;
import com.barangay.models.PaymentTransaction;
import java.util.List;

public class ReportService implements Reportable {
    private PaymentService paymentService;

    public ReportService(PaymentService paymentService) {
        this.paymentService = paymentService;
    
}
