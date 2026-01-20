package com.gloriane.Exercise3;

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = null;
        try {
            account = new BankAccount("12345", 1000.0);
            System.out.println("Initial balance: $" + account.getBalance());

            account.deposit(500.0);
            account.withdraw(200.0);
            account.withdraw(2000.0); // This will throw an exception

        } catch (BankAccount.InsufficientBalanceException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
        
        if (account != null) {
            System.out.println("Final balance: $" + account.getBalance());
        }
    }
}

