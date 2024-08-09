/**
 * Custom exception for insufficient funds.
 * 
 * @version V2.0
 */
public class InsufficientFundsException extends RuntimeException 
{
    public InsufficientFundsException(String message) 
    {
        super(message);
    }
}
