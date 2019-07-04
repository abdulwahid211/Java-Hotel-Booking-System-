/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */

import data.DataTransaction;
import model.Booking;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class showAllRooms extends JPanel {
	private Booking roomBooking; // roomObjects that retrieves list of details
	private JScrollPane scrollBar;// scroll bar for the table
	private JButton refresh; // refresh button for the table

	private String col[] = { "Room Number", "Room Status", "Visitor Name" };// column
																			// names
																			// for
	// the table
	// TableModel object to store the cell value of other objects.
	DefaultTableModel tableModel = new DefaultTableModel(col, 0);


	private JTable table;// table to display room availability



	private JPanel page; // Jpanel for the layout
	private JButton goBack; // button go back to main menu

	private DataTransaction bookingTransaction;

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
		// instantiating room object
		roomBooking = new Booking();
		// instantiating Jpanel
		page = new JPanel();
		page.setSize(750, 1200);
		page.setLayout(null);
		// instantiating table
		table = new JTable(tableModel);
		page.setBackground(Color.decode("#6FC9E9")); // background color

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

		page.add(table);
		// instantiating scroll bar for table
		scrollBar = new JScrollPane(table);
		scrollBar.setBounds(0, 70, 548, 300);
		page.add(scrollBar);

		bookingTransaction = new DataTransaction(Booking.class);
		displayData();

		return page;

	}

	public void removeTableContent(DefaultTableModel tableModel) {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	// refresh the table
	public void displayData() {

		removeTableContent(tableModel);

		String customerName;
		String roomAvailability;
		int roomNumber;

		List<Object[]> rows = bookingTransaction.getDataRows("select Bookings.roomNumber, Bookings.roomStatus, " +
				"Tennants.FirstName from hotel_project.Bookings, hotel_project.Tennants where Bookings.TennantId = Tennants.ID;");

		// iterate through the for loop to collect all relevant value to display
		// in the table
		for (int i = 0; i < rows.size(); i++) {

			roomNumber = (int) rows.get(i)[0];

			roomAvailability = (String) rows.get(i)[1];

			customerName = (String) rows.get(i)[2];

			Object[] objs = { roomNumber, roomAvailability, customerName };

			tableModel.addRow(objs);
		}

	}

}
