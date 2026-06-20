
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

public class CustomerLoginPortalFrame extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel imagelabel;
	private Container container;
	private ImageIcon image;
	private JButton loginBtn, cancelBtn;
	private JTextField clientIDTextField;
	private JTextField clientPassTextField;

	public CustomerLoginPortalFrame() {
		getContentPane().setBackground(SystemColor.text);
		initialise();
	}

	public void initialise() {

		this.frame = new JFrame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 150, 419, 530);
		this.setResizable(false);
		this.setTitle("Bank Mangament System");

		Container container = new Container();
		container = this.getContentPane();
		container.setLayout(null);

		loginBtn = new JButton("Login");
		loginBtn.setForeground(new Color(0, 0, 128));
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setBounds(30, 363, 119, 52);
		container.add(loginBtn);

		clientIDTextField = new JTextField();
		clientIDTextField.setBackground(new Color(230, 230, 250));
		clientIDTextField.setBounds(41, 187, 196, 43);
		getContentPane().add(clientIDTextField);
		clientIDTextField.setColumns(10);

		clientPassTextField = new JTextField();
		clientPassTextField.setBackground(new Color(230, 230, 250));
		clientPassTextField.setColumns(10);
		clientPassTextField.setBounds(43, 296, 196, 43);
		getContentPane().add(clientPassTextField);

		cancelBtn = new JButton("Go Back");
		cancelBtn.setForeground(new Color(0, 0, 128));
		cancelBtn.setBackground(new Color(255, 255, 255));
		cancelBtn.setBounds(30, 427, 118, 43);
		getContentPane().add(cancelBtn);

		imagelabel = new JLabel();
		// Image a = new ImageIcon(getClass().getResource("homePage.png"));
		imagelabel.setIcon(new ImageIcon(getClass().getResource("clientLoginPanel.png")));
		Dimension size = imagelabel.getPreferredSize();
		imagelabel.setBounds(-12, 0, 431, 528);
		container.add(imagelabel);

		// container.add(image);

		addActionListener();
	}

	public void addActionListener() {

		loginBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {

			Customer tempCustomer = new Customer();

			String id = clientIDTextField.getText();
			String pass = clientPassTextField.getText();

			ValidateUser validate = new ValidateUser(tempCustomer, id, pass);

			Customer customerSesstion;

			try {
				customerSesstion = validate.userAuthenticator();

				if (customerSesstion == null) {
					JOptionPane.showMessageDialog(null, "Error!");
				} else {

					CustomerPortalFrame cust = new CustomerPortalFrame(customerSesstion);
					cust.setVisible(true);
					this.dispose();

				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.dispose();
			// LoginPortalFrame s;
			// s = new LoginPortalFrame();
			// s.setVisible(true);

		} else if (e.getSource() == cancelBtn) {
			this.dispose();
			HomePageFrame a = new HomePageFrame();

			a.setVisible(true);

		}
	}

	public static void main(String[] args) {

		CustomerLoginPortalFrame s = new CustomerLoginPortalFrame();
		s.setVisible(true);

	}
}
