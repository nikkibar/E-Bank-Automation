package bank_management_system;
import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("serial")
public class SignUp_2 extends JFrame implements ActionListener{

	JButton next;
	@SuppressWarnings("rawtypes")
	private JComboBox religionBox, categoryBox, incomeBox, qualificationBox, occupationBox;
	private JTextField panField, aadharField;
	private JRadioButton syes, sno, eyes, eno;
	private SignUp_1 sign1;
	private String religion, category, income, qualification, occupation, pan, aadhar, scitizen, ecitizen, query;
	private boolean check = false;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SignUp_2(SignUp_1 sign1) {
		this.sign1 = sign1;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");
		setLayout(null);
		
		JLabel additionalDetails = new JLabel("Page 2: Personal Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290, 20, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD,22));
		religion.setBounds(100, 70, 100, 30);
		add(religion);
		
		
		String valReligion[] = {"Hindus", "Muslims", "Sikh", "Chritian", "Other"};
		religionBox = new JComboBox(valReligion);
		religionBox.setFont(new Font("Raleway", Font.BOLD,14));
		religionBox.setBackground(Color.WHITE);
		religionBox.setBounds(300, 70, 400, 30);
		add(religionBox);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD,22));
		category.setBounds(100, 120, 120, 30);
		add(category);
		
		String valCategory[] = {"Gen", "OBC", "EWS", "SC/ST", "Other"};
		categoryBox = new JComboBox(valCategory);
		categoryBox.setFont(new Font("Raleway", Font.BOLD,14));
		categoryBox.setBackground(Color.WHITE);
		categoryBox.setBounds(300, 120, 400, 30);
		add(categoryBox);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,22));
		income.setBounds(100, 170, 100, 30);
		add(income);
		
		String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "UpTo 10,00,000"};
		incomeBox = new JComboBox(valIncome);
		incomeBox .setFont(new Font("Raleway", Font.BOLD,14));
		incomeBox .setBackground(Color.WHITE);
		incomeBox .setBounds(300, 170, 400, 30);
		add(incomeBox );
		
		JLabel educational = new JLabel("Educational");
		educational.setFont(new Font("Raleway",Font.BOLD,22));
		educational.setBounds(100, 220, 130, 30);
		add(educational);
		
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100, 252, 140, 30);
		add(qualification);
		
		String valeducation[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
		qualificationBox = new JComboBox(valeducation);
		qualificationBox .setFont(new Font("Raleway", Font.BOLD,14));
		qualificationBox .setBackground(Color.WHITE);
		qualificationBox .setBounds(300, 252, 400, 30);
		add(qualificationBox );
		
		JLabel occupation = new JLabel("Ocupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,22));
		occupation.setBounds(100, 302, 130, 30);
		add(occupation);
		
		String valoccupation[] = {"Salaried", "Self-Employed", "Business","Student", "Other"};
		occupationBox = new JComboBox(valoccupation);
		occupationBox.setFont(new Font("Raleway", Font.BOLD,14));
		occupationBox.setBackground(Color.WHITE);
		occupationBox.setBounds(300, 302, 400, 30);
		add(occupationBox);
		
		JLabel pan = new JLabel("PAN Number:");
		pan.setFont(new Font("Raleway",Font.BOLD,22));
		pan.setBounds(100, 352, 140, 30);
		add(pan);
		
		this.panField = new JTextField();
		this.panField.setFont(new Font("Raleway", Font.BOLD,14));
		this.panField.setBounds(300, 352, 400, 30);
		add(this.panField);
		
		JLabel aadhar = new JLabel("Aadhar Number:");
		aadhar.setFont(new Font("Raleway",Font.BOLD,22));
		aadhar.setBounds(100, 402, 170, 30);
		add(aadhar);
		
		this.aadharField = new JTextField();
		this.aadharField.setFont(new Font("Raleway", Font.BOLD,14));
		this.aadharField.setBounds(300, 402, 400, 30);
		add(this.aadharField);
		
		JLabel seniorcitizen = new JLabel("Senior Citizen:");
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,22));
		seniorcitizen.setBounds(100, 452, 170, 30);
		add(seniorcitizen);
		
		syes = new JRadioButton("Yes");
		syes.setFont(new Font("Raleway",Font.BOLD,14));
		syes.setBounds(350,452,133,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setFont(new Font("Raleway",Font.BOLD,14));
		sno.setBounds(533,452,133,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(syes);
		seniorGroup.add(sno);
		
		JLabel eaccount = new JLabel("Existing Account:");
		eaccount.setFont(new Font("Raleway",Font.BOLD,22));
		eaccount.setBounds(100, 502, 190, 30);
		add(eaccount);
		
		eyes = new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway",Font.BOLD,14));
		eyes.setBounds(350,502,133,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setFont(new Font("Raleway",Font.BOLD,14));
		eno.setBounds(533,502,133,30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup eGroup = new ButtonGroup();
		eGroup.add(eyes);
		eGroup.add(eno);
		
		next = new JButton("Next");
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.setBounds(620, 552, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(850,650);
		setLocation(220,20);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//	public static void main(String[] args) {
//		new SignUp_2(null);
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!(eyes.isSelected() || eno.isSelected())) {				
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
			return;
		}
		
		if(!(syes.isSelected() || sno.isSelected())) {
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
			return;
		}
		
		if(this.panField.getText().isEmpty() || this.aadharField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill all the field");
		} else {
		    religion = religionBox.getSelectedItem().toString();
			category = categoryBox.getSelectedItem().toString();;
			income = incomeBox.getSelectedItem().toString();
			qualification = qualificationBox.getSelectedItem().toString();
			occupation = occupationBox.getSelectedItem().toString();
			pan = this.panField.getText().toString();
			aadhar = this.aadharField.getText().toString();
			scitizen = syes.isSelected()?"Yes":"No";
			ecitizen = eyes.isSelected()?"Yes":"No";
			query = "insert into signuptwo values("+sign1.formno+",'"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+ecitizen+"');";
			setVisible(false);
			new SignUp_3(sign1, this);
			check = true;

		}
		
	}
	
	//Insert the Data SignUp
		public void insert2() {
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
