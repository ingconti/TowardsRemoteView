package it.polimi.towardsremoteview.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import it.polimi.towardsremoteview.Server.Model.Automaton;

public class ServerMain {
    static int portNumber = 1234;
    static Automaton model = new Automaton();

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

        Controller controller = new Controller(model);
        VirtualView virtualView = new VirtualView(clientSocket, controller);
        virtualView.networkEventLoop();

        // we should close..
    }

}
