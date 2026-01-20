package com.gloriane.Exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RangeValidator {
    
    // Custom exception class
    static class InvalidRangeException extends Exception {
        public InvalidRangeException(String message) {
            super(message);
        }
    }
    
    public static void main(String[] args) {
        try {
            int validNumber = readIntegerInRange(1, 100);
            System.out.println("Good! You entered: " + validNumber);
        } catch (InvalidRangeException e) {
            System.out.println("Range Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    /*
    What it does: Creates a method that takes minimum and maximum values
    Why: This method will do all the checking work for you
    The throws keyword is like a warning label on the method. It tells anyone who wants to use this method:
     "Hey! This method might throw an InvalidRangeException, so be ready to catch it!"
     */
    // Input method that throws the custom exception
    public static int readIntegerInRange(int min, int max) throws InvalidRangeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer between " + min + " and " + max + ": ");
        
        try {
            int number = scanner.nextInt();
            
            if (number < min || number > max) {
                throw new InvalidRangeException("Number " + number + " is out of range [" + min + "-" + max + "]");
            }
            
            return number;
            
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input: Please enter a valid integer");
        }
    }
}
