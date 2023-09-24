package New;

import java.io.*;
import java.util.ArrayList;

public class Deserialize {
    static ArrayList<MailData> emp = new ArrayList<>();

    public static ArrayList<MailData> look() {
        try {
            File filename = new File("SentEmails.ser");
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = null;
            MailData sendMail;
            do {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                        sendMail = (MailData) objectInputStream.readObject();
                        emp.add(sendMail);
                    } catch (EOFException e) {
                        break;
                    }

                } catch (EOFException e) {
                    e.printStackTrace();
                    break;
                }

            } while (sendMail != null);
            assert objectInputStream != null;
            objectInputStream.close();
            fileInputStream.close();
            return emp;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occured.");
            e.printStackTrace();
        }
        return null;
    }
}









/*import java.io.*;
public class Deserialize {

    public static void look() {
        Employee e = null;
        //while
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);;
        System.out.println("Number: " + e.number);
    }
}*/