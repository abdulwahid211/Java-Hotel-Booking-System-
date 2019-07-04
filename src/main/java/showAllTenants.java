/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */
import data.DataTransaction;
import model.Tenant;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class showAllTenants implements util  {
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

	private DataTransaction tennatsTransaction;

	// return method of Jpanel to display interface layout in the main JFrane
	// method has parameter to reference object for actual action listener
	// in the mainMenu class
	public JPanel Container(Object o)  {
		String customerName; // local variable customer name
		int roomNumber; // local variable room number

		// instantiate Jpanel
		page = new JPanel();
		page.setSize(750, 1200);
		page.setLayout(null); // setting layout to null, it becomes absolute
								// position
		page.setBackground(Color.decode("#6FC9E9")); // background color 


		
		// instantiate table object
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);

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


		tennatsTransaction = new DataTransaction(Tenant.class);
		displayData();

		return page;

	}



	// refresh the table
	public void displayData() {

		removeTableContent(tableModel);

		String customerName;
		int roomNumber;

		List<Object[]> rows = tennatsTransaction.getDataRows("select" +
				" Bookings.roomNumber, Tennants.FirstName, Tennants.LastName from hotel_project.Bookings, hotel_project.Tennants " +
				"where Bookings.TennantId = Tennants.ID;;");

		// iterate through the for loop to collect all relevant value to display
		// in the table
		for (int i = 0; i < rows.size(); i++) {

			roomNumber = (int) rows.get(i)[0];

			customerName = rows.get(i)[1] +" "+rows.get(i)[2];

			Object[] objs = { customerName, roomNumber };

			tableModel.addRow(objs);
		}




	}

}
