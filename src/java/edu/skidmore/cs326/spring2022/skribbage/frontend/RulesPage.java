package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//import java.awt.event.WindowEvent;
import java.awt.Dimension;
//import java.awt.Graphics2D;
//import javax.swing.*;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Rectangle;
//import us.daveread.edu.graphics.shape.Drawable;
//import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
//import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.utilities.Utility;

/***
 * Creates a page that displays the rules for the user.
 * 
 * @author Jonah Marcus
 *         Last Edit: March 11, 2022
 *         Code Reviewed by Zoe Beals - 3/24/2022
 */
@SuppressWarnings("serial")
public class RulesPage extends DrawingSurface implements ActionListener {
    /**
     * mainframeWidth - int var to hold width.
     */
    private int mainframeWidth = 900;

    /**
     * mainframeHeight - int var to hold height.
     */
    private int mainframeHeight = 900;

    /**
     * mf - MainFrame window.
     */
    private MainFrame mf;

    /**
     * returnToMainMenu - button to return to home.
     */
    private Text returnToMainMenu;

    /**
     * navPage - NavigationPage window.
     */
    private NavigationPage navPage;

    /**
     * LOG - logger.
     */
    private static final Logger LOG;

    /**
     * homeScreen - HomeScreen window.
     */
    private HomeScreen homeScreen;

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
        LOG.trace("Entering RulesPage Constructor");
        mf = new MainFrame(this, "Rules Page", mainframeWidth, mainframeHeight,
            false);
        setup();
    }

    /**
     * setup method to setup window.
     */
    private void setup() {

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
        JTextArea rulesArea = new JTextArea("", 100, 350);
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);
        rulesArea.setEditable(false);

        JScrollPane scrollPane =
            new JScrollPane(rulesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(135, 350, 650, 500);
        scrollPane.getViewport().setBackground(Color.DARK_GRAY);
        add(scrollPane);

        rulesArea.setText(
            "The objective in Cribbage is to be the first player to get "
                + "121 points. " + "The gameplay is divided into "
                + "three distinct parts, "
                + "The Deal, The Play and The Show.");

        add(header);
        add(logo);
        add(returnToMainMenu);

    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMouseClick in PastGamesPage.java");
        if (e == returnToMainMenu) {
            returnToMainMenu.setBorderColor(Color.CYAN);
            Utility.pause(100);
            returnToMainMenu.setBorderColor(Color.BLACK);
            mf.dispose();
            navPage = NavigationPageManager.getInstance().getNavPage();
        }
    }

    // This is a placeholder. In the final product, the "Main Menu" button
    // will, as the label suggests, take the user back to the main menu.
    @Override
    public void actionPerformed(ActionEvent e) {

        LOG.trace("ActionPerfomed method in RulesPage.java");

        // mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
        if (e.getSource().equals(returnToMainMenu)) {
            mf.dispose();
            navPage = NavigationPageManager.getInstance().getNavPage();
            // PastGamesPage pastGames = new PastGamesPage();
            // spastGames.setVisible(true);
        }
    }

    /**
     * main method.
     * 
     * @param args
     */
    public static void main(String[] args) {

        LOG.trace("RulesPage main method");

        RulesPageManager.getInstance().getRulesPage();
    }
}
