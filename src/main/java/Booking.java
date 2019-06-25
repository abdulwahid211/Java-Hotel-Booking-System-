/* Name: Mohammed Abdul Wahid
 * Email: ma301ma@gold.ac.uk
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * This class helps to store and retrieve booking details in file text. It stores them in arrayList
 * . There are methods that add booking, remove and verify if the room is being occupied.
 */

public class Booking {
	// made a list that contains room objects
	private ArrayList<Room> Rooms = new ArrayList<Room>();
	private String FILE_PATH_NAME;

	// this method reads the booking details and stores them in the arraylist
	public void init() throws FileNotFoundException {
		// exception handling
		try {
			FILE_PATH_NAME = System.getProperty("user.dir") + "/src/main/resources/BookingData.txt";
			// scanner object to read the file
			Scanner s = new Scanner(new FileReader(FILE_PATH_NAME));

			String z;
			// once the file is reading
			while (s.hasNext()) {
				z = s.nextLine();// collect the string line
				String[] space = z.split(",");// split it up in arrays
				// store them in the room arraylist
				Rooms.add(new Room(Integer.parseInt(space[0]), space[1],
						space[2]));
			}

			s.close();

		}
		// if any error display a notification message
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "please double check!",
					"File failed to update", JOptionPane.ERROR_MESSAGE);
		}

	}

	// add new room visitor into the arraylist
	public void addVisitorRoom(String visitor, int roomNumber) {
		Rooms.get(roomNumber - 1).setVisitorName(visitor); // set the room name
		Rooms.get(roomNumber - 1).setRoomNumber(roomNumber);
		Rooms.get(roomNumber - 1).setStatus("Not Available"); // update the room
																// status

	}

	// remove room visitor from the arraylist
	public void RemoveVisitorRoom(int roomNumber) {
		Rooms.get(roomNumber - 1).setVisitorName("No visitor"); // remove visitor name
		Rooms.get(roomNumber - 1).setRoomNumber(roomNumber);
		Rooms.get(roomNumber - 1).setStatus("Room Available");// update the room
																// status

	}
	//update the text file
	public void UpdateData() {

		FileWriter writer;
		try {
			File roomDetails = new File(FILE_PATH_NAME);
			// creates a new file
			roomDetails.createNewFile();

			// creates a FileWriter Object
			writer = new FileWriter(roomDetails);
			for (int i = 0; i < Rooms.size(); i++) {
				writer.write(String.valueOf(Rooms.get(i).getRoonNumber()) + ","
						+ Rooms.get(i).getVisitorName() + ","
						+ Rooms.get(i).getRoomStatus() + "" + "\n");
			}
			writer.flush();
			writer.close();

		}
		// display notification message if any error in the file
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "please double check!",
					"File failed to update", JOptionPane.ERROR_MESSAGE);
		}

	}// end Update() fucntion 

	// boolean method that verifies if the room is available 
	// enter room number to check if the room is not ready use 
	public boolean verify(int roomNumber) {
		for (int i = 0; i < Rooms.size(); i++) {
			// using conditional statement to check room number matches and available 
			if (Rooms.get(i).getRoonNumber() == roomNumber
					&& Rooms.get(i).getRoomStatus().equals("Room Available")) {
				return true; // room is available 
			}
		}
		return false; // room is not available 
	}

	// getter method for arrayList
	public ArrayList<Room> getRoomList() {
		return this.Rooms;
	}

}
