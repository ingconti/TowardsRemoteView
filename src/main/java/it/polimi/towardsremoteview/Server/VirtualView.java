package it.polimi.towardsremoteview.Server;

import it.polimi.towardsremoteview.Server.Model.DinnerPhase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

    ModelListener listener;

    public VirtualView(Socket clientSocket, Controller controller) {
        this.clientSocket = clientSocket;

        CallBack callBack = (PropertyChangeEvent evt) -> {
            DinnerPhase state = this.controller.model.getState();
            String answer = state.toString();
            out.println(answer);
        };

        this.listener = new ModelListener(callBack);
        this.controller = controller;
        controller.setListener(this.listener);

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
                String status = this.controller.processCmd(s);
                System.out.println(status); // only for debug. we do NOT send back!
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
