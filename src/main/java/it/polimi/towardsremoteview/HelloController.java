package it.polimi.towardsremoteview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
       //was: welcomeText.setText("Welcome to JavaFX Application!");
        this.automaton.evolve();
        this.updateView();
    }

    void updateView(){
        String status = this.automaton.getState().toString();
        this.welcomeText.setText(status);
    }

    private Stage stage;
    public void setStage(Stage stage, Automaton automaton) {
        stage = stage;
        this.automaton = automaton;
    }

    private Automaton automaton;


}