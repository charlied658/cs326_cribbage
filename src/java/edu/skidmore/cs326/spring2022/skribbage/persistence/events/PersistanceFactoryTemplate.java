package edu.skidmore.cs326.spring2022.skribbage.persistence.events;

import java.beans.PropertyChangeEvent;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.FactoryTemplate;

/**
 * Subclass of FactoryTemplate that overwrites the eventCreation method to
 * handle persistance specific events.
 * 
 * @author
 *
 */
public class PersistanceFactoryTemplate extends FactoryTemplate {

	@Override
	public PropertyChangeEvent eventCreation(EventType event, Object source, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
