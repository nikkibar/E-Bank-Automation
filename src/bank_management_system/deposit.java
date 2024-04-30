package bank_management_system;

import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class deposit implements ActionListener {
    
	private JTextField depositField;
	private JLabel l1;
	private JButton deposit, back, exit;
	private long cardNumber;
	private transaction t1;
	private String check;;
    deposit(transaction t1, long card, String check) {
		this.t1 = t1;
		this.cardNumber = card;
		this.check = check;
		
		l1 = new JLabel("Entert the Amount you want to Deposit");
		l1.setForeground(Color.white);
		l1.setFont(new Font("System", Font.BOLD,14));
		l1.setBounds(180,240,280,20);
		t1.atmImage.add(l1);

		depositField = new JTextField();
		depositField.setBounds(190, 270, 260, 20);
		t1.atmImage.add(depositField);
		
		deposit = new JButton("Deposit");
		back = new JButton("Back");
		exit = new JButton("Exit");
		
		deposit.setFont(new Font("Raleway",Font.BOLD,12));
		back.setFont(new Font("Raleway",Font.BOLD,12));
		exit.setFont(new Font("Raleway",Font.BOLD,12));
		
		deposit.setBounds(334,376,150,22);
		back.setBounds(334,402,150,22);
		exit.setBounds(334,402,150,22);
		exit.setEnabled(false);
		
		t1.atmImage.add(deposit);
		if(this.check == "login")
		  t1.atmImage.add(back);
		else
		  t1.atmImage.add(exit);
		
		deposit.addActionListener(this);
		back.addActionListener(this);
		exit.addActionListener(this);
	
		
	}
    
    public void invisible() {
    	l1.setVisible(false);
    	deposit.setVisible(false);
    	back.setVisible(false);
    	depositField.setVisible(false);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		
		if(e.getSource() == exit) {
			t1.setVisible(false);
			new Login();
		} else if(e.getSource() == back) {
			t1.invisible();
			invisible();
		} else if(!depositField.getText().isEmpty()){
			if(Integer.parseInt(depositField.getText()) >= 0 && e.getSource() != back) {
				
				connection con;
				try {
					con = new connection();
					String amount = depositField.getText();
					Date date = new Date();
					String query = "insert into bank values('"+cardNumber+"','"+amount+"','Deposit','"+date+"','Successful')";
					con.s.executeUpdate(query);
					con.s.close();
					con.c.close();
					JOptionPane.showMessageDialog(null,"Rs. "+amount+"\nDeposited Successfully");
					if(check == "login") {						
						t1.invisible();
						invisible();
					} else {
						exit.setEnabled(true);
						depositField.setText("");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,"Something Went Wrong Try Again");
				depositField.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null,"Please Enter the Correct Ammount.");
			depositField.setText("");
		}
		
	}

}
