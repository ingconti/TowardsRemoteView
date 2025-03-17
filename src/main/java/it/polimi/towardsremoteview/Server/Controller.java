package it.polimi.towardsremoteview.Server;

import it.polimi.towardsremoteview.Server.Model.Automaton;

public class Controller {
    Automaton model = null;

    public Controller(Automaton model) {
        this.model = model;
    }

    public void evolve(String cmd) {
        this.model.evolve();
    }

}
