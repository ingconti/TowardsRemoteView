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
        /*
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                System.out.println(s);
                out.println(processCmd(s));
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        // we should close..
    }

/* moved
        static String processCmd(String s){

            String stateString;
            Boolean goOn = false;

            s = s.toUpperCase();
            System.out.println(s);
            if (s.equals("G")){
                goOn = model.evolve();
            }else if (s.equals("P")){
                model.setPaid();
            }else{
                DinnerPhase ph = DinnerPhase.fromString(s);
                goOn = model.evolveTo(ph);
            }

            stateString = model.getState().toString();
            return stateString;
        }
*/

}
