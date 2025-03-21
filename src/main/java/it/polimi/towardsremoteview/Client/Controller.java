package it.polimi.towardsremoteview.Client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
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
                if (answer.equals("DESSERT")){
                    safeCleanUpAll();
                }
            }
        };

        virtualServer.setUICallBack(this.updateUICallBack);
    }


    private void cleanUpAll() {
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void safeCleanUpAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                cleanUpAll();
            }
        });
    }



    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }



}