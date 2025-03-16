package it.polimi.towardsremoteview;


import it.polimi.towardsremoteview.Model.Automaton;
import it.polimi.towardsremoteview.Model.DinnerPhase;

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

        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                System.out.println(s);
                //was: out.println(s.toUpperCase());
                out.println(processCmd(s));

            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // we should close..
    }


        static Automaton model = new Automaton();

        // from: static Boolean readLoop(BufferedReader in, PrintWriter out ) on Automamton code.
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

    }
