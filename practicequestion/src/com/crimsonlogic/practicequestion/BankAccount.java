package com.crimsonlogic.practicequestion;

public class BankAccount implements Account {

    private float balance;
    private String accId;

    // Constructor to initialize the account with an ID and an initial balance
    public BankAccount(String accId, float initialBalance) {
        this.accId = accId;
        this.balance = initialBalance;
    }

    @Override
    public float getBalance(String accId) {
        // For simplicity, we're not actually validating the accId here.
        // In a real-world scenario, you'd check if the accId matches the account's ID.
        if (this.accId.equals(accId)) {
            return balance;
        } else {
            throw new IllegalArgumentException("Invalid account ID");
        }
    }

    @Override
    public float deposit(float depositAmt) {
        if (depositAmt > 0) {
            balance += depositAmt;
            return balance;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public float withdraw(float withdrawAmt) {
        if (withdrawAmt > 0) {
            if (withdrawAmt <= balance) {
                balance -= withdrawAmt;
                return balance;
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
    }
}
