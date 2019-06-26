/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */



/* This is my payment object which consists of details of the customer, the amount customer needs
 * to pay for the rent and some functions that works out the tax etc
 */

public class Payment {
	// securing all my variables as encapsulation
	private String customerName; // name of the tenant
	// made these two variables as static and final so it cannot be changed at all 
	private static final int rateDay = 200; // the rate that apply each day
	private static final double taxRate = 0.10; // tenants have to pay 10% tax
												// rate
	private double total;// total amount they have to pay before tax
	// type of payment they have paid, such as card, cash, or cheque
	private String paymentType;
	private String paymentStatus; // if they have paid or not
	private int roomNumber; // room number of the customer
	private double tax; // total they have been charged
	// number of days they are staying, adding this variable to this class helps
	// to calculate
	private int numOfDays;

	// my constructor object which you pass in customer name, number of days and
	// room number
	public Payment(String cname, int nod, int roomNum, String paymentSta, String paymentType ) {
		this.customerName = cname;
		this.numOfDays = nod;
		this.roomNumber = roomNum;
		this.paymentStatus = paymentSta;
		this.total = totalCal(nod); // return function that calculates tenants needs to pay
		// before tax
		this.tax = taxCal(total); //return function that calculates 10% tax 
		this.paymentType = paymentType; 

	}
  // public getter method for customer name 
	public String getcustomerName() {
		return this.customerName;
	}
	 // public getter method for payment type
	public String getPaymentType() {
		return this.paymentType;
	}
	public String getPaymentStutus() {
		return this.paymentStatus;
	}
	// public setter method for payment type
	public void setPaymentType(String type) {
		this.paymentType = type;
	}
	// public setter method for payment status
	public void setPaymentStatus(String status) {
			this.paymentStatus = status;
	}
	 // public getter method for room number
	public int getRoom() {
		return this.roomNumber;
	}
	 // public getter method for tax
	public double getTax() {
		return this.tax;
	}
	 // public getter method for total
	public double getTotal() {
		return this.total;
	}
	 // public getter method for no of days
	public int getNumOfDays() {
		return this.numOfDays;
	}
	 // public return method for tax calculation
	public double taxCal(double amount) {
		return amount * taxRate;
	}
	// public return method for payment before
	public double totalCal(int num) {
		return num * rateDay;
	}
	// public return method for final total after tax
	public double grandTotal() {
		return this.tax + this.total; // adding up total and tax pay
	}

}// end of class 
