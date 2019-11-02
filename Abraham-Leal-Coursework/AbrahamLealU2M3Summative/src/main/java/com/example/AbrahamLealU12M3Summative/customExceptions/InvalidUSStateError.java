package com.example.AbrahamLealU12M3Summative.customExceptions;

/**
 * Custom exception for invalid US State sent by client to the Game Store Service
 */
public class InvalidUSStateError extends IllegalArgumentException{
    public InvalidUSStateError(String errorMessage) {
        super(errorMessage);
    }
}
