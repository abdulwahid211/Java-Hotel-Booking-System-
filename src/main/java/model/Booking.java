package model;/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
// table name
@Table(name="Bookings")
public class Booking {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID")
private int id;

@Column(name="TennantId")
private int tennantsId;

// securing all global variables as private
@Column(name="roomNumber")
private int roomNumber; // visitors room number

@Column(name="roomStatus")
private String roomStatus; // status if the room is available or not

@Column(name="noDaysBooked")
private int noDaysBooked; // visitors room number

@Column(name="checkIn")
private java.time.LocalDateTime checkIn;

@Column(name="checkOut")
private java.time.LocalDateTime checkOut;


public Booking(){};

// constructor to create a room object
// inside the constructor you pass in room number, visitor name and boolean value if the room
// is available or not 
public Booking(int tennantsId, int rn, String _checkout ){
	this.roomNumber = rn;
    this.tennantsId = tennantsId;
	this.checkIn = this.checkIn.now();
	this.checkOut = this.checkOut.parse(_checkout+" 00:00:00.0".replace( " " , "T" ));
	this.roomStatus = "Not Available";
	this.noDaysBooked = this.calculateNoDaysBooked();
	}


	public int getId() {
		return id;
	}

	public int getTennantsId() {
		return tennantsId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public int calculateNoDaysBooked() {

	return  (int)ChronoUnit.DAYS.between(this.checkIn, this.checkOut);

	}

	public int getNoDaysBooked() {
		return noDaysBooked;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}
}
