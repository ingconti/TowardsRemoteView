package it.polimi.towardsremoteview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class VirtualServer {

    PrintWriter out = null;
    BufferedReader in = null;

    void start() {

        String hostName = "127.0.0.1";
        int portNumber = 1234;

        Socket echoSocket = null;
        try {
            echoSocket = new Socket(hostName, portNumber);
        } catch (IOException e) {
            System.err.println(e.toString() + " " + hostName);
            System.exit(1);
        }
        /* moved up, class instances:
        PrintWriter out = null;
        BufferedReader in = null;
         */
        BufferedReader stdIn = null;
        try {
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));

            stdIn = new BufferedReader(
                    new InputStreamReader(System.in));

        } catch (IOException e) {
            System.err.println(e.toString() + " " + hostName);
            System.exit(1);
        }
        // here was while..
        Thread t1 = new Thread(this::readingLoop);
    }

    void readingLoop(){
        System.out.println("reading thread started");

        while (true) {
            try {
                String answer = in.readLine();
                System.out.println("echo: " + answer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } // while
    }



    void sendCmd(String cmd){
        out.println(cmd);
    }
}
