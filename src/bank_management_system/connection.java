package bank_management_system;

import java.sql.*;

import javax.swing.JOptionPane;



public class connection {
	Connection c;
	Statement s;
	PreparedStatement ps;
	public connection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","root");
//			c = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6683886","sql6683886","A4F5VtbeCu");
			s = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public long fetchAmount(String query){
		long n =0;
		try {
			ResultSet rs = null;
			rs = s.executeQuery(query);
			if(rs.next()) {
				n = rs.getLong(1);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Something Went Wrong Try Again");
			e.printStackTrace();
			System.exit(0);
		} 
		return n;
	}
}
