
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* During the assignment it was difficult to switch different JPanels and  components with other classes,
 * so therefore i made this class as the main JFrame in which i can change JPanels
 * this happens through the use of CardLayout object. This allows me switch JPanels when user presses a button.
 * 
 * All the buttons  in the program has to be called in this class because it is only one that 
 * extends JFrame and implements Action listener, this helps to efficiently change JPanel layouts  
 * 
 * I used  all instance objects to call their JPanel function to display in this main GUI panel
 * 
 */

public class MainMenu extends JFrame implements ActionListener,ItemListener {
	// Implements the action listener so all buttons can be performed in the
	// program
	// securing all global variables and object as private
	// most of these instance objects displays individual relevant
	// JPanel(container)
	// and perform certain actions
	private Management ManagementPage; // management object for the utility
	private AddTenant addTenantButton; // addTenant object to add tenanrs
//	private showAllRooms showAllrooms; // to display all room tables
//	private RemoveTenant removeTenantPage; // container to remove tenant
//	private MakeAPayment makeAPayment; // to make an payment
//	private SearchTenant searchTenant; // search tenant
//	private showAllTenants showAlltenants; // to display all all tenants
//	private showAllPayments showPaymentsPage; // show all payments

	private JPanel switchPanels; // a panel that uses CardLayout
	// main buttons for the main menu
	private JButton managment; // button for adding, removing, booking tenants
	private JPanel menu; // main Jpanel for the Main Menu when the program
							// executes
	// room and make payments
	private JButton showPaymentList; // button to show you a payments list of
										// tenants to pay
	private JButton roomAvailable; // to see what rooms are currently available

	private JButton justExit; // exit the program

	// icons to display for my buttons
	private Icon pencil;
	private Icon exit;
	private Icon payList;
	private Icon tenList;

	// constructor for the main menu
	// All classes in the program has been set layout to null, which is an
	// absolute position
	// it allows me to position any components in the Jframe such as
	// All components uses setBounds function to position place and change the
	// height & weight
	public MainMenu() throws FileNotFoundException {
		super("Abdul Wahid's PAP JAVA CW3");



		// instantiate all instance object
		addTenantButton = new AddTenant();
//		showPaymentsPage = new showAllPayments();
//		removeTenantPage = new RemoveTenant();
//		makeAPayment = new MakeAPayment();
		ManagementPage = new Management();
//		searchTenant = new SearchTenant();
//		showAllrooms = new showAllRooms();
//		showAlltenants = new showAllTenants();
		// instantiate main Jpanel container
		menu = new JPanel();

		menu.setBackground(Color.decode("#6FC9E9"));
		menu.setLayout(null);
		menu.setSize(550, 500);

		// instantiate all picture icons
		pencil = new ImageIcon(getClass().getResource("pencil.png"));
		exit = new ImageIcon(getClass().getResource("exit.png"));
		payList = new ImageIcon(getClass().getResource("pay.png"));
		tenList = new ImageIcon(getClass().getResource("room.png"));

		// instantiate for management button
		managment = new JButton("Management", pencil);
		managment.setBounds(60, 70, 440, 80);
		// using font style for buttons
		managment.setFont(new Font("Serif", Font.BOLD, 20));
		managment.addActionListener(this);
		menu.add(managment);

		// instantiate for payment list button
		showPaymentList = new JButton("Payment List", payList);
		showPaymentList.setBounds(60, 160, 440, 80);
		// using font style for buttons
		showPaymentList.setFont(new Font("Serif", Font.BOLD, 20));
		showPaymentList.addActionListener(this);
		menu.add(showPaymentList);
		// instantiate for room available button
		roomAvailable = new JButton("Room Available", tenList);
		roomAvailable.setBounds(60, 260, 440, 80);
		// using font style for buttons
		roomAvailable.setFont(new Font("Serif", Font.BOLD, 20));
		roomAvailable.addActionListener(this);
		menu.add(roomAvailable);

		// instantiate for exit button
		justExit = new JButton("Exit Appication", exit);
		justExit.setBounds(144, 420, 240, 50);
		menu.add(justExit);
		justExit.addActionListener(this); // adding lisnter

		// Create the panel that contains the "switchPanels".
		// Here i used the Cardlayout for Jpanel to switch conatiners in the
		// program
		switchPanels = new JPanel(new CardLayout());
		// i add all Jpanel function from the object to the main layout
		// each layout represent individual pages
		switchPanels.add(menu, "returnMenu");
		switchPanels.add(ManagementPage.Container(this), "managementPage");
//		switchPanels.add(makeAPayment.Container(this), "makeAPayment");
//		switchPanels.add(showAllrooms.Container(this), "showAllrooms");
//		switchPanels.add(showAlltenants.Container(this), "showAlltenants");
//		switchPanels.add(showPaymentsPage.Container(this), "showPaymentsPage");
		switchPanels.add(addTenantButton.Container(this), "addTenantPage");
//		switchPanels.add(removeTenantPage.Container(this), "removeTenantPage");
//		switchPanels.add(searchTenant.Container(this), "searchTenant");
		add(switchPanels); // finally add the main Jpanel to the Jframe
	}

