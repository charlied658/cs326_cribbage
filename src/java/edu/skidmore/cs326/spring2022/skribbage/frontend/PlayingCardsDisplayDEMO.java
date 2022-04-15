package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;

//import static org.springframework.test.web.servlet.result.
//MockMvcResultMatchers.forwardedUrl;

import java.awt.Point;
//import java.awt.Graphics2D;
import java.io.File;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Text;

/**
 * This class tests the functionality of importing, storing, and displaying
 * playing cards needed for the game.
 * 
 * @author Jonah Marcus
 *         Last Update: March 28, 2022
 *         Last Edited by Jonah Marcus
 *         Code review - Zoe Beals 3/28/2022
 */
@SuppressWarnings("serial")
public class PlayingCardsDisplayDEMO extends DrawingSurface {

    /**
     * mf - Holds reference to the window.
     */
    private MainFrame mf;

    /**
     * cards[] - Stores the card PNGs.
     */
    private static Image[] cards;

    /**
     * mainframeWidth - int variable to hold main frame width.
     */
    private int mainframeWidth = 900;

    /**
     * mainframeHeight - int variable to hold main frame height.
     */
    private int mainframeHeight = 900;

    /**
     * refreshButton - refreshes the page and loads a new card.
     */
    private Text refreshButton;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PlayingCardsDisplayDEMO.class);
    }

    /**
     * TestPlayingCardsDisplay constructor.
     */
    public PlayingCardsDisplayDEMO() {
        LOG.trace("Entered TestPlayingCardDisplay constructor");
        mf = new MainFrame(this, "Testing Card Display", mainframeWidth,
            mainframeHeight, false);
        File cardDirectory = new File("Playing Cards");
        String[] cardList = cardDirectory.list();

        cards = new Image[cardList.length];

        for (int i = 0; i < cardList.length; i++) {
            cards[i] = new Image("Playing Cards/" + cardList[i],
                new Point(0, 0), 0.5, null);
            // add(new Image(cardList[i], new Point(0, 0), 0.5, null));
        }
        printCardsArray();
        setup();
    }

    /**
     * Sets up the MainFrame.
     */
    private void setup() {
        LOG.trace("Entered TestPlayingCardsDisplay() setup");
        setLayout(null);

        refreshButton = new Text("Refresh", new Point(375, 450), 40,
            Color.PINK, Color.BLACK);
        /*
         * for (int i = 0; i < 5; i++) {
         * Image card = cards[(int) Math.random() * (cards.length - 1)];
         * System.out.println("Made new card");
         * //card.setX(30 + (20 * i));
         * //card.setY(40);
         * add(card);
         * }
         */
        // add(new Image("Playing Cards/ace_of_spades.png",
        // new Point(0, 0), 0.75, null));
        for (int i = 0; i < cards.length; i++) {
            add(cards[i]);
            Utility.pause(500);
        }
        add(new Text("Those are all the cards!", new Point(265, 500), 30,
            Color.BLACK));

        // add(refreshButton);
        // System.out.println("\n" + cards[39].toString());
        // add(new Image("ungovernable.jpg", new Point(0, 0), 0.75, null));

    }

    /**
     * Does what it says on the tin: prints the cards[] array
     * to view its contents and make sure its correct and
     * consistent.
     */
    private static void printCardsArray() {
        LOG.trace("Entered printCardsArray");
        for (Image card : cards) {
            System.out.println(card.toString());
        }
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in TestPlayingCardsDisplay.java");
        if (e == refreshButton) {
            mf.dispose();
            new PlayingCardsDisplayDEMO();
        }

    }

    /**
     * This is the main method. I'm sure you can figure it out.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Entered main method");
        new PlayingCardsDisplayDEMO();
    }

}
