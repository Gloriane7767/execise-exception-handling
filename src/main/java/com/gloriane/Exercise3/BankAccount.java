package com.gloriane.Exercise3;

// Bank account class with exception handling
public class BankAccount {
    
    // Custom exception class
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }
    
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Current balance: " + balance + ", attempted withdrawal: " + amount);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ". New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}


