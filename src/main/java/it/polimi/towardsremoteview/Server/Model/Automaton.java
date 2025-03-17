package it.polimi.towardsremoteview.Server.Model;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Automaton {

    private Boolean paid = false;
    private DinnerPhase state = DinnerPhase.ENTREE;

    public DinnerPhase getState(){
        return state;
    }

    private Boolean canEvolve(){
        int currOrd = state.ordinal();
        int dessertOrd = DinnerPhase.DESSERT.ordinal();

        if (currOrd >= dessertOrd && !paid) {
            System.out.println("PAY BEFORE!!!");
            return false;
        }
        return true;
    }

    public void setPaid(){
        paid = true;
    }


    public Boolean evolve() {
        if (!canEvolve())
            return false;

        int currOrd = state.ordinal();
        int lastOrd = DinnerPhase.THE_END_OF_LUNCH.ordinal();

        if (currOrd < lastOrd) {
            DinnerPhase next = state.next();
            tellToListener(state, next);
            // and update:
            state = next;
            return true;
        }
        return false;
    }


    public Boolean evolveTo(DinnerPhase toState){
        if (!canEvolve())
            return false;

        int toOrd = toState.ordinal();
        int currOrd = state.ordinal();

        if (toOrd>currOrd) {
            tellToListener(state, toState);
            // and update:
            state = toState;
            return true;
        }
        return false;
    }


    private void tellToListener(DinnerPhase from, DinnerPhase to ){
        PropertyChangeEvent evt = new PropertyChangeEvent(
                this,
                "PHASE_CHANGED",
                from, to);
            listener.propertyChange(evt);
    }


    private PropertyChangeListener listener;

    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }

}
