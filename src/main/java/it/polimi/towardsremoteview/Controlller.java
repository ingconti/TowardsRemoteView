package it.polimi.towardsremoteview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controlller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
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