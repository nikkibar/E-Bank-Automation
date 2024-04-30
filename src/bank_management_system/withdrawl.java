package bank_management_system;

import java.awt.*;
import java.awt.event.*;
//import java.sql.ResultSet;

//import java.sql.*;
import javax.swing.*;

//import com.mysql.cj.protocol.Resultset;

import java.util.Date;

public class withdrawl implements ActionListener {

	private JTextField withdrawField;
	private JLabel l1;
	private JButton withdraw, back;
	private long cardNumber;
	private transaction t1;
	
	public withdrawl(transaction t1, long card) {
		this.t1 = t1;
		this.cardNumber = card;
		
		l1 = new JLabel("Entert the Amount you want to Withdraw");
		l1.setForeground(Color.white);
		l1.setFont(new Font("System", Font.BOLD,14));
		l1.setBounds(180,240,280,20);
		t1.atmImage.add(l1);

		withdrawField = new JTextField();
		withdrawField.setBounds(190, 270, 260, 20);
		withdrawField.setFont(new Font("Raleway",Font.BOLD, 14));
		t1.atmImage.add(withdrawField);
		
		withdraw = new JButton("Withdraw");
		back = new JButton("Back");
		
		withdraw.setFont(new Font("Raleway",Font.BOLD,12));
		back.setFont(new Font("Raleway",Font.BOLD,12));
		
		
		withdraw.setBounds(334,376,150,22);
		back.setBounds(334,402,150,22);
		
		t1.atmImage.add(withdraw);
		t1.atmImage.add(back);
		
		withdraw.addActionListener(this);
		back.addActionListener(this);
	}

	 public void invisible() {
	    	l1.setVisible(false);
	    	withdraw.setVisible(false);
	    	back.setVisible(false);
	    	withdrawField.setVisible(false);
	 }
	 
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			t1.invisible();
			invisible();
		} else if(!withdrawField.getText().isEmpty()){
			if(Integer.parseInt(withdrawField.getText()) > 0 && Integer.parseInt(withdrawField.getText()) <= 10000) {
				
				connection con;
				try {
					con = new connection();
					String amount = withdrawField.getText();
					Date date = new Date();
					
					//Fetch All deposit Money from Bank
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
						JOptionPane.showMessageDialog(null,"Rs. "+amount+"\nWithdraw Successfully");					
						t1.invisible();
						invisible();
					} else {
						JOptionPane.showMessageDialog(null,"Insufficient Balance");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Something Went Wrong Try Again");
					System.exit(0);
				}
			} else {
				JOptionPane.showMessageDialog(null,"Please Enter the Correct Ammount");
				withdrawField.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null,"Please Enter the Correct Ammount.\nAmmount Must be <= 10000");
			withdrawField.setText("");
		}
		
	}

}
