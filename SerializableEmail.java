package New;

import java.io.Serializable;

public class SerializableEmail implements Serializable {
    private static final long serialVersionUID = 1L; // Ensure version compatibility
    private String emailAddress;
    private String subject;
    private String content;
    private String sendDate;

    public SerializableEmail(String emailAddress, String subject, String content, String sendDate) {
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.content = content;
        this.sendDate = sendDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getSendDate() {
        return sendDate;
    }
}
