/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/*
 * The remove tenant class delets the tenant from text file. 
 * The user will need to press the remove tenant button to delete the person. 
 * A JList is used to displays all details of tenants that have been added previously or subsequently and a refresh button is used to update the JList. 
 * Once the user has pressed the refresh button, 
 * it will display list of tenant objects with their room number. 
 * The the user can then select the object of that particular tenant and once it been highlighted, 
 * the user can press the remove tenant button to delete. 
 * 
 */

public class RemoveTenant {

	private JButton goBack; // button to go back to main Menu
	private JButton refresh; // button to refresh the Jlist
	private JPanel page; // Jpanel
	private JButton removeTennant; // button to remove tenant
	private JList listTenants; // list to hold color names
	private JScrollPane scrollBar; // scrollBar for listTenants
	private TenantList tenant; // to get the list tenants
	private JLabel info; // label for info
	private JLabel info2; // label for info

	// getter method for go back button
	public JButton getGoBackButton() {
		return this.goBack;
	}

	// getter method for remove tenant button
	public JButton getRemoveTennantButton() {
		return this.removeTennant;
	}

	// getter method for refresh button
	public JButton getRefreshButton() {
		return this.refresh;
	}

	public JPanel Container(Object o) throws FileNotFoundException {
		// instantiate Jpanel
		page = new JPanel();
		page.setSize(550, 600);
		page.setLayout(null);
		// instantiate tenant object
		tenant = new TenantList();

		tenant.init();
		// instantiate Jlist
		// get array list of tenants and convert into arrays to display
		listTenants = new JList(tenant.getTenantsList().toArray());

		listTenants.setVisibleRowCount(10); // show ten rows

		listTenants
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // object
																					// can
																					// be
																					// selected
																					// once
		// instantiate scroll bar for Jlist
		scrollBar = new JScrollPane(listTenants);
		scrollBar.setBounds(50, 90, 460, 300);
		page.add(scrollBar);
		page.setBackground(Color.decode("#6FC9E9")); // background for Jpanel

		// instantiate back button
		goBack = new JButton("Go Back");
		goBack.setBounds(0, 0, 130, 30);
		page.add(goBack);
		goBack.addActionListener((ActionListener) o); // adding lisnter

		// instantiate info label
		info = new JLabel(
				"(Please select the object of that particular tenant to delete)");
		info.setBounds(50, -70, 560, 300);
		page.add(info);

		// instantiate info label
		info2 = new JLabel(
				"(Please press Refresh button to update the list)");
		
		info2.setBounds(140, -140, 560, 300);
		page.add(info2);

		// instantiate refresh button
		refresh = new JButton("Refresh");
		refresh.setBounds(220, 480, 120, 50);
		page.add(refresh);
		refresh.addActionListener((ActionListener) o); // adding lisnter

		// instantiate remove button
		removeTennant = new JButton("Remove Tennant");
		removeTennant.setBounds(210, 400, 160, 50);
		page.add(removeTennant);
		removeTennant.addActionListener((ActionListener) o); // adding lisnter

		return page;

	}

	// this method removes tenants object and updates the file
	// it also remove payment list and booking as well
	public void remove() throws FileNotFoundException {
		// instantiate tenant object
		TenantList tenant = new TenantList();
		tenant.init();
		// instantiate payment object
		PaymentList removePay = new PaymentList();
		removePay.init();
		// collect the tenant object from the Jlist selection
		Tenant object = tenant.getTenantsList().get(
				listTenants.getSelectedIndex());
		// instantiate booking object
		Booking roomBooking = new Booking();
		roomBooking.init();
		// remove the object in booking, payment and tenant as well
		roomBooking.RemoveVisitorRoom(object.getRoomNumber());
		removePay.removePaymentList(object.getRoomNumber());
		removePay.updatePayment();
		roomBooking.UpdateData();

		// now remove that tenant object
		tenant.removeTenant(listTenants.getSelectedIndex());

		// update the Jlist again
		listTenants.setListData(tenant.getTenantsList().toArray());

	}

	// refresh button to update the Jlist
	public void refresh() throws FileNotFoundException {
		TenantList tenant = new TenantList();

		tenant.init();

		listTenants.setListData(tenant.getTenantsList().toArray());

	}

}