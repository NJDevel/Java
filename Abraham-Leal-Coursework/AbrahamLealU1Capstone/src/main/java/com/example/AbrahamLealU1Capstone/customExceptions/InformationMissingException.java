package com.example.AbrahamLealU1Capstone.customExceptions;

/**
 * Custom exception for incomplete information sent by client to the Game Store Service
 */
public class InformationMissingException extends IllegalArgumentException {
    public InformationMissingException(String errorMessage) {
        super(errorMessage);
    }
}
