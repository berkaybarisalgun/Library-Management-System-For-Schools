package LibrarySystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import java.time.LocalDate;

public class Borrow extends JFrame implements ActionListener {
	LocalDate currentDate = LocalDate.now();

	JLabel l1;
	JTextField t1;
	JButton b1, b2;
	String registration_number;
	String regnum = "";

	Borrow(String regisration_number) {
		super("Borrow a book");
		this.registration_number = registration_number;
		regnum = regisration_number;
		setSize(600, 400);
		setLocation(600, 200);

		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBackground(new Color(173, 216, 230));

		JLabel title = new JLabel("Borrow a book");
		title.setBounds(180, 10, 200, 26);
		title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(title);

		l1 = new JLabel("Book name");
		l1.setBounds(100, 80, 100, 20);

		t1 = new JTextField();
		t1.setBounds(240, 80, 200, 20);
		p.add(l1);
		p.add(t1);

		b1 = new JButton("Borrow");
		b1.setBounds(180, 150, 100, 25);
		b2 = new JButton("Cancel");
		b2.setBounds(310, 150, 100, 25);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		p.add(b1);
		p.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new BorderLayout());

		add(p, "Center");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			try {
				String name = t1.getText();

				String book_name = "select name from books where name LIKE '%" + name + "%'";

				Connections c1 = new Connections();
				String deger = "";
				Resultset rs = (Resultset) c1.s.executeQuery(book_name);

				if (((ResultSet) rs).next()) {
					deger = ((ResultSet) rs).getString("name");
				}

				String q1 = "insert into rental values('" + regnum + "','" + deger + "','" + currentDate + "','"
						+ currentDate.plusDays(30) + "','" + "not yet" + "')";

				c1.s.executeUpdate(q1);

				JOptionPane.showMessageDialog(null, "Book successfully borrowed");
				this.setVisible(false);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else if (e.getSource() == b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Borrow("ala").setVisible(true);
	}
}