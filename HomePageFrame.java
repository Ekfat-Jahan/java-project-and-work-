import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

public class HomePageFrame extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel imagelabel;
	private Container container;
	private ImageIcon image;
	private JButton loginAsAdminBtn, loginAsClientBtn, exitBtn;

	public HomePageFrame() {
		getContentPane().setBackground(SystemColor.text);
		initialise();
	}

	public void initialise() {

		this.frame = new JFrame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 150, 450, 530);
		this.setResizable(false);
		this.setTitle("Bank Mangament System");

		Container container = new Container();
		container = this.getContentPane();
		container.setLayout(null);

		loginAsAdminBtn = new JButton("Admin Login");
		loginAsAdminBtn.setBackground(new Color(224, 255, 255));
		loginAsAdminBtn.setBounds(160, 225, 131, 53);
		container.add(loginAsAdminBtn);

		loginAsClientBtn = new JButton("Client Login");
		loginAsClientBtn.setBackground(new Color(224, 255, 255));
		loginAsClientBtn.setBounds(160, 310, 131, 53);
		container.add(loginAsClientBtn);

		exitBtn = new JButton("Exit");
		exitBtn.setBackground(new Color(224, 255, 255));
		exitBtn.setBounds(160, 392, 131, 53);
		container.add(exitBtn);

		imagelabel = new JLabel();
		// Image a = new ImageIcon(getClass().getResource("homePage.png"));
		imagelabel.setIcon(new ImageIcon(getClass().getResource("homePage.png")));
		Dimension size = imagelabel.getPreferredSize();
		imagelabel.setBounds(0, 0, size.width, size.height);
		container.add(imagelabel);

		// container.add(image);

		addActionListener();
	}

	public void addActionListener() {

		loginAsAdminBtn.addActionListener(this);
		loginAsClientBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == loginAsAdminBtn) {
			
			
			this.dispose();
			
			AdminLoginPortalFrame a;
			try {
				a = new AdminLoginPortalFrame();
				a.setVisible(true);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == loginAsClientBtn) {
			this.dispose();

			CustomerLoginPortalFrame a = new CustomerLoginPortalFrame();
			a.setVisible(true);

		} else if (e.getSource() == exitBtn) {
			System.exit(1);
		}
	}

	public static void main(String[] args) {

		HomePageFrame s = new HomePageFrame();
		s.setVisible(true);

	}

}
