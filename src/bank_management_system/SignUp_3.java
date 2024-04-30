package bank_management_system;

import java.awt.event.*;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.awt.*;
import javax.swing.*;
//import javax.swing.table.TableStringConverter;

@SuppressWarnings("serial")
public class SignUp_3 extends JFrame implements ActionListener{
	
	JRadioButton savingAccount, fdAccount, currentAccount, rdAccount;
	JLabel cardno, pin;
	JCheckBox atm, internet_banking, mobile_banking, emailsms_alert, cheque, estatement, aggrement;
	JButton submit, cancel;
	SignUp_1 form1;
	SignUp_2 form2;
	
	public SignUp_3(SignUp_1 form1, SignUp_2 form2) {
		this.form1 = form1;
		this.form2 = form2;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");
		setLayout(null);
		
		JLabel accountDetails = new JLabel("Page 3: Account Details");
		accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
		accountDetails.setBounds(300,20,300,30);
		add(accountDetails);
		
		JLabel aType = new JLabel("Account Type");
		aType.setFont(new Font("Raleway",Font.BOLD,22));
		aType.setBounds(100, 100, 200, 30);
		add(aType);
		
		savingAccount = new JRadioButton("Saving Account");
		savingAccount.setFont(new Font("Raleway",Font.BOLD,14));
		savingAccount.setBackground(Color.white);
		savingAccount.setBounds(100, 130, 150, 30);
		add(savingAccount);
		
		fdAccount = new JRadioButton("Fixed Deposit Account");
		fdAccount.setFont(new Font("Raleway",Font.BOLD,14));
		fdAccount.setBackground(Color.white);
		fdAccount.setBounds(330, 130, 200, 30);
		add(fdAccount);
		
		currentAccount = new JRadioButton("Current Account");
		currentAccount.setFont(new Font("Raleway",Font.BOLD,14));
		currentAccount.setBackground(Color.white);
		currentAccount.setBounds(100, 160, 150, 30);
		add(currentAccount);
		
		rdAccount = new JRadioButton("Reccuring Deposit Account");
		rdAccount.setFont(new Font("Raleway",Font.BOLD,14));
		rdAccount.setBackground(Color.white);
		rdAccount.setBounds(330, 160, 220, 30);
		add(rdAccount);
		
		ButtonGroup account = new ButtonGroup();
		account.add(currentAccount);
		account.add(savingAccount);
		account.add(fdAccount);
		account.add(rdAccount);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100, 220, 200, 30);
		add(card);
		
		JLabel digit = new JLabel("Your 16 Digit Card Number");
		digit.setFont(new Font("Raleway",Font.BOLD,10));
		digit.setBounds(105, 240, 200, 30);
		add(digit);
		
