package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Class to represent the start game state.
 * 
 * @author Zoe Beals
 */
public class StartGamePage extends DrawingSurface {

    /**
     * navPage - NavigationPage window.
     */
    private NavigationPage navPage;
    
    /**
     * spots - Array of spots.
     */
    private Spot[][] spots;
    
    /**
     * startGamePage - Mainframe window.
     */
    private MainFrame startGamePage;

    /**
     * gameBoard - Image to hold the game board.
     */
    private Image boardImage;
    
    /**
     * beginGame - Text variable to hold the start game button.
     */
    private Text beginGame;

    /**
     * cardDeck - Image to hold card deck.
     */
    private Image cardDeck;

    /**
     * player1Score - Text variable to hold player1 score.
     */
    private Text player1Score;

    /**
     * player2Score - Text variable to hold player2 score.
     */
    private Text player2Score;

    /**
     * player 1 - User variable to hold player1.
     */
    private User player1;

    /**
     * player2 - User variable to hold player2.
     */
    private User player2;

    /**
     * gameArea - space to hold the game playing area.
     */
    private Rectangle gameArea;

    /**
     * returnHome -Text variable to represent back button.
     */
    private Text returnHome;

    /**
     * homeScreen - HomeScreen window.
     */
    private HomeScreen homeScreen;
    
    /**
     * Log.
     */
    private static final Logger LOG;
    

    static {
        LOG = Logger.getLogger(StartGamePage.class);
    }
    /**
     * StartGamePage constructor.
     */
    public StartGamePage() {
        LOG.trace("StartGamePage constructor");
        startGamePage = new MainFrame(this, "Start Game Page", 900, 900, false);
        setup();
    }

    /**
     * setup method.
     */
    public void setup() {
        LOG.trace("setup method in StartGamePage.java");
        boardImage = new Image("newboard.png", new Point(40, 65), 1.5, null);
        gameArea = new Rectangle(new Point(25, 40),
            new Dimension(850, 800), Color.black, Color.green);
        beginGame = new Text("Start", new Point(375, 400), 20, Color.black, 
            Color.blue);
        cardDeck = new Image("card.jpg", new Point(500, 315), .6, null);
        player1Score = new Text("temp player 1:", new Point(35, 790), 20, 
            Color.black);
        player2Score = new Text("temp player 2: ", new Point(35, 810), 20,
            Color.black);
        returnHome = new Text("Return to home", new Point(10, 25), 20,
            Color.black, Color.blue);
        add(gameArea);
        add(beginGame);
        add(cardDeck);
        add(player2Score);
        add(player1Score);
        add(returnHome);
        add(boardImage);
        createGrid();
    }

    /**
     * createGrid method creates the board grid.
     */
    public void createGrid() {
        LOG.trace("createGrid method in StartGamePage.java");
        assignSpots();
        spots = BoardManager.getInstance().getBoard().getGrid();
        for (int i = 0; i < spots.length; i++) {
            System.out.println(Arrays.toString(spots[i]));
        }
    }

    /**
     * assignSpots method assigns all the special spots.
     */
    public void assignSpots() {
        LOG.trace("assignSpots method in StartGamePage,java");
        BoardManager.getInstance().getBoard().assignBattleSpot();
        BoardManager.getInstance().getBoard().assignJumpSpot();
        BoardManager.getInstance().getBoard().assignPrizeSpot();
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("drawableMouseClick method in StartGamepage.java");
        if (e == beginGame) {
            // start game
        } else if (e == returnHome) {
            navPage = new NavigationPage();
            startGamePage.dispose();
        }
    }

  
    /**
     * main method.
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Main method in StartGamePage.java");
        new StartGamePage();
    }

}
