package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Class to represent the start game state.
<<<<<<< HEAD
 * @author zbeals
 *
=======
 * 
 * @author zbeals
>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
 */
public class StartGamePage extends DrawingSurface {

    /**
     * startGamePage - Mainframe window.
     */
    private MainFrame startGamePage;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * gameBoard - Image to hold the game board.
     */
    private Image gameBoard;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * beginGame - Text variable to hold the start game button.
     */
    private Text beginGame;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * cardDeck - Image to hold card deck.
     */
    private Image cardDeck;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * player1Score - Text variable to hold player1 score.
     */
    private Text player1Score;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * player2Score - Text variable to hold player2 score.
     */
    private Text player2Score;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * player 1 - User variable to hold player1.
     */
    private User player1;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * player2 - User variable to hold player2.
     */
    private User player2;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * gameArea - space to hold the game playing area.
     */
    private Rectangle gameArea;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * returnHome -Text variable to represent back button.
     */
    private Text returnHome;
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * homeScreen - HomeScreen window.
     */
    private HomeScreen homeScreen;
<<<<<<< HEAD
    
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * StartGamePage constructor.
     */
    public StartGamePage() {
        startGamePage = new MainFrame(this, "Start Game Page", 900, 900, false);
        setup();
    }
<<<<<<< HEAD
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
    /**
     * setup method.
     */
    public void setup() {
        gameBoard = new Image("board.png", new Point(40, 45), 0.8, null);
        gameArea = new Rectangle(new Point(25, 40),
            new Dimension(850, 800), Color.black, Color.green);
<<<<<<< HEAD
        beginGame = new Text("Start", new Point(275, 400), 20, Color.black, 
            Color.blue);
        cardDeck = new Image("card.jpg", new Point(375, 315), .6, null);
        player1Score = new Text("temp player 1:", new Point(35, 790), 20, 
            Color.black);
        player2Score = new Text("temp player 2: ", new Point(35, 810), 20,
            Color.black);
        returnHome = new Text("Return to home", new Point(10, 25), 20, 
=======
        beginGame = new Text("Start", new Point(275, 400), 20, Color.black,
            Color.blue);
        cardDeck = new Image("card.jpg", new Point(375, 315), .6, null);
        player1Score = new Text("temp player 1:", new Point(35, 790), 20,
            Color.black);
        player2Score = new Text("temp player 2: ", new Point(35, 810), 20,
            Color.black);
        returnHome = new Text("Return to home", new Point(10, 25), 20,
>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
            Color.black, Color.blue);
        add(gameArea);
        add(beginGame);
        add(cardDeck);
        add(player2Score);
        add(player1Score);
        add(returnHome);
        add(gameBoard);
    }
<<<<<<< HEAD
    
    @Override
    public void drawableMouseClick(Drawable e) {
        if (e == beginGame) {
            //start game
=======

    @Override
    public void drawableMouseClick(Drawable e) {
        if (e == beginGame) {
            // start game
>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
        } else if (e == returnHome) {
            homeScreen = new HomeScreen();
            startGamePage.dispose();
        }
    }
<<<<<<< HEAD
    
    /**
     * main method.
=======

    /**
     * main method.
     * 
>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
     * @param args
     */
    public static void main(String[] args) {
        new StartGamePage();
    }
<<<<<<< HEAD
    
    
=======

>>>>>>> d599e4ec72d372caffa74468e69fe3928d68eb9f
}
