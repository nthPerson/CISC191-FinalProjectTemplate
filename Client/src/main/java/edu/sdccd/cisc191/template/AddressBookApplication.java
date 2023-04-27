package edu.sdccd.cisc191.template;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

/**
 * This application is used to create a list of contacts that represents an address book.
 * The user can add new contacts, remove contacts, display the contents of the address book,
 * create a phone list, sort the address book lexicographically, and request contact hobbies or interests
 * by making a request to a server.
 */
public class AddressBookApplication {
    public static void main(String[] args) throws IOException {
        // for taking user input
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddressBook addressBook = new AddressBook();

        // for communication between client and server
        ObjectOutputStream outgoingRequest;  // serialized output stream to send request to server
        ObjectInputStream incomingResponse;  // input stream to deserialize response received from server
        Request request;  // object that contains list to be sent to server
        Response response;  // response from server
        final String HOSTNAME = "localhost";
        final int PORT = 1234;

        while (true) {
            // display menu of options
            System.out.println("Main Menu:");
            System.out.println("Enter 1 to add a new contact to the address book.");
            System.out.println("Enter 2 to remove an existing contact.");
            System.out.println("Enter 3 to display the contents of the address book.");
            System.out.println("Enter 4 to create phone list");
            System.out.println("Enter 5 to sort list alphabetically (lexicographically)");
            System.out.println("Enter 6 to request contact interests");
            System.out.println("Enter 7 to quit.");

            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:  // add a new contact to the address book
                    System.out.println("Enter contact's name: ");
                    String name = reader.readLine();

                    System.out.println("Enter contact's phone number: ");
                    String phoneNumber = reader.readLine();

                    System.out.println("Enter contact's email address: ");
                    String emailAddress = reader.readLine();

                    Contact newContact = new Contact(name, phoneNumber,emailAddress);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added successfully!" + "\n" + "********************************" + "\n");
                    break;

//                case 2:  // remove an existing contact
//                    System.out.println("Enter name, phone number, or email address of the contact you wish to remove: ");
//                    String contactToRemove = reader.readLine();
//                    if (addressBook.removeContact(contactToRemove)) {
//                        System.out.println("Contact removed successfully!");
//                    } else {
//                        System.out.println("Contact was not found." + "\n" + "********************************" + "\n");
//                    }
//                    break;
                case 2:  // remove an existing contact
                    if (!addressBook.displayContacts()) {
                        System.out.println("There is no contact in address book for you to remove.");
                    }
                    else {
                        System.out.println("Enter name, phone number, or email address of the contact you wish to remove: ");
                        String contactToRemove = reader.readLine();

                        if (addressBook.removeContact(contactToRemove)) {
                            System.out.println("Contact removed successfully!");
                        } else {
                            System.out.println("Contact was not found." + "\n" + "********************************" + "\n");
                        }
                    }
                    break;

                case 3:  // display the contents of the address book
                    addressBook.displayContacts();
                    System.out.println("\n" + "********************************" + "\n");
                    break;

                case 4:  // create phone list
                    Map<String,String> phoneList = addressBook.convertToMap(addressBook);
                    addressBook.printPhoneMap(phoneList);
                    System.out.println("\n" + "********************************" + "\n");
                    break;

                case 5:  // sort list alphabetically (lexicographically)
                    addressBook.sortByName(addressBook);
                    addressBook.displayContacts();
                    System.out.println("\n" + "********************************" + "\n");
                    break;

                case 6:  // request contact interests aka hobbies
                    // call convertToList to convert contact list into ArrayList and construct Request
                    request = new Request(addressBook.convertToList(addressBook));

                    // send request to server
                    try {
                        // connect to server
                        Socket socket = new Socket(HOSTNAME, PORT);

                        // open input and output streams for communication with server
                        outgoingRequest = new ObjectOutputStream(socket.getOutputStream());
                        incomingResponse = new ObjectInputStream(socket.getInputStream());

                        // serialize and send request to server
                        outgoingRequest.writeObject(request);
                        outgoingRequest.flush();

                        // deserialize response received from sersver
                        response = (Response) incomingResponse.readObject();
                        System.out.println("Received response from server");

                        // print out each entry in response list and add contact "interest" aka hobby
                        for (Contact contact : response.getContactListResponse()) {
                            System.out.println(contact);

                            // randomly assign an interest to each contact
                            if ((Math.random() * 10) < 3) {
                                System.out.println(contact.getName() + "'s interest is bowling");
                            } else if ((Math.random() * 10) > 7) {
                                System.out.println(contact.getName() + "'s interest is pickle ball");
                            } else {
                                System.out.println(contact.getName() + "'s interest is larping");
                            }
                        }

                        // close socket connections
                        outgoingRequest.close();
                        incomingResponse.close();


                        System.out.println("\n" + "********************************" + "\n");
                    } catch (ClassNotFoundException e) {
                        System.out.println("An error occurred while trying to communicate with the server");
                        throw new RuntimeException(e);
                    }
                    break;

                case 7:  // quit
                    return;

                default:
                    System.out.println("Invalid choice, returning to main menu...");
            }
        }
    }

    public static void optionBoard() {
        // for taking user input
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddressBook addressBook = new AddressBook();

    }
}
