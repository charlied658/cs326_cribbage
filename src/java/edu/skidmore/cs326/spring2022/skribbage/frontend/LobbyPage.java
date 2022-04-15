package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
import java.awt.Dimension;
//import java.awt.Graphics2D;
import javax.swing.*;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;

import java.util.*;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;

/***
 * The "lobby," or the page that the player(s) see immediately before starting a
 * new game.
 * 
 * @author Jonah Marcus
 *         Last Update: April 11, 2022
 *         Last Edited by Jonah Marcus
 *         Code Reviewed March 27, 2022 - Zoe Beals
 *         Code Reviewed March 27, 2022 - Zoe Beals
 */

public class LobbyPage extends DrawingSurface implements ActionListener {
    /**
     * loggedInPlayer1 - The displayed player 1 name.
     */
    // private String loggedInPlayer1;

    /**
     * loggedInPlayer2 - The displayed player 2 name.
     */
    // private String loggedInPlayer2;

    /**
     * loggedInPlayer3 - The displayed player 3 name.
     */
    // private String loggedInPlayer3;

    /**
     * MAX_PLAYERS - Maximum player count in a given lobby.
     */
    private static final int MAX_PLAYERS = 3;

    /**
     * players - Holds instances of players in lobby.
     */
    private ArrayList<User> players = new ArrayList<User>();

    /**
     * playerNotLoggedIn - Up to three players can be logged into a single
     * instance of the program at once. This is the message that is displayed
     * when any one or more of the three potential spots is not filled by
     * a logged in player
     */
    // private String playerNotLoggedIn = "*PLAYER NOT LOGGED IN*";

    /**
     * mainframeWidth - int variable to hold main frame width.
     */
    private int mainframeWidth = 900;

    /**
     * mainframeHeight - int variable to hold main frame height.
     */
    private int mainframeHeight = 900;

    /**
     * mf - MainFrame variable to hold the window.
     */
    private MainFrame mf;

    /**
     * returnToMainMenu - Text variable to act as a button to return to home.
     */
    private Text returnToMainMenu;

    /**
     * startButton - Text object to act as a button to start the game once
     * =======
     * /**
     * startButton - Text object to act as a button to start the game once
     * >>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
     * all players have readied up.
     */
    private Text startButton;

    /**
     * player1Ready - Player 1 ready-up button.
     */
    private Circle player1Ready;

    /**
     * player2Ready - Player 2 ready-up button.
     */
    private Circle player2Ready;

    /**
     * player3Ready - Player 3 ready-up button.
     */
    private Circle player3Ready;

    /**
     * inventoryPage - Text object to be button to open the InventoryPage.
     */
    private Text inventoryPage;

