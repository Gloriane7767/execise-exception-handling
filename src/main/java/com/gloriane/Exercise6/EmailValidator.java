package com.gloriane.Exercise6;

public class EmailValidator {
    
    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @ symbol");
        }
        
        if (!email.contains(".")) {
            throw new IllegalArgumentException("Email must contain a domain extension");
        }
        
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Email must have exactly one @ symbol");
        }
        
        if (parts[0].isEmpty()) {
            throw new IllegalArgumentException("Email must have a username before @");
        }
        
        if (parts[1].isEmpty() || !parts[1].contains(".")) {
            throw new IllegalArgumentException("Email must have a valid domain after @");
        }
        
        System.out.println("Valid email: " + email);
    }
    
    public static void main(String[] args) {
        try {
            validateEmail("user@example.com");
            validateEmail("invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}