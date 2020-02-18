/*
 * Author: Audrey Horne
 */


import java.math.BigDecimal;

public class ATM {
	
	private BankAccount bankAccount = new BankAccount(new BigDecimal("500"));
	
	public void handleTransactions() throws NegativeBalanceException {
		try {
			bankAccount.withdraw(new BigDecimal("600"));
		} catch (NegativeBalanceException e) {
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
