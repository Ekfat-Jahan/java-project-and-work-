
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

public class AdminPortalFrame extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel imagelabel;
	private Container container;
	private ImageIcon image;
	private JButton addClientBtn, exitBtn;
	private JButton editClientBtn;
	private JButton deleteClientBtn;
	private JButton viewTransactionBtn;
	private Customer customer;

	public AdminPortalFrame(Customer customer) {
		this.customer = customer;
		getContentPane().setBackground(SystemColor.text);
		initialise();
	}

	public AdminPortalFrame() {
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

		addClientBtn = new JButton("Register Client");
		addClientBtn.setForeground(new Color(240, 255, 255));
		addClientBtn.setBackground(new Color(32, 178, 170));
		addClientBtn.setBounds(142, 77, 162, 53);
		container.add(addClientBtn);

		exitBtn = new JButton("Go Back");
		exitBtn.setForeground(new Color(240, 255, 255));
		exitBtn.setBackground(new Color(32, 178, 170));
		exitBtn.setBounds(142, 371, 162, 53);
		container.add(exitBtn);

		editClientBtn = new JButton("Edit Client");
		editClientBtn.setForeground(new Color(240, 255, 255));
		editClientBtn.setBackground(new Color(32, 178, 170));
		editClientBtn.setBounds(114, 146, 210, 53);
		getContentPane().add(editClientBtn);

		deleteClientBtn = new JButton("Delete Client");
		deleteClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		deleteClientBtn.setForeground(new Color(240, 255, 255));
		deleteClientBtn.setBackground(new Color(32, 178, 170));
		deleteClientBtn.setBounds(143, 221, 161, 53);
		getContentPane().add(deleteClientBtn);

		viewTransactionBtn = new JButton("View Transactions");
		viewTransactionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		viewTransactionBtn.setForeground(new Color(240, 255, 255));
		viewTransactionBtn.setBackground(new Color(32, 178, 170));
		viewTransactionBtn.setBounds(114, 288, 210, 53);
		getContentPane().add(viewTransactionBtn);

		imagelabel = new JLabel();
		imagelabel.setFont(new Font("Dialog", Font.BOLD, 24));
		imagelabel.setForeground(new Color(240, 255, 255));
		imagelabel.setBackground(new Color(32, 178, 170));
		imagelabel.setIcon(new ImageIcon(getClass().getResource("adminPortal.png")));
		Dimension size = imagelabel.getPreferredSize();
		imagelabel.setBounds(0, -33, 450, 528);
		container.add(imagelabel);

		// container.add(image);

		addActionListener();
	}

	public void addActionListener() {

		addClientBtn.addActionListener(this);
		editClientBtn.addActionListener(this);
		viewTransactionBtn.addActionListener(this);
		deleteClientBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addClientBtn) {
			RegisterCustomerFrame a = new RegisterCustomerFrame();
			a.setVisible(true);
			this.dispose();

		}

		else if (e.getSource() == editClientBtn) {

			CustomerEditor editor = new CustomerEditor();

			Customer target;

			String clientID = JOptionPane.showInputDialog(null, "Enter Client ID to Edit :", "Customer Editor",
					JOptionPane.QUESTION_MESSAGE);

			try {
				target = editor.searchCustomerByID(clientID);
				if (target == null) {
					JOptionPane.showMessageDialog(null, "No client found");
				} else {

					String email = JOptionPane.showInputDialog(null, "Enter new Email :", "Customer Editor",
							JOptionPane.QUESTION_MESSAGE);
					String name = JOptionPane.showInputDialog(null, "Enter new Name :", "Customer Editor",
							JOptionPane.QUESTION_MESSAGE);
					String age = JOptionPane.showInputDialog(null, "Enter new Age :", "Customer Editor",
							JOptionPane.QUESTION_MESSAGE);

					int parsedAge = Integer.parseInt(age);

					target.setEmail(email);
					target.setName(name);
					target.setAge(parsedAge);

					editor.editCustomer(target);

					JOptionPane.showMessageDialog(null, "Customer successfully edited");

				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == deleteClientBtn) {

			CustomerEditor editor = new CustomerEditor();

			Customer target;

			String clientID = JOptionPane.showInputDialog(null, "Enter Client ID to Edit :", "Customer Editor",
					JOptionPane.QUESTION_MESSAGE);

			try {
				target = editor.searchCustomerByID(clientID);
				if (target == null) {
					JOptionPane.showMessageDialog(null, "No client found");
				} else {
					editor.deleteCustomer(clientID);
					JOptionPane.showMessageDialog(null, "Customer Deleted successfully");

				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == exitBtn) {

			AdminLoginPortalFrame a;
			try {
				a = new AdminLoginPortalFrame();
				a.setVisible(true);
				this.dispose();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws IOException {

		AdminPortalFrame s = new AdminPortalFrame();
		s.setVisible(true);

	}
}
