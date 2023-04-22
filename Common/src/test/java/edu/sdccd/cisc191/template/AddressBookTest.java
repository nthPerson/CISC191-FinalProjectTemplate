package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    AddressBook testAddressBook = new AddressBook();
    Contact testContact1 = new Contact("Robert", "(858) 111-1111", "fake@gmail.com");
    Contact testContact2 = new Contact("Zed", "(760) 222-2222", "email@hotmail.com");
    Contact testContact3 = new Contact("Professor Huang", "(777) 867-5309", "coolGuy@yahoo.com");

    @Test
    void addContact() {
        testAddressBook.addContact(testContact1);
        assertEquals("Robert", testContact1.getName());

    }

    @Test
    void removeContact() {
        testAddressBook.addContact(testContact1);
        testAddressBook.addContact(testContact2);
        testAddressBook.addContact(testContact3);
        testAddressBook.removeContact("Robert");
        assertEquals("Zed", testAddressBook.getHead().getName());
        testAddressBook.addContact(testContact1);

    }

    @Test
    void displayContacts() {
        testAddressBook.addContact(testContact1);
        testAddressBook.addContact(testContact2);
        testAddressBook.addContact(testContact3);
        assertTrue(testAddressBook.displayContacts());

    }

    @Test
    void convertToMap() {
        testAddressBook.addContact(testContact2);
        testAddressBook.addContact(testContact3);
        testAddressBook.addContact(testContact1);
        Map<String, String> testContactMap = testAddressBook.convertToMap(testAddressBook);
        assertEquals("(777) 867-5309", testContactMap.get("Professor Huang"));
    }

    @Test
    void printPhoneMap() {
        testAddressBook.addContact(testContact2);
        testAddressBook.addContact(testContact3);
        testAddressBook.addContact(testContact1);
        Map<String, String> testContactMap = testAddressBook.convertToMap(testAddressBook);
        assertTrue(testAddressBook.printPhoneMap(testContactMap));

    }

    @Test
    void sortByName() {
        testAddressBook.addContact(testContact1);
        testAddressBook.addContact(testContact2);
        testAddressBook.addContact(testContact3);
        assertEquals("Robert", testAddressBook.getHead().getName());
        testAddressBook.sortByName(testAddressBook);
        assertEquals("Professor Huang", testAddressBook.getHead().getName());
    }

    @Test
    void convertToList() {
        Contact testContact = new Contact("Test Name", "Test Number", "Test Email");
        testAddressBook.addContact(testContact1);
        testAddressBook.addContact(testContact2);
        testAddressBook.addContact(testContact3);
        ArrayList<Contact> testList = new ArrayList<>(testAddressBook.convertToList(testAddressBook));
        assertEquals("Zed", testList.get(1).getName());


    }
}