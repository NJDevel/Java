package com.example.AbrahamLealU12M3Summative.customExceptions;

/**
 * Custom exception for incomplete information sent by client to the Game Store Service
 */
public class InformationMissingException extends IllegalArgumentException {
    public InformationMissingException(String errorMessage) {
        super(errorMessage);
    }
}
