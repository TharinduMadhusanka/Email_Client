package New;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    public static ArrayList<String[]> ReadFromFile(String GivenBday) {
        try {
            File myObj = new File("clientList.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String[]> personalData = new ArrayList<String[]>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] array1 = SplitToArray(data);
                if (!array1[0].equals("Official")) {
                    String Bdate = array1[array1.length - 1];
                    if (Bdate.split("/", 2)[1].equals(GivenBday.split("/", 2)[1])) {
                        personalData.add(array1);
                    }
                }
            }

            myReader.close(); // Close the scanner after reading the file
            return personalData;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public static String[] SplitToArray(String str) {
        String[] arrOfStr = str.split(",");
        return arrOfStr;
    }
}
