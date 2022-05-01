package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
//import java.awt.event.WindowEvent;
//import java.awt.Dimension;
//import java.awt.Graphics2D;
//import javax.swing.*;
import java.util.ArrayList;
//import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.common.LobbyManager;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
//import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;

//import java.util.*;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
//import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;

/***
 * The "lobby," or the page that the player(s) see immediately before starting a
 * new game.
 *
 * @author Jonah Marcus
 *         Last Update: April 27, 2022
 *         Last Edited by Jonah Marcus
 *         Code Reviewed March 27, 2022 - Zoe Beals
 *         Code Reviewed March 27, 2022 - Zoe Beals
 */

@SuppressWarnings("serial")
public class LobbyPage extends SkribbageDrawingSurface implements Page {
    
    /**
     * CPU_COLOR - CPU's "ready up" button should always be this color.
     */
    private static final Color CPU_COLOR = Color.CYAN;
    
    /**
     * The host of the lobby retrieved from the lobby manager.
     */
    private User host;
    
    /**
     * Instance of Computer Dealer.
     */
    private User playerCPU;

    /**
     * MAX_PLAYERS - Maximum player count in a given lobby.
     */
    private static final int MAX_PLAYERS = 3;

    /**
     * players - Holds instances of players in lobby.
     */
    private ArrayList<User> players = new ArrayList<>();
    
    /**
     * playersDisplay - Holds instances of Text that are
     * used to display players in lobby.
     */
    private ArrayList<Text> playersDisplay = new ArrayList<>();
    
    /**
     * readyUpButtons - Holds instances of clickable buttons
     * that are used to ready up.
     */
    private ArrayList<Circle> readyUpButtons = new ArrayList<>();

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
    @SuppressWarnings("unused")
    private MainFrame mf;

    /**
     * returnToMainMenu - Text variable to act as a button to return to home.
     */
    private Text returnToMainMenu;

    /**
     * startButton - Text object to act as a button to start the game once
     * all players have readied up.
     */
    private Text startButton;

    /**
     * inventoryPage - Text object to be button to open the InventoryPage.
     */
    private Text inventoryPageButton;

    /**
     * navPage - NavigationPage window.
     */
    @SuppressWarnings("unused")
    private NavigationPage navPage;

    /**
     * PageManager instance for managing pages.
     */
    private PageManager pageManager;

    /**
     * Lobby manager instance for managing the lobby.
     */
    private LobbyManager lobbyManager;

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
        pageManager = PageManager.getInstance();
        lobbyManager = LobbyManager.getInstance();
        new MainFrame(this, "Pre-Game Lobby", mainframeWidth,
            mainframeHeight, false);
        host = lobbyManager.getActiveLobby().getHost();
        addPlayer(host);
        playerCPU = new User(null, "[CPU] Computer Dealer", UserRole.CPU);
        addPlayer(playerCPU);
        setup();
        positionWindow();
    }

    /**
     * Adds player to ArrayList of Users.
     * @param player
     * @throws Error - When attempting to add a new player when the
     * lobby is full.
     */
    public void addPlayer(User player) throws Error {
        LOG.trace("Entered LobbyPage's addPlayer");
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            updatePage();
        } else {
            throw new Error("Maximum number of players already in lobby.");
        }
    }
    
    /**
     * Removes player from ArrayList of Users.
     * @param player
     * @throws Error - When lobby is empty.
     */
    public void removePlayer(User player) throws Error {
        LOG.trace("Entered LobbyPage's removePlayer");
        if (players.size() > 0) {
            players.remove(player);
            updatePage();
        } else {
            throw new Error("Lobby is empty.");  
        }
    }
    
    /**
     * Updates the lobby's displayed players whenever
     * a player is added or removed.
     */
    public void updatePage() {
        for (Text player : playersDisplay) {
            remove(player);
        }
        for (Circle button : readyUpButtons) {
            remove(button);
        }
        playersDisplay.clear();
        readyUpButtons.clear();
        displayPlayers();
    }
    
    /**
     * Takes players from ArrayList and displays them in lobby.
     */
    public void displayPlayers() {
        int textStartingY = 125;
        
        for (User player : players) {
            Text playerText = new Text(player.getUserName(), new Point(35,
                textStartingY), 16, Color.BLACK); 
            playersDisplay.add(playerText);
            add(playerText);
            int circleDiameter = 15;
            boolean cpu = player.getUserRole() == UserRole.CPU;
            Circle readyUp = new Circle(new Point(15, textStartingY 
                - circleDiameter),
                circleDiameter, cpu ? CPU_COLOR : Color.RED,
                                    cpu ? CPU_COLOR : Color.RED);
            readyUpButtons.add(readyUp);
            add(readyUp);
            textStartingY += 20;
        }
    }

    /**
     * setup method - sets up the window.
     */
    public void setup() {
        LOG.trace("LobbyPage setup");
        setLayout(null);

        Image logo = new Image("logo.png", new Point(300, 0), 0.6, null);

        returnToMainMenu = new Text("Main Menu",
            new Point(20, 40), 25, Color.BLACK, Color.BLUE);
        startButton = new Text("Start Game", new Point(20, 250),
            25, Color.BLACK, Color.BLUE);
        inventoryPageButton = new Text("Inventory Page", new Point(20, 300),
            25, Color.BLACK, Color.BLUE);

        

        add(new Text("Players in Lobby (Max " + MAX_PLAYERS + ")",
            new Point(25, 75), 20, Color.BLACK));
        add(new Text(
            "Lobby ID: " + lobbyManager.getActiveLobby()
                .getId(),
            new Point(25, 100), 20, Color.BLACK));

        displayPlayers();

        add(logo);
        add(returnToMainMenu);
        add(startButton);
        add(inventoryPageButton);

    }
    
    /**
     * setReadyButtonColor method - sets the color of the ready button.
     *
     * @param c - the Circle to set.
     */
    public void setReadyButtonColor(Circle c) {
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
            closeWindow();
            navPage = (NavigationPage) pageManager
                .createPage(PageType.NAVIGATION_PAGE);
            lobbyManager.deleteLobby(lobbyManager.getActiveLobby());
            
        } else if (e instanceof Circle) {
            Circle clickedCircle = (Circle) e;
            if (!(clickedCircle.getFillColor() == CPU_COLOR)) {
                setReadyButtonColor((Circle) e);
            }

        } else if (e == startButton) {

            // Placeholder - not functional yet
            startButton.setBorderColor(Color.CYAN);
            Utility.pause(100);
            startButton.setBorderColor(Color.BLACK);

            // Placeholder - not functional yet
            startButton.setBorderColor(Color.CYAN);
            Utility.pause(100);
            startButton.setBorderColor(Color.BLACK);
            closeWindow();
            pageManager.createPage(PageType.START_GAME_PAGE);
            

        } else if (e == inventoryPageButton) {
            inventoryPageButton.setBorderColor(Color.CYAN);
            Utility.pause(100);
            inventoryPageButton.setBorderColor(Color.BLACK);
            closeWindow();
            pageManager.createPage(PageType.INVENTORY_PAGE);
            
        }

    }
    
    /**
     * Returns reference to players ArrayList for unit testing
     * purposes.
     * @return players
     */
    public ArrayList<User> getPlayers() {
        return players;
    }
    
    /**
     * Returns reference to host for unit testing purposes.
     * @return host
     */
    public User getHost() {
        return host;
    }
    
    /**
     * Returns reference to playerCPU for unit testing purposes.
     * @return playerCPU;
     */
    public User getCPU() {
        return playerCPU;
    }

}
