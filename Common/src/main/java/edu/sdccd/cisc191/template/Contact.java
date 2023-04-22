package edu.sdccd.cisc191.template;

import java.io.Serializable;

/**
 * This class represents a single Contact in a generic linked list of contacts.
 */
public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Contact next;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.next = null;
    }

    public Contact getNext() {
        return next;
    }

    public void setNext(Contact next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}















//package edu.sdccd.cisc191.template;
///**
// * This class represents a single contact in an address book
// * */
//
//public class Contact {
//    private String lastName;
//    private String firstName;
//    private String phoneNumber;
//    private String homeAddress;
//    private String emailAddress;
//
//
//    public Contact(String lastName, String firstName, String phoneNumber,  String homeAddress, String emailAddress) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.phoneNumber = phoneNumber;
//        this.homeAddress = homeAddress;
//        this.emailAddress = emailAddress;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(String homeAddress) {
//        this.homeAddress = homeAddress;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    @Override
//    public String toString() {
//        return "Contact{" +
//                "lastName='" + lastName + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", homeAddress='" + homeAddress + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                '}';
//    }
//
//}
