module it.polimi.towardsremoteview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports it.polimi.towardsremoteview.Server.Model;
    opens it.polimi.towardsremoteview.Server.Model to javafx.fxml;
    exports it.polimi.towardsremoteview.Server;
    opens it.polimi.towardsremoteview.Server to javafx.fxml;
    exports it.polimi.towardsremoteview.Client;
    opens it.polimi.towardsremoteview.Client to javafx.fxml;
}