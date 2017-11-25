import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;


public class UpdateInfo extends JFrame {
	
	// declaration of all thr components 
	
		JLabel labelCustomeInfo             = new JLabel("Customer Information Update");		
        JLabel 		labelCurrentDate        = new JLabel("Current Date :");
		JLabel 		labelDate               = new JLabel();
		JLabel 		labelAccName            = new JLabel("Account Number");
		JLabel 		labelName               = new JLabel("Name");
		JLabel 		labelDateBirth          = new JLabel("Date of Birth");
		JLabel 		labelPhnNo              = new JLabel("Phone No.");
		JLabel 		labelAddress            = new JLabel("Address");
		JLabel 		labelDistrict           = new JLabel("District");
		JLabel 		labelState              = new JLabel("State");
		JLabel 		labelMstatus 			= new JLabel("Marital Status");
		JLabel 		labelGender 			= new JLabel("Gender");
		JLabel      labelFather  			= new JLabel("Father's Name");
		JLabel 		labelMother 			= new JLabel("Mother's Name");
		JLabel		labelBalance			= new JLabel("Balance");
		JLabel 		labelPhoto 			    = new JLabel();
		JLabel      labelMail 				= new JLabel("E-mail");
		JTextField  txtAccNum               = new JTextField();
		JTextField  txtName                 = new JTextField();
		JTextField  txtPhone                = new JTextField();
		JTextField  txtAddress              = new JTextField();
		JTextField  txtDistrict             = new JTextField();
		JTextField  txtState                = new JTextField();
		JTextField  txtMother               = new JTextField();
		JTextField  txtFather   			= new JTextField();
		JTextField  txtBalance   			= new JTextField();
		JTextField 	txtMail    		        = new JTextField();
	    
	    JRadioButton MaleRadioButton 		= new JRadioButton("Male");
		JRadioButton FemaleRadioButton 		= new JRadioButton("Female");
	    JRadioButton MarriedRadioButton 	= new JRadioButton("Married");
		JRadioButton UnmarriedRadioButton   = new JRadioButton("Unmarried");
		
	   
		JButton btPhotoUp 					= new JButton("Upload \r\n\r\nPhoto");
		JButton btSubmit 					= new JButton("Submit");
		JButton btCancel 					= new JButton("Cancel");
		JButton btDetails 					= new JButton("Details");
		JButton btSearch 					= new JButton("Search");
		
		JComboBox MonthComboBox				= new JComboBox();
		JComboBox YearComboBox 				= new JComboBox();
		JComboBox DateComboBox 				= new JComboBox();
		JTable tableA 						= new JTable();
		
		
		ButtonGroup gp						= new ButtonGroup();
		ButtonGroup mp						= new ButtonGroup();
		Calendar 	cal                     =new GregorianCalendar ();
		
		
	
		Connection connection=null;
		String s;
		
		String dateOfBirth;

		/**
		 * here is the constructor and all the declarations 
		 * here the frame is fixed and not resizable
		 * the background image path is declared
		 */
		
