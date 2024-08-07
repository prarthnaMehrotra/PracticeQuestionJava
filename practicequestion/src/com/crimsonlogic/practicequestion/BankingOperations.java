package com.crimsonlogic.practicequestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingOperations {

    private List<User> userList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void readUserChoice() {
        System.out.println("Enter the user choice:");
        System.out.println("register : to add new user");
        System.out.println("login : to login as existing user");
        System.out.println("checkbalance : to check balance user");
    }

    public void bankingMenu() {
        while (true) {
            readUserChoice();
            String bankOperation = sc.next();

            switch (bankOperation) {
                case "register":
                    registerUser();
                    break;

                case "login":
                    loginUser();
                    break;

                case "checkbalance":
                    checkBalance();
                    break;

                default:
                    System.out.println("Invalid option. Choose another option.");
            }
        }
    }

    private void registerUser() {
        System.out.println("Enter the user details:");
        System.out.print("Enter user ID: ");
        int userId = sc.nextInt();
        System.out.print("Enter user name: ");
        String userName = sc.next();
        System.out.print("Enter user password: ");
        String userPassword = sc.next();
        System.out.print("Enter account number: ");
        String accNumber = sc.next();
        System.out.print("Enter initial balance: Rs.");
        float initialBalance = sc.nextFloat();

        
        User newUser = new User(userId, userName, userPassword, accNumber, initialBalance);
        userList.add(newUser);

        System.out.println("User registered successfully!!!!");
    }

    private void loginUser() {
        System.out.print("Enter account number: ");
        String accNumber = sc.next();

        User user = findUserByAccountNumber(accNumber);
        if (user != null) {
            System.out.println("Login successful!!!!");
            userMenu(user);
        } else {
            System.out.println("Invalid account number. Please try again.");
        }
    }
    
    private void checkBalance() {
        System.out.print("Enter account number: ");
        String accNumber = sc.next();

        User user = findUserByAccountNumber(accNumber);
        if (user != null) {
            System.out.println("Current balance: " + user.getBalance());
            System.out.println("Standard annual interest rate: " + User.getInterestRate() + "%");
            System.out.println("Standard monthly fee deduction: Rs." + User.getMonthlyFee());
        } else {
            System.out.println("Invalid account number.");
        }
    }

    private User findUserByAccountNumber(String accNumber) {
        for (User user : userList) {
            if (user.getAccNumber().equals(accNumber)) {
                return user;
            }
        }
        return null;
    }

    private void userMenu(User user) {
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("deposit : to deposit money");
            System.out.println("withdraw : to withdraw money");
            System.out.println("checkbalance : to check balance");
            System.out.println("logout : to log out");

            String action = sc.next();

            switch (action) {
                case "deposit":
                    depositAmount(user);
                    break;

                case "withdraw":
                    withdrawAmount(user);
                    break;

                case "checkbalance":
                    checkBalance(user);
                    break;

                case "logout":
                    System.out.println("Logged out successfull!!!!");
                    return;

                default:
                    System.out.println("Invalid option. Choose another option.");
            }
            
        }
    }

	private void depositAmount(User user) {
    	System.out.print("Enter deposit amount: Rs.");
        float depositAmt = sc.nextFloat();
        try {
            user.deposit(depositAmt);
            System.out.println("Deposit successful!!! \nNew balance: Rs." + user.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
	}   

    private void withdrawAmount(User user) {
    	System.out.print("Enter withdrawal amount: Rs.");
        float withdrawAmt = sc.nextFloat();
        try {
            user.withdraw(withdrawAmt);
            System.out.println("Withdrawal successful!!! \nNew balance: Rs." + user.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
	}
	
	private void checkBalance(User user) {
        System.out.println("Current balance: Rs." + user.getBalance());
        System.out.println("Standard annual interest rate: " + User.getInterestRate() + "%");
        System.out.println("Standard monthly fee: Rs." + User.getMonthlyFee());
    }

}
