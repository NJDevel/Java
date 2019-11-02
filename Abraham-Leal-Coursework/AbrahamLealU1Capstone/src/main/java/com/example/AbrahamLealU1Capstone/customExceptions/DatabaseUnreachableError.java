package com.example.AbrahamLealU1Capstone.customExceptions;

/**
 * Custom exception for when Game Store service is unable to communicate with database server
 */
public class DatabaseUnreachableError extends IllegalArgumentException {
    public DatabaseUnreachableError(String errorMessage) {
        super(errorMessage);
    }
}
