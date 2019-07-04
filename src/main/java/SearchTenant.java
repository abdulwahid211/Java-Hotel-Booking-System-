/* Name: Mohammed Abdul Wahid
 * Email: ma301ma@gold.ac.uk
 */

import data.DataTransaction;
import model.Tenant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/* This class helps to find particular tenant from the Text File. 
 * The user enters exact full name of the tenant to see their details.  
 */
public class SearchTenant {

	private JButton goBack; // button to go back
	private JButton search; // button to search
	private JPanel page; // Jpanel
	private JLabel info2;
	private JButton listTennant; // to show list of tenants
	private JTextArea showResult; // to show the result from the search bar
	private JLabel info; // label info
	private JTextField searchBar; // to show the result from the search bar
	private JScrollPane scrollBar; // scroll bar for serach Bar

	private DataTransaction tennatsTransaction;

	// getter method for go back button
	public JButton getGoBackButton() {
		return this.goBack;
	}

	// getter method for search button
	public JButton getSearchButton() {
		return this.search;
	}

	// getter method for tenants f
	public JButton getTennant() {
		return this.listTennant;
	}

	public JPanel Container(Object o) throws FileNotFoundException {
		// instantiate Jpanel
		page = new JPanel();
		page.setSize(550, 600);
		page.setLayout(null);
		// instantiate JLabel
		info = new JLabel("(Please enter the exact full name of the TenantList) ");
		info.setBounds(7, 112, 440, 50);
		page.add(info);
		page.setBackground(Color.decode("#6FC9E9"));
		// instantiate show results
		showResult = new JTextArea();
		search = new JButton("Search TenantList");
		search.setBounds(7, 173, 140, 50);
		page.add(search);
		search.addActionListener((ActionListener) o);
		// instantiate JLabel
		info2 = new JLabel("Find TenantList"); 
		info2.setFont(new Font("Serif",Font.ITALIC,35)); 
		info2.setBounds(140, 36, 440, 50);
		page.add(info2);

		// instantiate search bar
		searchBar = new JTextField();
		searchBar.setBounds(7, 145, 300, 30);
		searchBar.setFont(new Font("Serif", Font.BOLD, 14)); // display font
		page.add(searchBar);

		// instantiate scroll bar
		scrollBar = new JScrollPane(showResult);
		scrollBar.setBounds(7, 240, 400, 220);
		page.add(scrollBar);


		// instantiate JtextArea
		showResult.setFont(new Font("Serif", Font.BOLD, 20)); // display font
		showResult.setEditable(false);
		goBack = new JButton("Go Back");
		goBack.setBounds(0, 0, 130, 30);
		page.add(goBack);
		goBack.addActionListener((ActionListener) o); // adding lisnter

		// instantiate Jbutton
		listTennant = new JButton("TenantList List");
		listTennant.setBounds(7, 460, 160, 50);
		page.add(listTennant);
		listTennant.addActionListener((ActionListener) o); // adding lisnter

		tennatsTransaction = new DataTransaction(Tenant.class);


		return page;

	}


	public void searchRequest() {
		// set both JtextArea to empty
		showResult.setText(" ");// set the result empty
		// this variable collects user input of search value
		String userRequest = searchBar.getText();
		if (userRequest.length()>0 ) { // checks if it conatins in



			java.util.List<Object[]> tennatsRow = tennatsTransaction.getDataRows("SELECT Tennants.LastName, Bookings.roomNumber,"+
					"Tennants.NoAdultVisitors, Tennants.NoMiniorsVisitors, Bookings.noDaysBooked,"+
					"Bookings.checkIn, Bookings.checkOut  from hotel_project.Bookings, hotel_project.Tennants " +
					"where hotel_project.Tennants.ID =  " +
					"hotel_project.Bookings.TennantId and hotel_project.Tennants.LastName = '"+userRequest+"';");



			// then display details of tenant details in first JtextField
			showResult.append(
					"Name: " + tennatsRow.get(0)[0]
							+"\n"
							+ "Room Number: " + tennatsRow.get(0)[1]
							+"\n"
							+ "Num of Adults staying: " + tennatsRow.get(0)[2]
							+ "\n"
							+ "Num of Minors Staying: "
							+ tennatsRow.get(0)[3] + "\n"
							+ "Num of days staying: " + tennatsRow.get(0)[4]
							+ "\n"
							+ "Check In: " + tennatsRow.get(0)[5]
							+ "\n"
							+ "Check Out: " + tennatsRow.get(0)[6]
			);


		} else {
			// else show default message which no result is found etc
			showResult.setText("");
			showResult.append("No resulst found, please double check!");
		}
	}

}