package edu.sdccd.cisc191.template;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a request for contact hobbies or interests
 * that is created by the server and then sent to the client.
 */
public class Response implements Serializable {
    private ArrayList<Contact> contactListResponse;

    public Response(Request receivedRequest) {
        this.contactListResponse = receivedRequest.getContactListRequest();
    }

    public void addContact(Contact contact) {
        contactListResponse.add(contact);
    }

    public void removeContact(Contact contact) {
        contactListResponse.remove(contact);
    }

    public ArrayList<Contact> getContactListResponse() {
        return contactListResponse;
    }

    public void setContactListResponse(ArrayList<Contact> contactList) {
        this.contactListResponse = contactList;
    }
}
