package it.polimi.towardsremoteview;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
    private BufferedReader reader;

    public ClientThread(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
        System.out.println("ClientThread started");
        long startTime = System.currentTimeMillis();
        int i = 0;

        while (true) {
            try {
                String answer = this.reader.readLine();
                System.out.println(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
