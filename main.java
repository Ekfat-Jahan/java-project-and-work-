import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {

		Customer CustomerList[];

		Transaction TransactionList[];

		Admin admin = new Admin();

		Filehandler fileHandler = new Filehandler();

		fileHandler.inintialiseAllDataFiles();
		fileHandler.fetchAdminCredentials(admin);

//passing Admin referenec to the file handler and file handler
		// will
		// initialise the admin credentials to the admin object, after that
		// we can use the admin object to do further verification

		HomePageFrame a = new HomePageFrame();
		a.setVisible(true);

	}

	void fetchData() {
	}

	void updata() {

	}

	void update(Customer CustomerList[]) {

	}

	void update(Transaction TransactionList[]) {

	}

}