    /**
     * navPage - NavigationPage window.
     */
    private NavigationPage navPage;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LobbyPage.class);
    }

    /**
     * LobbyPage constructor.
     */
    public LobbyPage() {
        LOG.trace("Entered LobbyPage Constructor.");
        mf = new MainFrame(this, "Pre-Game Lobby", mainframeWidth,
            mainframeHeight, false);
        setup();
    }

    /**
     * Takes new player to display on lobby page.
     * 
     * @param player
     */
    public void retrievePlayer(User player) {
        LOG.trace("Entered LobbyPage's getPlayer");
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
        }
    }

    /**
     * setup method - sets up the window.
     */
    private void setup() {
        LOG.trace("LobbyPage setup");
        setLayout(null);

        Image logo = new Image("logo.png", new Point(300, 0), 0.6, null);

        returnToMainMenu = new Text("Main Menu",
            new Point(20, 40), 25, Color.BLACK, Color.BLUE);
        startButton = new Text("Start Game", new Point(20, 250),
            25, Color.BLACK, Color.BLUE);

        int textStartingY = 100;

        // Hardcoded Users into ArrayList
//        retrievePlayer(new User("doinurmom69@sussybaka.net", "Bo Nehr",
//            "h0rr1bL3p@$$w0rd", UserRole.AUTHORIZED));
//        retrievePlayer(new User("sexhaver@reddit.com", "Hugh G. Rection",
//            "07Sept18kx83+&_4ajfS", UserRole.AUTHORIZED));

        add(new Text("Players in Lobby (Max " + MAX_PLAYERS + ")",
            new Point(25, 75), 20, Color.BLACK));

        for (int i = 0; i < players.size(); i++) {
            add(new Text(players.get(i).getUserName(), new Point(35,
                textStartingY), 16, Color.BLACK));
            textStartingY += 20;
        }

        /*
         * Text player1LoginSection = new Text(loggedInPlayer1,
         * new Point(35, 100), 16, Color.BLACK);
         * Text player2LoginSection = new Text(loggedInPlayer2,
         * new Point(35, 120), 16, Color.BLACK);
         * Text player3LoginSection = new Text(loggedInPlayer3,
         * new Point(35, 140), 16, Color.BLACK);
         */

        player1Ready = new Circle(new Point(10, 87), 15, Color.RED, Color.RED);
        player2Ready = new Circle(new Point(10, 107), 15, Color.RED, Color.RED);
        player3Ready = new Circle(new Point(10, 127), 15, Color.RED, Color.RED);

        // add(background);
        add(logo);
        add(returnToMainMenu);
        add(startButton);
        // add(inventoryPage);

        /*
         * add(player1LoginSection);
         * add(player2LoginSection);
         * add(player3LoginSection);
         */
        // add(player1Ready);
        // add(player2Ready);
        // add(player3Ready);
    }

    /**
     * getPlayerNames method - placeholder. Will eventually work with the
     * event listeners to receive the names of the players logged into
     * an instance of the program. For now, the names are hardcoded.
     */
    /*
     * private void getPlayerNames() {
     * LOG.trace("Entered getPlayerNames");
     * // All three will read playerNotLoggedIn message until a new name is
     * // received.
     * loggedInPlayer1 = playerNotLoggedIn;
     * loggedInPlayer2 = playerNotLoggedIn;
     * loggedInPlayer3 = playerNotLoggedIn;
     * loggedInPlayer1 = "[Redacted] \"Crypto\" [Redacted]";
     * loggedInPlayer2 = "Caleb \"Revenant\" Cross";
     * }
     */

    /**
     * setReadyButtonColor method - sets the color of the ready button.
     * 
     * @param c
     *            - the Circle to set.
     */
    private void setReadyButtonColor(Circle c) {
        LOG.trace("Entered setReadyButtonColor method.");
        if (c.getBorderColor().equals(Color.RED)) {
            c.setBorderColor(Color.GREEN);
            c.setFillColor(Color.GREEN);
        } else {
            c.setBorderColor(Color.RED);
            c.setFillColor(Color.RED);
        }
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in LobbyPage.java");
        if (e == returnToMainMenu) {
            returnToMainMenu.setBorderColor(Color.CYAN);
            Utility.pause(100);
            returnToMainMenu.setBorderColor(Color.BLACK);
            navPage = new NavigationPage();
            mf.dispose();
        } else if (e == player1Ready) {
            setReadyButtonColor(player1Ready);
        } else if (e == player2Ready) {
            setReadyButtonColor(player2Ready);
        } else if (e == player3Ready) {
            setReadyButtonColor(player3Ready);
        } else if (e == startButton) {

            // Placeholder - not functional yet
            startButton.setBorderColor(Color.CYAN);
            Utility.pause(100);
            startButton.setBorderColor(Color.BLACK);

            // Placeholder - not functional yet
            startButton.setBorderColor(Color.CYAN);
            Utility.pause(100);
            startButton.setBorderColor(Color.BLACK);
            new StartGamePage();
            mf.dispose();

        } else if (e == inventoryPage) {
            inventoryPage.setBorderColor(Color.CYAN);
            Utility.pause(100);
            inventoryPage.setBorderColor(Color.BLACK);
            new InventoryPage();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        LOG.trace("Entered actionPerformed method in LobbyPage.java");

    }

    /**
     * main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("LobbyPage.java main method");
        new LobbyPage();
    }
}
