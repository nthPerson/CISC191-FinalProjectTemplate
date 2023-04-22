package edu.sdccd.cisc191.template;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a server that takes requests from the address book application
 * for contact information.
 */
public class AddressBookServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server;  // listening socket for connections to address book client
        Socket connection;  // socket connection to client
        Request receivedRequest;  // request received from client
        Response response;  // response sent to client
        final int LISTENING_PORT = 1234;

        try {
            //  start listening on LISTENING_PORT
            server = new ServerSocket(LISTENING_PORT);
            System.out.println("AddressBookServer listening on port " + LISTENING_PORT);

            while (true) {
                // wait for connection request from client
                connection = server.accept();
                System.out.println("Connection established with " + connection.getInetAddress().toString());

                // create input and output streams for address book requests
                ObjectInputStream incomingRequest = new ObjectInputStream(connection.getInputStream());
                ObjectOutputStream outgoingResponse = new ObjectOutputStream(connection.getOutputStream());

                // receive request from client
                receivedRequest = (Request) incomingRequest.readObject();
                System.out.println("Received interest request, generating response...");

                // create the response
                response = new Response(receivedRequest);

                //  serialize and send response to client
                outgoingResponse.writeObject(response);
                outgoingResponse.flush();
                System.out.println("Response sent to client");

                // close socket connections
                incomingRequest.close();
                outgoingResponse.close();
                connection.close();
            }

        } catch (IOException e) {
            System.out.println("An error occurred and the server has shut down");
            System.out.println("Error: " + e);
        }
    }
}
