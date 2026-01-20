package com.gloriane;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {





        System.out.println("=========Ex 3========");
        demonstrateBankAccount();


        System.out.println("=========Ex 4========");

        scanner.close();
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
