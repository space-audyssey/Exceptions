/*
 * Author: Audrey Horne
 * This class propagates the custom negative balance exception if user tries to withdraw too much.
 * Otherwise, it updates the account balance of the user. It uses BigDecimal instead of double.
 */
import java.math.BigDecimal;

public class BankAccount {
	
	private BigDecimal balance;
	
	
	public BankAccount(BigDecimal balance) {
		super();
		this.balance = balance;
	}
	
	public void withdraw(BigDecimal withdrawAmount) throws NegativeBalanceException {
		/*
		 * BigDecimal doesn't overload operators; instead it either implements Comparable interface or 
		 * defines methods for operators
		 */
		if (withdrawAmount.compareTo(balance) == 1) { 
			throw new NegativeBalanceException(balance.subtract(withdrawAmount));
		} else {
			balance.subtract(withdrawAmount);
		}
	}
	
	public void quickWithdraw(BigDecimal withdrawAmount) throws NegativeBalanceException {
		if (withdrawAmount.compareTo(balance) == 1) {
			throw new NegativeBalanceException();
		} else {
			balance.subtract(withdrawAmount);
		}
	}
}
