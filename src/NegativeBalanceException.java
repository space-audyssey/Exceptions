/*
 * Author: Audrey Horne
 * This class is a custom exception that is tailored for a bank account transaction; it is a child 
 * of the Java Exception class.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class NegativeBalanceException extends Exception {
	/*
	 * Unlike with the double type, I must initialize the BigDecimal to 0.
	 * For currency, the default of getCurrencyInstance is US currency.
	 */
	private BigDecimal negativeBalance = new BigDecimal("0");
	private static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	/*
	 * These constructors use the parent constructor of Exception(String message) to set a message.
	 */
	public NegativeBalanceException() {
		super("Error: negative balance");
	}
	/*
	 * This constructor handles the FileNotFoundException, as it should not be propagated to the ATM;
	 * the user doesn't need to worry whether the transaction is writing to a file.
	 */
	public NegativeBalanceException(BigDecimal negativeBalance) {
		
		super("Amount exceeds balance by " + currency.format(negativeBalance));
		this.negativeBalance = negativeBalance;
		/*
		 * This try/catch block should technically not have an exception because if the file isn't there,
		 * it creates a new one. However, Java still wants us to address the possibility that the file isn't
		 * found -- a must if PrintWriter is used.
		 */
		try {
			PrintWriter out;
			out = new PrintWriter(new FileOutputStream(new File("C:\\Eclipse\\Eclipse_Workspace\\ExceptionsIndividual\\logFile.txt"), true)); 
			out.append("Amount exceeds balance by " + currency.format(negativeBalance));
			out.println();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
	}

	@Override
	public String toString() {
		return "Balance of " + currency.format(negativeBalance) + " not allowed";
	}
	
	
}
