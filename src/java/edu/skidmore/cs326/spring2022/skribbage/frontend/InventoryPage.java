package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
//import java.awt.event.WindowEvent;
//import java.util.HashMap;
import java.util.ArrayList;

//import java.awt.Graphics2D;

import org.apache.log4j.Logger;

//import edu.skidmore.cs326.spring2022.skribbage.common.Card;
//import edu.skidmore.cs326.spring2022.skribbage.common.Player;
//import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
//import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DialogPosition;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/***
 * The page that shows the player's inventory. Players can
 * send and receive tokens and items to and from other players.
 * 
 * @author Jonah Marcus
 *         Last Update: April 29, 2022
 *         Last Edited by Jonah Marcus
 */
@SuppressWarnings("serial")
public class InventoryPage extends SkribbageDrawingSurface implements Page {

    /**
     * mf - Holds reference to the window.
     */
    @SuppressWarnings("unused")
    private MainFrame mf;

    /**
     * currentUser - Current player whose inventory this is.
     */
    private User currentUser;

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
     * Button to purchase an Item.
     */
    private Text purchaseButton;

    /**
     * Name of the item to add.
     */
    private String itemToAdd;

    /**
     * ArrayList to wipe Inventory.
     */
    private ArrayList<Text> inventoryRender;

    /**
     * Object of type text that represents going back to lobby.
     */
    // JFrame frame;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(InventoryPage.class);
    }

    /**
     * InventoryPage constructor.
     */
    public InventoryPage() {
        LOG.trace("Entered InventoryPage Constructor.");
        // PLACEHOLDER - Add way to get player from database
        currentUser = PageManager.getInstance().getLoggedInUser();
        new MainFrame(this, "Inventory", mainframeWidth,
            mainframeHeight, false);
        setup();
        positionWindow();

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
        purchaseButton = new Text("Buy an Item", new Point(20, 385), 25,
            Color.BLACK, Color.BLUE);
        add(new Text("Inventory:", new Point(30, 90), 20, Color.BLACK));
        add(new Text("New Inventory:", new Point(30, 420), 20, Color.BLACK));

        int initXPosition = 30;
        int initYPosition = 115;

        inventoryRender = new ArrayList<>();

        currentUser.getInventoryManager().updateInventory();

        Object[] objectArray = currentUser.getInventoryManager()
            .createInventory().entrySet().toArray();

        for (int i = 0; i < objectArray.length; i++) {
            add(new Text(objectArray[i] + "  ",
                new Point(initXPosition,
                    initYPosition),
                16, Color.BLACK));
            initYPosition += 25;
        }

        // add(closeWindow);

        add(lobbyButton);
        add(purchaseButton);
        add(logo);

    }

    @Override
    public void drawableMouseClick(Drawable e) {
        int initXPosition = 30;
        int initYPosition = 450;
        LOG.trace("DrawableMouseClick in InventoryPage.java");
        if (e == closeWindow) {
            closeWindow.setBorderColor(Color.CYAN);
            Utility.pause(100);
            closeWindow.setBorderColor(Color.BLACK);
            closeWindow();
        } else if (e == lobbyButton) {
            closeWindow();
            PageManager.getInstance().createPage(PageType.LOBBY_PAGE);

        } else if (e == purchaseButton) {
            JFrame frame = new JFrame();
            if (currentUser.getInventoryManager()
                .searchForItem("Tokens") < 100) {
                JOptionPane.showMessageDialog(null,
                    "You're poor",
                    "Important Message",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                itemToAdd =
                    JOptionPane.showInputDialog(frame,
                        "Enter the name of the item you want");
                currentUser.getInventoryManager().addItem(itemToAdd, 1);
                currentUser.getInventoryManager().removeTokens("Tokens", 100);

                Object[] objectArray = currentUser.getInventoryManager()
                    .createInventory().entrySet().toArray();

                for (Text t : inventoryRender) {
                    remove(t);
                }
                inventoryRender.clear();

                for (int i = 0; i < objectArray.length; i++) {
                    Text t = new Text(objectArray[i] + "  ",
                        new Point(initXPosition,
                            initYPosition),
                        16, Color.BLACK);
                    inventoryRender.add(t);
                    add(t);
                    initYPosition += 25;
                }

            }

        }

    }

    /**
     * @param args
     */
    /*
     * public static void main(String[] args) {
     * new InventoryPage();
     * }
     */

}
