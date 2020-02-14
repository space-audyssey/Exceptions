/*
 * Author: Audrey Horne
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NegativeBalanceException extends Exception {
	
	private double negativeBalance;

	public NegativeBalanceException() {
		super("Error: negative balance");
	}

	public NegativeBalanceException(double negativeBalance) {
		
		super("Amount exceeds balance by " + negativeBalance);
		this.negativeBalance = negativeBalance;
		
		
		try {
			PrintWriter out;
			out = new PrintWriter("C:\\Eclipse\\Eclipse_Workspace\\ExceptionsIndividual\\logFile.txt");
			out.write("Amount exceeds balance by " + negativeBalance);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
	}

	@Override
	public String toString() {
		return "Balance of " + negativeBalance + " not allowed";
	}
	
	
}
