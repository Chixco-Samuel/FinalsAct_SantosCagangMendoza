package com.barangay.interfaces;

import com.barangay.exception.ExceptionHandling;

public interface Reportable {
    void generateReport() throws ExceptionHandling;
}