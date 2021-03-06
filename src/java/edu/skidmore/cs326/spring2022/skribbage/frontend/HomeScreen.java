package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.util.VerifyLibraryVersion;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * @author Zoe Beals
 *         updated as of 4/19/2022. By Sten
 *         Made the page implement Page interface
 *         Changed the method from closeCurrentWindow --> closeWindow
 *         Deleted dead code.
 *         HomeScreen class to act as the main menu
 *         of the game of cribbage.
 *         Code reviewed by Jonah Marcus on 3/29/2022
 */
@SuppressWarnings("serial")
public class HomeScreen extends SkribbageDrawingSurface implements Page {

    /**
     * welcomeMessage - Text variable that holds the welcome message.
     */
    private Text welcomeMessage;

    /**
     * logo - Image to hold the temporary game logo.
     */
    private Image logo;

    /**
     * loginPageButton - Text variable that represents the button to go to the
     * login page.
     */
    private Text loginPageButton;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(HomeScreen.class);
    }

    /**
     * HomeScreen constructor.
     * Initializes the MainFrame window
     */
    public HomeScreen() {
        LOG.trace("HomeScreen.java constructor");
        new MainFrame(this, "Skribbage Battle Royale Home", 900, 900, true);
        setup();
        positionWindow();
        checkGraphicsLibrary();
    }

    /**
     * Setup method creates the buttons being shown on the home screen.
     */
    public void setup() {
        LOG.trace("Setup method in HomeScreen.java started.");
        LOG.trace("Creating a Logo in HomeScreen.java in setup method.");
        logo = new Image("logo.png", new Point(150, 0), .6, null);
        LOG.trace(
            " Going add the logo to the main frame in HomeScreen.java class.");
        add(logo);
        LOG.trace(
            "Creating a loginPageButtong in HomeScreen.java in setup method.");

        welcomeMessage =
            new Text("Welcome! Please log in/sign up to begin a new game.",
                new Point(logo.getLocation().x + 35,
                    logo.getLocation().y + 350),
                20,
                Color.black, Color.blue);
        loginPageButton = new Text("Login/Sign Up",
            new Point(welcomeMessage.getLocation().x
                + 195, welcomeMessage.getLocation().y + 40),
            20, Color.black, Color.blue);
        add(loginPageButton);
        add(welcomeMessage);
    }

    /**
     * Check that the correct version of the graphics library is available,
     * otherwise place a warning message on the GUI.
     */
    private void checkGraphicsLibrary() {
        String verificationResult =
            VerifyLibraryVersion.getInstance().checkGraphicsLibraryMinVersion();
        if (verificationResult != null) {
            String[] versions = verificationResult.split(",");
            LOG.warn(
                "Outdated version of GUI library on path. Found version "
                    + versions[0] + " but need at least version "
                    + versions[1]);
            add(new Rectangle(new Point(5, logo.getLocation().y
                + logo.getDimension().height + 100),
                new Dimension(700, 100), Color.black, Color.red));
            Text versionWarn = new Text(
                "Warning! Outdated version of GUI library on path.",
                new Point(100, logo.getLocation().y
                    + logo.getDimension().height + 140),
                20, null, Color.white);
            add(versionWarn);
            versionWarn = new Text("Found version " + versions[0]
                + " but need at least version "
                + versions[1],
                new Point(50, logo.getLocation().y
                    + logo.getDimension().height + 170),
                20, null, Color.white);
            add(versionWarn);
        }
    }

    /**
     * override from DrawingSurface class.
     * 
     * @param e
     *            - Drawable object
     *            checks for a mouseclick on the DrawingSurface, then determines
     *            if the clickable surface was any of the buttons created.
     *            if loginPageButton, displays the login page
     */
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in HomeScreen.java");
        if (e == loginPageButton) {
            closeWindow();
            PageManager.getInstance().createPage(PageType.LOGIN_PAGE);
        }
    }
}
