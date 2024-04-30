package bank_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	JButton login,clear,signUp;
	JTextField cardNumber;
	JPasswordField pinNumber;
	Login(){
		setTitle("E-Bank Automation");
		setLayout(null);
		
		java.net.URL logo = getClass().getResource("logo.jpg");
		ImageIcon i1 = new ImageIcon(logo);
		Image logoImg = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(logoImg);
		JLabel logoImage = new JLabel(i1);
		logoImage.setBounds(100, 10, 100, 100);
		add(logoImage);
		
		JLabel headText = new JLabel("Welcome to E-Bank");
		headText.setFont(new Font("Osward",Font.BOLD, 38));
		add(headText);
		headText.setBounds(260, 40, 400, 60);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Raleway",Font.BOLD, 28));
		add(cardNo);
		cardNo.setBounds(120, 150, 150, 30);
		
		cardNumber = new JTextField();
		cardNumber.setBounds(300, 150, 230, 30);
		cardNumber.setFont(new Font("Arial",Font.BOLD,14));
		add(cardNumber);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD, 28));
		add(pin);
		pin.setBounds(120, 220, 150, 30);
		
		pinNumber = new JPasswordField();
		pinNumber.setBounds(300, 220, 230, 30);
		pinNumber.setFont(new Font("Arial",Font.BOLD,14));
		add(pinNumber);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 280, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 280, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(300, 330, 230, 30);
		signUp.setBackground(Color.black);
		signUp.setForeground(Color.white);
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.white);
		
		setSize(800,480);
		setVisible(true);
		setLocation(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		new Login();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear) {
			cardNumber.setText("");
			pinNumber.setText("");
		} else if(e.getSource() == login) {
			try {
				connection con = new connection();
				String card = cardNumber.getText();
				@SuppressWarnings("deprecation")
				String pin = pinNumber.getText();
				String query = "Select * from login where cardnumber = '"+card+"' and pin = '"+pin+"'";
				ResultSet rs =  con.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new transaction(Long.parseLong(card));
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter Correct\nCard Number or Pin");
					
				}
			} catch (SQLException e1) {
				System.exit(0);
				e1.printStackTrace();
			}
			
		} else {
			setVisible(false);
			new SignUp_1();
		}
	}

}
