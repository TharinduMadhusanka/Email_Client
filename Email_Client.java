package New;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
// import java.sql.Date;
import java.util.Date;

public class Email_Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                // Input format - Official: nimal,nimal@gmail.com,ceo
                System.out.println("Enter recipient details in the format 'person_type,name,email,position':");
                scanner.nextLine(); // Consume the newline character
                String personDetails = scanner.nextLine();
                SavePersons.saveToFile(personDetails);
                break;
            case 2:
                // Input format - email, subject, content
                System.out.print("Email Address: ");
                String email = scanner.next();
                System.out.print("Subject: ");
                String subject = scanner.next();
                System.out.print("Content: ");
                scanner.nextLine(); // Consume the newline character
                String content = scanner.nextLine();

                // Get the current date
                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String sendDate = dateFormat.format(currentDate);

                // Create a SerializableEmail object
                SerializableEmail emailObject = new SerializableEmail(email, subject, content, sendDate);

                // Serialize and save the email data to SentEmails.ser
                try {
                    FileOutputStream fileOut = new FileOutputStream("SentEmails.ser", true); // Append mode
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

                    objectOut.writeObject(emailObject);
                    objectOut.close();

                    System.out.println("Email data saved successfully.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println("Error saving email data.");
                }
                break;
            case 3:
                // Input format - yyyy/MM/dd (ex: 2018/09/17)
                System.out.print("Enter a birthday in yyyy/MM/dd format: ");
                String birthday = scanner.next();

                ArrayList<String[]> recipients = Read.ReadFromFile(birthday);

                if (recipients != null && !recipients.isEmpty()) {
                    System.out.println("Recipients with birthdays on " + birthday + ":");
                    for (String[] recipient : recipients) {
                        for (String data : recipient) {
                            System.out.print(data + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("No recipients have birthdays on the given date.");
                }
                break;

            // case 4:
            //     // input format - yyyy/MM/dd (ex: 2018/09/17)
            //     // code to print the details of all the emails sent on the input date
            //     System.out.println("Input date: ");
            //     String neededDate = scanner.next();
            //     int len = Deserialize.look().size();
            //     for (int i = 0; i < len; i++) {
            //         if (Deserialize.look().get(i).date.equals(neededDate)) {
            //             System.out.println(Deserialize.look().get(i).emailAddress);
            //             System.out.println(Deserialize.look().get(i).subject);
            //             System.out.println(Deserialize.look().get(i).content);
            //             System.out.println();
            //         }
            //     }

            //     break;
            // case 5:
            // // Print the number of recipient objects in the application
            // System.out.print("Number of recipients is: ");
            // System.out.println(numOfRecipients.TakeNumOfRecipients());
            // break;
            // default:
            //     System.out.println("Invalid option. Please select a valid option.");
            //     break;
        }
        scanner.close();
    }
}
