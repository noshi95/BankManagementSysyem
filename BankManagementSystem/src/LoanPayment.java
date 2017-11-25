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

public class LoanPayment extends JFrame {
		
	// here is the declaration for all components used and variables
	
	JLabel accNo = new JLabel("Enter Account Number");
	JLabel name = new JLabel("Name");
	JLabel paymentAmount = new JLabel("Payment Amount");
	JLabel paymenMonth = new JLabel("Payment Month");
	JButton details = new JButton("Details");
	JButton update = new JButton("Update");
	JButton btCancel = new JButton("Cancel");
	JTextField accNumTxt = new JTextField();
	JTextField paymentAmountTxt = new JTextField();
	JTextArea nameTxt = new JTextArea();
	JTextArea paymentMonthTxt = new JTextArea();
	Calendar cal =new GregorianCalendar ();
	JLabel showDate = new JLabel("");
	

	Connection connection=null;
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	public LoanPayment() {

		
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
		
		
		paymenMonth.setFont(new Font("Tahoma", Font.BOLD, 18));
		paymenMonth.setBounds(48, 236, 170, 37);//
		add(paymenMonth);
		
		
		paymentAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		paymentAmount.setBounds(48, 306, 170, 37);
		add(paymentAmount);
		
		
		details.setBounds(555, 96, 172, 46);
		add(details);
		
		
		update.setBounds(400, 402, 172, 46);
		add(update);
		
		btCancel.setBounds(200, 402, 172, 46);
		add(btCancel);
		
		
		
		accNumTxt.setBounds(274, 99, 245, 42);
		add(accNumTxt);
			
		paymentAmountTxt.setBounds(274, 305, 245, 42);
		add(paymentAmountTxt);
				
		nameTxt.setForeground(new Color(0, 0, 0));
		nameTxt.setBounds(274, 165, 245, 42);
		add(nameTxt);
		nameTxt.setEditable(false);
				
		paymentMonthTxt.setBounds(274, 236, 245, 42);
		add(paymentMonthTxt);
		
		
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
						{			 
						    connection= DatabaseConnection.dbConnector();
							String query ="select * from loan where Account_No=?";
							PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
							pst.setString(1, accNumTxt.getText());							
							ResultSet rs=pst.executeQuery();
							
							int count =0;
							while(rs.next())
								{
									count=count+1; 
								}
							if(count==1)
								{
									paymentSubmit();
								}
							
							else
							{
								JOptionPane.showMessageDialog(null,"Account No Do not Exist");
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
					if(Double.parseDouble(paymentAmountTxt.getText())>0)
					{
				    	try
				    	{
				    		
					    	
					    	String query2 ="insert into loan_payment (Account_No,Name,Payment_Month,Payment_Amount,Date) values (?,?,?,?,?) ";
					    	PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(query2);
					    	
					    	String  b=paymentAmountTxt.getText();
					    	double payAmount=Double.parseDouble(b);
					    	
					    	ps1.setString(1,accNumTxt.getText());
					    	ps1.setString(2,nameTxt.getText());
					    	ps1.setString(3,paymentMonthTxt.getText());
					    	ps1.setDouble(4,payAmount);
					    	ps1.setString(5,date);
					  
					    	ps1.execute();
					    	
					    	
				    	}
				    	catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,"Something wrong");
						}
				    	
			    	
				    	JOptionPane.showMessageDialog(null,"Payment Successed");
				    	dispose();
					
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Amount Value Can not be negative!");
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
	
	public void paymentSubmit()
	{	try
		{
			connection= DatabaseConnection.dbConnector();
			ResultSet rs = null;
	    	String query = "select Name from customer where Account_No = ? ";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1,accNumTxt.getText());
			rs = ps.executeQuery();
		    if(rs.next())
		    {
		        
		    	String name=rs.getString("Name");
		    	nameTxt.setText(name);
			
		    }
		    
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"Something wrong");
		}
	}
}
