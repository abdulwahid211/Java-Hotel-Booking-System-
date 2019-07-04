/*
   Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */


import data.DataTransaction;
import model.Booking;
import model.Payment;
import model.Tenant;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// this class contains all J swing components to run the Add tenants page 


public class AddTenant implements util {


    private JTextField firstName; // first name of tennant to enter
    private JTextField lastName; // last name of tennant to enter
    private JTextField roomNumber; // room number of tennant to enter
    // book
    private JButton Addtenants; // button for adding, and storing all data in
    // the text files
    private JButton refresh; // button to refresh table
    private JTextArea CheckOutData;
    private JScrollPane scrollBar; // scroll bar for the table
    private JScrollPane scrollBar2;// scroll bar for JtextArea CheckOutData
    // i need the scroll bar for JtextArea in order to display, without it. The
    // JText wont display because the layout is set to null

    // labels for the forms and give some info to the user
    private JLabel TitleLabel; // title label
    private JLabel firstNameLabel; // firstname label
    private JLabel lastNameLabel; // lastname label
    private JLabel NoOfAdultsLabel; // No of adults label
    private JLabel NoOfMinorsLabel; // No of minors label
    private JLabel roomNumberlabel; // room label
    private JLabel CheckOutLabel; // estimation price label
    private JLabel CheckOutInfo; // price label
    private JLabel tableInfo; // table label
    private JLabel icon; // label to display an image for the page

    // drop down boxes
    //
    private JComboBox title; // drop down box for title
    private JComboBox adults; // drop down box for No of adults
    private JComboBox minors;// drop down box for No of minors
    private JTable table; //table to display room availability
    // there are string arrays for JComoBoc objects to display drop down
    private static final String[] titles = {"Mr", "Ms", "Miss", "Mrs", "Dr",
            "Prof"};
    private static final String[] noAdults = {"1", "2", "3", "4"};
    private static final String[] noMinors = {"0", "1", "2", "3", "4"};
    // columns name for the Jtable
    String column_names[] = {"Room Number", "Room Status", "Visitor Name"};
    // TableModel object to store the cell value of other objects.
    private DefaultTableModel tableModel;
    // file
    Icon picture;
    JPanel page; // to display the interface layout
    private JButton goBack; // button to go back to previous page


    private DataTransaction tennatsTransaction;
    private DataTransaction bookingTransaction;
    private DataTransaction paymentTransaction;




    // getter method for go back button
    public JButton getGoBackButton() {
        return this.goBack;
    }

    // getter method for title drop down
    public JComboBox getTitle() {
        return this.title;
    }

    // getter method for refresh page
    public JButton getRefresh() {
        return this.refresh;
    }

    // getter method for No of minors drop down box
    public JComboBox getNoMinors() {
        return this.minors;
    }

    // getter method for adults No of adults
    public JComboBox getNoAdults() {
        return this.adults;
    }

    // getter method for add tenants
    public JButton getAddTenantsButton() {
        return this.Addtenants;
    }


    public JPanel Container(Object o)  {
        // instantiating all object in the method
        picture = new ImageIcon(getClass().getResource("/user.png"));

        page = new JPanel(); // the interface container to add all JComponents
        // for my GUI
        page.setBackground(Color.decode("#6FC9E9")); // background color
        page.setSize(750, 1200);
        page.setLayout(null); // set layout to null

        // image for add tenants page
        icon = new JLabel(picture);
        icon.setBounds(120, -16, 200, 100);
        page.add(icon);
        // title label
        TitleLabel = new JLabel("Title :");
        TitleLabel.setBounds(100, 60, 220, 30);
        page.add(TitleLabel);

        // drop down box title
        title = new JComboBox(titles);
        title.setBounds(146, 60, 150, 30);
        title.addActionListener((ActionListener) o);
        page.add(title);
        // firstName label
        firstNameLabel = new JLabel("First Name :");
        firstNameLabel.setBounds(60, 95, 220, 30);
        page.add(firstNameLabel);
        // Text Field to enter firstName
        firstName = new JTextField();
        firstName.setBounds(146, 95, 250, 30);
        page.add(firstName);
        // Text Field to enter lastName
        lastNameLabel = new JLabel("Last Name :");
        lastNameLabel.setBounds(60, 130, 220, 30);
        page.add(lastNameLabel);
        lastName = new JTextField();
        lastName.setBounds(146, 130, 250, 30);
        page.add(lastName);
        // no of adults label
        NoOfAdultsLabel = new JLabel("No. of Adults: ");
        NoOfAdultsLabel.setBounds(48, 165, 220, 30);
        page.add(NoOfAdultsLabel);
        // no of minors label
        NoOfMinorsLabel = new JLabel("Minors:");
        NoOfMinorsLabel.setBounds(225, 165, 220, 30);
        page.add(NoOfMinorsLabel);
        // instantiating the J drop down box for No of Adults
        adults = new JComboBox(noAdults);
        adults.setBounds(146, 165, 70, 30);
        adults.addActionListener((ActionListener) o);
        page.add(adults);
        // instantiating the J drop down box for No of Minors
        minors = new JComboBox(noMinors);
        minors.setBounds(290, 165, 70, 30);
        minors.addActionListener((ActionListener) o);
        page.add(minors);
        // room number label
        roomNumberlabel = new JLabel("Room No:");
        roomNumberlabel.setBounds(75, 200, 220, 30);
        page.add(roomNumberlabel);
        // J text field to enter room number
        roomNumber = new JTextField();
        roomNumber.setBounds(146, 200, 220, 30);
        page.add(roomNumber);

        // Check Out info label
        CheckOutInfo = new JLabel("yyyy-MM-dd");
        CheckOutInfo.setBounds(148, 237, 220, 30);
        page.add(CheckOutInfo);
        // CheckOut price label
        CheckOutLabel = new JLabel("Checkout date:");
        CheckOutLabel.setBounds(50, 260, 220, 30);
        page.add(CheckOutLabel);

        // button to add tenants
        Addtenants = new JButton("Add TenantList");
        Addtenants.setBounds(150, 360, 240, 50);
        Addtenants.setFont(new Font("Serif", Font.BOLD, 16));
        page.add(Addtenants);
        Addtenants.addActionListener((ActionListener) o);// Reference action
        // listener
        // to display simple box of rough calculation
        CheckOutData = new JTextArea(5, 10);
        page.add(CheckOutData);

        scrollBar2 = new JScrollPane(CheckOutData);
        scrollBar2.setBounds(146, 264, 260, 30);
        page.add(scrollBar2);
        CheckOutData.setText("");

        // instantiating go back button
        goBack = new JButton("< Go Back");
        goBack.setBounds(0, 0, 130, 30);
        page.add(goBack);
        goBack.addActionListener((ActionListener) o); // Reference action
        // listener
        // instantiating refresh button
        refresh = new JButton("Refresh");
        refresh.setBounds(100, 640, 330, 40);
        refresh.setFont(new Font("Serif", Font.BOLD, 14));
        page.add(refresh);
        refresh.addActionListener((ActionListener) o); // Reference action
        // listener
        // instantiating table model object
        tableModel = new DefaultTableModel(column_names, 0);
        // table info label
        tableInfo = new JLabel(
                "Room Availability Table  (Please press the refresh button to see )");
        tableInfo.setBounds(6, 400, 500, 50);
        page.add(tableInfo);
        // pass table model object to the actual Jtable object
        table = new JTable(tableModel);


        tennatsTransaction = new DataTransaction(Tenant.class);

        bookingTransaction = new DataTransaction(Booking.class);

        paymentTransaction = new DataTransaction(Payment.class);

        // i decided to put all variables and object of Jtable
        // in a method, so it allows to re initialise the file handling, if any
        // updates happen
        // as i can call the method again when the staff member
        // presses the refresh button and add tenant
        displayData();

        page.add(table);
        // scroll bar for the room table
        scrollBar = new JScrollPane(table);
        scrollBar.setBounds(5, 435, 540, 180);
        page.add(scrollBar);

        return page;

    }

