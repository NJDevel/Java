package com.example.AbrahamLealU1Capstone.customExceptions;

/**
 * Custom exception for invalid item types sent by client to the Game Store Service
 */
public class InvalidItemTypeException extends IllegalArgumentException {
    public InvalidItemTypeException(String errorMessage) {
        super(errorMessage);
    }
}
