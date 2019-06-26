/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/* This class helps to find particular tenant from the Text File. 
 * The user enters exact full name of the tenant to see their details.  
 */
public class SearchTenant {
//
//	private JButton goBack; // button to go back
//	private JButton search; // button to search
//	private JPanel page; // Jpanel
//	private JLabel info2;
//	private JButton listTennant; // to show list of tenants
//	private JTextArea showResult; // to show the result from the search bar
//	private JLabel info; // label info
//	private JTextField searchBar; // to show the result from the search bar
//	private JScrollPane scrollBar; // scroll bar for serach Bar
//
//	// getter method for go back button
//	public JButton getGoBackButton() {
//		return this.goBack;
//	}
//
//	// getter method for search button
//	public JButton getSearchButton() {
//		return this.search;
//	}
//
//	// getter method for tenants f
//	public JButton getTennant() {
//		return this.listTennant;
//	}
//
//	public JPanel Container(Object o) throws FileNotFoundException {
//		// instantiate Jpanel
//		page = new JPanel();
//		page.setSize(550, 600);
//		page.setLayout(null);
//		// instantiate JLabel
//		info = new JLabel("(Please enter the exact full name of the TenantList) ");
//		info.setBounds(7, 112, 440, 50);
//		page.add(info);
//		page.setBackground(Color.decode("#6FC9E9"));
//		// instantiate show results
//		showResult = new JTextArea();
//		search = new JButton("Search TenantList");
//		search.setBounds(7, 173, 140, 50);
//		page.add(search);
//		search.addActionListener((ActionListener) o);
//		// instantiate JLabel
//		info2 = new JLabel("Find TenantList");
//		info2.setFont(new Font("Serif",Font.ITALIC,35));
//		info2.setBounds(140, 36, 440, 50);
//		page.add(info2);
//
//		// instantiate search bar
//		searchBar = new JTextField();
//		searchBar.setBounds(7, 145, 300, 30);
//		searchBar.setFont(new Font("Serif", Font.BOLD, 14)); // display font
//		page.add(searchBar);
//
//		// instantiate scroll bar
//		scrollBar = new JScrollPane(showResult);
//		scrollBar.setBounds(7, 240, 400, 220);
//		page.add(scrollBar);
//
//
//		// instantiate JtextArea
//		showResult.setFont(new Font("Serif", Font.BOLD, 20)); // display font
//		showResult.setEditable(false);
//		goBack = new JButton("Go Back");
//		goBack.setBounds(0, 0, 130, 30);
//		page.add(goBack);
//		goBack.addActionListener((ActionListener) o); // adding lisnter
//
//		// instantiate Jbutton
//		listTennant = new JButton("TenantList List");
//		listTennant.setBounds(7, 460, 160, 50);
//		page.add(listTennant);
//		listTennant.addActionListener((ActionListener) o); // adding lisnter
//
//		return page;
//
//	}
//
//	// the method uses the hashtable from tenant list object to find
//	// if it does not, it shows no result found
//	public void searchRequest() throws FileNotFoundException {
//		Hashtable findTenant; // hashtable to find tenant
//		TenantList tenants; // tenant object
//		// instantiate tenant object
//		tenants = new TenantList();
//		tenants.init(); // load up the array list
//		tenants.initSearchTenant(); // load up the hashtable as well
//		findTenant = tenants.getSearchTenant(); // refrence the hashtable
//
//		showResult.setText(" ");// set the result empty
//		String userRequest = searchBar.getText(); // get the uer input from
//													// search bar
//		if (findTenant.containsKey(userRequest)) {// if it contains hashtable
//													// display it
//			// collect the tenant object
//			Tenant tenant = (Tenant) findTenant.get(userRequest);
//			// display tenant object on the JTextArea
//			showResult.append("Name: " + tenant.getTitle() + " "
//					+ tenant.getFirstName() + " " + tenant.getLastName() + "\n"
//					+ "Room Number: " + tenant.getRoomNumber() + "\n"
//					+ "Num of Adults staying: " + tenant.getNoAdultVisitors()
//					+ "\n" + "Num of Minors Staying: "
//					+ tenant.getNoMinorsVisitors() + "\n"
//					+ "Num of days staying: " + tenant.getNoDaysBooked());
//
//		} else {
//			// if no results not found display simple message
//			showResult.setText(" ");
//			showResult.append("No resulst found, please double check!");
//		}
//	}

}