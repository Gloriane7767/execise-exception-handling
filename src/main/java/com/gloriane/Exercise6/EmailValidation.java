package com.gloriane.Exercise6;

import java.util.regex.Pattern;

public class EmailValidation {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        try {
            validateEmail("test@example.com");
            System.out.println("test@example.com is valid.");
            validateEmail("invalid-email");
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed: " + e.getMessage());
        }
    }

    public static void validateEmail(String email) {
        if (email == null || !pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }
}
