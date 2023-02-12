package LibrarySystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class LoanDetails extends JFrame implements ActionListener {
	JTable t1;
	JButton b1, b2;
	JLabel l1, l2;
	Choice c1, c2;
	String x[] = { "Registration Number", "Name of Book", "Borrow Time", "Return Time", "Status" };
	String y[][] = new String[40][8];
	int i = 0, j = 0;

	LoanDetails() {
		super("Loan Details");
		setSize(700, 750);
		setLocation(600, 150);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		l1 = new JLabel("Sort by Registration Number");
		l1.setBounds(10, 20, 170, 20);
		add(l1);

		c1 = new Choice();

		l2 = new JLabel("Sort By Book Name");
		l2.setBounds(380, 20, 140, 20);
		add(l2);

		c2 = new Choice();
		t1 = new JTable(y, x);

		try {
			Connections c = new Connections();
			String s1 = "select * from rental";
			ResultSet rs = c.s.executeQuery(s1);

			t1.setModel(DbUtils.resultSetToTableModel(rs));

			String str2 = "select * from students";

			rs = c.s.executeQuery(str2);

			while (rs.next()) {
				c1.add(rs.getString("registration_number"));
			}
			c1.add("all");
		} catch (Exception e) {
			e.printStackTrace();
		}

		c1.setBounds(180, 20, 150, 20);
		add(c1);
		c2.setBounds(520, 20, 150, 20);

		String choice = "select name_of_book from rental";

		try {
			Connections c = new Connections();
			ResultSet rs = c.s.executeQuery(choice);
			while (rs.next()) {
				c2.add(rs.getString("name_of_book"));
			}
			c2.add("all");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		add(c2);

		b1 = new JButton("Search");
		b1.setBounds(20, 70, 80, 20);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Print");
		b2.setBounds(120, 70, 80, 20);
		b2.addActionListener(this);
		add(b2);

		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(0, 100, 700, 650);
		add(sp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			String str = "";

			try {

				Connections c = new Connections();
				if (c1.getSelectedItem().matches("all") && c2.getSelectedItem().matches("all")) {
					str = "select * from rental";
				} else if (c1.getSelectedItem().equals("all")) {
					str = "select * from rental where name_of_book = '" + c2.getSelectedItem() + "'";
				} else if (c2.getSelectedItem().equals("all")) {
					str = "select * from rental where registration_number = '" + c1.getSelectedItem() + "'";
				} else {
					str = "select * from rental where registration_number = '" + c1.getSelectedItem()
							+ "' AND name_of_book = '" + c2.getSelectedItem() + "'";

				}
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == b2) {
			try {
				t1.print();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new LoanDetails().setVisible(true);
	}

}