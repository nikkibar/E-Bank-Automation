package bank_management_system;

import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class transaction extends JFrame implements ActionListener {
	
	private JButton deposit, fastCash, pinChange, cashWithdrawl, miniStatement, balanceEnquiry, exit;
	private boolean check; 
	public JLabel atmImage,l1;
//	public JLabel l1;
	public int formno;
	public String pin;
	private long cardnumber;
	
	public transaction(long cardNumber) {
		startUp();
		try {
//			this.formno = rs.getInt(1);
			this.cardnumber = cardNumber;
//			this.pin = rs.getString(3);
		} catch (Exception e) {
			setVisible(false);
			new Login();
		 }
	}
	
	
//	public static void main(String[] args) {
//		new transaction(0);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deposit) {
			new deposit(this, cardnumber, "login");
		} else if(e.getSource() == fastCash) {
			new fastCash(this, cardnumber);
		} else if(e.getSource() == pinChange) {
			new pinChange(this, cardnumber);
		} else if(e.getSource() == cashWithdrawl) {
			new withdrawl(this, cardnumber);
		} else if(e.getSource() == miniStatement) {
			new miniStatement(String.valueOf(cardnumber));
			return;
		} else if(e.getSource() == balanceEnquiry) {
			new balance_enquiry(this, cardnumber);
		} else {
			System.exit(0);
		}
		invisible();
	}
	
	public void invisible() {
		if(!check) {
			l1.setVisible(false);
			deposit.setVisible(false);
			fastCash.setVisible(false);
			pinChange.setVisible(false);
			cashWithdrawl.setVisible(false);
			miniStatement.setVisible(false);
			balanceEnquiry.setVisible(false);
			exit.setVisible(false);
		} else {
			l1.setVisible(true);
			deposit.setVisible(true);
			fastCash.setVisible(true);
			pinChange.setVisible(true);
			cashWithdrawl.setVisible(true);
			miniStatement.setVisible(true);
			balanceEnquiry.setVisible(true);
			exit.setVisible(true);
		}
		
		check = !check;
		
	}
	
	private void startUp() {
    	setLayout(null);
		
		java.net.URL atm = getClass().getResource("atm.jpg");
		ImageIcon i1 = new ImageIcon(atm);
		Image atmImg = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(atmImg);
		atmImage = new JLabel(i1);
		atmImage.setBounds(0, 0, 850, 700);
		add(atmImage);
		
		l1 = new JLabel("Please Select Your Transaction");
		l1.setForeground(Color.white);
		l1.setFont(new Font("System", Font.BOLD,14));
		l1.setBounds(210,240,230,20);
		atmImage.add(l1);
		
		deposit = new JButton("Deposit");
		fastCash = new JButton("Fast Cash");
		pinChange = new JButton("PIN Change");
		cashWithdrawl = new JButton("Cash WIthdrawl");
		miniStatement = new JButton("Mini Statement");
		balanceEnquiry = new JButton("Balance Enquiry");
		exit = new JButton("Exit");
		
		deposit.setFont(new Font("Raleway",Font.BOLD,12));
		fastCash.setFont(new Font("Raleway",Font.BOLD,12));
		pinChange.setFont(new Font("Raleway",Font.BOLD,12));
		cashWithdrawl.setFont(new Font("Raleway",Font.BOLD,12));
		miniStatement.setFont(new Font("Raleway",Font.BOLD,12));
		balanceEnquiry.setFont(new Font("Raleway",Font.BOLD,12));
		exit.setFont(new Font("Raleway",Font.BOLD,12));
		
		deposit.setBounds(151,324,150,22);
		fastCash.setBounds(151,350,150,22);
		pinChange.setBounds(151,376,150,22);
		cashWithdrawl.setBounds(334,324,150,22);
		miniStatement.setBounds(334,350,150,22);
		balanceEnquiry.setBounds(334,376,150,22);
		exit.setBounds(334,402,150,22);
		
		atmImage.add(deposit);
		atmImage.add(fastCash);
		atmImage.add(pinChange);
		atmImage.add(cashWithdrawl);
		atmImage.add(miniStatement);
		atmImage.add(balanceEnquiry);
		atmImage.add(exit);
		
		deposit.addActionListener(this);
		fastCash.addActionListener(this);
		pinChange.addActionListener(this);
		cashWithdrawl.addActionListener(this);
		miniStatement.addActionListener(this);
		balanceEnquiry.addActionListener(this);
		exit.addActionListener(this);
		
		
		setLocation(300,0);
		setSize(800,700);
		setUndecorated(true);
		setVisible(true);
    }
	
//	public static void main(String[] args) {
//		new transaction(0);
//	}

}
