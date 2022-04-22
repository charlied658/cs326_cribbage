package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
//import java.awt.event.WindowEvent;
import java.util.HashMap;

//import java.awt.Graphics2D;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Suit;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;

/***
 * The page that shows the player's inventory. Players can
 * send and receive tokens and items to and from other players.
 * 
 * @author Jonah Marcus
 *         Last Update: April 11, 2022
 *         Last Edited by Jonah Marcus
 */
@SuppressWarnings("serial")
public class InventoryPage extends DrawingSurface implements Page {

    /**
     * mf - Holds reference to the window.
     */
    private MainFrame mf;

    /**
     * inventory - Holds all items/cards in inventory.
     */
    private HashMap<String, Card> inventory = new HashMap<String, Card>();

    /**
     * mainframeHeight - int variable to hold main frame height.
     */
    private int mainframeHeight = 750;

    /**
     * mainframeWidth - int variable to hold main frame width.
     */
    private int mainframeWidth = 750;

    /**
     * closeWindow - Text object that closes the window when clicked.
     */
    private Text closeWindow;

    /**
     * Object of type text that represents going back to lobby.
     */
    private Text lobbyButton;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PastGamesPage.class);
    }

    /**
     * InventoryPage constructor.
     */
    public InventoryPage() {
        LOG.trace("Entered InventoryPage Constructor.");
        mf = new MainFrame(this, "Inventory", mainframeWidth,
            mainframeHeight, false);
        setup();
    }

    /**
     * setup method - sets up the window.
     */
    public void setup() {
        LOG.trace("Entered setup (InventoryPage)");
        setLayout(null);

        Image logo = new Image("logo.png", new Point(320, 0), 0.45, null);

        closeWindow = new Text("Close",
            new Point(20, 40), 25, Color.BLUE, Color.BLACK);
        lobbyButton = new Text("Back to Lobby", new Point(20, 50), 25,
            Color.BLACK, Color.BLUE);
        add(new Text("Inventory:", new Point(30, 90), 20, Color.BLACK));

        // Placeholder cards
        inventory.put("one", new Card(Rank.KING, Suit.CLUBS));
        inventory.put("two", new Card(Rank.ACE, Suit.SPADES));
        inventory.put("three", new Card(Rank.SEVEN, Suit.DIAMONDS));
        inventory.put("four", new Card(Rank.TWO, Suit.HEARTS));
        inventory.put("five", new Card(Rank.SIX, Suit.DIAMONDS));
        inventory.put("six", new Card(Rank.NINE, Suit.CLUBS));
        inventory.put("seven", new Card(Rank.QUEEN, Suit.SPADES));

        Card[] allItems =
            inventory.values().toArray(new Card[inventory.size()]);

        int initXPosition = 30;
        int initYPosition = 115;

        for (Card item : allItems) {
            add(new Text(item.getSuit().getName() + " - "
                + item.getRank().getName(),
                new Point(initXPosition,
                    initYPosition),
                16, Color.BLACK));
            initYPosition += 25;
        }

        //add(closeWindow);
        add(lobbyButton);
        add(logo);
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in InventoryPage.java");
        if (e == closeWindow) {
            closeWindow.setBorderColor(Color.CYAN);
            Utility.pause(100);
            closeWindow.setBorderColor(Color.BLACK);
            closeWindow();
        } else if (e == lobbyButton) {
            PageManager.getInstance().createPage(PageType.LOBBY_PAGE);
            closeWindow();
        }

    }
    /**
     * Method from Page interface, to close the window.
     */
    public void closeWindow() {
        mf.dispose();
    }
     /**
     * @param args
     */
    /*
    public static void main(String[] args) {
        new InventoryPage();
    }
    */

}
