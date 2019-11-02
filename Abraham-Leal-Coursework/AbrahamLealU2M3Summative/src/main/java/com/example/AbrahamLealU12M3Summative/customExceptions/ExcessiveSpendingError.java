package com.example.AbrahamLealU12M3Summative.customExceptions;

/**
 * This exception is thrown when the subtotal or total amount exceeds $999.99, due to limitations of the database
 * to only store a maximum of 5 digits with 2 decimals places
 */
public class ExcessiveSpendingError extends IllegalArgumentException {
    public ExcessiveSpendingError(String errorMessage) {
        super(errorMessage);
    }
}