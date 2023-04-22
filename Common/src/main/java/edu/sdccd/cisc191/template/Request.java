package edu.sdccd.cisc191.template;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a request for contact hobbies or interests that is
 * sent from the client to the server.
 */
public class Request implements Serializable {
    private ArrayList<Contact> contactListRequest;

    public Request(ArrayList<Contact> contactList) {
        this.contactListRequest = contactList;
    }

    public void addContact(Contact contact) {
        contactListRequest.add(contact);
    }

    public void removeContact(Contact contact) {
        contactListRequest.remove(contact);
    }

    public ArrayList<Contact> getContactListRequest() {
        return contactListRequest;
    }

    public void setContactListRequest(ArrayList<Contact> contactList) {
        this.contactListRequest = contactList;
    }


}
