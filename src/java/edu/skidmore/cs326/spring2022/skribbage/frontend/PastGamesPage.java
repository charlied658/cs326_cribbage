package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;

/***
 * This is the page that allows the player to load old games.
 * 
 * @author Jonah Marcus
 *         Last Update: March 11 2022
 *         lOGGING added by Sten Leinasaar March 22, 2022.
 *         This is the page that allows the player to view and load old games.
 * 
 */

@SuppressWarnings("serial")
public class PastGamesPage extends DrawingSurface implements Page {
    /**
     * mainFrameWidth - int variable that holds mainframe width.
     */
    private int mainframeWidth = 900;

    /**
     * mainframeHeight - int variable that holds mainframe height.
     */
    private int mainframeHeight = 900;

    /**
     * mf - MainFrame window.
     */
    private MainFrame mf;

    /**
     * returnToMainMenu - button to return to homepage.
     */
    private Text returnToMainMenu;

    /**
     * allGames - array list of playable games.
     */
    private ArrayList<PlayableGame> allGames = new ArrayList<>();

    /**
     * completeGames - array list of completed games.
     */
    private ArrayList<PlayableGame> completeGames = new ArrayList<>();

    /**
     * incompleteGames - array list of incomplete games.
     */
    private ArrayList<PlayableGame> incompleteGames = new ArrayList<>();

    // Examples of games that show proof of concept
    /**
     * one - temporary playable game.
     */
    private PlayableGame one;

    /**
     * two - temporary playable game.
     */
    private PlayableGame two;

    /**
     * three - temporary playable game.
     */
    private PlayableGame three;

    /**
     * navPage - NavigationPage window.
     */
    @SuppressWarnings("unused")
    private NavigationPage navPage;
    /**
     * PageManager instance for page handling.
     */
    private PageManager pageManager;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PastGamesPage.class);
    }

    /**
     * PastGamesPage constructor.
     */
    public PastGamesPage() {
        pageManager = PageManager.getInstance();
        mf = new MainFrame(this, "Past Games Page", mainframeWidth,
            mainframeHeight, false);
        addGamesToList();
        setup();
        LOG.trace("Constructor reached");
    }

    /**
     * addGamesToList method to add current games to allGames.
     */
    public void addGamesToList() {
        LOG.trace("Entered addGamesToList method.");
        one = new PlayableGame(2021, 11, 30, new ArrayList<String>(),
            "", false);
        one.addPlayer("Jonah");
        one.addPlayer("Sten");
        one.addPlayer("Alex");
        allGames.add(one);

        two = new PlayableGame(2022, 2, 28, new ArrayList<String>(),
            "Apex Legends", false);
        two.addPlayer("Wraith");
        two.addPlayer("Mirage");
        two.addPlayer("Pathfinder");
        allGames.add(two);

        three = new PlayableGame(2022, 4, 13, new ArrayList<String>(),
            "Cringe", true);
        three.addPlayer("Hugh G. Rection");
        three.addPlayer("Tess T. Coles");
        three.addPlayer("Matt Sturbate");
        allGames.add(three);
    }

    /**
     * setup method to setup window.
     */
    public void setup() {
        LOG.trace("Setup of PastGamesPage");
        setLayout(null);
        Text header =
            new Text("Load Previous Game", new Point(50, 60), 36, Color.BLACK);
        returnToMainMenu = new Text("Main Menu", new Point(160, 115), 25,
            Color.BLACK, Color.BLUE);

        add(header);
        add(returnToMainMenu);

        Image logo = new Image("logo.png", new Point(435, 0), 0.48, null);
        add(logo);

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
        LOG.trace("For loop to check for incomplete games.");
        for (int i = 0; i < incompleteGames.size(); i++) {
            PlayableGame g = incompleteGames.get(i);
            int year = g.getDate().get(Calendar.YEAR);
            int month = g.getDate().get(Calendar.MONTH);
            int date = g.getDate().get(Calendar.DATE);
            if (g.getName().equals("")) {
                g.setName(year + formatDateOrMonth(month)
                    + formatDateOrMonth(date));
            }
            JButton gameButton = new JButton(g.getName() + " - "
                + year + " " + formatDateOrMonth(month) + " "
                + formatDateOrMonth(date) + " " + g.getPlayers().toString());
            /*
             * String[] gameInfo = incompleteGames.get(i).getGameInfo();
             * String timestamp = gameInfo[0];
             * String name = gameInfo[1];
             * String player1 = gameInfo[2];
             * String player2 = gameInfo[3];
             * JButton gameButton = new JButton(
             * name + "   " + timestamp + "   " + player1 + "   " + player2);
             */
            gameButton.setBounds(25, buttonYPosition, 400, 40);
            buttonYPosition += 50;
            gameButton.setBackground(new Color(255, 60, 60));
            add(gameButton);

        }
        LOG.trace("For loop to check for completed games");
        for (int i = 0; i < completeGames.size(); i++) {
            PlayableGame g = completeGames.get(i);
            int year = g.getDate().get(Calendar.YEAR);
            int month = g.getDate().get(Calendar.MONTH);
            int date = g.getDate().get(Calendar.DATE);
            JButton gameButton = new JButton(g.getName() + " - "
                + year + " " + formatDateOrMonth(month) + " "
                + formatDateOrMonth(date) + " " + g.getPlayers().toString());

            /*
             * String[] gameInfo = completeGames.get(i).getGameInfo();
             * String timestamp = gameInfo[0];
             * String name = gameInfo[1];
             * String player1 = gameInfo[2];
             * String player2 = gameInfo[3];
             * JButton gameButton = new JButton(
             * name + "   " + timestamp + "   " + player1 + "   " + player2);
             */
            gameButton.setBounds(25, buttonYPosition, 400, 40);
            buttonYPosition += 50;
            gameButton.setBackground(Color.GREEN);
            add(gameButton);

        }

    }

    /**
     * If date or month is only a single digit, this
     * will add a 0 to the beginning for formatting purposes.
     * 
     * @param i
     * @return toReturn - a formatted String as specified above
     */
    private String formatDateOrMonth(int i) {
        String toReturn = "";
        if (i < 10) {
            toReturn = "0" + i;
        } else {
            toReturn = "" + i;
        }
        return toReturn;
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMouseClick in PastGamesPage.java");
        if (e == returnToMainMenu) {
            returnToMainMenu.setBorderColor(Color.CYAN);
            Utility.pause(100);
            returnToMainMenu.setBorderColor(Color.BLACK);
            mf.dispose();
            navPage =
                (NavigationPage) pageManager
                    .createPage(PageType.NAVIGATION_PAGE);
        }
    }
}
