/**
 * this class is for deposit balance for specific account.
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Deposit extends JFrame {
		
	// here is the declaration for all components used and variables
	
	JLabel accNo = new JLabel("Enter Account Number");
	JLabel name = new JLabel("Name");
	JLabel currentBalance = new JLabel("Current Balance");
	JLabel depositAmount = new JLabel("Deposit Amount");
	JButton details = new JButton("Details");
	JButton update = new JButton("Update");
	JButton btCancel = new JButton("Cancel");
	JTextField accNumTxt = new JTextField();
	JTextField depositAmountTxt = new JTextField();
	JTextArea nameTxt = new JTextArea();
	JTextArea currentBalanceTxt = new JTextArea();
	Calendar cal =new GregorianCalendar ();
	JLabel showDate = new JLabel("");
	
	double finalBalance;
	
	Connection connection=null;
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	public Deposit() {

		
		setBounds(100, 100, 800, 600);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Deposit");
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setLayout(null);
		
	
		accNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		accNo.setBounds(48, 99, 214, 37);
		add(accNo);
		
		
		name.setFont(new Font("Tahoma", Font.BOLD, 18));
		name.setBounds(47, 165, 141, 41);
		add(name);
		
		
		currentBalance.setFont(new Font("Tahoma", Font.BOLD, 18));
		currentBalance.setBounds(48, 236, 150, 37);//
		add(currentBalance);
		
		
		depositAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		depositAmount.setBounds(48, 306, 151, 37);
		add(depositAmount);
		
		
		details.setBounds(555, 96, 172, 46);
		add(details);
		
		
		update.setBounds(400, 402, 172, 46);
		add(update);
		
		btCancel.setBounds(200, 402, 172, 46);
		add(btCancel);
		
		
		
		accNumTxt.setBounds(274, 99, 245, 42);
		add(accNumTxt);
			
		depositAmountTxt.setBounds(274, 305, 245, 42);
		add(depositAmountTxt);
				
		nameTxt.setForeground(new Color(0, 0, 0));
		nameTxt.setBounds(274, 165, 245, 42);
		add(nameTxt);
		nameTxt.setEditable(false);
				
		currentBalanceTxt.setBounds(274, 236, 245, 42);
		add(currentBalanceTxt);
		currentBalanceTxt.setEditable(false);
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		month+=1;
		int year=cal.get(Calendar.YEAR);
		
		String strDay = Integer.toString(day);
		String strMonth = Integer.toString(month);
		String strYear = Integer.toString(year);
		
		String date=strYear+"-"+strMonth+"-"+strDay;
		
		
		
		showDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		showDate.setBounds(350,0, 120, 100);
		add(showDate);
		showDate.setText(""+day+"/"+month+"/"+year);
		

		// performed UML operation against button click
		
		 connection= DatabaseConnection.dbConnector();
		 details.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) 
				{
					 try
						{	String balance;			 
						 	ResultSet rs = null;
					    	String query = "select Name ,Balance from customer where Account_No = ?";
							PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
							ps.setString(1,accNumTxt.getText());
							rs = ps.executeQuery();
						    if(rs.next())
						    {
						        
						    	String name=rs.getString("Name");
						    	nameTxt.setText(name);
						    	
						    	balance  = rs.getString("Balance");
						    	currentBalanceTxt.setText(balance);
						    	String  a=currentBalanceTxt.getText();
						    	finalBalance = Double.parseDouble(a);
	
						    }
						    
						    
						}
					 
					catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,"Something wrong");
						}
					}
				}
		 
		 );
		 
		 
		 update.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) 
				{
					if(Double.parseDouble(depositAmountTxt.getText())>0)
					{
				    	try
				    	{
				    		
					    	
					    	String query2 ="insert into deposit (Account_No,Deposit_Amount,Date) values (?,?,?) ";
					    	PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(query2);
					    	
					    	String  b=depositAmountTxt.getText();
					    	double balance=Double.parseDouble(b);
					    	
					    	ps1.setString(1,accNumTxt.getText());
					    	ps1.setDouble(2,balance);							 
					    	ps1.setString(3,date);
					  
					    	ps1.execute();
					    	
					    	finalBalance += balance;
					    	String query3 ="update customer set Balance= "+finalBalance+" where Account_No=?";
					    	PreparedStatement ps2 = (PreparedStatement) connection.prepareStatement(query3);
							ps2.setString(1,accNumTxt.getText());
							ps2.execute();
							
							
					    	String query4 ="insert into transaction (Account_No,Debit,Date) values (?,?,?) ";
					    	PreparedStatement ps3 = (PreparedStatement) connection.prepareStatement(query4);
					    	b=depositAmountTxt.getText();
					    	ps3.setString(1,accNumTxt.getText());
					    	ps3.setDouble(2,balance);							 
					    	ps3.setString(3,date);
					    	ps3.execute();
					    	
					    	
					    	
				    	}
				    	catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,"Something wrong");
						}
				    	
			    	
				    	JOptionPane.showMessageDialog(null,"Successfully Deposited");
				    	dispose();
					
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Deposit Value Can not be negetive!");
					}
				}
			}
	 
		);
		 
		 btCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) 
				{
					dispose();
				}
			});
		
		
	}
}
