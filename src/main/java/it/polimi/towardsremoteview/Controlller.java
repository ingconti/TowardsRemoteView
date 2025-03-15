package it.polimi.towardsremoteview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controlller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
       /*removed:
        welcomeText.setText("Welcome to JavaFX Application!");
        this.automaton.evolve();
        */
        this.updateView();
    }

    void updateView(){
        /* removed
        String status = this.automaton.getState().toString();
        this.welcomeText.setText(status);
        */
    }

    private Stage stage;
    //was: public void setStage(Stage stage, Automaton automaton) {
        public void setStage(Stage stage) {
        stage = stage;
        //removed: this.automaton = automaton;
    }

    //removed: private Automaton automaton;
}