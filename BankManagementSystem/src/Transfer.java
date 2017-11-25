import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class Transfer extends JFrame{

	// declaration of all the components
	
	JFrame frmMoneyTransfer = new JFrame();
	JLabel labalAmount = new JLabel("Amount");
	JLabel labelDstAmount = new JLabel("Destination Account");
	JLabel labelName = new JLabel("Name");
	JLabel labelCurrentAmount = new JLabel("Current Account Balance");
	JTextArea txtCurrentAccBalance = new JTextArea();
	JTextArea txtName = new JTextArea();
	JTextField txtAccNum = new JTextField();
	JTextField txtDstAcc = new JTextField();
	JTextField txtAmount = new JTextField();
	JButton btTransferAmount = new JButton("Transfer Amount");
	JButton btDetails = new JButton("Details");
	JButton btCancel = new JButton("Cancel");
	//JLabel labelDate = new JLabel("Date:");
	JLabel ShowDate = new JLabel("");
	Calendar cal =new GregorianCalendar ();
	
	double finalBalanceFromAcc;
	double finalBalanceToAcc;
	Connection connection=null;
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	public Transfer() {
	
		
		setTitle("Money Transfer");
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JLabel labelFromAccNo = new JLabel("From Account Number");
		labelFromAccNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelFromAccNo.setBounds(36, 82, 222, 44);
		add(labelFromAccNo);
		
		
		labalAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		labalAmount.setBounds(36, 399, 117, 44);
		add(labalAmount);
				
		labelDstAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelDstAmount.setBounds(36, 323, 215, 44);
		add(labelDstAmount);
				
		labelName.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelName.setBounds(36, 246, 86, 44);
		add(labelName);
		
		labelCurrentAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelCurrentAmount.setBounds(36, 178, 230, 22);
		add(labelCurrentAmount);
		
		
		txtCurrentAccBalance.setBounds(273, 166, 245, 42);
	    add(txtCurrentAccBalance);
	    txtCurrentAccBalance.setEditable(false);
				
		txtName.setBounds(273, 246, 245, 42);
		add(txtName);
		txtName.setEditable(false);
				
		txtAccNum.setBounds(273, 86, 245, 42);
		add(txtAccNum);
		txtAccNum.setColumns(10);
			
		txtDstAcc.setColumns(10);
		txtDstAcc.setBounds(273, 323, 245, 42);
		add(txtDstAcc);
				
		txtAmount.setColumns(10);
		txtAmount.setBounds(273, 401, 245, 42);
		add(txtAmount);
				
		btDetails.setBounds(557, 85, 130, 44);
		add(btDetails);
			
		btTransferAmount.setBounds(432, 478, 130, 44);
		add(btTransferAmount);
				
		btCancel.setBounds(249, 478, 130, 44);
	    add(btCancel);
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		month+=1;
		
		ShowDate.setBackground(Color.WHITE);
		ShowDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		ShowDate.setBounds(390, 24, 178, 30);
		add(ShowDate);
		ShowDate.setText(""+day+"/"+month+"/"+year);
		

		String strDay = Integer.toString(day);
		String strMonth = Integer.toString(month);
		String strYear = Integer.toString(year);
		
		String date=strYear+"-"+strMonth+"-"+strDay;
		
		
		btCancel.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) 
				{
					dispose();
				}
		 });
		 
		 
		
		 connection= DatabaseConnection.dbConnector();
		 btDetails.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) 
				{
					 try
						{	String balance;			 
						 	ResultSet rs = null;
					    	String query = "select Name ,Balance from customer where Account_No = ?";
							PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
							ps.setString(1,txtAccNum.getText());
							rs = ps.executeQuery();
						    if(rs.next())
						    {
						        
						    	String name=rs.getString("Name");
						    	txtName.setText(name);
						    	
						    	balance  = rs.getString("Balance");
						    	txtCurrentAccBalance.setText(balance);
						    	String  a=txtCurrentAccBalance.getText();
						    	finalBalanceFromAcc = Double.parseDouble(a);
						    	finalBalanceToAcc   = Double.parseDouble(a);
						    	
						    							    	
						    }
						    
						    
						}
					 
					catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,e1);
						}
					}
				}
		 
		 );
		 
		 
		 btTransferAmount.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) 
				{	
					
					if(Double.parseDouble(txtAmount.getText())>0)
					{
						
				    	try
				    	{	
				    					 
						 	ResultSet rs1 = null;
					    	String query = "select Balance from customer where Account_No = ?";
							PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
							ps.setString(1,txtDstAcc.getText());
							rs1 = ps.executeQuery();
							    if(rs1.next())
							    {
							        
							    	String dstbalance  = rs1.getString("Balance");
							    	double DstAccBl =Double.parseDouble(dstbalance);
							    	
							  
							    	
							    	finalBalanceToAcc   = DstAccBl;
							    	
					    		
					    		
						    		String  b=txtAmount.getText();
							    	double balance=Double.parseDouble(b);
							    	String query2 =" insert into transfer (Payee_Account,Recv_Account,Transfer_Amount,Date) values ("+Integer.parseInt(txtAccNum.getText())+","+Integer.parseInt(txtDstAcc.getText())+","+balance+",'"+date+"')";
							    	PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(query2);
							    	ps1.execute();
							    	
							    	finalBalanceFromAcc -= balance;
							    	finalBalanceToAcc   += balance;
							    	String query3 ="update customer set Balance= "+finalBalanceFromAcc+" where Account_No="+Integer.parseInt(txtAccNum.getText());
							    	PreparedStatement ps2 = (PreparedStatement) connection.prepareStatement(query3);
									ps2.execute();
							    	
									
							    	String query4 ="update customer set Balance= "+finalBalanceToAcc+" where Account_No="+Integer.parseInt(txtDstAcc.getText());
							    	PreparedStatement ps3 = (PreparedStatement) connection.prepareStatement(query4);
							    	ps3.execute();
							    	
							    	
							    	String query5 ="insert into transaction (Account_No,TransferFrom,TransferTo,Amount,Date) values (?,?,?,?,?) ";
							    	PreparedStatement ps4 = (PreparedStatement) connection.prepareStatement(query5);
							    	ps4.setString(1,txtAccNum.getText());
							    	ps4.setDouble(2,Double.parseDouble(txtAccNum.getText()));
							    	ps4.setDouble(3,Double.parseDouble(txtDstAcc.getText()));	
							    	ps4.setDouble(4,Double.parseDouble(txtAmount.getText()));
							    	ps4.setString(5,date);
							    	ps4.execute();
							    	
						    	
							    }
				    
				    	}
				    	
				    	catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,e1);
						}
				    	
				    	
				    	JOptionPane.showMessageDialog(null,"Successfully Transfered");
				    	dispose();
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Transfer Amount Value Can not be negetive!");
					}
			}
		 }
	 
		);
		
		
	
	
	}
}
