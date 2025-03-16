package it.polimi.towardsremoteview.Client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onEvolveButtonClick() {
        // was: String msg = new Date().toString();
        String msg = "g"; // as per AutomatonFromNetwork.
        this.virtualServer.sendCmd(msg);
        this.updateView();
    }

    @FXML
    protected void onPayButtonClick() {
        // was: String msg = new Date().toString();
        String msg = "p"; // as per AutomatonFromNetwork.
        this.virtualServer.sendCmd(msg);
        this.updateView();
    }



    void updateView(){

    }

    VirtualServer virtualServer;
    private Stage stage;
        public void setStage(Stage stage, VirtualServer virtualServer) {
        this.stage = stage;
        this.virtualServer = virtualServer;
    }

}