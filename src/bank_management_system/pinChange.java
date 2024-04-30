package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pinChange implements ActionListener {
	
	private transaction t1;
	private JLabel l1, newPin, confirmPin;
	private JButton changePin, back;
	private JPasswordField newPinField, confirmPinField;
	private long cardNumber;
	
	pinChange(transaction t1, long cardnumber){
		
		this.t1 = t1;
		this.cardNumber = cardnumber;
		
		l1 = new JLabel("Change Your Pin");
		l1.setForeground(Color.white);
		l1.setFont(new Font("System", Font.BOLD,16));
		l1.setBounds(255,240,180,30);
		t1.atmImage.add(l1);
		
		newPin = new JLabel("New Pin:");
		newPin.setForeground(Color.white);
		newPin.setFont(new Font("System", Font.BOLD,14));
		newPin.setBounds(151,280,180,20);
		t1.atmImage.add(newPin);
		
		newPinField = new JPasswordField();
		newPinField.setBounds(255, 280, 200, 20);
		t1.atmImage.add(newPinField);
		
		confirmPin = new JLabel("Re-Enter Pin:");
		confirmPin.setForeground(Color.white);
		confirmPin.setFont(new Font("System", Font.BOLD,14));
		confirmPin.setBounds(151,310,180,20);
		t1.atmImage.add(confirmPin);
		
		confirmPinField = new JPasswordField();
		confirmPinField.setBounds(255, 310, 200, 20);
		t1.atmImage.add(confirmPinField);
		
		
		changePin = new JButton("Change Pin");
		back = new JButton("Back");
		
		changePin.setFont(new Font("Raleway",Font.BOLD,12));
		back.setFont(new Font("Raleway",Font.BOLD,12));
		
		
		changePin.setBounds(334,376,150,22);
		back.setBounds(334,402,150,22);
		
		t1.atmImage.add(changePin);
		t1.atmImage.add(back);
		
		changePin.addActionListener(this);
		back.addActionListener(this);
	}

	private void visible() {
		l1.setVisible(false);
		newPin.setVisible(false);
		confirmPin.setVisible(false);
		changePin.setVisible(false);
		back.setVisible(false);
		newPinField.setVisible(false);
		confirmPinField.setVisible(false);
	}
	 
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			visible();
			t1.invisible();
		} else if(!(newPinField.getText().isEmpty() && confirmPinField.getText().isEmpty() && newPinField.getText().equals(confirmPinField.getText()))){
			String confirmPin = confirmPinField.getText();
			String newPin = newPinField.getText();
			if(confirmPin.length() == 4 && check(confirmPin) && newPin.length() == 4 && check(newPin)) {
				connection con;
				try {
					con = new connection();
					String query = "Update login set pin = '"+confirmPin+"' where cardnumber = '"+cardNumber+"' Limit 1";
					int n = con.s.executeUpdate(query);
					query = "Update signupthree set pin = '"+confirmPin+"' where cardnumber = '"+cardNumber+"' Limit 1";
					if(n > 0) {
						JOptionPane.showMessageDialog(null,"Pin Change Successfully!");
					} else {
						JOptionPane.showMessageDialog(null,"Something went wrong!");
						t1.setVisible(false);
						new Login();
					}
					con.s.executeUpdate(query);
					con.s.close();
					con.c.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				visible();
				t1.invisible();
				
			} else {
				JOptionPane.showMessageDialog(null,"Pin Must Have length of 4.\nAnd must be numeric and same!");
				newPinField.setText("");
				confirmPinField.setText("");
			}
			;
		} else {
			JOptionPane.showMessageDialog(null,"Please Enter All Field.");
		}
		
	}
	
	public boolean check(String pin) {
		for(int i=0; i<pin.length(); i++) {
			if (!Character.isDigit(pin.charAt(i))) {
                return false;
            }
		}
		return true;
	}
	
}
