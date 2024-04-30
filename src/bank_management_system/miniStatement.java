package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.ResultSet;


public class miniStatement{

	public miniStatement(String card) {
		 
		    JFrame frame = new JFrame("Mini Statement");
	        frame.setSize(400, 600);
	        frame.setLayout(null);  // Set null layout

	        // Create a panel to hold your content
	        JPanel contentPanel = new JPanel();
	        contentPanel.setLayout(null);

	        // Add some components to the content panel
	        
	        JLabel bank = new JLabel("Indian Bank");
	        bank.setBounds(150, -30, 100, 120);
	        contentPanel.add(bank);
	        
	        
	        JLabel cardnum = new JLabel("Card Number : "+card.substring(0,4)+"xxxxxxxx"+card.substring(12));
	        cardnum.setBounds(10, 50, 220, 20);
	        contentPanel.add(cardnum);
	        
	        
	       
	       

	        connection con;
	        try {
	        	con = new connection();
	        	
	        	ResultSet rs = con.s.executeQuery("Select * from bank where cardnumber = '"+card+"' and status = 'Successful'");
	        	int i =1;
	        	while (rs.next()){
	        		JLabel label = new JLabel("<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"</html>");
	        		label.setBounds(10, 80+30*i, 400, 20);
	        		contentPanel.add(label);
	        		i++;
	        	}
	        	rs.close();
	        	con.s.close();
	        	con.c.close();
	        	
	        } catch (Exception e) {
				e.printStackTrace();
			}
	        
	        // Create a JScrollPane and add the content panel to it
	        JScrollPane scrollPane = new JScrollPane(contentPanel);
	        scrollPane.setBounds(10, 10, 380, 550);  // Set bounds for the scroll pane

	        // Add the JScrollPane to the JFrame
	        frame.add(scrollPane);

	        // Add a vertical scrollbar to the JScrollPane
	        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL);
	        verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
	            @Override
	            public void adjustmentValueChanged(AdjustmentEvent e) {
	                // Handle the adjustment event here (if needed)
	            }
	        });
	        scrollPane.setVerticalScrollBar(verticalScrollBar);

	        frame.setVisible(true);
	        
	        // Adjust the preferred size of contentPanel based on its components
	        adjustContentSize(contentPanel);
		
	}
	
	private static void adjustContentSize(JPanel panel) {
	    Component[] components = panel.getComponents();
	    if (components.length > 0) {
	        Component lastComponent = components[components.length - 1];
	        int totalHeight = lastComponent.getY() + lastComponent.getHeight();
	        panel.setPreferredSize(new Dimension(panel.getWidth(), totalHeight));
	    }
	}
	
	
	
}
