package com.example.AbrahamLealU12M3Summative.customExceptions;

/**
 * Custom exception for when Game Store service is unable to communicate with database server
 */
public class DatabaseUnreachableError extends IllegalArgumentException {
    public DatabaseUnreachableError(String errorMessage) {
        super(errorMessage);
    }
}
