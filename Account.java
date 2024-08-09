import java.util.ArrayList;
import java.util.List;

/**
 * A Demo Bank Account.
 * Represents a simple bank account with basic operations like deposit and withdrawal.
 * 
 * @author Dawit Getachew
 * @version V2.0
 */
public class Account 
{
    // Instance Data
    private double balance;
    private final List<String> transactionLog;

    // Constructor: Initializes balance to 0
    public Account() 
    {
        this(0.0);
    }

    // Constructor: Initializes balance to a given amount
    public Account(double initialBalance) 
    {
        if (initialBalance < 0) 
        {
            throw new IllegalArgumentException("Initial balance must be non-negative");
        }
        this.balance = initialBalance;
        this.transactionLog = new ArrayList<>();
        logTransaction("Account created with initial balance: " + initialBalance);
    }

    /**
     * Deposits a specified amount into the account.
     * 
     * @param amount The amount to deposit. Must be positive.
     * @throws IllegalArgumentException if the amount is negative.
     */
    public synchronized void deposit(double amount) 
    {
        if (amount <= 0) 
        {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        logTransaction("Deposited: " + amount);
    }

    /**
     * Withdraws a specified amount from the account.
     * 
     * @param amount The amount to withdraw. Must be positive and less than or equal to the current balance.
     * @throws InsufficientFundsException if the amount is greater than the balance.
     */
    public synchronized void withdraw(double amount) 
    {
        if (amount <= 0) 
        {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > this.balance) 
        {
            throw new InsufficientFundsException("Insufficient funds. Transaction cancelled.");
        }
        this.balance -= amount;
        logTransaction("Withdrew: " + amount);
    }

    /**
     * Returns the current balance of the account.
     * 
     * @return The current balance.
     */
    public synchronized double getBalance() 
    {
        return this.balance;
    }

    /**
     * Returns the transaction log of the account.
     * 
     * @return The transaction log.
     */
    public synchronized List<String> getTransactionLog() 
    {
        return new ArrayList<>(this.transactionLog);
    }

    private void logTransaction(String message) 
    {
        this.transactionLog.add(message);
    }
}
