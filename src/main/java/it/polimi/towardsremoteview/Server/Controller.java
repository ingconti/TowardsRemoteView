package it.polimi.towardsremoteview.Server;

import it.polimi.towardsremoteview.Server.Model.Automaton;
import it.polimi.towardsremoteview.Server.Model.DinnerPhase;

public class Controller {
    Automaton model = null;

    public Controller(Automaton model) {
        this.model = model;
    }

    String processCmd(String s){ // Business logic
        String stateString;
        Boolean goOn = false;

        s = s.toUpperCase();
        System.out.println(s);
        if (s.equals("G")){
            goOn = model.evolve();
        }else if (s.equals("P")){
            model.setPaid();
        }else{
            DinnerPhase ph = DinnerPhase.fromString(s);
            goOn = model.evolveTo(ph);
        }

        stateString = model.getState().toString();
        return stateString;
    }
}
