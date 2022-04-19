package edu.skidmore.cs326.spring2022.skribbage.gamification.events;

import java.beans.PropertyChangeEvent;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.FactoryTemplate;

/**
 * Subclass of FactoryTemplate that overwrites the eventCreation method to
 * handle gamification specific events.
 * 
 * @author
 */
public class GamificationFactoryTemplate extends FactoryTemplate {

    @Override
    public PropertyChangeEvent eventCreation(EventType event, Object source,
        Object... args) {
        // TODO Auto-generated method stub
        return null;
    }

}
