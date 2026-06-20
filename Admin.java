
public class Admin extends Person {

	public Admin() {

	}

	public Admin(String name, String email, int age) {
		// TODO Auto-generated constructor stub
	}

	private String adminID;
	private String adminPass;

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

}
