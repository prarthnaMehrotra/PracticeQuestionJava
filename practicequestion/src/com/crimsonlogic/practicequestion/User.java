package com.crimsonlogic.practicequestion;

public class User {

    private int userId;
    private String userName;
    private String userPassword;
    private String accNumber;
    private float balance;
    private static final float interestRate = 0.03f;
    private static final float monthlyFee = 5.0f;

    // Default constructor
    public User() {}

    // Constructor with all the parameters
    public User(int userId, String userName, String userPassword, String accNumber, float initialBalance) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.accNumber = accNumber;
        this.balance = initialBalance;
    }

    // Getter and setter methods
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public static float getInterestRate() {
        return interestRate;
    }

    public static float getMonthlyFee() {
        return monthlyFee;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + userId;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return userId == other.userId &&
               userName.equals(other.userName) &&
               userPassword.equals(other.userPassword);
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
    }
}
