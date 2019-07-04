/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */

import data.DataTransaction;
import model.Tenant;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class RemoveTenant {

    private JButton goBack; // button to go back to main Menu
    private JButton refresh; // button to refresh the Jlist
    private JPanel page; // Jpanel
    private JButton removeTennant; // button to remove tenant
    private JList listTenants; // list to hold color names
    private JScrollPane scrollBar; // scrollBar for listTenants
    private JLabel info; // label for info
    private JLabel info2; // label for info
    private List<Tenant> tenants;

    private DataTransaction tennatsTransaction;

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

        tennatsTransaction = new DataTransaction(Tenant.class);

        tenants = tennatsTransaction.getAllTenants();

        listTenants = new JList(tenants.toArray());

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

        displayData();

        return page;

    }


    public void remove() {

        System.out.println("Size shit "+tenants.size());

        if (tenants.size() > 0) {

            Tenant t = tenants.get(listTenants.getSelectedIndex());

            tennatsTransaction.setQuery("DELETE FROM hotel_project.Payments where Payments.TennantId = '"+t.getId()+"';");

            tennatsTransaction.setQuery("DELETE FROM hotel_project.Bookings where Bookings.TennantId = '"+t.getId()+"';");

            tennatsTransaction.delete(tenants.get(listTenants.getSelectedIndex()));

            displayData();
        }

    }

    // refresh button to update the Jlist
    public void displayData() {

        tenants = tennatsTransaction.getAllTenants();

        listTenants.setListData(tenants.toArray());

    }

}