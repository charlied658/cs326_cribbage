package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.*;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import java.beans.PropertyChangeEvent;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.FactoryTemplate;

public class PersistenceFacade {

	private static final Logger LOG;
	private static final DatabaseManager DB_Instance;

	static {
		LOG = Logger.getLogger(FrontEndFactoryTemplate.class);
	}

	public String EventDBManager(EventType eventToHandle, Object[] metaData) {
		Boolean isSuccess = true;

		return isSuccess ? "success" : "fail";

	}

	 public static void main(String[] args) {

	}
}
