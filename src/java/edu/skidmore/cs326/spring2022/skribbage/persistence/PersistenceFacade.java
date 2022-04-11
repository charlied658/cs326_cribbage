package edu.skidmore.cs326.spring2022.skribbage.persistence;

//import edu.skidmore.cs326.spring2022.skribbage.frontend.events.*;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
//import java.beans.PropertyChangeEvent;

//import org.apache.log4j.Logger;

/**
 * Will contain the methods for an event listener and call the methods in the DatabaseManager
 */
public class PersistenceFacade {

//<<<<<<< HEAD
	//private static final Logger LOG;
	//private static final DatabaseManager DB_Instance;
	

//	static {
//		LOG = Logger.getLogger(FrontEndFactoryTemplate.class);
//	}

//	public String EventDBManager(EventType eventToHandle, Object[] metaData) {
//		Boolean isSuccess = true;
//
//		return isSuccess ? "success" : "fail";
//
//	}

//	 public static void main(String[] args) {
//
//	}
//=======
//    private static final Logger LOG;
//
//    private static DatabaseManager DB_Instance;
//
//    static {
//        LOG = Logger.getLogger(FrontEndFactoryTemplate.class);
//    }

	/**
	 * Will listen for the events and manage what method is being called
	 * @param eventToHandle the event that is being passed
	 * @param metaData the information that we are going to store
	 * @return if the event was successful or not
	 * 
	 */
    public String EventDBManager(EventType eventToHandle, Object[] metaData) {
        Boolean isSuccess = true;
        switch (eventToHandle) {
            case USER_LOGIN:

                return isSuccess ? "success" : "fail";
            case USER_DELETE_ACCOUNT:
                return isSuccess ? "success" : "fail";
            case USER_CREATE_ACCOUNT:
                return isSuccess ? "success" : "fail";
            case USER_CHANGE_PASSWORD:
                return isSuccess ? "success" : "fail";
            default:
                return "not valid persistence event";
        }

    }

//    public static void main(String[] args) {
//
//    }
//>>>>>>> 01d6bd53f021b02c7735798961a7c627dd271523
}
