
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
import javax.swing.SwingConstants;

public class CustomerPortalFrame extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel imagelabel;
	private Container container;
	private ImageIcon image;
	private JButton addAmountBtn, exitBtn;
	private JButton sendMoneyBtn;
	private JButton withdrawBtn;
	private JButton viewTransactionBtn;
	private JTextPane txtpnClientId;
	private JTextField clientNameTextField;
	private JTextField amountTextField;
	private Customer customer;

	public CustomerPortalFrame(Customer customer) {
		this.customer = customer;

		getContentPane().setBackground(SystemColor.text);
		initialise();

		System.out.println("from customer portal : \n" + customer);
	}

	public CustomerPortalFrame() {
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

		addAmountBtn = new JButton("Add Amount");
		addAmountBtn.setForeground(new Color(240, 255, 255));
		addAmountBtn.setBackground(new Color(32, 178, 170));
		addAmountBtn.setBounds(142, 213, 131, 53);
		container.add(addAmountBtn);

		exitBtn = new JButton("Go Back");
		exitBtn.setForeground(new Color(240, 255, 255));
		exitBtn.setBackground(new Color(32, 178, 170));
		exitBtn.setBounds(142, 428, 131, 53);
		container.add(exitBtn);

		sendMoneyBtn = new JButton("Send Amount");
		sendMoneyBtn.setForeground(new Color(240, 255, 255));
		sendMoneyBtn.setBackground(new Color(32, 178, 170));
		sendMoneyBtn.setBounds(221, 298, 152, 53);
		getContentPane().add(sendMoneyBtn);

		withdrawBtn = new JButton("Withdraw Amount");
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		withdrawBtn.setForeground(new Color(240, 255, 255));
		withdrawBtn.setBackground(new Color(32, 178, 170));
		withdrawBtn.setBounds(36, 298, 161, 53);
		getContentPane().add(withdrawBtn);

		viewTransactionBtn = new JButton("View Transactions");
		viewTransactionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		viewTransactionBtn.setForeground(new Color(240, 255, 255));
		viewTransactionBtn.setBackground(new Color(32, 178, 170));
		viewTransactionBtn.setBounds(106, 363, 210, 53);
		getContentPane().add(viewTransactionBtn);

		JTextPane txtpnCurrentAmount = new JTextPane();
		txtpnCurrentAmount.setFont(new Font("Dialog", Font.BOLD, 18));
		txtpnCurrentAmount.setText("Client Name : ");
		txtpnCurrentAmount.setBounds(22, 84, 169, 35);
		getContentPane().add(txtpnCurrentAmount);

		txtpnClientId = new JTextPane();
		txtpnClientId.setText("Current Amount: ");
		txtpnClientId.setFont(new Font("Dialog", Font.BOLD, 18));
		txtpnClientId.setBounds(22, 131, 188, 35);
		getContentPane().add(txtpnClientId);

		clientNameTextField = new JTextField(customer.getName());
		clientNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		clientNameTextField.setBackground(new Color(211, 211, 211));
		clientNameTextField.setBounds(243, 84, 130, 35);
		getContentPane().add(clientNameTextField);
		clientNameTextField.setColumns(10);

		amountTextField = new JTextField(customer.getAmount() + "");
		amountTextField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTextField.setColumns(10);
		amountTextField.setBackground(new Color(211, 211, 211));
		amountTextField.setBounds(243, 131, 131, 35);
		getContentPane().add(amountTextField);

		imagelabel = new JLabel();
		imagelabel.setFont(new Font("Dialog", Font.BOLD, 24));
		imagelabel.setForeground(new Color(240, 255, 255));
		imagelabel.setBackground(new Color(32, 178, 170));
		// Image a = new ImageIcon(getClass().getResource("homePage.png"));
		imagelabel.setIcon(new ImageIcon(getClass().getResource("userPortal.png")));
		Dimension size = imagelabel.getPreferredSize();
		imagelabel.setBounds(0, -33, 450, 528);
		container.add(imagelabel);

		// container.add(image);

		addActionListener();
	}

	public void addActionListener() {

		addAmountBtn.addActionListener(this);
		sendMoneyBtn.addActionListener(this);
		viewTransactionBtn.addActionListener(this);
		withdrawBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addAmountBtn) {

			String amount = JOptionPane.showInputDialog(null, "Enter amount :", "ADD MONEY",
					JOptionPane.QUESTION_MESSAGE);

			/**
			 * 
			 * later we will check client id not available exception amount is less then 0
			 * exception
			 **/

			String password = JOptionPane.showInputDialog(null, "Enter password", "ADD MONEY",
					JOptionPane.QUESTION_MESSAGE);
			
			System.out.println("password from input : "+password);
			System.out.println("password from session : "+customer.getCustomerPass());

			if (password.contentEquals(customer.getCustomerPass())) {
				double money = Double.parseDouble(amount);

				try {

					Transaction transaction = new Transaction();

					System.out.println();
					transaction.addAmount(money, customer);

					this.dispose();
					CustomerPortalFrame a = new CustomerPortalFrame(customer);
					a.setVisible(true);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {

				JOptionPane.showMessageDialog(null, "password doesnt matched!");
			}

		}
//		
//		else if (e.getSource() == sendMoneyBtn &&( customer.getAmount() < 0|| customer)) {
//
//	     JOptionPane.showMessageDialog(null,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);     
//
//
//		} 
		else if (e.getSource() == sendMoneyBtn) {

			String amount = JOptionPane.showInputDialog(null, "Enter amount :", "SEND MONEY",
					JOptionPane.QUESTION_MESSAGE);

			String clientID = JOptionPane.showInputDialog(null, "Enter Client ID :", "SEND MONEY",
					JOptionPane.QUESTION_MESSAGE);
			/**
			 * 
			 * later we will check client id not available exception amount is less then 0
			 * exception
			 **/

			String password = JOptionPane.showInputDialog(null, "Enter password", "SEND MONEY",
					JOptionPane.QUESTION_MESSAGE);

			if (password.contentEquals(customer.getCustomerPass())) {
				double money = Double.parseDouble(amount);

				Transaction transaction = new Transaction();
				try {

					transaction.sendAmount(money, customer, clientID);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			else {

				JOptionPane.showMessageDialog(null, "password doesnt matched!");
			}

		}

		else if (e.getSource() == withdrawBtn) {

			String amount = JOptionPane.showInputDialog(null, "Enter amount :", "WITHDRAW MONEY",
					JOptionPane.QUESTION_MESSAGE);

			/**
			 * 
			 * later we will check client id not available exception amount is less then 0
			 * exception
			 **/

			String password = JOptionPane.showInputDialog(null, "Enter password", "WITHDRAW MONEY",
					JOptionPane.QUESTION_MESSAGE);

			if (password.contentEquals(customer.getCustomerPass())) {
				double money = Double.parseDouble(amount);

				Transaction transaction = new Transaction();
				try {

					transaction.withdrawAmount(money, customer);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			else {

				JOptionPane.showMessageDialog(null, "password doesnt matched!");
			}

		}

		// else if (e.getSource() == addAmountBtn) {}

		else if (e.getSource() == exitBtn) {
			CustomerLoginPortalFrame a = new CustomerLoginPortalFrame();
			a.setVisible(true);
			this.dispose();

		}
	}

	public static void main(String[] args) {

		CustomerPortalFrame s = new CustomerPortalFrame();
		s.setVisible(true);

	}
}
