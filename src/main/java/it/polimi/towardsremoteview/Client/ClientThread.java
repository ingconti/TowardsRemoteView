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
                this.updateUICallBack.process(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // add calk back:
    private UpdateUICallBack updateUICallBack;

    void setUICallBack(UpdateUICallBack updateUICallBack){
        this.updateUICallBack = updateUICallBack;
    }
}
