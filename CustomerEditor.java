import java.io.IOException;
import java.util.ArrayList;

public class CustomerEditor {

	void deleteCustomer(String customerID) throws IOException {

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(customerID)) {

				customerList.remove(i);
				break;

			}

		}

		filedata.updateClientsData(customerList);

	}

	Customer searchCustomerByID(String customerID) throws IOException {
		Customer target = null;

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(customerID)) {

				target = customerList.get(i);
				break;

			}

		}
		return target;

	}

	void editCustomer(Customer targetCustomer) throws IOException {

		ArrayList<Customer> customerList = new ArrayList();

		Filehandler filedata = new Filehandler();

		filedata.fetchClientsData(customerList);

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getCustomerID().contentEquals(targetCustomer.getCustomerID())) {

				customerList.remove(i);
				customerList.add(targetCustomer);
				break;

			}

		}

		filedata.updateClientsData(customerList);

	}

}
