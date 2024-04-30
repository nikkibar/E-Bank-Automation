package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

//import java.sql.*;
import javax.swing.*;

public class fastCash implements ActionListener {
	
	private JButton hundred, fiveHundred, oneThousand, twoThousand, fiveThousand, tenThousand, back;
	private JLabel l1;
	private long cardNumber;
	private transaction t1;
	
	public fastCash(transaction t1, long card) {
		this.t1 = t1;
		this.cardNumber = card;
		startup();
	}
	
	private void visible() {
		l1.setVisible(false);
		hundred.setVisible(false);
		oneThousand.setVisible(false);
		twoThousand.setVisible(false);
		fiveThousand.setVisible(false);
		tenThousand.setVisible(false);
		back.setVisible(false);
		fiveHundred.setVisible(false);
	}
	
	private void startup() {
		l1 = new JLabel("Please Select Withdraw Amount");
		l1.setForeground(Color.white);
		l1.setFont(new Font("System", Font.BOLD,14));
		l1.setBounds(210,240,230,20);
		t1.atmImage.add(l1);
		
		hundred = new JButton("Rs. 100");
		fiveHundred = new JButton("Rs. 500");
		oneThousand = new JButton("Rs. 1000");
		twoThousand = new JButton("Rs. 2000");
		fiveThousand = new JButton("Rs. 5000");
		tenThousand = new JButton("Rs. 10000");
		back = new JButton("Back");
		
		hundred.setFont(new Font("Raleway",Font.BOLD,12));
		fiveHundred.setFont(new Font("Raleway",Font.BOLD,12));
		oneThousand.setFont(new Font("Raleway",Font.BOLD,12));
		twoThousand.setFont(new Font("Raleway",Font.BOLD,12));
		fiveHundred.setFont(new Font("Raleway",Font.BOLD,12));
		tenThousand.setFont(new Font("Raleway",Font.BOLD,12));
		back.setFont(new Font("Raleway",Font.BOLD,12));
		
		hundred.setBounds(151,324,150,22);
		fiveHundred.setBounds(151,350,150,22);
		oneThousand.setBounds(151,376,150,22);
		twoThousand.setBounds(334,324,150,22);
		fiveThousand.setBounds(334,350,150,22);
		tenThousand.setBounds(334,376,150,22);
		back.setBounds(334,402,150,22);
		
		t1.atmImage.add(hundred);
		t1.atmImage.add(fiveHundred);
		t1.atmImage.add(oneThousand);
		t1.atmImage.add(twoThousand);
		t1.atmImage.add(fiveThousand);
		t1.atmImage.add(tenThousand);
		t1.atmImage.add(back);
		
		hundred.addActionListener(this);
		fiveHundred.addActionListener(this);
		oneThousand.addActionListener(this);
		twoThousand.addActionListener(this);
		fiveThousand.addActionListener(this);
		tenThousand.addActionListener(this);
		back.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			visible();
			t1.invisible();
		} else {
			connection con;
			try {
				con = new connection();
				String amount = ((JButton)e.getSource()).getText().substring(4);
				Date date = new Date();
				
				//Fetch All deposit from Bank
				String query = "SELECT COALESCE(SUM(amount), 0) AS total_amount FROM bank where type = 'Deposit' and cardnumber = '"+cardNumber+"' and status = 'Successful'";
				long deposit = con.fetchAmount(query);
				
				//Fetch WithDrawMoney from Bank
				query = "SELECT COALESCE(SUM(amount), 0) AS total_amount FROM bank where type = 'Withdraw' and cardnumber = '"+cardNumber+"' and status = 'Successful'";
				long withdraw = con.fetchAmount(query);
				
				long balance = deposit-withdraw;
				long request =Long.parseLong(amount);
				if(balance>=request && e.getSource() != back){
					query = "insert into bank values('"+cardNumber+"','"+amount+"','Withdraw','"+date+"','Successful')";
					con.s.executeUpdate(query);
					con.s.close();
					con.c.close();
					JOptionPane.showMessageDialog(null,"Rs. "+amount+"\nDebitted Successfully");					
					t1.invisible();
					visible();
				} else {
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null,"Something Went Wrong Try Again");
				System.exit(0);
			}
		}
	}

}