		cardno = new JLabel("XXXX-XXXX-XXXX-4184");
		cardno.setFont(new Font("Raleway", Font.BOLD,22));
		cardno.setBounds(300, 220, 400, 30);
		add(cardno);
				
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100, 300, 100, 30);
		add(pin);
		
		JLabel pindigit = new JLabel("Your 4 Digit Password");
		pindigit.setFont(new Font("Raleway",Font.BOLD,10));
		pindigit.setBounds(100, 320, 200, 30);
		add(pindigit);
		
		pin = new JLabel("XXXX");
		pin.setFont(new Font("Raleway", Font.BOLD,22));
		pin.setBounds(300, 300, 200, 30);
		add(pin);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100, 380, 300, 30);
		add(services);
		
		atm = new JCheckBox("ATM Card");
		atm.setFont(new Font("Raleway",Font.BOLD,14));
		atm.setBackground(Color.white);
		atm.setBounds(100, 410, 100, 30);
		add(atm);
		
		internet_banking = new JCheckBox("Internet Banking");
		internet_banking.setFont(new Font("Raleway",Font.BOLD,14));
		internet_banking.setBackground(Color.white);
		internet_banking.setBounds(330, 410, 200, 30);
		add(internet_banking);
		
		
		mobile_banking = new JCheckBox("Mobile Banking");
		mobile_banking.setFont(new Font("Raleway",Font.BOLD,14));
		mobile_banking.setBackground(Color.white);
		mobile_banking.setBounds(100, 440, 200, 30);
		add(mobile_banking);
		
		emailsms_alert = new JCheckBox("EMAIL & SMS Alerts");
		emailsms_alert.setFont(new Font("Raleway",Font.BOLD,14));
		emailsms_alert.setBackground(Color.white);
		emailsms_alert.setBounds(330, 440, 200, 30);
		add(emailsms_alert);
		
		
		cheque = new JCheckBox("Cheque-Book");
		cheque.setFont(new Font("Raleway",Font.BOLD,14));
		cheque.setBackground(Color.white);
		cheque.setBounds(100, 470, 200, 30);
		add(cheque);
		
		estatement = new JCheckBox("E-Statement");
		estatement.setFont(new Font("Raleway",Font.BOLD,14));
		estatement.setBackground(Color.white);
		estatement.setBounds(330, 470, 200, 30);
		add(estatement);
		
		aggrement = new JCheckBox("I herby declare that above entered details are correct to the best of my knowledge.");
		aggrement.setFont(new Font("Raleway",Font.BOLD,11));
		aggrement.setBackground(Color.white);
		aggrement.setBounds(100, 530, 470, 30);
		aggrement.addActionListener(this);
		add(aggrement);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setForeground(Color.white);
		submit.setBackground(Color.black);
		submit.setBounds(200,560,100,30);
		submit.setEnabled(false);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.addActionListener(this);
		cancel.setBounds(363,560,100,30);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		setSize(850,650);
		setLocation(220,20);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new SignUp_3(null,null);
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cancel) {
			return;
		}
		
		if(aggrement.isSelected() && e.getSource() == aggrement) {
			submit.setEnabled(true);
			aggrement.setEnabled(false);
			return;
		} 
		if(!(savingAccount.isSelected() || fdAccount.isSelected() || currentAccount.isSelected() || rdAccount.isSelected())) {				
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
			return;
		} else {
			String account_type = savingAccount.isSelected()?"Saving Account":(fdAccount.isSelected()?"Fixed Deposit Account":(currentAccount.isSelected()?"Current Account":"Reccuring Deposit Account"));
		    Random random = new Random();
		    long cardno = Math.abs(random.nextLong()%90000000L)+5040963000000000L;
		    int pin = (int) ((int)Math.abs(random.nextLong()%9000L)+1000L);
		    String facility = "";
		    if(atm.isSelected())
		    	facility += "ATM Card,";
		    if(internet_banking.isSelected())
		    	facility += "Internet Banking,";
		    if(mobile_banking.isSelected())
		    	facility += "Mobile Banking,";
		    if(emailsms_alert.isSelected())
		    	facility += "EMAIL & SMS Alerts,";
		    if(cheque.isSelected())
		    	facility += "Cheque-Book,";
		    if(estatement.isSelected())
		    	facility += "E-Statement,";
		    
		    connection con =null;
		    try {
		    	form1.insert1();
		    	form2.insert2();
		    	con = new connection();
		    	String query = "insert into signupthree values ("+form1.formno+",'"+account_type+"','"+cardno+"','"+pin+"','"+facility+"')";
		    	con.s.executeUpdate(query);
		    	query = "insert into login values ("+form1.formno+",'"+cardno+"','"+pin+"')";
		    	con.s.executeUpdate(query);
		    	con.s.close();
				con.c.close();
				JOptionPane.showMessageDialog(null, "Card Number = "+cardno+"\nPIN = "+pin);
				setVisible(false);
				transaction t1 = new transaction(cardno);
				t1.invisible();
				new deposit(t1, cardno, "form");
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}
	}
}
