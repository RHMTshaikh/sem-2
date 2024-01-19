package KhalidSir;
// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private double balance;
    private double transactionFee;
    private int transactionCount=0;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance, double transactionFee) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionFee = transactionFee;
    }
    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            balance -= transactionFee;
            transactionCount++;
            System.out.println("Deposited $" + amount);
        }
    }
    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            balance -= transactionFee;
            transactionCount++;
            System.out.println("Withdrawn $" + amount);
        }
        else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
    // Getters for account number and balance
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public double getTransactionCount() {
        return transactionCount;
    }
    // to be implemented by subclasses
    public abstract double calculateInterest();
}
//____________________________________________________________________________________
class SavingsAccount extends BankAccount {
    private double interestRate = 7;
    // Constructor
    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance,0);
    }
    // Calculate interest based on balance and interest rate
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}
// ____________________________________________________________________________________
class CheckingAccount extends BankAccount {
    private double interestRate = 1;
    // Constructor
    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance,10);
    }
    public double calculateInterest() {
        return (getBalance() * interestRate / 100);
    }
    public double getTransactionFee() {
        return getTransactionCount()*10;
    }
}
public class MainBankAccount {
    public static void main(String[] args) {
        // Create a SavingsAccount and CheckingAccount
        SavingsAccount savingsAccount = new SavingsAccount("SAV001", 1000.0); // Account number, initial balance, interest rate
        CheckingAccount checkingAccount = new CheckingAccount("CHK001", 1500.0); // Account number, initial balance, transaction fee

        // Perform operations on the savings account
        System.out.println("Savings Account:");
        System.out.println("Initial Balance: $" + savingsAccount.getBalance());
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(200.0);
        System.out.println("Current Balance: $" + savingsAccount.getBalance());
        System.out.println("Interest Earned: $" + savingsAccount.calculateInterest());

        // Perform operations on the checking account
        System.out.println("\nChecking Account:");
        System.out.println("Initial Balance: $" + checkingAccount.getBalance());
        checkingAccount.deposit(300.0);
        checkingAccount.withdraw(100.0);
        System.out.println("Current Balance: $" + checkingAccount.getBalance());
        System.out.println("Interest Earned: $" + checkingAccount.calculateInterest());
        System.out.println("Transaction Fee: $" + checkingAccount.getTransactionFee());
    }
}
