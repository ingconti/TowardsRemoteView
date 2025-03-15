package it.polimi.towardsremoteview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Date;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String msg = new Date().toString();
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