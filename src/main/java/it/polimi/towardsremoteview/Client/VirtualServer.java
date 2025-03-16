package it.polimi.towardsremoteview.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class VirtualServer {

    PrintWriter out = null;
    BufferedReader in = null;

    public void start() {

        String hostName = "127.0.0.1";
        int portNumber = 1234;

        Socket echoSocket = null;
        try {
            echoSocket = new Socket(hostName, portNumber);
        } catch (IOException e) {
            System.err.println(e.toString() + " " + hostName);
            System.exit(1);
        }

        BufferedReader stdIn = null;
        try {
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(1);
        }

        ClientThread clientThread = new ClientThread(in);
        clientThread.start();
    } // end of start

    public void sendCmd(String cmd){
        out.println(cmd);
    }
}
