package com.nischal.expensetracker.common.exception;

/**
 * @Author : Nischal on 7/23/2024
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Resource not found.");
    }
}