	@Override
	// all buttons from other objects are called
	// inside actionPerformed method
	// actionPerformed method to perform action for all buttons
	// As the user presses any button it will change pages the CardLayout Jpanel
	// to their relevant GUI interface
	public void actionPerformed(ActionEvent e) {
		// CardLayout object
		setSize(550, 500); // return to default size
		CardLayout changePages = (CardLayout) (switchPanels.getLayout());
		// button for exit application
		if (e.getSource() == justExit) {
			System.exit(0);// terminate the program
		}
		// button for switch management page,
		if (e.getSource() == managment) {

			changePages.show(switchPanels, "managementPage");
			setSize(550, 520);// size for manangement page
		}
		// button to see room availability,
		if (e.getSource() == roomAvailable) {
			changePages.show(switchPanels, "showAllrooms");

		}
		// button for switch back to main menu
		if (e.getSource() == ManagementPage.getRetrnMenu()) {
			changePages.show(switchPanels, "returnMenu");

		}
		// button for add tenant page ,
		if (e.getSource() == ManagementPage.getAddTenants()) {
			changePages.show(switchPanels, "addTenantPage");

			setSize(550, 730); // set size for the Add tenants page
		}
		// button for remove tenant page,
		if (e.getSource() == ManagementPage.getRemovetenantsButton()) {
			changePages.show(switchPanels, "removeTenantPage");

			setSize(550, 550); // set size for the remove tenants page
		}
		// button for make an payment page,
		if (e.getSource() == ManagementPage.getMakeAPayment()) {
			changePages.show(switchPanels, "makeAPayment");

			setSize(550, 650); // set size for the payment page
		}
		// button for make an search page,
		if (e.getSource() == ManagementPage.getSearchTenant()) {
			changePages.show(switchPanels, "searchTenant");

			setSize(450, 600); // set size for the search tenants page
		}

		// if (e.getSource() == showAllrooms.getGoBackButton()) {
		// changePages.show(switchPanels, "returnMenu");

		// }
		// button for to leave the remove tenant page
//		if (e.getSource() == removeTenantPage.getGoBackButton()) {
//			changePages.show(switchPanels, "managementPage");
//			setSize(550, 520);// size for manangement page
//		}
//		// button for to leave the payment page
//		if (e.getSource() == makeAPayment.getGoBackButton()) {
//			changePages.show(switchPanels, "managementPage");
//
//			setSize(550, 520);// size for manangement page
//		}
//		// button for remove tenant
//		if (e.getSource() == removeTenantPage.getRemoveTennantButton()) {
//			// exception handling to avoid any errors
//			try {
//				removeTenantPage.remove(); // once the has user pressed remove
//											// tenant
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//			setSize(550, 550); // set size for the remove tenants page
//		}
//		// button to refresh remove tenant page
//		if (e.getSource() == removeTenantPage.getRefreshButton()) {
//			// exception handling to avoid any errors
//			try {
//				removeTenantPage.refresh();// once the has user pressed it will
//											// refresh tenant
//				;
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//			setSize(550, 550); // set size for the remove tenants page
//		}
		// button to back to the management page
		if (e.getSource() == addTenantButton.getGoBackButton()) {
			changePages.show(switchPanels, "managementPage");
			setSize(550, 520);// size for manangement page
		}
		// button to add tenants
		if (e.getSource() == addTenantButton.getAddTenantsButton()) {
			try {
				addTenantButton.addTenants();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setSize(550, 730); // set size for the Add tenants page
		}
		// button to refresh page in add tenants page
		if (e.getSource() == addTenantButton.getRefresh()) {
			try {
				addTenantButton.displayRoomTable();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setSize(550, 730); // set size for the Add tenants page
		}
		// button for calculate tenant payments
		if (e.getSource() == addTenantButton.getCaluclate()) {
			addTenantButton.showPrice();
			setSize(550, 730); // set size for the Add tenants page

		}
		// listen for Jcombo button for title or No adults and minors
		if (e.getSource() == addTenantButton.getTitle()
				|| e.getSource() == addTenantButton.getNoMinors()
				|| e.getSource() == addTenantButton.getNoAdults()) {

			setSize(550, 730); // set size for the Add tenants page

		}
		// button to go back to search tenant
//		if (e.getSource() == searchTenant.getGoBackButton()) {
//
//			// setSize(350, 330); // set size for page
//			changePages.show(switchPanels, "managementPage");
//			setSize(550, 520);// size for manangement page
//		}
//		// button to that particular search tenant
//		if (e.getSource() == searchTenant.getSearchButton()) {
//
//			setSize(450, 600); // set size for the search tenants page
//			try {
//				searchTenant.searchRequest();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//		}
//		// find tenant who wants to pay
//		if (e.getSource() == makeAPayment.getSearchButton()) {
//
//			setSize(550, 730); // set size for page
//			try {
//				makeAPayment.searchRequest();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			setSize(550, 650); // set size for the payment page
//		}
//
//		// JCheckBox button to select cash type in the make a payment page
//		if (e.getSource() == makeAPayment.getCash()) {
//			// deselect everything else
//			makeAPayment.getCard().setSelected(false);
//			makeAPayment.getCheque().setSelected(false);
//			makeAPayment.getOther().setSelected(false);
//			setSize(550, 650); // set size for the payment page
//
//			makeAPayment.setPayment("Cash");
//		}
//		// JCheckBox button to select card type in the make a payment page
//		if (e.getSource() == makeAPayment.getCard()) {
//			// deselect everything else
//			makeAPayment.getCash().setSelected(false);
//			makeAPayment.getCheque().setSelected(false);
//			makeAPayment.getOther().setSelected(false);
//			setSize(550, 650); // set size for the payment page
//			makeAPayment.setPayment("Card");
//		}
//		// JCheckBox button to select cheque type in the make a payment page
//		if (e.getSource() == makeAPayment.getCheque()) {
//			// deselect everything else
//			makeAPayment.getCash().setSelected(false);
//			makeAPayment.getCard().setSelected(false);
//			makeAPayment.getOther().setSelected(false);
//			setSize(550, 650); // set size for the payment page
//
//			makeAPayment.setPayment("Cheque");
//		}
//		// JCheckBox button to select other type in the make a payment page
//		if (e.getSource() == makeAPayment.getOther()) {
//			// deselect everything else
//			makeAPayment.getCash().setSelected(false);
//			makeAPayment.getCard().setSelected(false);
//			makeAPayment.getCheque().setSelected(false);
//			setSize(550, 650); // set size for the payment page
//			// set the other string
//			makeAPayment.setPayment("Other");
//		}
//		// button to make an payment
//		if (e.getSource() == makeAPayment.getTennantPayment()) {
//
//
//			try {
//				makeAPayment.pay();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		// button to search tenant
//		if (e.getSource() == searchTenant.getTennant()) {
//			changePages.show(switchPanels, "showAlltenants");
//
//		}
//		// button to go back
//		if (e.getSource() == showAlltenants.getGoBackButton()) {
//			changePages.show(switchPanels, "searchTenant");
//			setSize(450, 600); // set size for the search tenants page
//		}
//		// button to refresh
//		if (e.getSource() == showAlltenants.getRefreshButton()) {
//			try {
//				showAlltenants.refreshPage();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		// button to go back main menu
//		if (e.getSource() == showAllrooms.getGoBackButton()) {
//			changePages.show(switchPanels, "returnMenu");
//
//		}
//		// button to refresh all room page
//		if (e.getSource() == showAllrooms.getRefreshButton()) {
//			try {
//				showAllrooms.refreshPage();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
		// button to display payment list page
		if (e.getSource() == showPaymentList) {
			changePages.show(switchPanels, "showPaymentsPage");

		}
//		// button to go back to main menu
//		if (e.getSource() == showPaymentsPage.getGoBackButton()) {
//			changePages.show(switchPanels, "returnMenu");
//		}
//		// button for refresh page
//		if (e.getSource() == showPaymentsPage.getRefreshButton()) {
//			try {
//				showPaymentsPage.refreshPage();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}
}
