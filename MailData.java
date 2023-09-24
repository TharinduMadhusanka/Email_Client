package New;

public class MailData implements java.io.Serializable {
    public String subject;
    public String emailAddress;

    public String content;

    public String  date;

    public void mailCheck() {
        System.out.println("Mailing a check to " + subject + " " + emailAddress);
    }
}