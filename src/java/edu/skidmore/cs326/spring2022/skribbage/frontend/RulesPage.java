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

import us.daveread.edu.graphics.shape.impl.Rectangle;
//import us.daveread.edu.graphics.shape.Drawable;
//import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
//import us.daveread.edu.graphics.shape.impl.Rectangle;

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
    private int mainframeWidth = 650;

    /**
     * mainframeHeight - int var to hold height.
     */
    private int mainframeHeight = 1500;

    /**
     * mf - MainFrame window.
     */
    private MainFrame mf;

    /**
     * returnToMainMenu - button to return to home.
     */
    private JButton returnToMainMenu;

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
        Rectangle background = new Rectangle(new Point(0, 0),
            new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        Text header = new Text("Skribbage Battle Royale Rules",
            new Point(20, 70), 40, Color.WHITE);
        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.setBounds(20, 80, 120, 25);
        returnToMainMenu.setBackground(Color.LIGHT_GRAY);
        returnToMainMenu.addActionListener(this);

        // This adds a scrollable text area. This will allow us to add as
        // much text as we want without worrying about formatting. We will
        // add the actual text in a later sprint, it is not very important
        // for right now.
        JTextArea rulesArea = new JTextArea("", 15, 30);
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);
        rulesArea.setEditable(false);

        JScrollPane scrollPane =
            new JScrollPane(rulesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(40, 120, 570, 800);
        scrollPane.getViewport().setBackground(Color.DARK_GRAY);
        add(scrollPane);

        rulesArea.setText(
            "The objective in Cribbage is to be the first player to get "
                + "121 points. " + "The gameplay is divided into "
                + "three distinct parts, "
                + "The Deal, The Play and The Show.");

        /*
         * ;
         * String intro3 = "Deal, the Play, and the Show.";
         * String dealHeader = "The Deal";
         * Color introColor = Color.WHITE;
         * int introFontSize = 18;
         * Text intro1Text = new Text(intro1, new Point(10, 110), introFontSize,
         * introColor);
         * Text intro2Text = new Text(intro2, new Point(10, 135), introFontSize,
         * introColor);
         * Text intro3Text = new Text(intro3, new Point(10, 160), introFontSize,
         * introColor);
         * Text dealHeaderText = new Text(dealHeader, new Point(250, 210), 30,
         * Color.WHITE);
         * add(background);
         * add(header);
         * add(intro1Text);
         * add(intro2Text);
         * add(intro3Text);
         * add(dealHeaderText);
         */
        add(background);
        add(header);
        add(returnToMainMenu);

        /*
         * String[] introSplit = intro.split(" ");
         * int introFontSize = 18;
         * int introXPosition = 10;
         * int introYPosition = 100;
         * for(int i = 0; i < introSplit.length; i++) {
         * if(introXPosition + introSplit[i].length() * introFontSize >
         * mainframeWidth - 10) {
         * introXPosition = 10;
         * introYPosition += 10;
         * }
         * add(new Text(introSplit[i], new Point(introXPosition,
         * introYPosition), introFontSize, Color.WHITE));
         * introXPosition += introSplit[i].length() * introFontSize;
         * }
         */
    }
    /*
     * public boolean detectsMouseClick(Rectangle rec) {
     * for (int i = 0; i < rec.getDimension().width; i++) {
     * for (int j = 0; j < rec.getDimension().height; j++) {
     * if(rec.mouseClickDetected(i, j)) {
     * return true;
     * }
     * }
     * }
     * return false;
     * }
     */

    // This is a placeholder. In the final product, the "Main Menu" button
    // will, as the label suggests, take the user back to the main menu.
    @Override
    public void actionPerformed(ActionEvent e) {

        LOG.trace("ActionPerfomed method in RulesPage.java");

        // mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
        if (e.getSource().equals(returnToMainMenu)) {
            mf.dispose();
            navPage = new NavigationPage();
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

        new RulesPage();
    }
}
