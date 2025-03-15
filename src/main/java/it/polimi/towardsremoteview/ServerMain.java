package it.polimi.towardsremoteview;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    static int portNumber = 1234;

    public static void main(String[] args) {

        System.out.println("Server Started!");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Listening on port " + portNumber);

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Accepted");

        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // waits for data and reads it in until connection dies
        // readLine() blocks until the server receives a new line from client
        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                System.out.println(s);
                out.println(s.toUpperCase());
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // we should close..
    }
}
