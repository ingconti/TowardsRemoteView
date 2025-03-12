module it.polimi.towardsremoteview {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.polimi.towardsremoteview to javafx.fxml;
    exports it.polimi.towardsremoteview;
}