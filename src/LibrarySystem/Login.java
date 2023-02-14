package LibrarySystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.mysql.cj.protocol.Resultset;
import java.util.Random;

public class Login extends JFrame implements ActionListener {
	boolean x=false;

	Random rand = new Random();

	int a = rand.nextInt(10);
	int b = rand.nextInt(10);
	String islem = a + "+" + b;
	int islem2 = a + b;

	JLabel label1, label2, label3, label4, label5;
	JTextField textf1, textf2, textf3;
	JPasswordField passf;
	Choice choice1;
	JButton button1, button2, button3, button4;

	private static void setFrameProperties(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 300);
	}

	Login() {
		super("Login Page");
		setLayout(null);
		getContentPane().setBackground(Color.white);

		label1 = new JLabel("School number");
		label1.setBounds(300, 20, 100, 20);
		add(label1);

		label2 = new JLabel("Password");
		label2.setBounds(300, 60, 100, 20);
		add(label2);

		textf1 = new JTextField(15);
		textf1.setBounds(400, 20, 150, 20);
		add(textf1);

		passf = new JPasswordField(15);
		passf.setBounds(400, 60, 150, 20);
		add(passf);

		label3 = new JLabel("Logging in as");
		label3.setBounds(300, 100, 100, 20);
		add(label3);

		ImageIcon ic3 = new ImageIcon("Icons/login-icon.jpg");
		Image i3 = ic3.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon icc3 = new ImageIcon(i3);
		label4 = new JLabel(icc3);
		label4.setBounds(0, 0, 250, 250);
		add(label4);

		String islem = a + "+" + b;
		int islem2 = a + b;

		label5 = new JLabel("Captcha:  " + islem);
		label5.setBounds(360, 200, 100, 20);
		add(label5);
		textf3 = new JTextField(3);
		textf3.setBounds(455, 200, 150, 20);
		add(textf3);

		// in this side we create choose section
		// we determine the authorization to be entered
		choice1 = new Choice();
		choice1.add("Student");
		choice1.add("Librarian");
		choice1.setBounds(400, 100, 150, 20);
		add(choice1);

		// here i created button for login
		button1 = new JButton("Login ");
		button1.setBackground(Color.green);
		button1.setBounds(300, 140, 100, 20);
		add(button1);

		// here i created button for login
		button2 = new JButton("Exit   ");
		button2.setBackground(Color.red);
		button2.setBounds(300, 175, 100, 20);
		add(button2);

		button3 = new JButton("Sign up");
		button3.setBackground(Color.gray);
		button3.setBounds(450, 157, 100, 20);
		add(button3);

		ImageIcon ic2 = new ImageIcon("Icons/verify.png");
		Image i1 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);

		button4 = new JButton("Verify ", new ImageIcon(i1));
		// button4.setBackground(Color.gray);
		button4.setBounds(455, 230, 100, 20);
		add(button4);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		// this code allows to select the size of the frame and make it visible.

		setLayout(new BorderLayout());
		setSize(640, 300);
		setLocation(600, 300);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if (e.getSource() == button4) {
				String a = textf3.getText();
				int b = Integer.parseInt(a);

				if (islem2 == b) {
					JOptionPane.showMessageDialog(null, "verified successfully");
					x=true;
					
					
				} else {
					JOptionPane.showMessageDialog(null, "not succesful to verify YOU ARE A ROBOT");
					this.setVisible(false);
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "somethings is wrong try again later.");
			this.setVisible(false);
		}

		if (e.getSource() == button1) {
			if(x==true) {
				try {
					Connections c = new Connections();
					String a = textf1.getText();
					String b = passf.getText();
					String user = choice1.getSelectedItem();
					String query = "select * from login where school_number='" + a + "' and password='" + b + "' and user='"
							+ user + "'";
					Resultset rs = (Resultset) c.s.executeQuery(query);
					if (((ResultSet) rs).next()) {
						String regnum = ((ResultSet) rs).getString("registration_number");
						new Project(regnum, user).setVisible(true);
						this.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid login");
						textf1.setText("");
						passf.setText("");
					}
				} catch (Exception e1) {
					e1.printStackTrace();

					System.out.println("error: " + e1);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Verify yourself");
			}
			

		} else if (e.getSource() == button2) {
			this.setVisible(false);
		} else if (e.getSource() == button3) {
			this.setVisible(false);

			new Signup().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}