package it.polimi.towardsremoteview.Client;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
    private BufferedReader reader;

    public ClientThread(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
        System.out.println("ClientThread started");

        while (true) {
            try {
                String answer = this.reader.readLine();
                System.out.println(answer);
                //AAAA this.co
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
