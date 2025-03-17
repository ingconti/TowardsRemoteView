package it.polimi.towardsremoteview.Server.Model;


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
            state = state.next();
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
            state = toState;
            return true;
        }
        return false;
    }

    private PropertyChangeListener listener;

    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }

}
