package com.gloriane;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========Ex 1========");

        System.out.print("Enter first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = scanner.nextInt();

        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }

        System.out.println("=========Ex 2========");
        try {
            int validNumber = readIntegerInRange(1, 100);
            System.out.println("Good! You entered: " + validNumber);
        } catch (OutOfRangeException e) {
            System.out.println("Range Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Input Error: " + e.getMessage());
        }

        System.out.println("=========Ex 3========");
        demonstrateBankAccount();


        System.out.println("=========Ex 4========");

        scanner.close();
    }

    /*
    What it does: Creates a special error type for when numbers are outside your range
    Why: Java needs to know what kind of error to throw when the number is too big or too small
     */
    // Custom exception class
    static class OutOfRangeException extends Exception {
        public OutOfRangeException(String message) {
            super(message);
        }
    }

    /*
    What it does: Creates a method that takes minimum and maximum values
    Why: This method will do all the checking work for you
    The throws keyword is like a warning label on the method. It tells anyone who wants to use this method:
     "Hey! This method might throw an OutOfRangeException, so be ready to catch it!"
     */
    // Input method that throws the custom exception
    public static int readIntegerInRange(int min, int max) throws OutOfRangeException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int number = scanner.nextInt();

            if (number < min || number > max) {
                throw new OutOfRangeException("Number " + number + " is out of range [" + min + "-" + max + "]");
            }

            return number;

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input: Please enter a valid integer");
        }
    }

    // Custom exception class for banking operations
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    // Bank account class with exception handling
    public static class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public void deposit(double amount) throws CustomException {
            if (amount <= 0) {
                throw new CustomException("Deposit amount must be positive.");
            }
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        }

        public void withdraw(double amount) throws CustomException {
            if (amount <= 0) {
                throw new CustomException("Withdrawal amount must be positive.");
            }
            if (amount > balance) {
                throw new CustomException("Insufficient funds. Balance: $" + balance);
            }
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ". New balance: $" + balance);
        }

        public double getBalance() {
            return balance;
        }
    }

    // Method to demonstrate bank account operations
    public static void demonstrateBankAccount() {
        try {
            BankAccount account = new BankAccount("12345", 1000.0);
            System.out.println("Initial balance: $" + account.getBalance());

            account.deposit(500.0);
            account.withdraw(200.0);
            account.withdraw(2000.0); // This will throw an exception

        } catch (CustomException e) {
            System.out.println("Banking Error: " + e.getMessage());
        }
    }
}
