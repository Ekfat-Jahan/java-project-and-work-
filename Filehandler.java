
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Filehandler {

	private Admin admin;
	private Customer customerList[];
	private Transaction transactionsList[];

	public Filehandler(Admin admin, Customer[] customerList, Transaction[] transactionsList) {
		super();
		this.admin = admin;
		this.customerList = customerList;
		this.transactionsList = transactionsList;
	}

	public Filehandler() {
		// TODO Auto-generated constructor stub
	}

	BufferedWriter buffwriter;
	BufferedReader buffreader;

	File adminDirectory = new File("Admin_Directory");
	File clientsInformationDirectory = new File("clinets_Information_Directory");
	File TransactionsDirectory = new File("Transactions_Directory");

	// File adminCredentialsFile;
	// File clientsDataFile;

	File transactionDataFile;

	String adminFileName = "AdminCredentials.txt";
	String clientsFileName = "clientsDataFile.txt";
	String transactionsFileName = "transactionsFile.txt";

	File clientsDataFile = new File(clientsInformationDirectory.getAbsolutePath() + "/" + clientsFileName);
	File adminCredentialsFile = new File(adminDirectory.getAbsolutePath() + "/" + adminFileName);

	void inintialiseAllDataFiles() throws IOException {

		if (!adminDirectory.exists()) {

			adminDirectory.mkdir();

			adminCredentialsFile = new File(adminDirectory.getAbsolutePath() + "/" + adminFileName);

			adminCredentialsFile.createNewFile();

			buffwriter = new BufferedWriter(new FileWriter(adminCredentialsFile));

			JOptionPane.showMessageDialog(null, "Admin Password and ID arent Set!", "ADMIN SETUP",
					JOptionPane.WARNING_MESSAGE);
			String id = JOptionPane.showInputDialog(null, "Enter Id :", "ADMIN ID", JOptionPane.QUESTION_MESSAGE);
			String pass = JOptionPane.showInputDialog(null, "Enter password :", "ADMIN Password",
					JOptionPane.QUESTION_MESSAGE);

			buffwriter.append(id + ',' + pass);
			buffwriter.close();
			JOptionPane.showMessageDialog(null, "Admin Registered SuccessFully! proceed to Login page");

			clientsInformationDirectory.mkdir();
			TransactionsDirectory.mkdir();

			clientsDataFile = new File(clientsInformationDirectory.getAbsoluteFile() + "/" + clientsFileName);
			transactionDataFile = new File(TransactionsDirectory.getAbsoluteFile() + "/" + transactionsFileName);
			clientsDataFile.createNewFile();
			transactionDataFile.createNewFile();

		}

	}

	void fetchAdminCredentials(Admin admin) throws IOException {

		buffreader = new BufferedReader(new FileReader(adminCredentialsFile));

		String str[] = null;
		String tempstr;

		// admin,1234

		while ((tempstr = buffreader.readLine()) != null) {

			str = tempstr.split(",");
		}

		admin.setAdminID(str[0]);
		admin.setAdminPass(str[1]);

	}

	void fetchClientsData(ArrayList<Customer> customerList) throws IOException {

		clientsDataFile = new File(clientsInformationDirectory.getAbsolutePath() + "/" + clientsFileName);

		buffreader = new BufferedReader(new FileReader(clientsDataFile));

		String splittedDataArray[] = null;
		String tempstr;

		// Customer tempcustomer = new Customer(name, email, age, customerID,
		// customerPass, amount);

		while ((tempstr = buffreader.readLine()) != null) {
			splittedDataArray = tempstr.split(",");

			int age = Integer.parseInt(splittedDataArray[2]); // parse int

			double amount = Double.parseDouble(splittedDataArray[5]); // parse double

			Customer tempCustomer = new Customer(splittedDataArray[0], splittedDataArray[1], age, splittedDataArray[3],
					splittedDataArray[4], amount);

			customerList.add(tempCustomer);
		}

	}

	void updateCientById(ArrayList<Customer> customerList, Customer targetClient) {

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(targetClient.getCustomerID())) {
				customerList.remove(i);

			}

		}

		customerList.add(targetClient);

	}

	void updateClientsData(ArrayList<Customer> customerList) throws IOException {
		
		clientsDataFile.delete();
		clientsDataFile.createNewFile();

		for (int i = 0; i < customerList.size(); i++) {

			addClientDataToFile(customerList.get(i));

		}

	}

	void addClientDataToFile(Customer customer) throws IOException {

		buffwriter = new BufferedWriter(new FileWriter(clientsDataFile, true)); // appending to file
		buffwriter.append(customer.getName());
		buffwriter.append(",");
		buffwriter.append(customer.getEmail());
		buffwriter.append(",");
		buffwriter.append(customer.getAge() + "");
		buffwriter.append(",");
		buffwriter.append(customer.getCustomerID());
		buffwriter.append(",");
		buffwriter.append(customer.getCustomerPass());
		buffwriter.append(",");

		String amount = Double.toString(customer.getAmount());

		buffwriter.append(amount);
		buffwriter.append("\n");
		buffwriter.close();

	}

	void updateTransactionsData() {

	}
}
