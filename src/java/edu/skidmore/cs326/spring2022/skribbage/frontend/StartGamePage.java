package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
//import java.util.Random;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Class to represent the start game state.
 * 
 * @author Zoe Beals
 */
@SuppressWarnings("serial")
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
    // private User player1;

    /**
     * player2 - User variable to hold player2.
     */
    // private User player2;

    /**
     * Board to hold the spots.
     */
    private Rectangle board;
    
    /**
     * gameArea - space to hold the game playing area.
     */
    private Rectangle gameArea;

    /**
     * Visual representation of the spots on the board.
     */
    private Circle[][] spotRenderer;
    
    /**
     * returnHome -Text variable to represent back button.
     */
    private Text returnHome;

    /**
     * homeScreen - HomeScreen window.
     */
    // private HomeScreen homeScreen;

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
        createSpots();
        //animateSpots();
    }
    
    /**
     * Renders the spots on the board.
     */
    public void createSpots() {
        spotRenderer = new Circle[120][3];
        for (int i = 0; i < spotRenderer.length; i++) {
            for (int j = 0; j < spotRenderer[0].length; j++) {
                spotRenderer[i][j] = new Circle(
                    new Point(60 + j * 20 + (i / 30) * 80,
                        650 - (i % 30) * 20), 16,
                    Color.black, Color.black);
                add(spotRenderer[i][j]);
                //System.out.println("Adding spot [" + i + "][" + j + "]");
            }
        }
    }
    
    /**
     * Test animation of spots on board.
     * @author Charlie Davidson
     */
    public void animateSpots() {
        
        //Random rand = new Random();
        
        int redPosition = 0;
        int bluePosition = 0;
        int yellowPosition = 0;
        
        
        while (true) {
            for (int i = 0; i < spotRenderer.length; i++) {
                if (redPosition == i) {
                    spotRenderer[i][0].setFillColor(Color.red);
                } else {
                    spotRenderer[i][0].setFillColor(Color.black);
                }
                
                if (bluePosition == i) {
                    spotRenderer[i][1].setFillColor(Color.blue);
                } else {
                    spotRenderer[i][1].setFillColor(Color.black);
                }
                
                if (yellowPosition == i) {
                    spotRenderer[i][2].setFillColor(Color.yellow);
                } else {
                    spotRenderer[i][2].setFillColor(Color.black);
                }
                
            }
            //redPosition = (redPosition + rand.nextInt(5)) % 120;
            //bluePosition = (bluePosition + rand.nextInt(5)) % 120;
            //yellowPosition = (yellowPosition + rand.nextInt(5)) % 120;
            
            redPosition = (redPosition + 1) % 120;
            bluePosition = (bluePosition + 1) % 120;
            yellowPosition = (yellowPosition + 1) % 120;
            
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * setup method.
     */
    public void setup() {
        LOG.trace("setup method in StartGamePage.java");
        //boardImage = new Image("newboard.png", new Point(40, 65), 1.5, null);
        board = new Rectangle(new Point(35, 50), new Dimension(350, 700),
            Color.black, new Color(180, 110, 30));
        gameArea = new Rectangle(new Point(25, 40),
            new Dimension(850, 800), Color.black, Color.green);
        beginGame = new Text("Start", new Point(35, 880), 20, Color.black,
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
        add(board);
        //add(boardImage);
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
            animateSpots();
            LOG.trace("Going to start the game");
        } else if (e == returnHome) {
            navPage = NavigationPageManager.getInstance().getNavPage();
            startGamePage.dispose();
        }
    }

    /**
     * main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Main method in StartGamePage.java");
        new StartGamePage();
    }

}
