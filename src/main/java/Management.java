/* Name: Mohammed Abdul Wahid
 * Email: ma301ma@gold.ac.uk
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*this class helps to display four buttons, Add tenants, Remove tenant, Search Tenant and Make
 * an payment  
 * 
 * 
 */

public class Management {

	private JButton Addtenants; // button to go Add tenants page
	private JPanel menu; // for
	private JButton returnMenu; // button to back main menu

	private JButton makeAPayment; // button go to make an payment page
	private JButton Removetenants; // // button go to remove tenant page
	private JButton searchTenant; // button go to search tenant page

	// getter method for return main menu
	public JButton getRetrnMenu() {
		return this.returnMenu;
	}

	// getter method for add tenants
	public JButton getAddTenants() {
		return this.Addtenants;
	}

	// getter method remove tenants
	public JButton getRemovetenantsButton() {
		return this.Removetenants;
	}

	// getter method search tenants
	public JButton getSearchTenant() {
		return this.searchTenant;
	}

	// getter method make an payment
	public JButton getMakeAPayment() {
		return this.makeAPayment;
	}

	// relevant icons to display in the buttons
	private Icon add;
	private Icon remove;
	private Icon find;
	private Icon pay;

	public JPanel Container(Object o) {

		// instantiate image icons
		add = new ImageIcon(getClass().getResource("user.png"));
		remove = new ImageIcon(getClass().getResource("delete.png"));
		find = new ImageIcon(getClass().getResource("find.png"));
		pay = new ImageIcon(getClass().getResource("pay.png"));

		// instantiate Jpanel
		menu = new JPanel();
		menu.setSize(550, 600);
		menu.setLayout(null);
		// instantiate Add tenants button
		Addtenants = new JButton("Add Tenants", add);
		Addtenants.setBounds(60, 70, 440, 80);
		Addtenants.setFont(new Font("Serif",Font.BOLD,16)); // font style 
		Addtenants.addActionListener((ActionListener) o);
		// instantiate Add tenants button
		menu.add(Addtenants);
		menu.setBackground(Color.decode("#FFC161")); // sett the background
														// color

		// instantiate remove tenants button
		Removetenants = new JButton("Remove Tenants", remove);
		Removetenants.setBounds(60, 150, 440, 80);
		Removetenants.setFont(new Font("Serif",Font.BOLD,16));
		Removetenants.addActionListener((ActionListener) o);
		menu.add(Removetenants);

		// instantiate make an payment button
		makeAPayment = new JButton("Make A Payment", pay);
		makeAPayment.setBounds(60, 230, 440, 80);
		makeAPayment.setFont(new Font("Serif",Font.BOLD,16));
		makeAPayment.addActionListener((ActionListener) o);
		menu.add(makeAPayment);

		// instantiate search button
		searchTenant = new JButton("Search Tenant", find);
		searchTenant.setBounds(60, 310, 440, 80);
		searchTenant.setFont(new Font("Serif",Font.BOLD,16));
		searchTenant.addActionListener((ActionListener) o);
		menu.add(searchTenant);
		// instantiate return main menu button
		returnMenu = new JButton("Return Main Menu");
		returnMenu.setBounds(140, 440, 240, 50);
		returnMenu.setFont(new Font("Serif",Font.BOLD,16));
		menu.add(returnMenu);

		returnMenu.addActionListener((ActionListener) o); // adding listener

		return menu;

	}

}
