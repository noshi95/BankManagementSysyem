import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

public class ShowLoanPayment extends JFrame{

	
	JTable table= new JTable();
	JLabel ShowLoanPayment = new JLabel("Show Loan Payment's");
	JButton btShowDetails = new JButton("Show All Loan Payment's");
	JButton btCancel = new JButton("Cancel");
	JButton btSearch = new JButton("Search");
	JTextField txtSearch = new JTextField();
	Connection connection=null;

	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */

	public ShowLoanPayment() {

		
		setBounds(100, 100, 1360, 768);
		setTitle("Transaction History");
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\Img6crt.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 71, 1194, 588);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		btShowDetails.setBounds(600, 670, 185,43);
	    add(btShowDetails);
	    
		btCancel.setBounds(410 ,670, 185, 43);
		add(btCancel);
	    
		btSearch.setBounds(1150 ,670, 120, 43);
		add(btSearch);
	    
	
		
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setColumns(10);
		txtSearch.setBounds(1000, 670, 140, 43);
		add(txtSearch);
		
		
		
		ShowLoanPayment.setForeground(Color.BLACK);
		ShowLoanPayment.setFont(new Font("Tahoma", Font.BOLD, 40));
		ShowLoanPayment.setBounds(451, -13, 527, 108);
		add(ShowLoanPayment);
		

		 connection= DatabaseConnection.dbConnector();
		
		 //Button actions and uml operation against button click
		 
		 btShowDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					 try
						{
						 	String query ="select * from loan_payment";
						 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						 	ResultSet rs=pst.executeQuery();
						 	table.setModel(DbUtils.resultSetToTableModel(rs));
						
						}
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
				}
			});
			
		 btSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					 try
						{
						 	String query ="select * from loan_payment where Account_No=?";
						 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						 	pst.setString(1,txtSearch.getText());
						 	ResultSet rs=pst.executeQuery();
						 	table.setModel(DbUtils.resultSetToTableModel(rs));
						
						}
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
				}
			});
		 
			btCancel.addActionListener(new ActionListener() 
			 {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
			 });
		
	}
}
