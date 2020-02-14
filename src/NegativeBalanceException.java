/*
 * Author: Audrey Horne
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class NegativeBalanceException extends Exception {
	
	private static double negativeBalance;
	private static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public NegativeBalanceException() {
		super("Error: negative balance");
	}

	public NegativeBalanceException(double negativeBalance) {
		
		super("Amount exceeds balance by " + currency.format(negativeBalance));
		NegativeBalanceException.negativeBalance = negativeBalance;
		
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
