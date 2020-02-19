/*
 * Author: Audrey Horne
 * This class is the driver for the program and handles the NegativeBalance Exception.
 * It initializes BankAccount with a BigDecimal instead of double.
 */


import java.math.BigDecimal;

public class ATM {
	
	private BankAccount bankAccount = new BankAccount(new BigDecimal("500")); // must use 'new' with BigDecimal
	
	/*
	 * handleTransactions handles the custom NegativeBalanceException and prints calls both of the constructors
	 * that are defined in the NegativeBalanceException class (to the generic versus custom messages)
	 */
	public void handleTransactions() throws NegativeBalanceException {
		try {
			bankAccount.withdraw(new BigDecimal("600"));
		} catch (NegativeBalanceException e) { // withdraw throws this exception if balance < withdraw amount
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		try {
			bankAccount.quickWithdraw(new BigDecimal("600"));
		} catch (NegativeBalanceException e){
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws NegativeBalanceException {
		
		ATM atm = new ATM();
		atm.handleTransactions();

	}

}
