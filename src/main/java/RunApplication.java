/* Name: Abdul Wahid
 * Email: abdulwahid211@gmail.com
 */

import java.io.FileNotFoundException;

import javax.swing.JFrame;

// main class to run the application 
public class RunApplication {

	public static void main(String[] args) throws FileNotFoundException {
		MainMenu mainMenu = new MainMenu(); // create ButtonFrame

		mainMenu.setSize(550, 500); // default size for window 

		mainMenu.setResizable(false); // size cannot be changed 
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default closing 
		mainMenu.setVisible(true); // display frame

	}
}
