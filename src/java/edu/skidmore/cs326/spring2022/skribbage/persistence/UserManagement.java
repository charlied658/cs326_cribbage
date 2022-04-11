package edu.skidmore.cs326.spring2022.skribbage.persistence;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;

public interface UserManagement {

	public boolean userCreate(User userToCreate, Password password);
	
	public boolean userDelete(User userToDelete);
	
	public boolean passwordChange(User userToUpdate, Password currentPassword, Password newPassword);
	
	public boolean userChange(User userToChange, Object... args);
	
	
}
