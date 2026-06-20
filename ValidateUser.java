import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ValidateUser {
	Customer customer;
	String clientID;
	String clientPass;

	public ValidateUser() {
		// TODO Auto-generated constructor stub
	}

	public ValidateUser(Customer customer, String clientID, String clientPass) {
		super();
		this.customer = customer;
		this.clientID = clientID;
		this.clientPass = clientPass;
	}

	Customer userAuthenticator() throws IOException {

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		for (int i = 0; i < customerList.size(); i++) {

			if ((customerList.get(i).getCustomerID().contentEquals(clientID))
					&& (customerList.get(i).getCustomerPass().contentEquals(clientPass))) {
				customer = customerList.get(i);

				break;

			}

		}

		return customer;

	}

}
