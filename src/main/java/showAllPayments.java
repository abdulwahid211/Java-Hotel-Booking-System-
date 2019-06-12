/* Name: Mohammed Abdul Wahid
 * Email: ma301ma@gold.ac.uk
 */
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * This display all payment details in JTable, the user can refresh table as well 
 * 
 * 
 * 
 */
public class showAllPayments extends JPanel {

	private PaymentList payment; // payment that retrieves list of details
	private JScrollPane scrollBar; // scroll bar for the table
	private JButton refresh; // refresh button for the table

	private String col[] = { "Customer Name", "Room Number", "Days Staying",
			"Payment Total £", "Payment Status" };// column
	// names
	// for
	// the table
	// TableModel object to store the cell value of other objects.
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	// The 0 argument is number rows.

	private JTable table;// table to display room availability
	private JPanel page; // // Jpanel for the layout
	private JButton goBack; // button go back to main menu

	// getter method for go back button
	public JButton getGoBackButton() {
		return this.goBack;
	}

	// getter method for refresh button
	public JButton getRefreshButton() {
		return this.refresh;
	}

	// return method of Jpanel to display interface layout in the main JFrane
	// method has parameter to reference object for actual action listener
	// in the mainMenu class
	public JPanel Container(Object o) throws FileNotFoundException {
		String customerName; // local variable customer name
		int noDaysStaying;
		int roomNumber;
		String status;
		// instantiating payment object
		payment = new PaymentList();
		// instantiating Jpanel
		page = new JPanel();
		page.setSize(750, 1200);
		page.setLayout(null);
		// instantiating table
		table = new JTable(tableModel);
		page.setBackground(Color.decode("#6FC9E9")); // background color 
		payment.init();
		// iterate through the for loop to collect all relevant value to display
		// in the table
		for (int i = 0; i < payment.getPaymentsList().size(); i++) {
			customerName = payment.getPaymentsList().get(i).getcustomerName();
			noDaysStaying = payment.getPaymentsList().get(i).getNumOfDays();
			roomNumber = payment.getPaymentsList().get(i).getRoom();
			status = payment.getPaymentsList().get(i).getPaymentStutus();
			// using the array objects to collect
			Object[] objs = { customerName, roomNumber, noDaysStaying,
					payment.totalCal(noDaysStaying), status };
			// display every object in table
			tableModel.addRow(objs);
		}
		// instantiating refresh button
		refresh = new JButton("Refresh");
		refresh.setBounds(200, 400, 200, 90);
		refresh.addActionListener((ActionListener) o);
		page.add(refresh);
		// instantiating goBack button
		goBack = new JButton("Back to Main Menu");
		goBack.setBounds(0, 400, 200, 90);
		goBack.addActionListener((ActionListener) o);
		page.add(goBack);
		// instantiating scroll bar for table
		page.add(table);
		scrollBar = new JScrollPane(table);
		scrollBar.setBounds(10, 70, 540, 300);
		page.add(scrollBar);

		return page;

	}

	// this is the function that removes old data in the table and then
	// updates the new one
	// deletes row from the table
	// so therefore it prevents duplicates,
	public void removeTableContent(DefaultTableModel tableModel) {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	// refresh the table
	public void refreshPage() throws FileNotFoundException {
		removeTableContent(tableModel);
		String customerName;
		int noDaysStaying;
		int roomNumber;
		String status;

		PaymentList payment = new PaymentList();
		payment.init();// retrive all data from the text file and put in a
						// arraylist
		// load up table again
		for (int i = 0; i < payment.getPaymentsList().size(); i++) {
			customerName = payment.getPaymentsList().get(i).getcustomerName();
			noDaysStaying = payment.getPaymentsList().get(i).getNumOfDays();
			roomNumber = payment.getPaymentsList().get(i).getRoom();
			status = payment.getPaymentsList().get(i).getPaymentStutus();
			Object[] objs = { customerName, roomNumber, noDaysStaying,
					payment.totalCal(noDaysStaying), status };

			tableModel.addRow(objs);
		}
	}

}
