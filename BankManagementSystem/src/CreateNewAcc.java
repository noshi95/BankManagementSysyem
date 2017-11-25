/**
 * this class is for creating new account.
 * admin/manager/employee anyone can create new account
 */

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JLabel;
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

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreateNewAcc extends JFrame 
{
	// here is the declaration for all components used

		JLabel labelCustomerInfo = new JLabel("Customer's Information Form");
	    JLabel labelCurrentDate = new JLabel("Current Date :");
	    JLabel labelAccName = new JLabel("Account Number");
	    JLabel labelName = new JLabel("Name");
	   	JLabel labelState = new JLabel("State");
	   	JTextField txtAccNo = new JTextField();
	   	JTextField txtName = new JTextField();
	   	JTextField txtPhoneNo = new JTextField();
	   	JTextField txtAddress = new JTextField();
	   	JTextField txtDistrict = new JTextField();
	   	JTextField txtState = new JTextField();
	    JLabel labelDateBirth = new JLabel("Date of Birth");
		JLabel labelPhoneNo = new JLabel("Phone No.");
		JLabel labelAddress = new JLabel("Address");
		JLabel labelDistrict = new JLabel("District");
		JLabel labelMaterial = new JLabel("Material Status");
		JLabel labelGender = new JLabel("Gender");
		JRadioButton MaleRadioButton = new JRadioButton("Male");
		JRadioButton FemaleRadioButton = new JRadioButton("Female");
		JRadioButton MarriedRadioButton = new JRadioButton("Married");
		JRadioButton UnmarriedRadioButton = new JRadioButton("Unmarried");
		JTextField txtFatherName = new JTextField();
		JTextField txtMotherName = new JTextField();
		JTextField txtBalance = new JTextField();
		JLabel labelFatherName = new JLabel("Father's Name");
		JLabel labelMotherName = new JLabel("Mother's Name");		
		JLabel labelBalance = new JLabel("Balance");
	    JLabel labelPhoto = new JLabel();
	    JButton btUpdatePhoto = new JButton("Upload \r\n\r\nPhoto");	
		JLabel labelMail = new JLabel("E-mail");
		JTextField txtMail = new JTextField();
		JComboBox DateComboBox = new JComboBox();
		JComboBox MonthComboBox = new JComboBox();
		JComboBox YearComboBox = new JComboBox();
		JLabel labelShowDate = new JLabel("2/11/2016");
		Calendar cal =new GregorianCalendar ();
		JButton btSubmit = new JButton("Submit");
		JButton btCancel = new JButton("Cancel");
		
		Connection connection=null;
		String s;
		String dateOfBirth;
		ButtonGroup bg= new ButtonGroup();
		ButtonGroup cg= new ButtonGroup();
	
		/**
		 * here is the constructor and all the declarations 
		 * here the frame is fixed and not resizable
		 * the background image path is declared
		 */
		
	public CreateNewAcc() {

		
		
		 setTitle("Create New Account");
		 setBounds(100, 100, 1360, 768);
		 setVisible(true);
		 setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		 setLayout(null);
		 setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6crt.jpg")));
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		 setResizable(false);
		
		
		
		labelCustomerInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelCustomerInfo.setBounds(474, 0, 452, 62);
		add(labelCustomerInfo);
		
		
		labelCurrentDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelCurrentDate.setBounds(525, 61, 150, 43);
		add(labelCurrentDate);
		
		
		labelAccName.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAccName.setBounds(57, 127, 160, 20);
		add(labelAccName);
		
		
		labelName.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelName.setBounds(57, 191, 96, 14);
		add(labelName);
		
		
		labelDateBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelDateBirth.setBounds(57, 239, 120, 31);
		add(labelDateBirth);
		
		
		labelPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelPhoneNo.setBounds(57, 322, 96, 14);
		add(labelPhoneNo);
		
		
		labelAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAddress.setBounds(57, 454, 96, 14);
		add(labelAddress);
		
		
		labelDistrict.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelDistrict.setBounds(57, 539, 96, 14);
		add(labelDistrict);
		
	
		labelState.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelState.setBounds(57, 605, 46, 14);
		add(labelState);
		
		
		txtAccNo.setColumns(10);
		txtAccNo.setBounds(235, 127, 240, 31);
		add(txtAccNo);
		
		
		txtName.setColumns(10);
		txtName.setBounds(235, 177, 240, 31);
		add(txtName);
		
		
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setBounds(235, 316, 250, 31);
		add(txtPhoneNo);
		
		
		txtAddress.setName("Date");
		txtAddress.setColumns(10);
		txtAddress.setBounds(235, 426, 250, 74);
		add(txtAddress);
		
	
		txtDistrict.setColumns(10);
		txtDistrict.setBounds(235, 533, 250, 31);
		add(txtDistrict);
		
		
		txtState.setColumns(10);
		txtState.setBounds(235, 599, 250, 31);
		add(txtState);
		

		labelMaterial.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMaterial.setBounds(660, 390, 150, 14);
		add(labelMaterial);
		
		
		labelGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelGender.setBounds(660, 341, 96, 14);
		add(labelGender);
		
		
		MaleRadioButton.setBounds(842, 322, 58, 33);
		MaleRadioButton.setContentAreaFilled(false);
		add(MaleRadioButton);
		bg.add(MaleRadioButton);
		MaleRadioButton.setActionCommand("Male");
		  
		
	
		FemaleRadioButton.setBounds(953, 322, 88, 33);
		FemaleRadioButton.setContentAreaFilled(false);
		add(FemaleRadioButton);
		bg.add(FemaleRadioButton);
		FemaleRadioButton.setActionCommand("Female");
		
		
		MarriedRadioButton.setBounds(842, 388, 109, 23);
		MarriedRadioButton.setContentAreaFilled(false);
		add(MarriedRadioButton);
		cg.add(MarriedRadioButton);
		MarriedRadioButton.setActionCommand("Married");
		
		
		UnmarriedRadioButton.setBounds(953, 388, 109, 23);
		UnmarriedRadioButton.setContentAreaFilled(false);
		add(UnmarriedRadioButton);
		cg.add(UnmarriedRadioButton);
		UnmarriedRadioButton.setActionCommand("Unmarried");
		  
		
		
		
		txtFatherName.setColumns(10);
		txtFatherName.setBounds(820, 443, 334, 31);
		add(txtFatherName);
		
		
		txtMotherName.setColumns(10);
		txtMotherName.setBounds(820, 505, 334, 31);
		add(txtMotherName);
		
		
		txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalance.setColumns(10);
		txtBalance.setBounds(820, 563, 334, 31);
		add(txtBalance);
		
	
		
		labelFatherName.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelFatherName.setBounds(660, 449, 160, 14);
		add(labelFatherName);
		
		
		labelMotherName.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMotherName.setBounds(661, 511, 159, 14);
		add(labelMotherName);
		
		labelBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelBalance.setBounds(660, 569, 160, 14);
		add(labelBalance);
		
		
		labelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelPhoto.setBounds(1010, 73, 160, 150);
		add(labelPhoto);
		
		
		btUpdatePhoto.setBounds(1034, 242, 120, 43);
		add(btUpdatePhoto);
		
		btSubmit.setBounds(500 ,670, 120, 43);
		add(btSubmit);
		
		btCancel.setBounds(700 ,670, 120, 43);
		add(btCancel);
		
		labelMail.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelMail.setBounds(57, 377, 96, 14);
		add(labelMail);
		
	
		txtMail.setColumns(10);
		txtMail.setBounds(235, 371, 250, 31);
		add(txtMail);
		

		DateComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		DateComboBox.setBounds(235, 238, 46, 32);
	    add(DateComboBox);
		
	
		MonthComboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "Sepetember", "October", "November", "December"}));
		MonthComboBox.setBounds(301, 238, 83, 32);
		add(MonthComboBox);
		
		
		YearComboBox.setModel(new DefaultComboBoxModel(new String[] {"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		YearComboBox.setBounds(405, 238, 70, 32);
		add(YearComboBox);
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		month+=1;
		int year=cal.get(Calendar.YEAR);
		
		
		
		labelShowDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelShowDate.setBounds(685, 61, 152, 43);
		add(labelShowDate);
		labelShowDate.setText(""+day+"/"+month+"/"+year);
		
	
	// insert/update/delete from database against button click 	
		
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		connection= DatabaseConnection.dbConnector();
		btSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					 try
						{
						 String query2 ="insert into customer(Account_No,Name,DOB,Phone_No,Email,Address,District,State,Gender,Marital_Status,Father_Name,Mother_Name,Balance,Photo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						 	
						 PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement(query2);
						 InputStream is = new FileInputStream(new File(s));
						 
						 dateOfBirth=getDate();
						 
						 	
						 pst2.setString(1,txtAccNo.getText());
						 pst2.setString(2,txtName.getText());
						 pst2.setString(3,dateOfBirth);
						 pst2.setString(4,txtPhoneNo.getText());
						 pst2.setString(5,txtMail.getText());
						 pst2.setString(6,txtAddress.getText());
						 pst2.setString(7,txtDistrict.getText());
						 pst2.setString(8,txtState.getText());
						 
						 pst2.setString(9,bg.getSelection().getActionCommand());
						 pst2.setString(10,cg.getSelection().getActionCommand());
						 
						 pst2.setString(11,txtFatherName.getText());
						 pst2.setString(12,txtMotherName.getText());
						 pst2.setString(13,txtBalance.getText());
						 ////
						 pst2.setBlob(14,is);
						 
						  pst2.execute();
						 
						 JOptionPane.showMessageDialog(null,"Successfully Created");
						 dispose();
						
						}
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,"Data Missing. Please fillup all the field");
						}
				}
			});
		
		
		btUpdatePhoto.addActionListener(new ActionListener(){
		    
		       @Override
		       public void actionPerformed(ActionEvent e){
		    	   getPic();
		    	   
		       }
		    });
	}
	
	//this method os used to fetch picture from file system
	
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
	
	  public ImageIcon ResizeImage(String imgPath){
	        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
	        Image newImage = img.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImage);
	        return image;
	    }
	  
	  // this method is used for getting date
	  
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
