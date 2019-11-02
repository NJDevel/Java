package com.example.AbrahamLealU1Capstone.customExceptions;

/**
 * Custom exception for invalid US State sent by client to the Game Store Service
 */
public class InvalidUSStateError extends IllegalArgumentException{
    public InvalidUSStateError(String errorMessage) {
        super(errorMessage);
    }
}
