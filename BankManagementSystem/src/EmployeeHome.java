/**
 * this class contains the homepage of an Employee
 * when an employee will login this interface will come 
 */

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.DayOfWeek;
import java.awt.Component;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmployeeHome extends JFrame
{			
	JLabel txtHomeInfo = new JLabel("USN BANK LTD");
	JLabel showDate = new JLabel ();
	Calendar cal=new GregorianCalendar();
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	public EmployeeHome()
	 	{

			 setVisible(true);
			 setTitle("USN BANK LTD");
			 setSize(1360,768);
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setFocusable(true);
			 setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Java Project\\src\\apphome.jpg")));
			 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			 this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			 setResizable(false);
			
			 txtHomeInfo.setForeground(new Color(10, 18, 145));
			 txtHomeInfo.setFont(new Font("Impact", Font.BOLD, 65));
			 txtHomeInfo.setBounds(444,11, 500, 66);
			 
			 add(txtHomeInfo);
			 
			 JMenuBar menubar= new JMenuBar();
			 setJMenuBar(menubar);
			 
			 JMenu account = new JMenu ("Account");
			 menubar.add(account);
			 
			 JMenu transaction = new JMenu ("Transaction");
			 menubar.add(transaction);
			 
			 JMenu view = new JMenu ("View");
			 menubar.add(view);
			 
			 JMenu other = new JMenu ("Others");
			 menubar.add(other);
			 
			 JMenuItem accNew= new JMenuItem("New Account");
			 account.add(accNew);
			
			 JMenuItem accSU= new JMenuItem("Search/Update Account");
			 account.add(accSU);
			 
			 JMenuItem allCustomers= new JMenuItem("All Customers");
			 account.add(allCustomers);
			 
			
			JMenuItem deposit = new JMenuItem("Deposit");
			 	transaction.add(deposit);
			 
			JMenuItem withdraw = new JMenuItem("Withdraw");
			 	transaction.add(withdraw);
			 
			JMenuItem transfer = new JMenuItem("Transfer");
				transaction.add(transfer);
			 
		    JMenuItem fdForm = new JMenuItem("FD Form");
		    	transaction.add(fdForm);
			 
			JMenuItem loan = new JMenuItem("Loan");
				transaction.add(loan);
				
			JMenuItem loanPayment = new JMenuItem("Loan Payment");
				transaction.add(loanPayment);
				
			 

					JMenuItem tHistory = new JMenuItem("Transaction History");
					view.add(tHistory);
					
					JMenuItem chkFd = new JMenuItem("FD(s)");
					view.add(chkFd);
					
					JMenuItem chkLoan = new JMenuItem("Loan(s)");
					view.add(chkLoan);

					
					JMenuItem logOut = new JMenuItem("Log Out");
					other.add(logOut);
					
					JMenuItem exit = new JMenuItem("Exit");
					other.add(exit);
					
					JMenuItem showLoanPayments = new JMenuItem("Show Loan Payment");
					view.add(showLoanPayments);
				
					
					// there are the actions of mouse click on the items of Jmenu
					
					accNew.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							CreateNewAcc ac1 = new CreateNewAcc();
							
						}
					});
					
					accSU.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							UpdateInfo ac2 = new UpdateInfo();
						}
					});
					
					allCustomers.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e2) {
							AllCustomerDetails asd = new AllCustomerDetails();
						}
					});
					
					deposit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							Deposit ac3 = new Deposit();
						}
					});
					
					withdraw.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							Withdraw ac4 = new Withdraw();
						}
					});
					
					transfer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							Transfer ac5 = new Transfer();
						}
					});
					
					fdForm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							FdForm ac6 = new FdForm();
						}
					});
					
					loan.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							LoanForm ac7 = new LoanForm();
						}
					});
					
					
					
					exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							System.exit(0);
						}
					});
					

					
					logOut.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							dispose(); 
							Login l1 = new Login ();
						}
					});
					
					
					tHistory.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							TransactionHistory d1 = new TransactionHistory();
							
						}
					});
					chkLoan.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							ShowLoan d1 = new ShowLoan();
							
						}
					});
					
					chkFd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							ShowFd d1 = new ShowFd();
							
						}
					});
					
					showLoanPayments.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							ShowLoanPayment d1 = new ShowLoanPayment();
							
						}
					});
					
					loanPayment.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							LoanPayment ac8 = new LoanPayment();
						}
					});
					
					
					
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					month+=1;
					int year=cal.get(Calendar.YEAR);
					
					
					showDate.setFont(new Font("Impact", Font.BOLD, 65));
					showDate.setForeground(new Color(10, 18, 145));
					showDate.setBounds(480,112, 456, 66);
					
					
					showDate.setText(day+"/"+month+"/"+year);
					add(showDate);
					
					

	 	}
					
}