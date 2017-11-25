import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class FdForm extends JFrame //implements ActionListener
{
	// here is the declaration of all the components that were used
	
	JButton btSubmit = new JButton("Submit");
	JButton btCancel = new JButton("Cancel");
	
	
	JLabel labelAccountNo= new JLabel("Account No.");
	JLabel labelType= new JLabel("Type");
	JLabel labelAmount= new JLabel("Amount");
	JLabel labelPeriod= new JLabel("Period (Month)");
	JLabel labelInterest= new JLabel("Interest %");
	JLabel showDate = new JLabel ();
	
	
	JTextField txtAccount = new JTextField();
	JTextField txtAmount = new JTextField();
	JTextField txtPeriod = new JTextField();		
	JTextField txtInterest = new JTextField();
	
	String option[]={"Policy 1","Policy 2","Policy 3","Policy 4","Policy 5"};  
	
	JComboBox<String> PolicyComboBox = new JComboBox<>(option);
	
	Calendar cal =new GregorianCalendar ();

	Connection connection=null;
	String dateOfBirth;
	String date;
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	public FdForm()
	{
		super("FD Form");
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setResizable(false);
		 setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6cr800.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		//labelDate.setBounds(300,30,80,80);
		
		//labelDate.setBounds(150,170,80,80);
	
		labelAccountNo.setBounds(150,170,120,80);
		labelAccountNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelAccountNo);
		
		labelType.setBounds(150,250,80,80);
		labelType.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelType);
		
		labelAmount.setBounds(150,330,80,80);
		labelAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelAmount);
		
		labelPeriod.setBounds(150,410,140,80);
		labelPeriod.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelPeriod);
		
		labelInterest.setBounds(150,490,110,80);
		labelInterest.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelInterest);
		
		

		add(txtAccount);
		txtAccount.setBounds(300,190,240,35);
		
		add(txtAmount);
		txtAmount.setBounds(300,350,240,35);
		
		add(txtPeriod);
		txtPeriod.setBounds(300,430,240,35);
		
		add(txtInterest);
		txtInterest.setBounds(300,510,240,35);
		
		add(PolicyComboBox);
		PolicyComboBox.setBounds(300,270,240,35); 
		
		add(btCancel);
		btCancel.setBounds(240,630,110,40);
		
		add(btSubmit);
		btSubmit.setBounds(500,630,110,40);
		
		
		//sb.addActionListener(this);
		setLayout(null);
		

		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		month+=1;
		int year=cal.get(Calendar.YEAR);
		
		
		showDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		showDate.setBounds(350, 20, 120, 100);
		add(showDate);
		showDate.setText(""+day+"/"+month+"/"+year);
		
		String strDay = Integer.toString(day);
		String strMonth = Integer.toString(month);
		String strYear = Integer.toString(year);
		
		date=strYear+"-"+strMonth+"-"+strDay;
	
	// button actions against mouse click	
		
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		
		connection= DatabaseConnection.dbConnector();
		
		
			btSubmit.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e2) 
				{	
					checkAccount();
				}
				
		});
		
	}
	
	public void checkAccount()
	{	try
		{
			connection= DatabaseConnection.dbConnector();
			String query ="select * from customer where Account_No=?";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			pst.setString(1, txtAccount.getText());
			
			ResultSet rs=pst.executeQuery();
			String gtUserTp=txtAccount.getText();
				
			
			int count =0;
			while(rs.next())
				{
					count=count+1; 
				}
			if(count==1)
				{
					fdSubmit();
				}
			
			else
			{
				JOptionPane.showMessageDialog(null,"Account No Do not Exist");
			}
		}	
	
		catch(Exception e3)
		{
			JOptionPane.showMessageDialog(null,e3);
		}
	}
	
	
	public void fdSubmit()
	{	
		connection= DatabaseConnection.dbConnector();
		if(Double.parseDouble(txtAmount.getText())>0)
		{
			try
				{	
				     int acc = Integer.parseInt(txtAccount.getText()) ;
				     double am =Double.parseDouble(txtAmount.getText());
				     String fdType  =PolicyComboBox.getSelectedItem().toString();
				     double pr =Double.parseDouble(txtPeriod.getText());
				     double in =Double.parseDouble(txtInterest.getText());
				 	 String sql1 ="insert into FD (Account_No,Type,Amount,Period,Interest,Date) values(?,?,?,?,?,?)";
				 	 PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(sql1);
				 
				    
					 st1.setInt	(1,acc);
					 st1.setString(2,fdType);
					 st1.setDouble(3,am);						 
					 st1.setDouble(4,pr);												
					 st1.setDouble(5,in);
					 st1.setString(6,date);
					 st1.execute();
					 
					 JOptionPane.showMessageDialog(null,"Successfully Created");
					 dispose();
				 	
				}
			 
			catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null,e3);
				}
		}
	
	
		else
		{
			JOptionPane.showMessageDialog(null,"Amount Value Can not be negetive!");
		}

	}
	
	
	
	
	
}	




