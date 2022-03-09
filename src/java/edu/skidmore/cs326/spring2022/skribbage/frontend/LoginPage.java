package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DialogPosition;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

//import java.awt.Point;
/**
 * 
 * @author zbeals
 *
 */
public class LoginPage extends DrawingSurface {
	
	private MainFrame loginPage;
	private Text login;
	private String username, usernameToChange;
	private String password, passwordToChange, verifyPasswordToChange;
	private Text changePassword;
	
	public LoginPage() {
		loginPage = new MainFrame(this, "Skribbage Battle Royale", 900, 900, true);
		setup();
	}
	
	public void setup() {
		login = new Text("Login", new Point(50, 50), 20, Color.black, Color.blue);
		changePassword = new Text("Change Password", new Point(login.getLocation().x + 100, 50), 20, Color.black, Color.blue);
		add(login);
		add(changePassword);
	}
	
	public void changePasswordButtonClicked(boolean presentUser) {
		if (presentUser) {
			usernameToChange = getUserInput("Change Password", "Enter username", DialogPosition.CENTER_ALL);
		}
		passwordToChange = getUserInput("Change Password", "Enter new password", DialogPosition.CENTER_ALL, true);
		verifyPasswordToChange = getUserInput("Change Password", "Enter password again", DialogPosition.CENTER_ALL, true);
	}
	
	public void drawableMouseClick(Drawable e) {
		if (e == login) {
			login.setFillColor(Color.GREEN);
			addMessage("Login button clicked");
			username = getUserInput("Login", "Enter username", DialogPosition.CENTER_ALL);
			password = getUserInput("Login", "Enter password for: " + username, DialogPosition.CENTER_ALL, true);
		} else if (e == changePassword) {
			changePassword.setFillColor(Color.GREEN);
			changePasswordButtonClicked(true);
			if (passwordToChange.equals(verifyPasswordToChange)) {
				addMessage("Passwords are the same");
				password = passwordToChange;
				username = usernameToChange;
			} else {
				addMessage("Passwords are not the same");
				while (!passwordToChange.equals(verifyPasswordToChange)) {
					changePasswordButtonClicked(false);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginPage();
	}
}
