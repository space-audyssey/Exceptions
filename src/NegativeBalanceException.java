/*
 * Author: Audrey Horne
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class NegativeBalanceException extends Exception {
	
	private BigDecimal negativeBalance = new BigDecimal("0");
	private static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public NegativeBalanceException() {
		super("Error: negative balance");
	}

	public NegativeBalanceException(BigDecimal negativeBalance) {
		
		super("Amount exceeds balance by " + currency.format(negativeBalance));
		this.negativeBalance = negativeBalance;
		
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
