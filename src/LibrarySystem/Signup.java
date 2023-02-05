package LibrarySystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Signup extends JFrame implements ActionListener {

	JPanel p1;
	JTextField t1, t2, t3, t4;
	Choice c1;
	JButton b1, b2;

	Signup() {
		setBounds(600, 250, 700, 400);

		p1 = new JPanel();
		p1.setBounds(30, 30, 650, 300);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		p1.setForeground(Color.black);
		p1.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Create-Account", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(173, 216, 230)));
		add(p1);

		JLabel l1 = new JLabel("School Number");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Serif", Font.BOLD, 16));
		l1.setBounds(80, 50, 120, 20);
		p1.add(l1);

		JLabel l2 = new JLabel("Name");
		l2.setForeground(Color.DARK_GRAY);
		l2.setFont(new Font("Serif", Font.BOLD, 15));
		l2.setBounds(80, 90, 100, 20);
		p1.add(l2);

		JLabel l3 = new JLabel("Password");
		l3.setForeground(Color.DARK_GRAY);
		l3.setFont(new Font("Serif", Font.BOLD, 15));
		l3.setBounds(80, 130, 100, 20);
		p1.add(l3);

		JLabel l4 = new JLabel("Create Account As");
		l4.setForeground(Color.DARK_GRAY);
		l4.setFont(new Font("Serif", Font.BOLD, 15));
		l4.setBounds(80, 170, 125, 20);
		p1.add(l4);

		JLabel l5 = new JLabel("Registration Number");
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Serif", Font.BOLD, 15));
		l5.setBounds(80, 210, 140, 20);
		l5.setVisible(false);
		p1.add(l5);

		t1 = new JTextField();
		t1.setBounds(220, 50, 120, 20);
		p1.add(t1);

		t2 = new JTextField();
		t2.setBounds(220, 90, 120, 20);
		p1.add(t2);

		t3 = new JTextField();
		t3.setBounds(220, 130, 120, 20);
		p1.add(t3);

		t4 = new JTextField();
		t4.setBounds(220, 210, 120, 20);
		t4.setVisible(false);
		p1.add(t4);

		c1 = new Choice();
		c1.add("Librarian");
		c1.add("Student");
		c1.setBounds(220, 170, 150, 20);
		p1.add(c1);

		b1 = new JButton("Create");
		b1.setBackground(Color.darkGray);
		b1.setForeground(Color.green);
		b1.setBounds(140, 290, 120, 30);
		b1.addActionListener(this);
		p1.add(b1);

		b2 = new JButton("Back");
		b2.setBackground(Color.DARK_GRAY);
		b2.setForeground(Color.red);
		b2.setBounds(300, 290, 120, 30);
		b2.addActionListener(this);
		p1.add(b2);

		ImageIcon i1 = new ImageIcon("Icons/signupicon.png");
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(400, 30, 250, 250);
		p1.add(l6);

		c1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				String user = c1.getSelectedItem();
				if (user.equals("Student")) {
					l5.setVisible(true);
					t4.setVisible(true);
				} else {
					l5.setVisible(false);
					t4.setVisible(false);
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String school_number = t1.getText();
			String name = t2.getText();
			String password = t3.getText();
			String user = c1.getSelectedItem();
			String registration_number = t4.getText();
			try {
				Connections c = new Connections();
				String str = null;
				if (user.equals("Librarian")) {
					str = "insert into login values('" + registration_number + "', '" + school_number + "', '" + name
							+ "', '" + password + "', '" + user + "')";
				} else {
					str = "update login set school_number = '" + school_number + "', name = '" + name
							+ "', password = '" + password + "', user = '" + user + "' where registration_number = '"
							+ t4.getText() + "'";
				}

				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				this.setVisible(false);
				new Login().setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == b2) {
			this.setVisible(false);
			new Login().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new Signup().setVisible(true);
	}

}
