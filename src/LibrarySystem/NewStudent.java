package LibrarySystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewStudent extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l11;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JButton b1, b2;

	NewStudent() {

		super("New Student");
		setLocation(600, 200);
		setSize(700, 500);

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.white);

		JLabel title = new JLabel("New Student");
		title.setBounds(180, 10, 200, 26);
		title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(title);

		l1 = new JLabel("Student Name");
		l1.setBounds(100, 80, 100, 20);

		t1 = new JTextField();
		t1.setBounds(240, 80, 200, 20);
		p.add(l1);
		p.add(t1);

		l2 = new JLabel("Registration No");
		l2.setBounds(100, 120, 100, 20);
		l11 = new JLabel();
		l11.setBounds(240, 120, 200, 20);
		p.add(l2);
		p.add(l11);

		l3 = new JLabel("Address");
		l3.setBounds(100, 160, 100, 20);
		t3 = new JTextField();
		t3.setBounds(240, 160, 200, 20);
		p.add(l3);
		p.add(t3);

		l5 = new JLabel("City");
		l5.setBounds(100, 200, 100, 20);
		t5 = new JTextField();
		t5.setBounds(240, 200, 200, 20);
		p.add(l5);
		p.add(t5);

		l4 = new JLabel("State");
		l4.setBounds(100, 240, 100, 20);
		t4 = new JTextField();
		t4.setBounds(240, 240, 200, 20);
		p.add(l4);
		p.add(t4);

		l6 = new JLabel("Email");
		l6.setBounds(100, 280, 100, 20);
		t6 = new JTextField();
		t6.setBounds(240, 280, 200, 20);
		p.add(l6);
		p.add(t6);
		l7 = new JLabel("Phone Number");
		l7.setBounds(100, 320, 100, 20);
		t7 = new JTextField();
		t7.setBounds(240, 320, 200, 20);
		p.add(l7);
		p.add(t7);

		b1 = new JButton("Next");
		b1.setBounds(120, 390, 100, 25);
		b2 = new JButton("Cancel");
		b2.setBounds(250, 390, 100, 25);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.green);

		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.red);

		p.add(b1);
		p.add(b2);

		setLayout(new BorderLayout());
		add(p, "Center");

		ImageIcon ic1 = new ImageIcon("Icons/hicon1.jpg");
		Image i3 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon ic2 = new ImageIcon(i3);
		l8 = new JLabel(ic2);

		add(l8, "West");

		getContentPane().setBackground(Color.white);

		b1.addActionListener(this);
		b2.addActionListener(this);

		Random ran = new Random();
		int first = ran.nextInt(10000);
		l11.setText("" + first);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String name = t1.getText();
			String registration_number = l11.getText();
			String address = t3.getText();
			String state = t4.getText();
			String city = t5.getText();
			String email = t6.getText();
			String phone = t7.getText();

			String q1 = "insert into students values('" + name + "','" + registration_number + "','" + address + "','"
					+ city + "','" + state + "','" + email + "','" + phone + "')";
			String q2 = "insert into login values('" + registration_number + "', '', '', '', '')";
			try {
				Connections c1 = new Connections();
				c1.s.executeUpdate(q1);
				c1.s.executeUpdate(q2);
				JOptionPane.showMessageDialog(null, "Student Details Added Successfully");
				this.setVisible(false);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == b2) {
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new NewStudent().setVisible(true);
	}

}
