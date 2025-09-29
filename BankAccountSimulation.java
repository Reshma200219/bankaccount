package bankaccount;

import java.util.ArrayList;
import java.util.List;

// Base Account class
class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal!");
        }
    }

    // Show balance
    public double getBalance() {
        return balance;
    }

    // Show transaction history
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

// SavingsAccount demonstrating inheritance
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    // Method overriding - adds interest
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest of " + interest + " added!");
    }
}

// Main Class
public class BankAccountSimulation {
    public static void main(String[] args) {
        // Create a savings account
        SavingsAccount acc1 = new SavingsAccount("Reshma", 5000, 5);

        acc1.deposit(2000);
        acc1.withdraw(1000);
        acc1.addInterest();
        
        System.out.println("\nFinal Balance: " + acc1.getBalance());
        acc1.printTransactionHistory();
    }
}

