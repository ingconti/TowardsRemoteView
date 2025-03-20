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
    private ColorsAndCoord ColorsAndCoordForAnswer(String answer) {
        switch (answer) {
            case "ENTREE":return new ColorsAndCoord(30, Color.GREEN);
            case "MAIN COURSE":return new ColorsAndCoord(60, Color.ORANGE);
            case "SECOND COURSE":return new ColorsAndCoord(90, Color.BLUE);
            case "DESSERT":return new ColorsAndCoord(120, Color.MAGENTA);
            case "END OF YOUR LUNCH!":return new ColorsAndCoord(150, Color.YELLOW);
        }
        return new ColorsAndCoord(30, Color.BLACK);
    }



    private void addCircle(String answer){
        ColorsAndCoord colorsAndCoord = ColorsAndCoordForAnswer(answer);
        double centerX = colorsAndCoord.x, centerY = 100, radius = 30;
        Circle c1 = new Circle(centerX, centerY, radius, colorsAndCoord.c);
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