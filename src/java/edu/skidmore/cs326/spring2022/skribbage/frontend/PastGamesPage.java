package edu.skidmore.cs326.spring2022.skribbage.frontend;


import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.util.*;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Rectangle;

/***
 * This is the page that allows the player to load old games.
 * 
 * @author Jonah Marcus
 *         Last Update: March 11 2022
 * lOGGING added by Sten Leinasaar March 22, 2022.
 * This is the page that allows the player to view and load old games.
 * @author Jonah Marcus
 * Last Update: March 11 2022
 * This is the page that allows the player to load old games.
 * 
 * @author Jonah Marcus
 *         Last Update: March 10 2022
 */

@SuppressWarnings("serial")
public class PastGamesPage extends DrawingSurface implements ActionListener {
    /**
     * 
     */
    private int mainframeWidth = 650;

    /**
     * 
     */
    private int mainframeHeight = 1500;

    /**
     * 
     */
    private MainFrame mf;

    /**
     * 
     */
    private HomeScreen homeScreen;
    
    /**
     * 
     */
    private JButton returnToMainMenu;

    /**
     * 
     */
    private ArrayList<PlayableGame> allGames = new ArrayList<>();

    /**
     * 
     */
    private ArrayList<PlayableGame> completeGames = new ArrayList<>();

    /**
     * 
     */
    private ArrayList<PlayableGame> incompleteGames = new ArrayList<>();

    // Examples of games that show proof of concept
    /**
     * 
     */
    private PlayableGame one =
        new PlayableGame(11, 7, 2021, "Jonah", "Sten", "CS326", true);

    /**
     * 
     */
    private PlayableGame two = new PlayableGame(12, 31, 2021, "Chris Cornell",
        "Ben Shepherd", "Soundgarden", true);

    /**
     * 
     */
    private PlayableGame three =
        new PlayableGame(1, 17, 2022, "Hugh Jass", "Tess T Culls", "", false);
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    
    static {
        LOG = Logger.getLogger(PastGamesPage.class);
    }

    /**
     * 
     */
    public PastGamesPage() {
        mf = new MainFrame(this, "Past Games Page", mainframeWidth,
            mainframeHeight, false);
        addGamesToList();
        setup();
        LOG.trace("Constructor reached");
    }
    /**
     * 
     */
    public void addGamesToList() {
        allGames.add(one);
        allGames.add(two);
        allGames.add(three);
    }
    /**
     * 
     */
    public void setup() {
        LOG.trace("Setup of PastGamesPage");
        setLayout(null);
        Rectangle background = new Rectangle(new Point(0, 0),
            new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        Text header =
            new Text("Load Previous Game", new Point(120, 70), 40, Color.WHITE);
        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.setBounds(20, 80, 120, 25);
        returnToMainMenu.setBackground(Color.LIGHT_GRAY);
        returnToMainMenu.addActionListener(this);

        add(background);
        add(header);
        add(returnToMainMenu);

        // There is a boolean field in each PlayableGame class that shows
        // whether or not
        // a game is completed. This will place each game into the appropriate
        // ArrayList
        // for later organization. For now, this just adds the test cases. In
        // the future,
        // there will be a list of all active games that is a bit more
        // sophisticated.
        LOG.trace("For loop to separate completed and uncompleted games.");
        for (int i = 0; i < allGames.size(); i++) {
            PlayableGame game = allGames.get(i);
            if (game.isCompleted()) {
                completeGames.add(game);
            } else {
                incompleteGames.add(game);
            }
        }

        // For now, all of the incomplete games will be red, and all
        // of the complete games will be green This can be changed
        // to look a bit nicer later, but again, this is just a proof
        // of concept. Additionally, as the client requested, all
        // of the incomplete games will be above the games that
        // have been completed.
        int buttonYPosition = 150;
        for (int i = 0; i < incompleteGames.size(); i++) {
            String[] gameInfo = incompleteGames.get(i).getGameInfo();

            String timestamp = gameInfo[0];
            String name = gameInfo[1];
            String player1 = gameInfo[2];
            String player2 = gameInfo[3];
            JButton gameButton = new JButton(
                name + "   " + timestamp + "   " + player1 + "   " + player2);
            gameButton.setBounds(50, buttonYPosition, 550, 40);
            buttonYPosition += 50;
            gameButton.setBackground(Color.RED);
            add(gameButton);

        }
        for (int i = 0; i < completeGames.size(); i++) {
            String[] gameInfo = completeGames.get(i).getGameInfo();

            String timestamp = gameInfo[0];
            String name = gameInfo[1];
            String player1 = gameInfo[2];
            String player2 = gameInfo[3];
            JButton gameButton = new JButton(
                name + "   " + timestamp + "   " + player1 + "   " + player2);
            gameButton.setBounds(50, buttonYPosition, 550, 40);
            buttonYPosition += 50;
            gameButton.setBackground(Color.GREEN);
            add(gameButton);

        }

    }

    // This is a placeholder. In the final product, the "Main Menu" button
    // will, as the label suggests, take the user back to the main menu.
    @Override
    public void actionPerformed(ActionEvent e) {
        // mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
        if (e.getSource().equals(returnToMainMenu)) {
            mf.dispose();
            //RulesPage rules = new RulesPage();
            //rules.setVisible(true);
            homeScreen = new HomeScreen();
        }
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        new PastGamesPage();
    }
}
