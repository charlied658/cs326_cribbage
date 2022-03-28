package edu.skidmore.cs326.spring2022.skribbage.frontend;

//import static org.springframework.test.web.servlet.result.
//MockMvcResultMatchers.forwardedUrl;

import java.awt.Point;
//import java.awt.Graphics2D;
import java.io.File;

import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * This class tests the functionality of importing, storing, and displaying
 * playing cards needed for the game.
 * 
 * @author Jonah Marcus
 *         Last Update: March 27, 2022
 *         Last Edited by Jonah Marcus
 *         Code review - Zoe Beals 3/28/2022
 */
public class TestPlayingCardsDisplay extends DrawingSurface {

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
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(TestPlayingCardsDisplay.class);
    }

    /**
     * TestPlayingCardsDisplay constructor.
     */
    public TestPlayingCardsDisplay() {
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
        add(cards[50]);
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

    /**
     * This is the main method. I'm sure you can figure it out.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Entered main method");
        new TestPlayingCardsDisplay();
    }

}
