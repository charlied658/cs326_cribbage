package edu.skidmore.cs326.spring2022.skribbage.frontend;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
import java.awt.Dimension;
//import java.awt.Graphics2D;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.util.*;

import java.io.*;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;

/**
 * This class tests the functionality of importing, storing, and displaying
 * playing cards needed for the game.
 * @author Jonah Marcus
 *         Last Update: March 27, 2022
 *         Last Edited by Jonah Marcus
 */
public class TestPlayingCardsDisplay extends DrawingSurface {
    
    /**
     * cards[] - Stores the card PNGs.
     */
    private static Image[] cards;
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PastGamesPage.class);
    }
    
    /**
     * TestPlayingCardsDisplay constructor.
     */
    public TestPlayingCardsDisplay() {
        LOG.trace("Entered TestPlayingCardDisplay constructor");
        File cardDirectory = new File("Playing Cards");
        String[] cardList = cardDirectory.list();
        
        cards = new Image[cardList.length];
        
        for (int i = 0; i < cardList.length; i++) {
            cards[i] = new Image(cardList[i], new Point(20 * i, 30), null);
        }
    }
    
    /**
     * Does what it says on the tin: prints the cards[] array
     * to view its contents and make sure its correct and
     * consistent.
     */
    private static void printCardsArray() {
        LOG.trace("Entered printCardsArray");
        for (Image card: cards) {
            System.out.println(card.toString());
        }
    }
    
    /**
     * This is the main method. I'm sure you can figure it out.
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Entered main method");
        new TestPlayingCardsDisplay();
        printCardsArray();
    }

}
