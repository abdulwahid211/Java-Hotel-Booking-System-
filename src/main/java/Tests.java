import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Tests {


    public static void main(String args[]) throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader("TenantData.txt"));

        String z;
        // once the file is reading
        while (s.hasNext()) {
            z = s.nextLine(); // collect the string line
            String[] space = z.split(" "); // split it up in arrays

            System.out.println(space);
        }
    }

}
