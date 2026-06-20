public class Customer extends Person {

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerPass=" + customerPass + ", amount=" + amount + "]";
	}

	private String customerID;
	private String customerPass;
	private double amount=0;

	public Customer(String name, String email, int age, String customerID, String customerPass, double amount) {
		super(name, email, age);
		this.customerID = customerID;
		this.customerPass = customerPass;
		this.amount = amount;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerPass() {
		return customerPass;
	}

	public void setCustomerPass(String customerPass) {
		this.customerPass = customerPass;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
