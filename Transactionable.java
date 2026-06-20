import java.io.IOException;

public interface Transactionable {
	
	abstract void sendAmount(double amount, Customer Sender, String RecieverID) throws IOException;
	abstract void withdrawAmount(double amount,Customer client) throws IOException;
	abstract void addAmount(double amount,Customer client) throws IOException;

}
