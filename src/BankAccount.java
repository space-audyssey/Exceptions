import java.math.BigDecimal;

/*
 * Author: Audrey Horne
 */

public class BankAccount {
	
	private BigDecimal balance;

	public BankAccount(BigDecimal balance) {
		super();
		this.balance = balance;
	}
	
	public void withdraw(BigDecimal withdrawAmount) throws NegativeBalanceException {
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
