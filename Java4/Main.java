//bank account management system
//this program defines an abstract bankaccount class that represents a bank account with a baalance
//it includes deposits, retrieving balance, and withdrawal.
import java.util.Scanner;

abstract class BankAccount { 
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        
        if (balance - amount >= 100) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal unavailable: Balance must remain above $100");
        }
    }
}

class CheckingAccount extends BankAccount {

    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
    
        if (amount + 1 <= balance) {
            balance -= (amount + 1); // Deducting the transaction fee ($1)
        } else {
            System.out.println("Withdrawal denied. Insufficient funds.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        SavingsAccount savings = new SavingsAccount(1000);  // Savings account has 1000
        CheckingAccount checking = new CheckingAccount(40);  // Checking account has 40

    
        System.out.print("Enter withdrawal amount from Savings Account: ");
        double savingsWithdrawAmount = scanner.nextDouble();
        savings.withdraw(savingsWithdrawAmount); 

        // Ask for withdrawal amount from user for Checking Account
        System.out.print("Enter withdrawal amount from Checking Account: ");
        double checkingWithdrawAmount = scanner.nextDouble();
        checking.withdraw(checkingWithdrawAmount); // Withdraw user-specified amount from checking

        // Output balances after transactions
        System.out.println("Savings Account Balance after transactions: " + savings.getBalance());
        System.out.println("Checking Account Balance after transactions: " + checking.getBalance());

        scanner.close(); // Close  scanner
    }
}
