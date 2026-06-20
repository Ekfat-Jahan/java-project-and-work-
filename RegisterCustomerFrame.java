
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextPane;

public class RegisterCustomerFrame extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel imagelabel;
	private Container container;
	private ImageIcon image;
	private JButton exitBtn, submitBtn;
	private JTextField emailField;
	private JTextField clientIdField;
	private JTextField ageField;
	private JTextField nameField;
	private JTextField initalAmountField;
	private JTextField passwordField;
	private Customer customer;

	public RegisterCustomerFrame() {
		getContentPane().setBackground(SystemColor.text);
		initialise();
	}

	public RegisterCustomerFrame(Customer customer) {
		this.customer = customer;
		getContentPane().setBackground(SystemColor.text);
		initialise();
	}

	public void initialise() {

		this.frame = new JFrame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 150, 424, 530);
		this.setResizable(false);
		this.setTitle("Bank Mangament System");

		Container container = new Container();
		container = this.getContentPane();
		container.setLayout(null);

		exitBtn = new JButton("Go Back");
		exitBtn.setForeground(Color.BLUE);
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setBounds(33, 405, 121, 53);
		container.add(exitBtn);

		emailField = new JTextField();
		emailField.setBackground(new Color(211, 211, 211));
		emailField.setBounds(180, 181, 169, 35);
		getContentPane().add(emailField);
		emailField.setColumns(10);

		clientIdField = new JTextField();
		clientIdField.setColumns(10);
		clientIdField.setBackground(new Color(211, 211, 211));
		clientIdField.setBounds(180, 58, 169, 35);
		getContentPane().add(clientIdField);

		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBackground(new Color(211, 211, 211));
		ageField.setBounds(180, 236, 169, 35);
		getContentPane().add(ageField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBackground(new Color(211, 211, 211));
		nameField.setBounds(180, 123, 169, 35);
		getContentPane().add(nameField);

		initalAmountField = new JTextField();
		initalAmountField.setColumns(10);
		initalAmountField.setBackground(new Color(211, 211, 211));
		initalAmountField.setBounds(180, 353, 169, 35);
		getContentPane().add(initalAmountField);

		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(211, 211, 211));
		passwordField.setBounds(180, 297, 169, 35);
		getContentPane().add(passwordField);

		submitBtn = new JButton("Submit");
		submitBtn.setForeground(Color.BLUE);
		submitBtn.setBackground(Color.WHITE);
		submitBtn.setBounds(254, 405, 121, 53);
		getContentPane().add(submitBtn);

		imagelabel = new JLabel();
		imagelabel.setFont(new Font("Dialog", Font.BOLD, 24));
		imagelabel.setForeground(new Color(240, 255, 255));
		imagelabel.setBackground(new Color(32, 178, 170));
		// Image a = new ImageIcon(getClass().getResource("homePage.png"));
		imagelabel.setIcon(new ImageIcon(getClass().getResource("clientRegistrationForm.png")));
		Dimension size = imagelabel.getPreferredSize();
		imagelabel.setBounds(0, -33, 450, 528);
		container.add(imagelabel);

		// container.add(image);

		addActionListener();
	}

	public void addActionListener() {
		exitBtn.addActionListener(this);
		submitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exitBtn) {
			AdminPortalFrame a = new AdminPortalFrame();
			a.setVisible(true);
			this.dispose();
		} else if (e.getSource() == submitBtn) {

			String name = nameField.getText();
			String email = emailField.getText();
			double amount = Double.parseDouble(initalAmountField.getText());
			String customerPass = passwordField.getText();
			int age = Integer.parseInt(ageField.getText());
			String customerID = clientIdField.getText();

			customer = new Customer(name, email, age, customerID, customerPass, amount);

			Filehandler reg = new Filehandler();
			try {
				reg.addClientDataToFile(customer);

				JOptionPane.showMessageDialog(null, "Data SuccessFully Registered!");
				AdminPortalFrame a = new AdminPortalFrame();
				a.setVisible(true);
				this.dispose();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {

		RegisterCustomerFrame s = new RegisterCustomerFrame();
		s.setVisible(true);

	}
}
