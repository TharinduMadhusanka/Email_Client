# Email Client

This is a command-line based email client application that allows you to manage a list of recipients, send birthday greetings, and store sent emails. The application loads recipient details from a text file and maintains recipient objects for each person. It provides functionality to add new recipients, send birthday greetings, and retrieve sent emails.

## Features

### Recipient Management

- The application loads recipient details from a text file.
- You can add new recipients through the command-line interface.

### Birthday Greetings

- On a recipient's birthday, the application sends a birthday greeting.
- Different messages are sent to official friends and personal recipients.
- Official friends receive a message like: "Wish you a Happy Birthday, <your name>."
- Personal recipients receive a message like: "Hugs and love on your birthday, <your name>."

### Recipient Count

- The system keeps a count of recipient objects.
- Static members are used to maintain this count.

### Email Storage

- All emails sent by the email client are saved to the hard disk using object serialization.

### Email Retrieval

- You can retrieve information about all emails sent on a particular day using a command-line option.
