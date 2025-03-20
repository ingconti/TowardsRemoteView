package it.polimi.towardsremoteview.Client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private HBox hbox;


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


    // todo: You will process answer..
    private int xForAnswer(String answer) {
        switch (answer) {
            case "ENTREE":return 30;
            case "MAIN COURSE":return 60;
            case "SECOND COURSE":return 90;
            case "DESSERT":return 120;
            case "END OF YOUR LUNCH!":return 30;
        }
        return 0;
    }



    private void addCircle(String answer){
        double centerX = xForAnswer(answer), centerY = 100, radius = 30;
        Circle c1 = new Circle(centerX, centerY, radius, Color.RED);
        this.hbox.getChildren().add(c1);
    }



    private void safeUpdateView(String msg){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                updateView(msg);
            }
        });

    }

    private void updateView(String msg){
        this.welcomeText.setText(msg);
        this.addCircle(msg);
    }


    VirtualServer virtualServer;
    private Stage stage;

    UpdateUICallBack updateUICallBack;

    public void setStage(Stage stage, VirtualServer virtualServer) {
        this.stage = stage;
        this.virtualServer = virtualServer;

        // add call back:
        this.updateUICallBack = new UpdateUICallBack() {
            @Override
            public void process(String answer) {
                System.out.println("Call back " + answer);
                safeUpdateView(answer);
            }
        };

        virtualServer.setUICallBack(this.updateUICallBack);
    }


}