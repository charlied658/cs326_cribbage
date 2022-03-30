package edu.skidmore.cs326.spring2022.skribbage.common;

import java.beans.PropertyChangeEvent;

import java.util.Arrays;

import java.util.List;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.FrontEndFactoryTemplate;
import edu.skidmore.cs326.spring2022.skribbage.gamification.events.GamificationFactoryTemplate;
import edu.skidmore.cs326.spring2022.skribbage.logic.events.LogicFactoryTemplate;
import edu.skidmore.cs326.spring2022.skribbage.persistence.events.PersistanceFactoryTemplate;

/**
 * This class creates an event of type PropertyChangeEvent
 * from the metadata given in EventType enum.
 * 
 * @author Sten Leinasaar
 *         Last Edit: March 23, 2022
 */
public class EventFactory {

    /**
     * Singleton instance of a EventFactory.
     * Instance can be accessed through EventFactory.getInstance()
     */
    private static final EventFactory INSTANCE;

    /**
     * List of subclasses for FactoryTemplate class.
     */
    private List<FactoryTemplate> templates;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(EventFactory.class);
        INSTANCE = new EventFactory();
    }

    /**
     * EventFactory private constructor.
     */
    private EventFactory() {
        // ADD TO THE LIST HERE.

        List<? extends FactoryTemplate> templates = Arrays.asList(
            new LogicFactoryTemplate(), new GamificationFactoryTemplate(),
            new FrontEndFactoryTemplate(), new PersistanceFactoryTemplate());

    }

    /**
     * Synchronized getInstance of a EventFactory method.
     * 
     * @return Singleton instance of the factory.
     */
    public static synchronized EventFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Creates an event of type PropertyChangeEvent based on the
     * EventType enum value being passed.
     * 
     * @param event
     *            Type of an event as specified from the ENUM.
     * @param source
     *            Source that fired the update.
     * @param args
     *            Vararg of Object type.
     * @return An event of type that was specified.
     * @throws Exception
     *             Event Not Found when EventType cannot be created.
     */
    public PropertyChangeEvent createEvent(EventType event, Object source,
        Object... args) throws Exception {

        Object[] eventArgumentList = event.getArgumentList();

        for (int i = 0; i < eventArgumentList.length; i++) {

            if (args[i].getClass() == eventArgumentList[i]) {
                continue;

            } else {
                LOG.error(
                    "Illegal argument: Argument data types do not match enum");
                throw new IllegalArgumentException(
                    "Argument data types do not match enum");
            }
        }



        PropertyChangeEvent temp;
        LOG.trace(
            "Calling createEvent from each subclass "
                + "with their overWritten hook method.");
        for (FactoryTemplate subclass : templates) {
            temp = subclass.createEvent(event, source, args);
            if (temp != null) {
                LOG.trace(
                    "Event was returned by a subclass. Returning the event: "
                        + temp.toString());
                return temp;
            }

        }

        LOG.error("Event not found");
        throw new Exception("Event Not Found");

    }

}
