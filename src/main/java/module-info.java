module it.polimi.towardsremoteview {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.polimi.towardsremoteview to javafx.fxml;
    exports it.polimi.towardsremoteview;
    exports it.polimi.towardsremoteview.Model;
    opens it.polimi.towardsremoteview.Model to javafx.fxml;
}