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
 * This class helps to store and retrieve payments details in file text. It stores them in arrayList
 * and hashtable. There are methods that add payments, remove and search.
 */

public class PaymentList {

	// a list of payment objects
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	// a hashtable that stores the name of the tenant as the key and payments
	// object as the value
	// hashtable will be useful for searching payments in search payment page
	private Hashtable<String, Payment> searchPayments = new Hashtable<String, Payment>();
	private static final int rateDay = 200; // the rate that apply each
	private String FILE_PATH_NAME;

	// this method reads the payment details and stores them in the arraylist
	public void init() throws FileNotFoundException {
		// exception handling
		try {

			FILE_PATH_NAME = System.getProperty("user.dir") + "/src/main/resources/PaymentList.txt";
			// scanner object to read the file
			Scanner s = new Scanner(new FileReader(FILE_PATH_NAME));

			String z;
			// once the file is reading
			while (s.hasNext()) {
				z = s.nextLine();// collect the string line
				String[] space = z.split(" "); // split it up in arrays
				// store them in the arraylist
				payments.add(new Payment(space[0] + " " + space[1], Integer
						.parseInt(space[2]), Integer.parseInt(space[3]),
						space[4], space[5]));
			}

			s.close();

		}
		// display notification message if any error in the file
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "please double check!",
					"File failed to update", JOptionPane.ERROR_MESSAGE);
		}

	}

	// remove payment from the arraylist by entering the room number
	public void removePaymentList(int roomNumber) {
		// use for loop to iterate
		for (int i = 0; i < payments.size(); i++) {
			// if found
			if (payments.get(i).getRoom() == roomNumber) {
				payments.remove(i);// remove from the arraylist
			}
		}
	}

	// add payment into text file
	public void addPayment(String customerName, int nod, int roomNum,
			String paymentSta, String type, boolean writeData) {
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
			writer.write(customerName + " " + nod + " " + roomNum + " "
					+ paymentSta + " " + type + "\n");
			writer.flush();
			writer.close();

		}
		// display notification message if any error in the file
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Your TenantData file failed to update, "
							+ "please double check!", "File failed to update",
					JOptionPane.ERROR_MESSAGE);
		}

	}
  // method for edit values in payment object, then update them in the arraylist 
	public void editPayment(int roomNumber, String payment, String paymentType) {
		// use the for loop to iterate 
		for (int i = 0; i < payments.size(); i++) {
		// if the room numbe is found 
			if (payments.get(i).getRoom() == roomNumber) {
             // update the payment details 
				payments.get(i).setPaymentStatus(payment);
				payments.get(i).setPaymentType(paymentType);
			}
		}
	}
 
	//update the text file
	public void updatePayment() {

		FileWriter writer;
		try {
			File tenantDetails = new File(FILE_PATH_NAME);
			// creates a new file
			tenantDetails.createNewFile();

			// creates a FileWriter Object
			writer = new FileWriter(tenantDetails);
			for (int i = 0; i < payments.size(); i++) {
				writer.write(payments.get(i).getcustomerName() + " "
						+ payments.get(i).getNumOfDays() + " "
						+ payments.get(i).getRoom() + " "
						+ payments.get(i).getPaymentStutus() + " "
						+ payments.get(i).getPaymentType() + "\n");
			}
			writer.flush();
			writer.close();

		}
		// display notification message if any error in the file
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Your Payment file failed to update, "
							+ "please double check!", "File failed to update",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	// store all payment object from the arraylist inside the hashtable
	public void initSearchTenant() {
		// for loop to iterate via arraylist
		for (int i = 0; i < payments.size(); i++) {
			// put them in a hashtable
						// first input tenants name and second payment object
			searchPayments.put(payments.get(i).getcustomerName(),
					payments.get(i));

		}
	}
  // getter method for hashtable of payments 
	public Hashtable<String, Payment> getSearchPayment() {
		return this.searchPayments;
	}
	 // getter method for arraylist of payments
	public ArrayList<Payment> getPaymentsList() {
		return this.payments;
	}

	// public return method for tax calculation
	public double totalCal(int num) {
		return num * rateDay;
	}

}
