package LibrarySystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Project extends JFrame implements ActionListener {

	String registration_number;

	Project(String registration_number, String person) {
		super("Library Management Systems");
		this.registration_number = registration_number;
		setSize(1024, 576);
		setLocation(500, 200);

		/* Adding background image */
		ImageIcon ic = new ImageIcon("Icons/library2.2.jpg");
		Image i3 = ic.getImage().getScaledInstance(1024, 576, Image.SCALE_DEFAULT);
		ImageIcon icc3 = new ImageIcon(i3);
		JLabel l1 = new JLabel(icc3);
		add(l1);

		/* First Column */
		JMenuBar mb = new JMenuBar();
		JMenu master = new JMenu("Master");
		JMenuItem m1 = new JMenuItem("New Student");
		JMenuItem m2 = new JMenuItem("Student Details");
		JMenuItem m3 = new JMenuItem("Rental Details");

		master.setForeground(Color.BLUE);

		/* ---- Student Details ---- */
		m1.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon icon1 = new ImageIcon("Icons/icon1.png");
		Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m1.setIcon(new ImageIcon(image1));
		m1.setBackground(Color.WHITE);

		/* ---- Rental Details ---- */
		m2.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon icon2 = new ImageIcon("Icons/icon2.png");
		Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m2.setIcon(new ImageIcon(image2));
		m2.setBackground(Color.WHITE);

		/* ---- Deposit Details ----- */
		m3.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon icon3 = new ImageIcon("Icons/icon3.png");
		Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m3.setIcon(new ImageIcon(image3));
		m3.setBackground(Color.WHITE);

		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);

		/* Second Column */
		JMenu info = new JMenu("Information");
		JMenuItem info1 = new JMenuItem("Update Information");
		JMenuItem info2 = new JMenuItem("View Information");

		info.setForeground(Color.RED);

		/* ---- Pay Bill ---- */
		info1.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon icon41 = new ImageIcon("Icons/icon4.png");
		Image image41 = icon41.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		info1.setIcon(new ImageIcon(image41));
		info1.setBackground(Color.WHITE);

		/* ---- Last Bill ---- */
		info2.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon icon42 = new ImageIcon("Icons/icon6.png");
		Image image42 = icon42.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		info2.setIcon(new ImageIcon(image42));
		info2.setBackground(Color.WHITE);

		info1.addActionListener(this);
		info2.addActionListener(this);

		/* Fourth Column */
		JMenu utility = new JMenu("Library");
		JMenuItem ut1 = new JMenuItem("Books");
		JMenuItem ut2 = new JMenuItem("Add Book");
		JMenuItem ut3 = new JMenuItem("Borrow");

		utility.setForeground(Color.GRAY);

		ut1.addActionListener(this);
		ut2.addActionListener(this);
		ut3.addActionListener(this);

		/* Fifth Column */
		JMenu exit = new JMenu("Logout");
		JMenuItem ex = new JMenuItem("Logout");
		exit.setForeground(Color.BLUE);

		/* ---- Exit ---- */
		ex.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon icon11 = new ImageIcon("Icons/icon11.png");
		Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ex.setIcon(new ImageIcon(image11));
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);

		master.add(m1);
		master.add(m2);
		master.add(m3);

		info.add(info1);
		info.add(info2);

		utility.add(ut1);
		utility.add(ut2);
		utility.add(ut3);

		exit.add(ex);

		if (person.equals("Librarian")) {
			mb.add(master);
		} else {
			mb.add(info);

		}
		mb.add(utility);
		mb.add(exit);

		setJMenuBar(mb);

		setFont(new Font("Senserif", Font.BOLD, 16));
		setLayout(new FlowLayout());
		setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if (msg.equals("Student Details")) {
			new StudentDetails().setVisible(true);
		} else if (msg.equals("New Student")) {
			new NewStudent().setVisible(true);

		} else if (msg.equals("Logout")) {
			this.setVisible(false);
			new Login().setVisible(true);
		}

		else if (msg.equals("Rental Details")) {
			new LoanDetails().setVisible(true);
		} else if (msg.equals("View Information")) {
			new ViewInformation(registration_number).setVisible(true);
		} else if (msg.equals("Update Information")) {
			new UpdateInformation(registration_number).setVisible(true);
		} else if (msg.equals("Borrow")) {

			new Borrow(registration_number).setVisible(true);
		}

		else if (msg.equals("Books")) {

			new Books().setVisible(true);
		} else if (msg.equals("Add Book")) {
			new AddBook().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new Project("", "").setVisible(true);
	}

}
