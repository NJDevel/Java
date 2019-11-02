package com.example.AbrahamLealU12M3Summative.customExceptions;

/**
 * Custom exception for insufficient inventory on purchase requests sent by client to the Game Store Service
 */
public class InsufficientInventoryException extends IllegalArgumentException {
    public InsufficientInventoryException(String errorMessage) {
        super(errorMessage);
    }
}
