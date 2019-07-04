package model;

/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
// table name
@Table(name = "Payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "TennantId")
	private int tennantId;

	@Column(name = "BookingId")
	private int bookingId;

	@Column(name = "Total")
	private double total;

	@Column(name = "PaymentType")
	private String paymentType;

	@Column(name = "PaymentStatus")
	private String paymentStatus;

	@Column(name = "Tax")
	private double tax;

	@Column(name = "DateOfPayment")
	private java.time.LocalDateTime dateOfPayment;

	private static final int rateDay = 200; // the rate that apply each day

	private static final double taxRate = 0.10; // tenants have to pay 10% tax


	public Payment(){};

	public Payment(int tennantId, int bookingId, int nod) {
		this.tennantId = tennantId;
		this.bookingId = bookingId;
		this.total = totalCal(nod);
		this.paymentType = "No_Payment";
		this.paymentStatus = "Not_Paid";
		this.tax = taxCal(this.total);
		this.dateOfPayment = this.dateOfPayment.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTennantId() {
		return tennantId;
	}

	public void setTennantId(int tennantId) {
		this.tennantId = tennantId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public LocalDateTime getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDateTime dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	// public return method for tax calculation
	public double taxCal(double amount) {
		return amount * taxRate;
	}
	// public return method for payment before
	public double totalCal(int num) {
		return num * rateDay;
	}
}// end of class
