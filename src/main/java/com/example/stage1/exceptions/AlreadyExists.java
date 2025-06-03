// AlreadyExists.java
package com.example.stage1.exceptions;

/**
 * Exception thrown when a resource already exists in the system.
 * For example, when trying to add a student with an email that already exists.
 */
public class AlreadyExists extends RuntimeException {
    public AlreadyExists(String message) {
        super(message);
    }
}