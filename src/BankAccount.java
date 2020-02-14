/*
 * Author: Audrey Horne
 */

public class BankAccount {
	
	private double balance;

	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}
	
	public void withdraw(double withdrawAmount) throws NegativeBalanceException {
		if (withdrawAmount > balance) {
			throw new NegativeBalanceException(balance - withdrawAmount);
		} else {
			balance -= withdrawAmount;
		}
	}
	
	public void quickWithdraw(double withdrawAmount) throws NegativeBalanceException {
		if (withdrawAmount > balance) {
			throw new NegativeBalanceException();
		} else {
			balance -= withdrawAmount;
		}
	}
}
