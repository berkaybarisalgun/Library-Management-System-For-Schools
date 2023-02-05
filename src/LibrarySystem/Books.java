package LibrarySystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Books extends JFrame implements ActionListener {

	JTable t1;
	JButton b1;
	String x[] = { "Name", "Writer", "Number of Pages", "Which Year" };
	String y[][] = new String[100][5];
	int i = 0, j = 0;

	Books() {

		super("Book Details");
		setSize(400, 300);
		setLocation(400, 150);

		try {
			Connections c1 = new Connections();
			String s1 = "select * from books";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++] = rs.getString("name");
				y[i][j++] = rs.getString("writer");
				y[i][j++] = rs.getString("number_of_pages");
				y[i][j++] = rs.getString("which_year");

				i++;
				j = 0;
			}
			t1 = new JTable(y, x);

		} catch (Exception e) {
			e.printStackTrace();
		}

		b1 = new JButton("Print");
		add(b1, "South");
		JScrollPane sp = new JScrollPane(t1);
		add(sp);
		b1.addActionListener(this);

	}

	public static void main(String[] args) {
		new Books().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == b1){
            try{
                t1.print();
            }catch(Exception e1){}
        }

	}

}
