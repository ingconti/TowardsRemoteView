package it.polimi.towardsremoteview.Client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onEvolveButtonClick() {
        String msg = "g"; // as per AutomatonFromNetwork.
        this.virtualServer.sendCmd(msg);
    }

    @FXML
    protected void onPayButtonClick() {
        String msg = "p"; // as per AutomatonFromNetwork.
        this.virtualServer.sendCmd(msg);
    }


/*
    void updateView(String msg){
        this.welcomeText.setText(msg);
    }*/


    VirtualServer virtualServer;
    private Stage stage;

    public void setStage(Stage stage, VirtualServer virtualServer) {
        this.stage = stage;
        this.virtualServer = virtualServer;
        // create on fly:
        this.viewUpdater = new ViewUpdater(this);
    }

    private ViewUpdater viewUpdater;

}