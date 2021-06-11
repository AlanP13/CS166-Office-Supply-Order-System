import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class OfficeOrderSupplySystem 
{
	public static String txtFile="office.txt";
	static OrderManager orderSystem = new OrderManager();
	private static JTextField fileField;
public static void main(String[] args)
{
	showWindow();
}
private static void DeletingOrder()
{
	@SuppressWarnings("resource")
	Scanner scan=new Scanner(System.in);
	int orderNo;
	    System.out.print("Enter the order you want to delete:-");
		orderNo=scan.nextInt();
	    orderSystem.DeleteOrder(orderNo);
        System.out.println("Order list after deletion of OrderID "+orderNo);
        orderSystem.getOrders().forEach(order -> System.out.println(order.toString()+"\n"));
        
}
private static void CustomerList()
{
	@SuppressWarnings("resource")
	Scanner scan=new Scanner(System.in);
	String orderNo;
	    System.out.print("Enter the customer you want to search:-");
		orderNo=scan.nextLine();
		orderSystem.customerID=orderNo;
		System.out.println("Orders done by "+orderSystem.customerID);
        orderSystem.getCustomerList(orderSystem.customerID).forEach(order -> System.out.println(order.toString()+"\n"));
	    
}
private static void FileSystem(String txtFile,OrderManager orderSystem) 
{
	String columns[];
	int count = 1;
	String temp = null;
	char orderID = 0;
	int orderAmount1=0;
	String customerID = "";
	String productID = "";
	Date date1 = null;
	int orderAmount2=0;
	Date date2 = null;
	 SimpleDateFormat formatter1=new SimpleDateFormat("MM/dd/yyyy");
	try (Scanner reader = new Scanner(new FileReader(txtFile))) 
	{
		while (reader.hasNextLine()) 
		{
			temp = reader.nextLine();
			columns = temp.split(",");
			if (columns[0] != null && !columns[0].isEmpty())
	        	orderID = columns[0].charAt(0);//O or R
			if(orderID=='R'||orderID=='r')
			{
			if (count > 0 && columns.length ==7 ) 
			  {
				if (columns[1] != null && !columns[1].isEmpty())
					customerID = columns[1];// Enterprise
				if (columns[2] != null && !columns[2].isEmpty())
					productID = columns[2];// S1
				if (columns[3] != null && !columns[3].isEmpty())
					date1 =formatter1.parse(columns[3]);// 12/7/2015
				if (columns[4] != null && !columns[4].isEmpty())
					orderAmount1 =Integer.parseInt(columns[4]);//9
			    if (columns[5] != null && !columns[5].isEmpty())
					orderAmount2 = Integer.parseInt(columns[5]);//9
				if (columns[6] != null && !columns[6].isEmpty())
					date2 =formatter1.parse(columns[6]);// 12/7/2019
				long diffInMillies  = Math.abs(date2.getTime() - date1.getTime());
				long IntervalOfDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				orderSystem.addRepeatedOrder(customerID, productID, date1, date2, orderAmount1, orderAmount2,IntervalOfDays);
		        
			  }
			}
			else
			{
				if(count>0&&columns.length==5)
				{
					if (columns[1] != null && !columns[1].isEmpty())
						customerID = columns[1];// Enterprise
				 	if (columns[2] != null && !columns[2].isEmpty())
						productID = columns[2];// S1
					if (columns[3] != null && !columns[3].isEmpty())
						date1 = formatter1.parse(columns[3]);// 12/7/2015
					if (columns[4] != null && !columns[4].isEmpty())
						orderAmount1 =Integer.parseInt(columns[4]);//9
				    orderSystem.addOneTimeOrder(customerID, productID, date1,orderAmount1);   
				}
			}
			count++;
		}
    System.out.println("List of Orders:-");
    orderSystem.getOrders().forEach(order -> System.out.println(order.toString()+"\n"));   
    } 
	catch (ParseException e) 
	{
	e.printStackTrace();
	} 
	catch (FileNotFoundException e1) 
	{
	e1.printStackTrace();
	}
}
public static void clearConsole(String csvFile1) 
{
	System.out.println("/--------------------------------/");
	System.out.flush();
}
public static void showWindow()
{
		JFrame frame=new JFrame("Office Order Supply System");
		frame.setBounds(100,100,369,249);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fileField = new JTextField();
		fileField.setBounds(125, 23, 217, 20);
		frame.getContentPane().add(fileField);
		fileField.setColumns(10);
		
		JLabel lblEnterFileName = new JLabel("Enter File name");
		lblEnterFileName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterFileName.setBounds(10, 23, 105, 17);
		frame.getContentPane().add(lblEnterFileName);
		
		JButton btnEnter1 = new JButton("Enter");
		btnEnter1.setBounds(125, 54, 89, 23);
		frame.getContentPane().add(btnEnter1);
		
		JButton btnClear1 = new JButton("Clear");
		btnClear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClear1.setBounds(253, 54, 89, 23);
		frame.getContentPane().add(btnClear1);
		
		JLabel lbltxtFormat = new JLabel("(.txt) format");
		lbltxtFormat.setBounds(10, 58, 89, 14);
		frame.getContentPane().add(lbltxtFormat);
		
		JButton btnRead = new JButton("Read");
		btnRead.setBounds(220, 88, 89, 23);
		frame.getContentPane().add(btnRead);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(220, 113, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(220, 138, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 172, 332, 25);
		frame.getContentPane().add(btnExit);
		
		JLabel lblReadAndSort = new JLabel("Read and sort through the file");
		lblReadAndSort.setBounds(10, 92, 204, 14);
		frame.getContentPane().add(lblReadAndSort);
		
		JLabel lblDeleteAnOrder = new JLabel("Delete an order in the file");
		lblDeleteAnOrder.setBounds(10, 117, 206, 14);
		frame.getContentPane().add(lblDeleteAnOrder);
		
		JLabel lblSearchForA = new JLabel("Search for a Particular Customer");
		lblSearchForA.setBounds(10, 142, 204, 14);
		frame.getContentPane().add(lblSearchForA);
		btnEnter1.addActionListener(new ActionListener() 
	     {
	         @Override
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 txtFile=fileField.getText();
	         }
	     });
		btnClear1.addActionListener(new ActionListener() 
	     {
	         @Override
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 fileField.setText(null);
	            }
	     });
		btnRead.addActionListener(new ActionListener() 
	     {
	         @Override
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 FileSystem(txtFile,orderSystem);
	 		     clearConsole(txtFile);
	         }
	     });
		btnDelete.addActionListener(new ActionListener() 
	     {
	         @Override
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 DeletingOrder();
	 		    clearConsole(txtFile);
	         }
	     });
		btnSearch.addActionListener(new ActionListener() 
	     {
	         @Override
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 CustomerList();
	 			clearConsole(txtFile);
	         }
	     });
		btnExit.addActionListener(new ActionListener() 
	     {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             int option = JOptionPane.showConfirmDialog(frame, "Are you sure?");
	             if(option == JOptionPane.YES_OPTION) {
	                 frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	             }
	         }
	     });		
		frame.setVisible(true);
		
		
}
}