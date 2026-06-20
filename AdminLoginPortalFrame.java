
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

public class AdminLoginPortalFrame extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel imagelabel;
	private Container container;
	private ImageIcon image;
	private JButton loginBtn, cancelBtn;
	private JTextField adminIDTextField;
	private JTextField adminPassTextField;

	public AdminLoginPortalFrame() throws IOException {
		// fileinitialiser();
		getContentPane().setBackground(SystemColor.text);
		initialise();
	}

//	public void fileinitialiser() throws IOException {
//	
//		
//		File fileDirectory = new File("TextFilesDirectory");
//		System.out.println(fileDirectory.getAbsolutePath());
//

//		if (!fileDirectory.exists()) {
//
//			fileDirectory.mkdir();
//
//			File file = new File(fileDirectory.getAbsolutePath() + "/AdminCredentials.txt");
//			file.createNewFile();
//			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//
//			JOptionPane.showMessageDialog(null, "Admin Password and ID arent Set!", "ADMIN SETUP",
//					JOptionPane.WARNING_MESSAGE);
//			String id = JOptionPane.showInputDialog(null, "Enter Id :", "ADMIN ID", JOptionPane.QUESTION_MESSAGE);
//			String pass = JOptionPane.showInputDialog(null, "Enter password :", "ADMIN Password",
//					JOptionPane.QUESTION_MESSAGE);
//
//			writer.append(id + ',' + pass);
//			writer.close();
//		}
//
//	}

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

		adminIDTextField = new JTextField();
		adminIDTextField.setBackground(new Color(230, 230, 250));
		adminIDTextField.setBounds(41, 187, 196, 43);
		getContentPane().add(adminIDTextField);
		adminIDTextField.setColumns(10);

		adminPassTextField = new JTextField();
		adminPassTextField.setBackground(new Color(230, 230, 250));
		adminPassTextField.setColumns(10);
		adminPassTextField.setBounds(43, 296, 196, 43);
		getContentPane().add(adminPassTextField);

		cancelBtn = new JButton("Go Back");
		cancelBtn.setForeground(new Color(0, 0, 128));
		cancelBtn.setBackground(new Color(255, 255, 255));
		cancelBtn.setBounds(30, 427, 118, 43);
		getContentPane().add(cancelBtn);

		imagelabel = new JLabel();
		// Image a = new ImageIcon(getClass().getResource("homePage.png"));
		imagelabel.setIcon(new ImageIcon(getClass().getResource("adminLoginPanel.png")));
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

			Filehandler file = new Filehandler();
			
			Admin admin = new Admin(); // empty
			

			try {
				file.fetchAdminCredentials(admin);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String adminId = adminIDTextField.getText();
			String adminPass = adminPassTextField.getText();

			if (admin.getAdminID().contentEquals(adminId) && admin.getAdminPass().contains(adminPass)) {

				AdminPortalFrame ad = new AdminPortalFrame();
				ad.setVisible(true);
			//	System.out.println("logged in");

			}
			else {
				
				JOptionPane.showMessageDialog(null, "Password Doesnt match!");
				this.dispose();
				HomePageFrame a = new HomePageFrame();
				a.setVisible(true);
			}


		} else if (e.getSource() == cancelBtn) {
			this.dispose();
			HomePageFrame a = new HomePageFrame();

			a.setVisible(true);

		}
	}

	public static void main(String[] args) throws IOException {

		AdminLoginPortalFrame s = new AdminLoginPortalFrame();
		s.setVisible(true);

	}
}
