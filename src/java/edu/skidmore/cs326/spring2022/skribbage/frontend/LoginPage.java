package edu.skidmore.cs326.spring2022.skribbage.frontend;

//import java.awt.Point;
import javax.swing.JPanel;

import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JTextField;
//import javax.swing.Spring;
//import javax.swing.SpringLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
//import java.awt.CardLayout;
import java.awt.Color;
//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Graphics2D;
//import java.awt.Dimension;
import java.awt.FlowLayout;
//
//import us.daveread.edu.graphics.shape.Drawable;
//import us.daveread.edu.graphics.shape.impl.Text;
//import us.daveread.edu.graphics.shape.impl.Image;
//import us.daveread.edu.graphics.surface.DrawingSurface;
//import us.daveread.edu.graphics.surface.MainFrame;
//import us.daveread.edu.graphics.shape.impl.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Class.....
* @author Zoe Beals
*
*/
public class LoginPage {
	// Text username;
//	Text password;
//	JButton loginButton;
//	JButton changePassword;
//	JTextField usernameField;
//	JTextField passwordField;
//	static String user;
//	static String pass;
//	MainFrame temp;
//	JLabel username;
//	Text logo;
//	JPanel buttons;

	/**
	 * Lol.
	 */
	private JButton changePass; // Button to eventually change password
	/**
	 * 
	 */
	private JFrame frame; // frame of the page
	/**
	 * 
	 */
	private JPanel buttonPanel, textPanel; // panels to hold the buttons and the user inputs
	/**
	 * 
	 */
	private JLabel user, pass; // uesrname and password labels
	/**
	 * 
	 */
	private JTextField userField, passField; // textfields for username and password input
	/**
	 * 
	 */
	private JButton login; // login button
	/**
	 * 
	 */
	private boolean[] userInputs = new boolean[2]; // boolean to hold if username and password were both successfully
													// entered and the enter key was pressed

	/**
	 * LoginPage constructor instantiates all of the class variables with
	 * appropriate information checks for input other than an empty string in
	 * username and password textfields changes state of login button based on user
	 * inputs. adds button panel and inputs panel to frame and displays frame
	 * 
	 *
	 */
	public LoginPage() {
//		temp = new MainFrame(this, 900, 900, false);
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				setup();
//			}
//		});
		/**
		 * 
		 */
		frame = new JFrame("Skribbage Battle Royale");

		buttonPanel = new JPanel();
		textPanel = new JPanel();
		user = new JLabel("Username: ");
		pass = new JLabel("Password: ");
		userField = new JTextField(10);
		passField = new JPasswordField(10);
		// adds a listener to the text field to be able to get the input the user types
		userField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (userField.getText() != "") {
					userInputs[0] = true; // sets username input to valid
				}
			}
		});
		// adds a listener to the text field to be able to get the input the user types
		passField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (passField.getText() != "") {
					userInputs[1] = true; // sets pasword input to valid
				}
			}
		});
		login = new JButton("Login");
		// adds a listener to the button to be able to change state
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (userInputs[0] && userInputs[1]) {
					login.setBackground(Color.green); // set color to green to represent valid login
				} else {
					login.setBackground(Color.red); // set color to red to represent invalid login
				}
			}
		});
		changePass = new JButton("Change Password");
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setLayout(new FlowLayout());
		// adding things to each panel
		textPanel.add(user);
		textPanel.add(userField);
		textPanel.add(pass);
		textPanel.add(passField);
		buttonPanel.add(login);
		buttonPanel.add(changePass);
		// adding to the frame
		frame.add(textPanel, BorderLayout.PAGE_START);
		frame.add(buttonPanel, BorderLayout.PAGE_END);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	public void setup() {
		// username = new JLabel("hello");
//		logo = new Text("Skribbage Battle Royale", new Point(200, 100), 40, Color.black);
//		username = new Text("Enter username: ", new Point(10, 20), 15, Color.black);
//		password = new Text("Enter password: ", new Point(10, 40), 15, Color.black);
//		add(username);
//		add(password);
//		add(logo);
//		boolean[] inputs = new boolean[2];
//		usernameField = new JTextField(10);
//		usernameField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				user = usernameField.getText();
//				if (user != "") {
//					inputs[0] = true;
//				}
//				System.out.println("username: " + user);
//			}
//		});
//		add(usernameField);
//		passwordField = new JTextField(10);
//		passwordField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				pass = passwordField.getText();
//				if (pass != "") {
//					inputs[1] = true;
//				}
//				System.out.println("password: " + pass);
//			}
//		});
//		System.out.println("after:" + usernameField.getText());
//		System.out.println("after: " +passwordField.getText());
//		loginButton = new JButton("Login");
//		loginButton.setBackground(Color.white);
//		loginButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				if (inputs[0] && inputs[1]) {
//					loginButton.setBackground(Color.green);
//				} else {
//					loginButton.setBackground(Color.red);
//				}
//			}
//		});
//		add(loginButton);
//		add(passwordField);
		// Trying out springlayout
//		loginButton = new JButton("Login");
//		buttons = new JPanel();
//		buttons.setLayout(new FlowLayout());
//		buttons.add(loginButton);
//		String[] labels = {"Username: ", "Password: "};
//		int numPairs = labels.length;
//		JPanel p = new JPanel(new SpringLayout());
//		for (int i = 0; i < numPairs; i++) {
//			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
//			p.add(l);
//			JTextField textField = new JTextField(10);
//			textField.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent event) {
//					System.out.println(l.getText() + textField.getText());
//				}
//			});
//			l.setLabelFor(textField);
//			p.add(textField);
//		}
//		makeCompactGrid(p, numPairs, 2, 6, 6, 6, 6);
////		JFrame frame = new JFrame("Skribbage Battle Royale");
//		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		p.setOpaque(false);
//		temp.setContentPane(p);
//		temp.add(buttons, BorderLayout.PAGE_END);
//		temp.pack();
//		temp.setVisible(true);

	}

