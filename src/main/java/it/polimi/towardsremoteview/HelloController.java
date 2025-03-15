package it.polimi.towardsremoteview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    private Stage stage;
    public void setStage(Stage stage, Automaton automaton) {
        stage = stage;
        this.automaton = automaton;
    }

    private Automaton automaton;


}