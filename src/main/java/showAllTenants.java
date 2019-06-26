/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * This display all tenant details in JTable, the user can refresh table as well 
 * 
 * 
 * 
 */

public class showAllTenants  {
	private TenantList tenants; // tenants that retrieves list of details
	private JScrollPane scrollBar; // scroll bar for the table
	private JButton refresh; // refresh button for the table
	private String col[] = { "TenantList Name", "Room number" }; // column names for
																// the table
	// TableModel object to store the cell value of other objects.
	private DefaultTableModel tableModel;
	private JTable table;// table to display room availability
	private JPanel page; // Jpanel for the layout
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
		int roomNumber; // local variable room number

		// instantiate Jpanel
		page = new JPanel();
		page.setSize(750, 1200);
		page.setLayout(null); // setting layout to null, it becomes absolute
								// position
		page.setBackground(Color.decode("#6FC9E9")); // background color 

		// instantiate tenant object
		tenants = new TenantList();
		tenants.init(); // load up the arraylist of tenants

		
		// instantiate table object
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		

		// iterate through the for loop to collect all relevant value to display
		// in the table
		for (int i = 0; i < tenants.getTenantsList().size(); i++) {
			customerName = tenants.getTenantsList().get(i).getFirstName() + " "
					+ tenants.getTenantsList().get(i).getLastName();
			roomNumber = tenants.getTenantsList().get(i).getRoomNumber();
			// using the array objects to collect
			Object[] objs = { customerName, roomNumber };
			// display every object in table
			tableModel.addRow(objs);
		}
		// instantiate refresh button
		refresh = new JButton("Refresh");
		refresh.setBounds(200, 300, 200, 50);
		refresh.setFont(new Font("Serif",Font.BOLD,17)); 
		refresh.addActionListener((ActionListener) o);
		page.add(refresh);

		// instantiate goBack button
		goBack = new JButton("Back to Search Page");
		goBack.setBounds(0, 400, 200, 90);
		goBack.addActionListener((ActionListener) o);
		page.add(goBack);

		// instantiate scroll bar for table
		page.add(table);
		scrollBar = new JScrollPane(table);
		scrollBar.setBounds(0, 0, 550, 300);
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
		TenantList tenants = new TenantList();
		String customerName;
		int roomNumber;
		// retrive all data from the text file and put in a arraylist
		tenants.init();
		// load up table again
		for (int i = 0; i < tenants.getTenantsList().size(); i++) {
			customerName = tenants.getTenantsList().get(i).getFirstName() + " "
					+ tenants.getTenantsList().get(i).getLastName();
			roomNumber = tenants.getTenantsList().get(i).getRoomNumber();

			Object[] objs = { customerName, roomNumber };

			tableModel.addRow(objs);
		}

	}

}