	public UpdateInfo() {
	
		

		setBounds(100, 100, 1360, 768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6crt.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		labelCustomeInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelCustomeInfo.setBounds(10, 0, 475, 62);
		add(labelCustomeInfo);
		
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		month+=1;
		int year=cal.get(Calendar.YEAR);
		
		
		labelCurrentDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelCurrentDate.setBounds(1042, 0, 150, 43);
		add(labelCurrentDate);
		

		labelDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelDate.setBounds(1192, 0, 152, 43);
		add(labelDate);
		labelDate.setText(""+day+"/"+month+"/"+year);
		
	
		labelAccName.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAccName.setBounds(20, 73, 160, 20);
		add(labelAccName);
		

		labelName.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelName.setBounds(20, 129, 96, 14);
		add(labelName);
		
	
		labelDateBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelDateBirth.setBounds(20, 174, 120, 31);
		add(labelDateBirth);
		

		labelPhnNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelPhnNo.setBounds(20, 414, 96, 14);
		add(labelPhnNo);
		
		
		labelAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAddress.setBounds(20, 533, 96, 14);
        add(labelAddress);
		

		labelDistrict.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelDistrict.setBounds(20, 603, 96, 14);
		add(labelDistrict);
		
		
		labelState.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelState.setBounds(20, 653, 46, 14);
		add(labelState);
		
	
		txtAccNum.setColumns(10);
		txtAccNum.setBounds(167, 73, 240, 31);
		add(txtAccNum);
		

		txtName.setColumns(10);
		txtName.setBounds(167, 123, 240, 31);
		add(txtName);

		txtPhone.setColumns(10);
		txtPhone.setBounds(164, 408, 250, 31);
		add(txtPhone);
		
	
		txtAddress.setName("Date");
		txtAddress.setColumns(10);
		txtAddress.setBounds(164, 505, 250, 74);
		add(txtAddress);
		
		
		txtDistrict.setColumns(10);
		txtDistrict.setBounds(164, 597, 250, 31);
		add(txtDistrict);
		
		
		txtState.setColumns(10);
		txtState.setBounds(164, 647, 250, 31);
		add(txtState);
		
		
		labelMstatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMstatus.setBounds(20, 369, 150, 14);
		add(labelMstatus);
		
		labelGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelGender.setBounds(20, 308, 96, 14);
		add(labelGender);
		
	
		MaleRadioButton.setBounds(171, 301, 58, 33);
		MaleRadioButton.setContentAreaFilled(false);
		add(MaleRadioButton);
		gp.add(MaleRadioButton);
		MaleRadioButton.setActionCommand("Male");
		

		FemaleRadioButton.setBounds(282, 301, 88, 33);
		FemaleRadioButton.setContentAreaFilled(false);
		add(FemaleRadioButton);
		gp.add(FemaleRadioButton);
		FemaleRadioButton.setActionCommand("Female");
		
		

		MarriedRadioButton.setBounds(171, 367, 109, 23);
		MarriedRadioButton.setContentAreaFilled(false);
		add(MarriedRadioButton);
		mp.add(MarriedRadioButton);
		MarriedRadioButton.setActionCommand("Married");
		

		UnmarriedRadioButton.setBounds(282, 367, 109, 23);
		UnmarriedRadioButton.setContentAreaFilled(false);
		add(UnmarriedRadioButton);
		mp.add(UnmarriedRadioButton);
		UnmarriedRadioButton.setActionCommand("Unmarried");
		
		
		
		txtFather.setColumns(10);
		txtFather.setBounds(167, 221, 247, 31);
	    add(txtFather);
		

		txtMother.setColumns(10);
		txtMother.setBounds(167, 263, 247, 31);
		add(txtMother);
		
		
		txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalance.setColumns(10);
		txtBalance.setBounds(551, 332, 120, 31);
		txtBalance.setEnabled(false);
		add(txtBalance);
		

		labelFather.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelFather.setBounds(20, 227, 429, 14);
		add(labelFather);
		

		labelMother.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMother.setBounds(20, 269, 428, 14);
		add(labelMother);
		
	
		labelBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelBalance.setBounds(473, 338, 160, 14);
		add(labelBalance);
		
	
		labelPhoto.setLayout(null);
		labelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelPhoto.setBounds(590, 73, 160, 150);
		add(labelPhoto);

		
		btPhotoUp.setBounds(613, 239, 120, 43);
		add(btPhotoUp);
		
		
		btSubmit.setBounds(490 ,670, 120, 43);
		add(btSubmit);
		
		btCancel.setBounds(650 ,670, 120, 43);
		add(btCancel);
		
		btDetails.setBounds(426, 69, 112, 34);
		add(btDetails);
		
		btSearch.setBounds(426, 122, 112, 34);
		add(btSearch);
			
		labelMail.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMail.setBounds(20, 469, 96, 14);
		add(labelMail);
		
		
		txtMail.setColumns(10);
		txtMail.setBounds(164, 463, 250, 31);
		add(txtMail);
		
		DateComboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		DateComboBox.setBounds(167, 173, 46, 32);
		add(DateComboBox);
		
		
		MonthComboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		MonthComboBox.setBounds(233, 173, 83, 32);
		add(MonthComboBox);
		
		
		YearComboBox.setModel(new DefaultComboBoxModel(new String[] {"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		YearComboBox.setBounds(337, 173, 70, 32);
		add(YearComboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(789, 78, 475, 602);
		getContentPane().add(scrollPane);
		
		tableA = new JTable();
		scrollPane.setViewportView(tableA);
		tableA.setEnabled(false);
		
		
		// here is the actions of button click and database uml operation against click
		
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		connection= DatabaseConnection.dbConnector();
		
		btDetails.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    ResultSet rs = null;
						    	String query = "select * from customer where Account_No = ?";
								PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
								ps.setString(1,txtAccNum.getText());
								rs = ps.executeQuery();
							    if(rs.next())
							    {
							          
							    	String name=rs.getString("Name");
							    	txtName.setText(name);
							    	
							    	String date      = rs.getString("DOB");
								    setDate(date);
							    	
		               				String phn_no 	  = rs.getString("Phone_No");
		               				txtPhone.setText(phn_no);
		               				
		               				String email      = rs.getString("Email");
							        txtMail.setText(email);
		               				
		               										        
							        String address   = rs.getString("Address");
							        txtAddress.setText(address);
							        
							        String district   = rs.getString("District");
							        txtDistrict.setText(district);
							        
							        String state 	  = rs.getString("State");
							        txtState.setText(state);
							        
							        String gender	  = rs.getString("Gender");
							        setGender (gender);
							        
							        String marital = rs.getString("Marital_Status");
							        setMarital(marital);	
							        
							        String father 	  = rs.getString("Father_Name");
							        txtFather.setText(father);
							        
							        String mother     = rs.getString("Mother_Name");
							        txtMother.setText(mother);
							        
							        String balance    = rs.getString("Balance");
							        txtBalance.setText(balance);
							        
							       
							        
														        
							        byte[] img = rs.getBytes("Photo");
							        setImage(img);
							        							       						        							          
							      }  
							    else
							    {
							          JOptionPane.showMessageDialog(null, "No Data found for the Account ID Given!");
							    }
							   }
						    catch(Exception ex)
						    {
							           JOptionPane.showMessageDialog(null, ex.getMessage());
						    }
								  								
					}
			
		});
		
		btSubmit.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
					 try
						{
						 dateOfBirth=getDate();
						 String query2="update customer set Name='"+txtName.getText()+"',DOB='"+dateOfBirth+"',Phone_No='"+txtPhone.getText()+"',Email='"+txtMail.getText()+"',Address='"+txtAddress.getText()+"',District='"+txtDistrict.getText()+"',State='"+txtState.getText()+"',Gender='"+gp.getSelection().getActionCommand()+"',Marital_Status='"+mp.getSelection().getActionCommand()+"',Father_Name='"+txtFather.getText()+"',Mother_Name='"+txtMother.getText()+"',Balance="+Double.parseDouble(txtBalance.getText())+"where Account_No="+Integer.parseInt(txtAccNum.getText());
						 PreparedStatement ps3 = (PreparedStatement) connection.prepareStatement(query2);
					
						 
						 ps3.execute();

						 JOptionPane.showMessageDialog(null,"Successfully Created");
						 dispose();
						
						}
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
				}
			});
	
		
		btPhotoUp.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
					 try
						{
						 	 getPic();
						 	 InputStream is = new FileInputStream(new File(s));
						 	 String query4 ="update customer set Photo=? where Account_No="+Integer.parseInt(txtAccNum.getText());						 	
							 PreparedStatement pst4 = (PreparedStatement) connection.prepareStatement(query4);
							 pst4.setBlob(1,is);							 
							 pst4.execute();
							 
							 //JOptionPane.showMessageDialog(null,"Photo Updated");
							
							
						 
						 
						}
					 catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
					}
		});
		
		btSearch.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
					 try
						{

						 	String query ="select Account_No,Name,DOB,Phone_No,Email,Address from customer where  Name=?";
						 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						 	pst.setString(1, txtName.getText());
						 	ResultSet rs=pst.executeQuery();
						 	tableA.setModel(DbUtils.resultSetToTableModel(rs));
						
						 
						}
					 catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
					}
		});
						    	
	}
	

	
	 public void setGender (String x)
	 {	
		 
		    if(x.equals("Male"))
	        {
	        	
	        	 gp.setSelected(MaleRadioButton.getModel(), true);
	        }
	        else
	        {
	        	
	        	gp.setSelected(FemaleRadioButton.getModel(), true);
	        }	        
	        
	 }
	 
	 public void setMarital(String x)
	 {	
		 
		    if(x.equals("Married"))
	        {
	        	
	        	 mp.setSelected(MarriedRadioButton.getModel(), true);
	        }
	        else
	        {
	        	
	        	mp.setSelected(UnmarriedRadioButton.getModel(), true);
	        }	        
	        
	 }
	 
	 public void setDate (String x)
	 {	
		 String temp = x;
		 String[] output = temp.split("-");
		 String year = output[0];
		 String month = output[1];
		 String date = output[2];
		 
		
		 if(month.equals("01"))
         {
       	  month="January";
         }
		 else if(month.equals("02"))
         {
       	  month="February";
         }
		 else if(month.equals("03"))
         {
       	  month="March";
         }
		 else if(month.equals("04"))
         {
       	  month="April";
         }
		 else if(month.equals("05"))
         {
       	  month="May";
         }
		 else if(month.equals("06"))
         {
       	  month="June";
         }
		 else if(month.equals("07"))
         {
       	  month="July";
         }
		 else if(month.equals("08"))
         {
       	  month="August";
         }
		 else if(month.equals("09"))
         {
       	  month="Sepember";
         }
         
		 else if(month.equals("10"))
         {
       	  month="October";
         }
		 else if(month.equals("11"))
         {
       	  month="November";
         }
		 else if(month.equals("12"))
         {
       	  month="December";
         }
		 DateComboBox.setSelectedItem(date);
		 MonthComboBox.setSelectedItem(month);
		 YearComboBox.setSelectedItem(year);		 
		 
	 }
	 
	 public void setImage(byte[] img)
	 {
		 ImageIcon image = new ImageIcon(img);
         Image im = image.getImage();
         Image myImg = im.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon newImage = new ImageIcon(myImg);
         labelPhoto.setIcon(newImage);
	 }
	 
		public void getPic()
		{
				JFileChooser filechooser= new JFileChooser();
				filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","jpg","gif","png");
				int result = filechooser.showSaveDialog(null);
				if(result== JFileChooser.APPROVE_OPTION){
					File selectedFile=filechooser.getSelectedFile();
					String path=selectedFile.getAbsolutePath();
					labelPhoto.setIcon(ResizeImage(path));
					s=path;
				}
				
				else if(result==JFileChooser.CANCEL_OPTION){

				}
				
		}
		
		  public ImageIcon ResizeImage(String imgPath)
		  {
		        ImageIcon MyImage = new ImageIcon(imgPath);
		        Image img = MyImage.getImage();
		        Image newImage = img.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(),Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImage);
		        return image;
		   }
		  
		  public String getDate()
	      {
	          String date  =DateComboBox.getSelectedItem().toString();
	          String month =MonthComboBox.getSelectedItem().toString();
	          String year  = YearComboBox.getSelectedItem().toString();
	          String dob;
	          
	          if(month=="January")
	          {
	        	  month="01";
	          }
	          else if(month=="February")
	          {
	        	  month="02";
	          }
	          else if(month=="March")
	          {
	        	  month="03";
	          }
	          else if(month=="April")
	          {
	        	  month="04";
	          }
	          else if(month=="May")
	          {
	        	  month="05";
	          }
	          else if(month=="June")
	          {
	        	  month="06";
	          }
	          else if(month=="July")
	          {
	        	  month="07";
	          }
	          else if(month=="August")
	          {
	        	  month="08";
	          }
	          else if(month=="September")
	          {
	        	  month="09";
	          }
	          else if(month=="October")
	          {
	        	  month="10";
	          }
	          else if(month=="November")
	          {
	        	  month="11";
	          }
	          else if(month=="December")
	          {
	        	  month="12";
	          }
	          
	          
	          dob = year+"-"+month+"-"+date ;
	          
	          return dob;
	          
	      }
}
