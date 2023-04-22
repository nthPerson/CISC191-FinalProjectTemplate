package edu.sdccd.cisc191.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an address book that contains the name, phone number,
 * and email address of contacts that are added to the list by the user.
 */
public class AddressBook {
    private Contact head;
    public Contact getHead() {
        return head;
    }
    public void setHead(Contact head) {
        this.head = head;
    }
    public AddressBook() {
        head = null;
    }

    /**
     * Adds contact to the end of the address book
     * @param contact contact to be added to address book
     */
    public void addContact(Contact contact) {
        // if the address book is empty, add new contact to start of list
        if (head == null) {
            head = contact;
        } else {
            // traverse address book list until the end is reached
            Contact current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // add new contact to end of list
            current.setNext(contact);
        }
    }

    /**
     * Removes the contact that is described by searchItem from the address book
     * @param searchItem name, phone number, or email address of contact to be removed
     * @return true if the contact is found and removed
     */
    public boolean removeContact(String searchItem) {
        // search head node first
        if (head == null) {
            // if list is empty, contact is definitely not found
            return false;
        } else if (head.getName().equals(searchItem)
                || head.getPhoneNumber().equals(searchItem)
                || head.getEmailAddress().equals(searchItem)) {
            // if the contact is found at the head node, remove contact
            head = head.getNext();
            return true;
        } else {
            // keep track of head pointer
            Contact previous = head;
            // node used to traverse the list
            Contact current = head.getNext();

            // search list for searchItem
            while (current.getNext() != null) {
                if (head.getName().equals(searchItem)
                        || head.getPhoneNumber().equals(searchItem)
                        || head.getEmailAddress().equals(searchItem)) {
                    previous.setNext(current.getNext());
                    return true;
                }
                // remove contact
                previous = current;
                current = current.getNext();
            }
            // if contact is not found
            return false;
        }
    }

    /**
     * Displays the contents of the address book to the console
     * @return true if contacts were displayed successfully
     */
    public boolean displayContacts() {
        // if the list is empty there is nothing to display
        if (head == null) {
            System.out.println("The address book is empty!");
            return false;
        } else {
            Contact current = head;

            while (current != null) {
                System.out.println(current);
                current = current.getNext();
            }
            return true;
        }
    }

    /**
     * Converts the address book to a HashMap that represents a phone list
     * @param contacts the address book to be converted into a HashMap
     * @return a HashMap of <Name, PhoneNumber> that represents a phone list created from the address book
     */
    public Map<String, String> convertToMap(AddressBook contacts) {
        Map<String, String> newMap = new HashMap<>();
        if (contacts.head == null) {
            return newMap;
        } else {
//            Contact current = addressBook.head;
//            newMap.put(addressBook.head.getName(), addressBook.head.getPhoneNumber());

            Contact current = contacts.head;
            while (current != null) {
//                current = addressBook.head.getNext();
                newMap.put(current.getName(), current.getPhoneNumber());
                current = current.getNext();
            }
            return newMap;
        }
    }

    /**
     * Prints the phone list that is represented by phoneMap
     * @param phoneMap the map to be printed
     * @return true if the map is able to print
     */
    public boolean printPhoneMap(Map<String, String> phoneMap) {
        if (phoneMap == null) {
            return false;
        } else {
            for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            return true;
        }
    }

    /**
     * Sorts the address book lexicographically
     * @param contacts the address book to be sorted
     */
    public void sortByName(AddressBook contacts) {
        Contact current = contacts.head;
        Contact iterationPointer = null;
        String tempName;
        String tempNumber;
        String tempEmail;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                iterationPointer = current.getNext();
                while (iterationPointer != null) {
                    // if the current node's contact name is greater than the next node's contact name, do the swap
                    if (current.getName().compareTo(iterationPointer.getName()) > 0) {
                        // copy contact information from current node
                        tempName = current.getName();
                        tempNumber = current.getPhoneNumber();
                        tempEmail = current.getEmailAddress();

                        // swap contact information from next node to current node
                        current.setName(iterationPointer.getName());
                        current.setPhoneNumber(iterationPointer.getPhoneNumber());
                        current.setEmailAddress(iterationPointer.getEmailAddress());

                        // swap contact information from current node to next node
                        iterationPointer.setName(tempName);
                        iterationPointer.setPhoneNumber(tempNumber);
                        iterationPointer.setEmailAddress(tempEmail);
                    }
                    iterationPointer = iterationPointer.getNext();
                }
                current = current.getNext();
            }
        }
    }

    /**
     * Converts an address book to an ArrayList for serialization and processing
     * @param contacts the address book to be converted
     * @return an ArrayList of Contacts
     */
    public ArrayList<Contact> convertToList(AddressBook contacts) {
        ArrayList<Contact> contactList = new ArrayList<>();
        if (contacts.head == null) {
            return contactList;
        } else {
            Contact current = contacts.head;
            while (current != null) {
                contactList.add(current);
                current = current.getNext();
            }
            return contactList;
        }
    }

}


