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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MakeAPayment {

	private JButton goBack; // button go back to main menu
	private JButton search; // button to find the tenant
	private JPanel page; // Jpanel for conatiner
	private JButton Pay; // button to pay that tenant
	private JTextArea tenantResults; // to show the result of tenant details
	private JTextArea paymentResults;// to show the result of payment details

	private JTextField serachBar; // search bar to find the tenant
	private JScrollPane scrollBar; // scroll bar for tenantResults
	private JScrollPane scrollBar2; // scroll bar for paymentResults
	// general labels
	private JLabel info;
	private JLabel info2;
	private JLabel titlePage; // to display an image
	// JCheckBox makes it easier to tick particular payment method rather than
	// entering
	private JCheckBox cash; // cash payemnt
	private JCheckBox card; // card payment
	private JCheckBox cheque; // cheque payment
	private JCheckBox other; // other payment
	private String paymentType; // to hold value of JCheckBox

    private DataTransaction tennatsTransaction;

	// getter method for go back button
	public JButton getGoBackButton() {
		return this.goBack;
	}

	// setter method for payment type
	public void setPayment(String a) {
		paymentType = a;
	}
	// getter method search button
	public JButton getSearchButton() {
		return this.search;
	}
	// getter method paymentType
	public String getPaymentType() {
		return this.paymentType;
	}
	// getter method TenantPayment
	public JButton getTennantPayment() {
		return this.Pay;
	}
	// getter method JCheckBox cash
	public JCheckBox getCash() {
		return this.cash;
	}
	// getter method JCheckBox card
	public JCheckBox getCard() {
		return this.card;
	}
	// getter method JCheckBox cheque
	public JCheckBox getCheque() {
		return this.cheque;
	}
	// getter method JCheckBox other
	public JCheckBox getOther() {
		return this.other;
	}

	public JPanel Container(Object o) throws FileNotFoundException {
		// instantiate Jpanel
		page = new JPanel();
		page.setSize(550, 600);
		page.setLayout(null);

		// instantiate title page
		titlePage = new JLabel("Payment");
		titlePage.setFont(new Font("Serif",Font.ITALIC,27));
		titlePage.setBounds(220, 36, 440, 50);
		page.add(titlePage);


		// instantiate tenants results
		tenantResults = new JTextArea();
		// instantiate search button
		search = new JButton("Search TenantList");
		search.setBounds(380, 122, 140, 50);
		page.add(search);
		search.addActionListener((ActionListener) o);
		// instantiate info label
		info = new JLabel("(Please enter the exact last name of the Tenant) ");
		info.setBounds(7, 86, 440, 50);
		page.add(info);
		// instantiate second info label
		info2 = new JLabel("(Please choose particular payment method) ");
		info2.setBounds(120, 456, 440, 50);
		page.add(info2);
		page.setBackground(Color.decode("#6FC9E9"));
		// instantiate search bar
		serachBar = new JTextField();
		serachBar.setBounds(7, 120, 370, 30);
		serachBar.setFont(new Font("Serif", Font.BOLD, 14));
		page.add(serachBar);
		// instantiate scroll bar
		scrollBar = new JScrollPane(tenantResults);
		scrollBar.setBounds(7, 200, 250, 260);
		page.add(scrollBar);


		tenantResults.setEditable(false);
		// instantiate go back button
		goBack = new JButton("Go Back");
		goBack.setBounds(0, 0, 130, 30);
		page.add(goBack);
		goBack.addActionListener((ActionListener) o); // adding lisnter

		// instantiate JcheckBox for card, cash, cheque and other
		cash = new JCheckBox("Cash");
		cash.addActionListener((ActionListener) o);
		cash.setBounds(120, 490, 60, 30);
		page.add(cash);

		card = new JCheckBox("Card");
		card.addActionListener((ActionListener) o);
		card.setBounds(190, 490, 60, 30);
		page.add(card);

		cheque = new JCheckBox("Cheque");
		cheque.addActionListener((ActionListener) o);
		cheque.setBounds(260, 490, 80, 30);
		page.add(cheque);

		other = new JCheckBox("Other");
		other.addActionListener((ActionListener) o);
		other.setBounds(340, 490, 80, 30);
		page.add(other);

		// instantiate payment Results details
		paymentResults = new JTextArea();
		paymentResults.setEditable(false);
		scrollBar2 = new JScrollPane(paymentResults);
		scrollBar2.setBounds(270, 200, 250, 260);
		page.add(scrollBar2);
		// instantiate  pay button
		Pay = new JButton("Pay");
		Pay.setEnabled(false);
		Pay.setBounds(200, 540, 160, 50);
		page.add(Pay);
		Pay.addActionListener((ActionListener) o); // adding lisnter
        tennatsTransaction = new DataTransaction(Tenant.class);


		return page;

	}

	// search method to get details of the tenant
	// this method is called when the user presses the search button
	public void searchRequest(){
		Pay.setEnabled(false); // Disable the pay button first


		// set both JtextArea to empty
		tenantResults.setText("");
		paymentResults.setText("");
		// this variable collects user input of search value
		String userRequest = serachBar.getText();
		if (userRequest.length()>0 ) { // checks if it conatins in



            List<Object[]> tennatsRow = tennatsTransaction.getDataRows("SELECT Tennants.LastName, Bookings.roomNumber,"+
                            "Tennants.NoAdultVisitors, Tennants.NoMiniorsVisitors, Bookings.noDaysBooked,"+
                            "Bookings.checkIn, Bookings.checkOut  from hotel_project.Bookings, hotel_project.Tennants " +
                            "where hotel_project.Tennants.ID =  " +
                            "hotel_project.Bookings.TennantId and hotel_project.Tennants.LastName = '"+userRequest+"';");



            // then display details of tenant details in first JtextField
            tenantResults.append(
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

            List<Object[]> PaymentRow = tennatsTransaction.getDataRows("SELECT Tax,Total,PaymentType,PaymentStatus FROM hotel_project.Payments, hotel_project.Tennants\n" +
                    "where Payments.TennantId = Tennants.ID and hotel_project.Tennants.LastName = '"+userRequest+"';");
            

            paymentResults.append(
                    "Tax: £" + PaymentRow.get(0)[0]+
                    "\n"
                    + "Total: £" + PaymentRow.get(0)[1]
                    +"\n"
                    + "Payment Type: " + PaymentRow.get(0)[2]
                    + "\n"
                    + "Payment Status: " + PaymentRow.get(0)[3]);



		} else {
			// else show default message which no result is found etc
			tenantResults.setText("");
			paymentResults.setText("");
			tenantResults.append("No resulst found, please double check!");
		}
	}


}