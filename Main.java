/**
 * Main Class to run the Account class.
 * Demonstrates the creation and usage of Account objects.
 * 
 * @version V2.0
 */
public class Main 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Creating account objects
            Account customer1 = new Account();
            customer1.deposit(500);

            Account customer2 = new Account(100);

            // Output balances
            System.out.println("Customer 1 Balance: " + customer1.getBalance());
            System.out.println("Customer 2 Balance: " + customer2.getBalance());

            // Withdraw some amount
            customer1.withdraw(200);
            System.out.println("Customer 1 Balance after withdrawal: " + customer1.getBalance());

            // Display transaction logs
            System.out.println("Customer 1 Transaction Log: " + customer1.getTransactionLog());
            System.out.println("Customer 2 Transaction Log: " + customer2.getTransactionLog());
            
        } catch (IllegalArgumentException | InsufficientFundsException e) 
        {
            System.err.println(e.getMessage());
        }
    }
}
