/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * This class helps to store and retrieve tenants details in file text. It stores them in arrayList
 * and hashtable. There are methods that add tenants, remove and search.
 */

public class TenantList {

	// an arraylist of tenant objects
	private ArrayList<Tenant> tenant = new ArrayList<Tenant>();
	// a hashtable that stores the name of the tenant as the key and tenant
	// object as the value
	// hashtable will be useful for searching tenants in my application
	private Hashtable<String, Tenant> searchTenants = new Hashtable<String, Tenant>();
	private String FILE_PATH_NAME;

	// this method reads the tenant details and stores them in the arraylist
	public void init() throws FileNotFoundException {
		// exception handling
		try {
			FILE_PATH_NAME = System.getProperty("user.dir") + "/src/main/resources/TenantData.txt";
			System.out.println(new File("").getAbsoluteFile() );
			// scanner object to read the file
			Scanner s = new Scanner(new FileReader(FILE_PATH_NAME));

			String z;
			// once the file is reading
			while (s.hasNext()) {
				z = s.nextLine(); // collect the string line
				String[] space = z.split(" "); // split it up in arrays
				// store them in the arraylist
				tenant.add(new Tenant(space[0], space[1], space[2],
						space[3], space[4], Integer.parseInt(space[5]), Integer
								.parseInt(space[6])));
			}

			s.close(); // close the scanner object
			// display message if any error in the file
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "please double check!",
					"File failed tokjnj update", JOptionPane.ERROR_MESSAGE);
		}

	}

	// store all tenant object from the arraylist inside the hashtable
	public void initSearchTenant() {
		// for loop to iterate via arraylist
		for (int i = 0; i < tenant.size(); i++) {
			// put them in a hashtable
			// first input tenants name and second tenant object
			searchTenants.put(tenant.get(i).getFirstName() + " "
					+ tenant.get(i).getLastName(), tenant.get(i));

		}
	}

	// add tenant into text file
	public void addTenant(String title, String firstName, String lastName,
			String adults, String miniors, int noDays, int rm, boolean writeData) {
		// file writer object
		FileWriter writer;
		try {
			File tenantDetails = new File(FILE_PATH_NAME);
			// creates a new file
			tenantDetails.createNewFile();

			// creates a FileWriter Object
			// if writeData is true then dont erase or false then erase
			// everything
			// i use this boolean value to determine if the file needs re write
			// again
			writer = new FileWriter(tenantDetails, writeData);
			// write the content into file text
			writer.write(title + " " + firstName + " " + lastName + " "
					+ adults + " " + miniors + " " + noDays + " " + rm + "\n");
			writer.flush();
			writer.close();

		}
		// display message if any error in the file
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Your TenantData file failed to update, "
							+ "please double check!",
					"File failed to upfsvfddate", JOptionPane.ERROR_MESSAGE);
		}

	}

	// remove tenant from the arraylist by entering the index value
	// then update the text file
	public void removeTenant(int index) {

		if (tenant.size() > 0) {
			tenant.remove(index);

			// update the file again
			FileWriter writer;
			try {
				File tenantDetails = new File(FILE_PATH_NAME);
				// creates a new file
				tenantDetails.createNewFile();

				// creates a FileWriter Object
				writer = new FileWriter(tenantDetails);
				for (int i = 0; i < tenant.size(); i++) {
					writer.write(tenant.get(i).getTitle() + " "
							+ tenant.get(i).getFirstName() + " "
							+ tenant.get(i).getLastName() + " "
							+ tenant.get(i).getNoAdultVisitors() + " "
							+ tenant.get(i).getNoMinorsVisitors() + " "
							+ tenant.get(i).getNoDaysBooked() + " "
							+ tenant.get(i).getRoomNumber() + "\n");
				}
				writer.flush();
				writer.close();

			}
			// display message if any error in the file
			catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Your TenantData file failed to update, "
								+ "please double check!",
						"File failed to remove tenant",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	// to find particular tenant from hashtable
	public Tenant findTenant(String name) {
		return searchTenants.get(name);
	}

	// getter method for hashtable of tenants
	public Hashtable<String, Tenant> getSearchTenant() {
		return this.searchTenants;
	}
	// getter method for tenant object by entering room number 
	public int getTenantObject(int a) {
		return tenant.get(a).getRoomNumber();
	}

	// getter method for arraylist of tenants
	public ArrayList<Tenant> getTenantsList() {
		return this.tenant;
	}

}
