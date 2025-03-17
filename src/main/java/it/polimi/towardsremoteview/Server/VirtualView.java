package it.polimi.towardsremoteview.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class VirtualView {

    BufferedReader in = null;
    PrintWriter out = null;
    Socket clientSocket = null;
    Controller controller = null;

    public VirtualView(Socket clientSocket, Controller controller) {
        this.clientSocket = clientSocket;
        this.controller = controller;

        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void networkEventLoop(){
        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                System.out.println(s);
                // no more...out.println(processCmd(s));
                this.controller.evolve(s);
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