//	public static void makeCompactGrid(Container parent, int rows, int cols, int initialX, int initialY, int xPad, int yPad) {
//		SpringLayout layout;
//		try {
//			layout = (SpringLayout)parent.getLayout();
//		} catch (ClassCastException ex) {
//			System.err.println("The first argument to makeCompactGrid must use SpringLayout");
//			return;
//		}
//		Spring x = Spring.constant(initialX);
//		for (int c = 0; c < cols; c++) {
//			Spring width = Spring.constant(0);
//			for (int r = 0; r < rows; r++) {
//				width = Spring.max(width, getConstraintsForCell(r, c, parent, cols).getWidth());
//				SpringLayout.Constraints constraints = getConstraintsForCell(r, c, parent, cols);
//				constraints.setX(x);
//				constraints.setWidth(width);
//			}
//			x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
//		}
//		Spring y = Spring.constant(initialY);
//		for (int r = 0; r < rows; r++) {
//			Spring height = Spring.constant(0);
//			for (int c = 0; c < cols; c++) {
//				height = Spring.max(height, getConstraintsForCell(r, c, parent, cols).getHeight());
//				SpringLayout.Constraints constraints = getConstraintsForCell(r, c, parent, cols);
//				constraints.setY(y);
//				constraints.setHeight(height);
//			}
//			y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
//		}
//		SpringLayout.Constraints pCons = layout.getConstraints(parent);
//		pCons.setConstraint(SpringLayout.SOUTH, y);
//		pCons.setConstraint(SpringLayout.EAST, x);
//	}
//	
//	private static SpringLayout.Constraints getConstraintsForCell(int row, int col, Container parent, int cols) {
//		SpringLayout layout = (SpringLayout) parent.getLayout();
//		Component c = parent.getComponent(row*cols + col);
//		return layout.getConstraints(c);
//	}
//	
//	
//	public static void setContainerSize(Container parent, int pad) {
//		SpringLayout layout = (SpringLayout)parent.getLayout();
//		Component[] components = parent.getComponents();
//		Spring maxHeightSpring = Spring.constant(0);
//		SpringLayout.Constraints pCons = layout.getConstraints(parent);
//		Component rightmost = components[components.length - 1];
//		SpringLayout.Constraints rCons = layout.getConstraints(rightmost);
//		pCons.setConstraint(SpringLayout.EAST, Spring.sum(Spring.constant(pad), rCons.getConstraint(SpringLayout.EAST)));
//		
//		for (int i = 0; i < components.length; i++) {
//			SpringLayout.Constraints cons = layout.getConstraints(components[i]);
//			maxHeightSpring = Spring.max(maxHeightSpring, cons.getConstraint(SpringLayout.SOUTH));
//		}
//		pCons.setConstraint(SpringLayout.SOUTH, Spring.sum(Spring.constant(pad), maxHeightSpring));
//	}

	public static void main(String[] args) {
		new LoginPage();
	}

}
