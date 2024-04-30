package bank_management_system;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class balance_enquiry implements ActionListener{
	private JLabel balanceView;
	long balance = 0, cardnumber;
	private transaction t1;
	private JButton back;
	
	public balance_enquiry(transaction t1, long cardnumber) {
		this.t1 = t1;
		this.cardnumber = cardnumber;
		
		connection con;
		try {
			con = new connection();
			
			//Fetch All deposit from Bank
			String query = "SELECT COALESCE(SUM(amount), 0) AS total_amount FROM bank where type = 'Deposit' and cardnumber = '"+cardnumber+"' and status = 'Successful'";
			long deposit = con.fetchAmount(query);
			
			//Fetch WithDrawMoney from Bank
			query = "SELECT COALESCE(SUM(amount), 0) AS total_amount FROM bank where type = 'Withdraw' and cardnumber = '"+cardnumber+"' and status = 'Successful'";
			long withdraw = con.fetchAmount(query);
			
			balance = deposit - withdraw;
			
			balanceView = new JLabel("Your Current Balance: Rs. "+balance);
			balanceView.setForeground(Color.white);
			balanceView.setFont(new Font("System", Font.BOLD,14));
			balanceView.setBounds(161,240,250,30);
			t1.atmImage.add(balanceView);
			
			back = new JButton("Back");
			back.setFont(new Font("Raleway",Font.BOLD,12));
			back.setBounds(334,402,150,22);
			t1.atmImage.add(back);
			back.addActionListener(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		t1.invisible();
		back.setVisible(false);
		balanceView.setVisible(false);
		
	}
}
