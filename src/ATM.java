/*
 * Author: Audrey Horne
 */

import java.io.FileNotFoundException;

public class ATM {
	
	private BankAccount bankAccount = new BankAccount(500);
	
	public void handleTransactions() throws NegativeBalanceException {
		try {
			bankAccount.withdraw(600);
		} catch (NegativeBalanceException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		try {
			bankAccount.quickWithdraw(600);
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