    // this is the non return method that adds all tenant details in the text
    // file
    // this method get called when user presses the add tenant button
    // throw file handing exception, if file cannot be found
    public void addTenants() {
        // this is the function that removes old data in the table and then
        // updates the new one
        // so therefore it prevents duplicates in the table
        removeTableContent(tableModel);
        // two boolean return function checkNumber() to ensure both names are
        // words only
        firstName.getText().replaceAll("\\s+", "");
        lastName.getText().replaceAll("\\s+", "");


        boolean firstNameWordOnly = checkNumber(firstName.getText());
        boolean lastNameWordOnly = checkNumber(lastName.getText());


        if (firstNameWordOnly && lastNameWordOnly) {
            // file handling to prevent wrong input
            try { // try method


                if (firstName.getText().length() > 0
                        && lastName.getText().length() > 0
                        && roomNumber.getText().length() > 0
                        && CheckOutData.getText().length() > 0) {

                    Tenant newTenant = new Tenant(titles[title.getSelectedIndex()],
                            firstName.getText().replaceAll("\\s+", ""), lastName.getText().replaceAll("\\s+", ""),
                            noAdults[adults.getSelectedIndex()],
                            noMinors[minors.getSelectedIndex()]);
                        int tennantId = tennatsTransaction.add(newTenant);


                    Booking newBooking = new Booking(tennantId, Integer.parseInt(roomNumber.getText()), CheckOutData.getText());

                    int bookingId = bookingTransaction.add(newBooking);

                    Payment newPayment = new Payment(tennantId,bookingId,newBooking.getNoDaysBooked());

                    paymentTransaction.add(newPayment);


                    displayData(); // display new updated table again,

                    // empty all JtextField
                    firstName.setText("");
                    lastName.setText("");
                    roomNumber.setText("");
                    CheckOutData.setText("");


                }// end of if
                else { // warn the user, if all forms not done properly
                    JOptionPane.showMessageDialog(null,
                            "Please fill all the required fields!",
                            "You must fill in everything!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            // catch method
            catch (Exception nfe) { // display the error message for wrong input

                JOptionPane.showMessageDialog(null,
                        nfe,
                        "Wrong input, please double check! ",
                        JOptionPane.ERROR_MESSAGE);

                System.out.println(nfe);
            }// end of if statement for checking numbers in names
        } else {// if the user has then display warning message
            JOptionPane.showMessageDialog(null, "Names cannot contain numbers",
                    "Wrong input values", JOptionPane.ERROR_MESSAGE);
            firstName.setText("");// empty firstname field
            lastName.setText("");// empty lastname field
        }
    }// end of function

    // boolean function that checks if the word does not contain number
    // to ensure all names contain words only
    public boolean checkNumber(String onlyWord) {
        char[] indivual = onlyWord.toCharArray(); // break string to char array
        // iterate for loop to check every single word is not a number
        for (int i = 0; i < onlyWord.length(); i++) {
            // if it the word is a digit, then return value false
            if (Character.isDigit(indivual[i])) {
                return false;
            }
        }
        return true; // if no words contain number then return true
    }

    // method to display room table
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
