package it.polimi.towardsremoteview.Server;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ModelListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String debugStr = evt.getPropertyName()  + " " +
                evt.getOldValue() + evt.getNewValue();
        System.out.println(debugStr);
    }
}
