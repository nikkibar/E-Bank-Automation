package bank_management_system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import java.util.*;


@SuppressWarnings("serial")
public class SignUp_1 extends JFrame implements ActionListener{

	private  long n;
	private JTextField nameField, fnameField,  emailField,  addressField, cityField, stateField, pinCodeField;
	private JRadioButton mgenField, fgenField, ogenField, singleField, marriedField;
	private  JDateChooser datechooser;
	private JButton next, login;
	int formno;
	private  String name, fname, dob, gen, email, mstatus, address, city, state, pinCode, query;
	private boolean check = false;
	SignUp_1(){
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE1");
		setLayout(null);
		
		Random ran = new Random();
		n = Math.abs(ran.nextLong()%9000L)+1000L;

		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+ n);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 10, 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetails.setBounds(290, 50, 400, 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,22));
		name.setBounds(100, 100, 100, 30);
		add(name);

		nameField = new JTextField();
		nameField.setFont(new Font("Raleway", Font.BOLD,14));
		nameField.setBounds(300, 100, 400, 30);
		add(nameField);
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,22));
		fname.setBounds(100, 140, 170, 30);
		add(fname);
		
		fnameField = new JTextField();
		fnameField.setFont(new Font("Raleway", Font.BOLD,14));
		fnameField.setBounds(300, 150, 400, 30);
		add(fnameField);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,22));
		dob.setBounds(100, 200, 200, 30);
		add(dob);
		
		datechooser = new JDateChooser();
		datechooser.setFont(new Font("Raleway",Font.BOLD,14));
		datechooser.setBounds(300, 200, 400, 30);
		add(datechooser);
		
		JLabel gen = new JLabel("Gender:");
		gen.setFont(new Font("Raleway",Font.BOLD,22));
		gen.setBounds(100, 240, 100, 30);
		add(gen);
		
		mgenField = new JRadioButton("Male");
		mgenField.setFont(new Font("Raleway",Font.BOLD,14));
		mgenField.setBounds(300,240,133,30);
		mgenField.setBackground(Color.white);
		add(mgenField);
		
		fgenField = new JRadioButton("Female");
		fgenField.setFont(new Font("Raleway",Font.BOLD,14));
		fgenField.setBounds(433,240,133,30);
		fgenField.setBackground(Color.white);
		add(fgenField);
		
		
		ogenField = new JRadioButton("Other");
		ogenField.setFont(new Font("Raleway",Font.BOLD,14));
		ogenField.setBounds(566,240,133,30);
		ogenField.setBackground(Color.white);
		add(ogenField);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(mgenField);
		genderGroup.add(fgenField);
		genderGroup.add(ogenField);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD,22));
		email.setBounds(100, 290, 100, 30);
		add(email);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Raleway", Font.BOLD,14));
		emailField.setBounds(300, 290, 400, 30);
		add(emailField);
			
		JLabel mstatus = new JLabel("Marital Status:");
		mstatus.setFont(new Font("Raleway",Font.BOLD,22));
		mstatus.setBounds(100, 340, 170, 30);
		add(mstatus);
		
		singleField = new JRadioButton("Single");
		singleField.setFont(new Font("Raleway",Font.BOLD,14));
		singleField.setBounds(350,340,133,30);
		singleField.setBackground(Color.white);
		add(singleField);
		
		marriedField = new JRadioButton("Married");
		marriedField.setFont(new Font("Raleway",Font.BOLD,14));
		marriedField.setBounds(533,340,133,30);
		marriedField.setBackground(Color.white);
		add(marriedField);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(singleField);
		maritalGroup.add(marriedField);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,22));
		address.setBounds(100, 390, 100, 30);
		add(address);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Raleway", Font.BOLD,14));
		addressField.setBounds(300, 390, 400, 30);
		add(addressField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,22));
		city.setBounds(100, 440, 100, 30);
		add(city);
		
		cityField = new JTextField();
		cityField.setFont(new Font("Raleway", Font.BOLD,14));
		cityField.setBounds(300, 440, 400, 30);
		add(cityField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,22));
		state.setBounds(100, 490, 100, 30);
		add(state);
		
		stateField = new JTextField();
		stateField.setFont(new Font("Raleway", Font.BOLD,14));
		stateField.setBounds(300, 490, 400, 30);
		add(stateField);
		
		JLabel pinCode = new JLabel("Pin Code:");
		pinCode.setFont(new Font("Raleway",Font.BOLD,22));
		pinCode.setBounds(100, 550, 130, 30);
		add(pinCode);
		
		pinCodeField = new JTextField();
		pinCodeField.setFont(new Font("Raleway", Font.BOLD,14));
		pinCodeField.setBounds(300, 550, 400, 30);
		add(pinCodeField);
		
		next = new JButton("Next");
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.setBounds(610, 590, 80, 30);
		next.addActionListener(this);
		add(next);
		
		login = new JButton("Back");
		login.setFont(new Font("Raleway", Font.BOLD,14));
		login.setForeground(Color.white);
		login.setBackground(Color.black);
		login.setBounds(510, 590, 80, 30);
		login.addActionListener(this);
		add(login);
		
		
		
		getContentPane().setBackground(Color.white);
		setSize(850,670);
		setLocation(220,10);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
//	public static void main(String[] args) {
//		new SignUp_1();
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			setVisible(false);
			new Login();
			return;
		}
		if(!(mgenField.isSelected() || fgenField.isSelected() || ogenField.isSelected())) {				
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
			return;
		}
		if(!(singleField.isSelected() || marriedField.isSelected())) {
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
			return;
		}
		if(nameField.getText().isEmpty() || fnameField.getText().isEmpty() || emailField.getText().isEmpty() || addressField.getText().isEmpty() || cityField.getText().isEmpty() || stateField.getText().isEmpty() || pinCodeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
		} else {
			this.formno =  (int)n;
			this.name = nameField.getText();
			this.fname = fnameField.getText();
			this.dob = ((JTextComponent) datechooser.getDateEditor().getUiComponent()).getText();
			this.gen = mgenField.isSelected()?"Male":(fgenField.isSelected()?"Female":"Other");
			this.email = emailField.getText();
			this.mstatus = singleField.isSelected()?"Single":"Female";
			this.address = addressField.getText();
			this.city = cityField.getText();
			this.state = stateField.getText();
			this.pinCode = pinCodeField.getText();
			query = "insert into signup values("+formno+",'"+name+"','"+fname+"','"+dob+"','"+gen+"','"+email+"','"+mstatus+"','"+address+"','"+city+"','"+state+"','"+pinCode+"');";
			setVisible(false);
			new SignUp_2(this);
			check = true;

		}
		
	}
	
	//Insert the Data SignUp
	public void insert1() {
		if(check) {
			connection conn = null;
			try {
				conn = new connection();
				conn.s.executeUpdate(query);
				conn.s.close();
				conn.c.close();
			} catch(Exception e1){
				e1.printStackTrace();
			} 
		}
	}
	
	

}
