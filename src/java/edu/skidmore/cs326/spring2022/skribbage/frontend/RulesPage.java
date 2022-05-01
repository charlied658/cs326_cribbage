package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;

import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;

/***
 * Creates a page that displays the rules for the user.
 * 
 * @author Jonah Marcus
 *         Last Edit: March 11, 2022
 *         Code Reviewed by Zoe Beals - 3/24/2022
 */
@SuppressWarnings("serial")
public class RulesPage extends SkribbageDrawingSurface implements Page {
    /**
     * mainframeWidth - int var to hold width.
     */
    private int mainframeWidth = 1200;

    /**
     * mainframeHeight - int var to hold height.
     */
    private int mainframeHeight = 900;

    /**
     * mf - MainFrame window.
     */
    @SuppressWarnings("unused")
    private MainFrame mf;

    /**
     * returnToMainMenu - button to return to home.
     */
    private Text returnToMainMenu;

    /**
     * navPage - NavigationPage window.
     */
    @SuppressWarnings("unused")
    private NavigationPage navPage;

    /**
     * PageManager instance for page management.
     */
    private PageManager pageManager;

    /**
     * LOG - logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(RulesPage.class);
    }

    /***
     * Creates the page which will display the rules of the game for the user.
     * 
     * @author Jonah Marcus
     *         Last Edit: March 11, 2022
     */
    public RulesPage() {
        pageManager = PageManager.getInstance();
        LOG.trace("Entering RulesPage Constructor");
        mf = new MainFrame(this, "Rules Page", mainframeWidth, mainframeHeight,
            false);
        setup();
        positionWindow();
    }

    /**
     * setup method to setup window.
     */
    public void setup() {

        LOG.trace("Entering the setup method in RulesPage.java");

        setLayout(null);
        Text header = new Text("Skribbage Battle Royale Rules",
            new Point(150, 275), 40, Color.BLACK);
        Image logo = new Image("logo.png", new Point(250, 0), 0.4, null);
        returnToMainMenu = new Text("Main Menu", new Point(375, 325), 24,
            Color.BLACK, Color.BLUE);

        // This adds a scrollable text area. This will allow us to add as
        // much text as we want without worrying about formatting. We will
        // add the actual text in a later sprint, it is not very important
        // for right now.

        JTextArea rulesArea = new JTextArea(100, 350);
        rulesArea.setFont(new Font("ComicSans", Font.BOLD | Font.ITALIC, 20));
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);
        rulesArea.setEditable(false);

        JScrollPane scrollPane =
            new JScrollPane(rulesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(135, 350, 1000, 700);

        scrollPane.getViewport().setBackground(Color.CYAN);
        add(scrollPane);
        String toRead = " ";

        toRead = readFromFile();
        rulesArea.setText(toRead);

        add(header);
        add(logo);
        add(returnToMainMenu);

    }

    /**
     * Method to read the rules from the rules text file.
     * 
     * @return
     *         A string that will be set as a text.
     */
    public String readFromFile() {
        String read = "";
        try {
            Scanner fileRead = new Scanner(new File("rules.txt"));
            while (fileRead.hasNext()) {
                read += fileRead.nextLine();
            }
        }
        catch (FileNotFoundException e) {
            LOG.error("FileNotFoundException occured.");
        }
        return read;
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMouseClick in PastGamesPage.java");
        if (e == returnToMainMenu) {
            returnToMainMenu.setBorderColor(Color.CYAN);
            Utility.pause(100);
            returnToMainMenu.setBorderColor(Color.BLACK);
            closeWindow();
            navPage =
                (NavigationPage) pageManager
                    .createPage(PageType.NAVIGATION_PAGE);

        }
    }

}
