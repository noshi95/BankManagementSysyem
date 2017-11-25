import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

public class RemoveUser extends JFrame
{
	// all the components are declared here
	
	JButton btRemove = new JButton("Remove");
	JButton cancel = new JButton("Cancel");
	JButton details = new JButton("Details");
	
	JLabel labelUpdateUser = new JLabel("Update User");
	
	JLabel labelUname = new JLabel("User Name");
	JLabel labelName = new JLabel("Name");
	JLabel labelGender = new JLabel("Gender");
	JRadioButton MaleRadioButton = new JRadioButton("Male");
	JRadioButton FemaleRadioButton = new JRadioButton("Female");
	JLabel labelDateBirth = new JLabel("Date of Birth");
	JLabel labelPhone = new JLabel("Phone");
	JLabel labelAddress = new JLabel("Address");
	
	JTextField txtUname = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtPhone = new JTextField();
	JTextField txtAddress = new JTextField();		
	
	
	String date[]={"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};  
	String month[]={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	String year[]={"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
	
	JComboBox<String> DateComboBox = new JComboBox<>(date);
	JComboBox<String> MonthComboBox = new JComboBox<>(month);
	JComboBox<String> YearComboBox = new JComboBox<>(year);

	
		Calendar cal =new GregorianCalendar ();
	
	JLabel showDate = new JLabel ();
	
	Connection connection=null;
	
	String dateOfBirth;
	
	ButtonGroup gp= new ButtonGroup();
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	
	public RemoveUser()
	{
		super("Remove");
		setSize(800,800);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6cr800.jpg")));
		
		
		JFrame frame = new JFrame();
		
		labelUpdateUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelUpdateUser.setBounds(290, 0, 475, 62);
		add(labelUpdateUser);
		
		add(labelUname);
		labelUname.setBounds(150,90,80,80);
		add(labelName);
		labelName.setBounds(150,170,80,80);
		add(labelGender);
		labelGender.setBounds(150,250,80,80);
		add(labelDateBirth);
		labelDateBirth.setBounds(150,330,80,80);
				
		add(labelPhone);
		labelPhone.setBounds(150,410,80,80);
		add(labelAddress);
		labelAddress.setBounds(150,490,80,80);
		
		add(txtUname);
		txtUname.setBounds(300,110,240,35);
		
		add(txtName);
		txtName.setBounds(300,190,240,35);
		txtName.setEditable(false);
		
		add(txtPhone);
		txtPhone.setBounds(300,430,240,35);
		txtPhone.setEditable(false);
		
		add(txtAddress);
		txtAddress.setBounds(300,510,270,95);
		txtAddress.setEditable(false);
		
		add(cancel);
		cancel.setBounds(260,650,110,40); 
		
		add(btRemove);
		btRemove.setBounds(450,650,110,40);
		
		details.setBounds(600, 110, 110, 40);
		add(details);
		
		setLayout(null);
		
		
		MaleRadioButton.setBounds(300,250,80,80);
		MaleRadioButton.setContentAreaFilled(false);
		gp.add(MaleRadioButton);
		add(MaleRadioButton);
		MaleRadioButton.setActionCommand("Male");
				

		FemaleRadioButton.setBounds(380,250,80,80);
		FemaleRadioButton.setContentAreaFilled(false);
		gp.add(FemaleRadioButton);
		add(FemaleRadioButton);
		FemaleRadioButton.setActionCommand("Female");
		
		
		
		DateComboBox.setBounds(300, 360, 46, 32);
		add(DateComboBox);
		
		
		MonthComboBox.setBounds(370, 360, 83, 32);
		add(MonthComboBox);
		
		
		YearComboBox.setBounds(470, 360, 70, 32);
		add(YearComboBox);
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		month+=1;
		
		showDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		showDate.setBounds(350,20, 130, 100);		
		add(showDate);
		showDate.setText(""+day+"/"+month+"/"+year);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		connection= DatabaseConnection.dbConnector();
		
		// performed uml operation on database against the button click
		
		details.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    ResultSet rs = null;
						    	String query = "select * from user where Username = ?";
								PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
								ps.setString(1,txtUname.getText());
								rs = ps.executeQuery();
							    if(rs.next()){
							          
							    	String name=rs.getString("Name");
							    	txtName.setText(name);
							    	
		               				String phn_no 	  = rs.getString("Phone");
		               				txtPhone.setText(phn_no);
		               						               										        
							        String address   = rs.getString("Address");
							        txtAddress.setText(address);
							        							        							        
							        String gender	  = rs.getString("Gender");
							        setGender (gender);
							        							     
							        String bdate	  = rs.getString("DOB");
							        setDate (bdate);							        
							        
							      } 
							    
							    else
							    {
							          JOptionPane.showMessageDialog(null, "User ID do not exist!");
							     }
							    }
						    catch(Exception ex)
						    {
							           JOptionPane.showMessageDialog(null, ex.getMessage());
						    }
								  								
							}
			
		});
		
		 btRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					 try
						{
						 	String query ="delete from user where Username=?";
						 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						 	pst.setString(1,txtUname.getText());
						 	pst.execute();		
						 	JOptionPane.showMessageDialog(null,"Removed Successfully");
						 	dispose();
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
		 DateComboBox.setEnabled(false);
		 
		 MonthComboBox.setSelectedItem(month);
		 MonthComboBox.setEnabled(false);
		 
		 YearComboBox.setSelectedItem(year);
		 YearComboBox.setEnabled(false);
		 
		 
	 }
	 
}
	
	
	