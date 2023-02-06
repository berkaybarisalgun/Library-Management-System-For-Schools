package LibrarySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
	Connection con;
	Statement s;

	public Connections() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///slms", "root", "admin");
			s = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}