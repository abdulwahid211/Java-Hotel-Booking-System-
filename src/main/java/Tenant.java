/* Name: Mohammed Abdul Wahid
 * Email: ma301ma@gold.ac.uk
 */
// a class for tenant object
public class Tenant {
	// protecting all my variables as private 
private String title; // customers initial title 	
private String firstName; // customers firstname 
private String lastName; // lastname
private String noAdultVisitors; //  No of Adult Visitors 
private String noMiniorsVisitors; // No of Minor Visitors 
private int noDaysBooked; // number days they have booked to stay 
private int roomNumber;	// their room number 

// constructor to pass in values 
	public Tenant(String title,String firstN, String lastN, String adults,
			String minors,int noDays, int rm){
		
		this.title = title;
		this.firstName = firstN;
		this.lastName = lastN;
		this.noAdultVisitors = adults;
		this.noMiniorsVisitors = minors;
		this.noDaysBooked = noDays;
		this.roomNumber = rm;
	}
	// getter method for title 
	public String getTitle(){
		return this.title;
	}
	// getter method for firstname
	public String getFirstName(){
		return this.firstName;
	}
	// getter method for lastname
	public String getLastName(){
		return this.lastName;
	}
	// getter method for 
	public String getNoAdultVisitors(){
		return this.noAdultVisitors;
	}
	// getter method for No of Minor Visitors 
	public String getNoMinorsVisitors(){
		return this.noMiniorsVisitors;
	}
	// getter method for no days booked 
	public int getNoDaysBooked(){
		return this.noDaysBooked;
	}
	// getter method for room number 
	public int getRoomNumber(){
		return this.roomNumber;
	}
	/// string method so its prints the object content 
	public String toString(){
		return"> Title:"+this.title +" Name:" + this.firstName +" "+
	this.lastName+", Room Number:"+String.valueOf(this.roomNumber);
	}
	
	
}