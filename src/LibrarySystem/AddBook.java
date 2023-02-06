package LibrarySystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBook extends JFrame implements ActionListener {

	JTextField t1, t2, t3, t4;
	JLabel l11, l12;
	JButton b1, b2;

	AddBook() {
		setBounds(500, 220, 850, 400);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel title = new JLabel("Add Book");
		title.setBounds(110, 0, 400, 30);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(title);

		JLabel l3 = new JLabel("Name");
		l3.setBounds(30, 60, 100, 20);
		add(l3);

		t1 = new JTextField();
		t1.setBounds(230, 60, 200, 20);
		add(t1);

		JLabel l4 = new JLabel("Writer");
		l4.setBounds(30, 110, 100, 20);
		add(l4);

		t2 = new JTextField();
		t2.setBounds(230, 110, 200, 20);
		add(t2);

		JLabel l5 = new JLabel("Number Of Pages");
		l5.setBounds(30, 160, 100, 20);
		add(l5);

		t3 = new JTextField();
		t3.setBounds(230, 160, 200, 20);
		add(t3);

		JLabel l6 = new JLabel("Which Year");
		l6.setBounds(30, 210, 100, 20);
		add(l6);

		t4 = new JTextField();
		t4.setBounds(230, 210, 200, 20);
		add(t4);

		b1 = new JButton("Update");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70, 280, 100, 25);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(230, 280, 100, 25);
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon("Icons/add-book.png");
		Image i2 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l8 = new JLabel(i3);
		l8.setBounds(450, 50, 400, 300);
		add(l8);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			String s3 = t1.getText();
			String s4 = t2.getText();
			String s5 = t3.getText();
			String s6 = t4.getText();

			try {
				Connections c = new Connections();				
				c.s.executeUpdate("INSERT INTO books VALUES ('" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "')");
				JOptionPane.showMessageDialog(null, "Book added succesfully");
				this.setVisible(false);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ae.getSource() == b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddBook().setVisible(true);
	}
}