package LibrarySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

public class StudentDetails extends JFrame implements ActionListener {

	JTable t1;
	JButton b1;
	String x[] = { "Student Name", "Registration Number", "Address", "City", "State", "Email", "Phone" };
	String y[][] = new String[40][8];
	int i = 0, j = 0;

	StudentDetails() {
		super("Student Details");

		setSize(1200, 650);
		setLocation(400, 150);

		try {
			Connections c1 = new Connections();
			String s1 = "select * from students";
			Resultset rs = (Resultset) c1.s.executeQuery(s1);

			while (((ResultSet) rs).next()) {
				y[i][j++] = ((ResultSet) rs).getString("name");
				y[i][j++] = ((ResultSet) rs).getString("registration_number");
				y[i][j++] = ((ResultSet) rs).getString("address");
				y[i][j++] = ((ResultSet) rs).getString("city");
				y[i][j++] = ((ResultSet) rs).getString("state");
				y[i][j++] = ((ResultSet) rs).getString("email");
				y[i][j++] = ((ResultSet) rs).getString("phone");
				i++;
				j = 0;
			}
			t1 = new JTable(y, x);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		b1 = new JButton("Print");
		add(b1, "South");
		JScrollPane sp = new JScrollPane(t1);
		add(sp);
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			t1.print();
		} catch (Exception e1) {
		}

	}

	public static void main(String[] args) {
		new StudentDetails().setVisible(true);
	}

}
