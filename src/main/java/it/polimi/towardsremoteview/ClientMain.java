package it.polimi.towardsremoteview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(ClientMain.class.getResource("hello-view.fxml"));

        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        //was: controller.setStage(stage);
        controller.setStage(stage, this.virtualServer);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // added:
        this.virtualServer.start();
    }


    public static void main(String[] args) {
        launch();
    }


    /*removed
     Automaton automaton;
    public ClientMain() {
        //removed this.automaton = new Automaton();
    }
     */

    VirtualServer   virtualServer;
    public ClientMain() {
        this.virtualServer = new VirtualServer();
    }
}