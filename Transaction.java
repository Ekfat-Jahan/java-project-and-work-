
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Transaction implements Transactionable {
	private int serialNo;
	private Date date;
	private String senderID;
	private String reciverID;
	private double amount;

	@Override
	public void sendAmount(double amount, Customer sender, String targetID) throws IOException {

		Customer Receiver;

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		boolean flag = false;
		int index = 0;

		// for changing the recivers amount
		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(targetID)) {

				System.out.println("content :" + i + "." + customerList.get(i).getCustomerID());

				double prevAmount = customerList.get(i).getAmount();

				customerList.get(i).setAmount(amount + prevAmount);
				flag = true;
				index = i;
				Receiver = customerList.get(i);
				break;

			}

		}

		// for changing the senders amount

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(sender.getCustomerID())) {

				double prevAmount = customerList.get(i).getAmount();

				customerList.get(i).setAmount(prevAmount - amount);
				flag = true;
				break;

			}

		}

		String name = customerList.get(index).getName();
		if (flag) {

			filedata.updateClientsData(customerList);
			JOptionPane.showMessageDialog(null, "Sucessfully sent " + amount + " to " + name);

		} else {
			JOptionPane.showMessageDialog(null, "Failed to send Money!");

		}

		filedata.updateClientsData(customerList);

	}

	@Override
	public void withdrawAmount(double amount, Customer client) throws IOException {

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		boolean flag = false;
		int index = 0;

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(client.getCustomerID())) {

				double prevAmount = customerList.get(i).getAmount();

				customerList.get(i).setAmount(prevAmount - amount);
				flag = true;
				index = i;
				break;

			}

		}

		String name = customerList.get(index).getName();
		if (flag) {

			filedata.updateClientsData(customerList);
			JOptionPane.showMessageDialog(null, "Withdrawn succesfully! : " + amount + " .tk");

		} else {
			JOptionPane.showMessageDialog(null, "Failed to withdrawn!");

		}

		filedata.updateClientsData(customerList);

	}

	@Override
	public void addAmount(double amount, Customer client) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("In add amount :  " + client.toString());

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		boolean flag = false;
		int index = 0;

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(client.getCustomerID())) {

				double prevAmount = customerList.get(i).getAmount();

				customerList.get(i).setAmount(prevAmount + amount);
				flag = true;
				index = i;
				break;

			}

		}

		String name = customerList.get(index).getName();
		if (flag) {

			filedata.updateClientsData(customerList);
			JOptionPane.showMessageDialog(null, "Succesfully added :" + amount + " .tk");

		} else {
			JOptionPane.showMessageDialog(null, "Failed to add amount!");

		}

		filedata.updateClientsData(customerList);

	}

}
