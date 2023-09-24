package New;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SavePersons {

    public static void saveToFile(String personDetails) {
        try {
            FileWriter fileWriter = new FileWriter("clientList.txt", true); // Open the file in append mode
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Append the user details to the file
            printWriter.println(personDetails);

            printWriter.close(); // Close the file
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving user data.");
        }
    }
}
