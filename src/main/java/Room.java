/* Name: Mohammed Abdul Wahid
 * Email: ma301ma@gold.ac.uk
 */
// this class creates a room for the visitor 
// it has relevant attributes such as room number where visitor will stay and name of the tenant 
// it also has room status to let the staff member know if the room is available or not
public class Room {
// securing all global variables as private 
private int roomNumber; // visitors room number 
private String visitorName; // visitors name 
private String roomStatus; // status if the room is available or not 

// constructor to create a room object
// inside the constructor you pass in room number, visitor name and boolean value if the room
// is available or not 
public Room(int rn, String visName, String avaiable){
	this.roomNumber = rn;
	this.visitorName = visName;
	
	this.roomStatus = avaiable;
	
	
	}

// return method for room number 
public int getRoonNumber(){
	return this.roomNumber;
}
// return method for visitor name 
public String getVisitorName(){
	return this.visitorName;
}
//return method for room status
public String getRoomStatus(){
	return this.roomStatus;
}
// setter method for visior name
public void setVisitorName(String name){
	this.visitorName = name;
}
//setter method for room number
public void setRoomNumber(int number){
	this.roomNumber = number;
}
// method for staff members to change status of the room
public void setStatus(String avaiable){ // staff members pass in boolean value to determine status
	
		this.roomStatus = avaiable;

	
}


}
