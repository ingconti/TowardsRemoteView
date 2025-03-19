package it.polimi.towardsremoteview.Client;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewUpdater {

    private Controller parentController;

    public ViewUpdater(Controller parentController) {
        this.parentController = parentController;
    }


    public void buildUpStage() {

        Button evolveButton = new Button("Evolve");
        evolveButton.setOnAction(value ->  {

        });
    }

}
