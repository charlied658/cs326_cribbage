package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;
import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.VisibleObject;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.LineSegment;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Class to represent the start game state.
 * 
 * @author Zoe Beals
 *         Code review by Jonah Marcus on 17 April 2022
 *         Last edited by Charlie Davidson
 */
@SuppressWarnings("serial")
public class StartGamePage extends DrawingSurface implements Page {

    /**
     * startGamePage - Mainframe window.
     */
    private MainFrame startGamePage;

    /**
     * PageManager instance for page management.
     */
    private PageManager pageManager;

    /**
     * GameManager instance to manage the game.
     */
    private GameManager gameManager;

    /**
     * navPage - NavigationPage window.
     */
    @SuppressWarnings("unused")
    private NavigationPage navPage;

    /**
     * Space to hold the game playing area.
     */
    private Rectangle gameArea;

    /**
     * Board to hold the spots.
     */
    private Rectangle board;

    /**
     * Button to return to the previous screen.
     */
    private Text returnHomeButton;

    /**
     * Button to resize the window to be smaller.
     */
    private Text resizeButton;

    /**
     * Button to start the game.
     */
    private Text startButton;

    /**
     * Arrows displayed on board.
     */
    private Image[] arrows;

    /**
     * Lines displayed on the board which occur every 5 spaces.
     */
    private LineSegment[] boardLines;

    /**
     * How many spaces each player moves.
     */
    private int moveAmt;

    /**
     * Store whether the game currently running.
     */
    private boolean running;

    /**
     * Toggles the screen being resized.
     */
    private boolean resizeWindow;

    /**
     * Visual representation of the spots on the board.
     */
    private VisibleObject[][] spotRenderer;

    /**
     * Location of spots on the board.
     */
    private Point[][] spotLocations;

    /**
     * Locations where the pegs can move on the board.
     */
    private Point[][] pegSpotLocations;

    /**
     * Visual representation of the pegs on the board.
     */
    private Circle[] pegRenderer;

    /**
     * Starting positions of the pegs.
     */
    private Circle[][] initialSpots;

    /**
     * Final spot on the board.
     */
    private Circle endSpot;

    /**
     * Locations of the pegs on the board.
     */
    private int[] pegLocations;

    /**
     * Arraylist of card images.
     */
    private ArrayList<CardImage> standardDeck;

    /**
     * Cards currently displayed in the deck.
     */
    private ArrayList<CardImage> cardsInDeck;

    /**
     * Cards currently displayed in center of board.
     */
    private ArrayList<CardImage> cardsInPlay;

    /**
     * Cards currently displayed in the player's hand.
     */
    private ArrayList<CardImage> cardsInHand;

    /**
     * Cards currently selected in the player's hand.
     */
    @SuppressWarnings("unused")
    private ArrayList<CardImage> cardsInHandSelected;

    /**
     * Cards currently displayed in the crib.
     */
    @SuppressWarnings("unused")
    private ArrayList<CardImage> cardsInCrib;

    /**
     * Cards currently displayed in the opponent's hand.
     */
    private ArrayList<CardImage> cardsInOpponentHand;

    /**
     * Stores the file names of the 52 cards.
     */
    private String[] fileNames;

    /**
     * Number of cards displayed on the deck. This is only for visual purposes.
     */
    private final int numcards = 52;

    /**
     * counting players points.
     */
    private int playerPoints = 0;

    /**
     * counting computer points.
     */
    private int computerPoints = 0;

    /**
     * label for player points.
     */
    private Text playerPointsLabel;

    /**
     * label for computer points.
     */
    private Text computerPointsLabel;

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(StartGamePage.class);
    }

    /**
     * StartGamePage constructor.
     */
    public StartGamePage() {
        pageManager = PageManager.getInstance();
        gameManager = new GameManager(new Game(2));
        LOG.trace("StartGamePage constructor");
        startGamePage = new MainFrame(
            this, "Start Game Page", 1400, 900, false);
        setup();
    }

    /**
     * Setup method.
     */
    public void setup() {
        LOG.trace("setup method in StartGamePage.java");

        gameArea = new Rectangle(new Point(25, 40),
            new Dimension(1350, 800), Color.black, new Color(43, 176, 19));
        board = new Rectangle(new Point(35, 50), new Dimension(350, 700),
            Color.black, new Color(180, 110, 30));
        returnHomeButton = new Text("Return to home", new Point(10, 25), 20,
            Color.black, Color.blue);
        resizeButton = new Text("Resize Window", new Point(180, 25), 20,
            Color.black, Color.blue);
        startButton = new Text("Start Game", new Point(700, 420), 20,
            Color.black, Color.blue);
        arrows = new Image[3];
        arrows[0] = new Image("arrow.png", new Point(100, 70), 1, null);
        arrows[1] = new Image("arrow.png", new Point(260, 70), 1, null);
        arrows[2] = new Image("arrow2.png", new Point(180, 695), -1, null);
        playerPointsLabel = new Text("Player Points: " + playerPoints,
            new Point(30, 800), 20, Color.black, Color.blue);
        computerPointsLabel = new Text("Computer Points: " + computerPoints,
            new Point(30, 830), 20, Color.black, Color.blue);
        add(gameArea);
        add(board);
        add(returnHomeButton);
        add(resizeButton);
        add(startButton);
        add(playerPointsLabel);
        add(computerPointsLabel);
        boardLines = new LineSegment[24];
        for (int i = 0; i < 24; i++) {
            if ((i >= 0 && i < 6) || (i >= 12 && i < 18)) {
                boardLines[i] = new LineSegment(
                    new Point(60 + (i / 6) * 80, 590 - (i % 6) * 100 - 2),
                    new Point(120 + (i / 6) * 80 - 4, 590 - (i % 6) * 100 - 2),
                    Color.yellow);
            } else {
                boardLines[i] = new LineSegment(
                    new Point(60 + (i / 6) * 80, 690 - (i % 6) * 100 - 2),
                    new Point(120 + (i / 6) * 80 - 4, 690 - (i % 6) * 100 - 2),
                    Color.yellow);
            }
            add(boardLines[i]);
        }

        add(arrows[0]);
        add(arrows[1]);
        add(arrows[2]);

        moveAmt = 5;
        running = false;
        resizeWindow = false;

        createGrid();
        assignSpots();
        renderSpots();
        createCards();

    }

    /**
     * Creates the board grid.
     */
    public void createGrid() {
        LOG.trace("createGrid method in StartGamePage.java");
        BoardManager.getInstance().getBoard().initializeGrid();
    }

    /**
     * Assigns all the special spots.
     */
    public void assignSpots() {
        LOG.trace("assignSpots method in StartGamePage,java");
        BoardManager.getInstance().getBoard().assignBattleSpot();
        for (int i = 0; i < 2; i++) {
            BoardManager.getInstance().getBoard().assignJumpSpot();
            BoardManager.getInstance().getBoard().assignPrizeSpot();
        }
    }

    /**
     * Renders the spots and pegs on the board.
     * 
     * @author Charlie Davidson
     */
    public void renderSpots() {

        initialSpots = new Circle[2][3];

        for (int i = 0; i < initialSpots.length; i++) {
            for (int j = 0; j < initialSpots[0].length; j++) {
                initialSpots[i][j] = new Circle(
                    new Point(60 + j * 20, 720 - i * 20),
                    16, Color.black, Color.black);
                add(initialSpots[i][j]);
            }
        }

        endSpot = new Circle(new Point(320, 700),
            16, Color.black, Color.black);
        add(endSpot);

        spotLocations = new Point[120][3];
        for (int i = 0; i < spotLocations.length; i++) {
            for (int j = 0; j < spotLocations[0].length; j++) {
                if ((i >= 0 && i < 30) || (i >= 60 && i < 90)) {
                    spotLocations[i][j] = new Point(60 + j * 20 + (i / 30) * 80,
                        670 - (i % 30) * 20);
                } else {
                    spotLocations[i][j] = new Point(100 - j * 20
                        + (i / 30) * 80, 90 + (i % 30) * 20);
                }
            }
        }

        pegSpotLocations = new Point[120][3];
        spotRenderer = new VisibleObject[120][3];
        Board boardInstance = BoardManager.getInstance().getBoard();
        for (int i = 0; i < spotRenderer.length; i++) {
            for (int j = 0; j < spotRenderer[0].length; j++) {
                if (boardInstance.getGrid()[i][j]
                    .getType() == SpotType.BATTLE) {
                    spotRenderer[i][j] = new Circle(spotLocations[i][1],
                        16, Color.black, Color.white);
                    pegSpotLocations[i][j] = spotLocations[i][1];
                } else if (boardInstance.getGrid()[i][j]
                    .getType() == SpotType.PRIZE) {
                    spotRenderer[i][j] = new Circle(spotLocations[i][j],
                        16, Color.yellow, Color.black);
                    pegSpotLocations[i][j] = spotLocations[i][j];

                } else if (boardInstance.getGrid()[i][j]
                    .getType() == SpotType.JUMP) {
                    spotRenderer[i][j] = new Rectangle(new Point(
                        (int) spotLocations[i][j].getX() + 2,
                        (int) spotLocations[i][j].getY() + 2),
                        new Dimension(12, 12), Color.yellow, Color.black);
                    spotRenderer[i][j].setRotationDegrees(45);
                    pegSpotLocations[i][j] = spotLocations[i][j];

                } else {
                    spotRenderer[i][j] = new Circle(spotLocations[i][j],
                        16, Color.black, Color.black);
                    pegSpotLocations[i][j] = spotLocations[i][j];
                }
                add(spotRenderer[i][j]);
            }
        }

        pegLocations = new int[3];
        pegLocations[0] = -1;
        pegLocations[1] = -1;
        pegLocations[2] = -1;

        pegRenderer = new Circle[3];
        pegRenderer[0] = new Circle(
            (Point) initialSpots[1][0].getLocation().clone(),
            16, Color.white, Color.red);
        pegRenderer[1] = new Circle(
            (Point) initialSpots[1][1].getLocation().clone(),
            16, Color.white, Color.blue);
        pegRenderer[2] = new Circle(
            (Point) initialSpots[1][2].getLocation().clone(),
            16, Color.white, Color.yellow);

        add(pegRenderer[0]);
        add(pegRenderer[1]);
        add(pegRenderer[2]);
    }

    /**
     * Initialize the cards.
     */
    public void createCards() {

        fileNames = new String[52];
        for (int i = 0; i < 4; i++) {
            String suit;
            if (i == 0) {
                suit = "clubs";
            } else if (i == 1) {
                suit = "diamonds";
            } else if (i == 2) {
                suit = "hearts";
            } else {
                suit = "spades";
            }

            fileNames[13 * i] = "ace_of_" + suit + ".png";
            fileNames[13 * i + 1] = "2_of_" + suit + ".png";
            fileNames[13 * i + 2] = "3_of_" + suit + ".png";
            fileNames[13 * i + 3] = "4_of_" + suit + ".png";
            fileNames[13 * i + 4] = "5_of_" + suit + ".png";
            fileNames[13 * i + 5] = "6_of_" + suit + ".png";
            fileNames[13 * i + 6] = "7_of_" + suit + ".png";
            fileNames[13 * i + 7] = "8_of_" + suit + ".png";
            fileNames[13 * i + 8] = "9_of_" + suit + ".png";
            fileNames[13 * i + 9] = "10_of_" + suit + ".png";
            fileNames[13 * i + 10] = "jack_of_" + suit + ".png";
            fileNames[13 * i + 11] = "queen_of_" + suit + ".png";
            fileNames[13 * i + 12] = "king_of_" + suit + ".png";
        }

        standardDeck = new ArrayList<CardImage>();
        cardsInDeck = new ArrayList<CardImage>();
        cardsInPlay = new ArrayList<CardImage>();
        cardsInHand = new ArrayList<CardImage>();
        cardsInOpponentHand = new ArrayList<CardImage>();

        for (int i = 0; i < numcards; i++) {
            fileNames[i] = "Playing Cards/" + fileNames[i];
            standardDeck.add(new CardImage(new Image(
                "card.png", new Point(
                    1150 + (i * 25) / numcards,
                    315 + (i * 25) / numcards),
                0.6, null), i));
        }

        gameManager.initializeDeck();
        updateCardPositions();

        for (int i = cardsInDeck.size() - 1; i >= 0; i--) {
            add(cardsInDeck.get(i).getImage());
        }

    }

    /**
     * Update the card positions based on the data in the Game object.
     */
    public void updateCardPositions() {
        cardsInDeck.clear();
        cardsInPlay.clear();
        cardsInHand.clear();
        cardsInOpponentHand.clear();

        ArrayList<Card> gameCardsInDeck =
            gameManager.getGame().getCardsInDeck();
        ArrayList<Card> gameCardsInPlay =
            gameManager.getGame().getCardsInPlay();
        ArrayList<Card> gameCardsInHand =
            gameManager.getGame().getCardsInHand();
        ArrayList<Card> gameCardsInOpponentHand =
            gameManager.getGame().getCardsInOpponentHand();

        for (int i = 0; i < gameCardsInDeck.size(); i++) {
            cardsInDeck.add(
                standardDeck.get(
                    gameCardsInDeck.get(i).getCardID()));
        }

        for (int i = 0; i < gameCardsInPlay.size(); i++) {
            cardsInPlay.add(
                standardDeck.get(
                    gameCardsInPlay.get(i).getCardID()));
        }

        for (int i = 0; i < gameCardsInHand.size(); i++) {
            cardsInHand.add(
                standardDeck.get(
                    gameCardsInHand.get(i).getCardID()));
        }

        for (int i = 0; i < gameCardsInOpponentHand.size(); i++) {
            cardsInOpponentHand.add(
                standardDeck.get(
                    gameCardsInOpponentHand.get(i).getCardID()));
        }

    }

    /**
     * Test animation of pegs on board.
     */

    public void animatePegs() {
        while (running) {
            movePeg(0, moveAmt);
            movePeg(1, moveAmt);
            movePeg(2, moveAmt);
            if (pegLocations[0] == 120
                && pegLocations[1] == 120
                && pegLocations[2] == 120) {
                running = false;
                startButton.setMessage("Start");
            }
        }
    }

    /**
     * Move cards in the deck.
     */
    public void moveDeck() {
        int deckSize = cardsInDeck.size();
        for (int i = 0; i < deckSize; i++) {
            cardsInDeck.get(i).setDestLocation(
                new Point(1150 + i * 25 / deckSize, 315 + i * 25 / deckSize));
        }
    }

    /**
     * Move cards in the play area.
     */
    public void movePlayCards() {
        int playSize = cardsInPlay.size();
        for (int i = 0; i < playSize; i++) {
            cardsInPlay.get(i).setDestLocation(
                new Point(550 + (i * 350) / playSize, 330));
        }
    }

    /**
     * Move cards in the player's hand.
     */
    public void moveHandCards() {
        int handSize = cardsInHand.size();
        for (int i = 0; i < handSize; i++) {
            cardsInHand.get(i).setDestLocation(
                new Point(550 + (i * 350) / handSize,
                    resizeWindow ? 550 : 630));
        }
    }

    /**
     * Move cards in the opponent's hand.
     */
    public void moveOpponentHandCards() {
        int opponentHandSize = cardsInOpponentHand.size();
        for (int i = 0; i < opponentHandSize; i++) {
            cardsInOpponentHand.get(i).setDestLocation(
                new Point(550 + (i * 350) / opponentHandSize, 80));
        }
    }

    /**
     * Animate the cards.
     * 
     * @param steps
     */
    public void moveCards(int steps) {

        moveDeck();
        movePlayCards();
        moveHandCards();
        moveOpponentHandCards();

        double[] x = new double[numcards];
        double[] y = new double[numcards];

        double[] destX = new double[numcards];
        double[] destY = new double[numcards];

        double[] xDist = new double[numcards];
        double[] yDist = new double[numcards];

        for (int i = 0; i < numcards; i++) {

            Point initialPoint = standardDeck.get(i).getImage().getLocation();
            Point destPoint = standardDeck.get(i).getDestLocation();

            x[i] = initialPoint.getX();
            y[i] = initialPoint.getY();

            destX[i] = destPoint.getX();
            destY[i] = destPoint.getY();

            xDist[i] = destX[i] - x[i];
            yDist[i] = destY[i] - y[i];
        }

        for (int i = 0; i < steps; i++) {

            if (i == steps / 2) {
                updateLayers();
            }

            for (int j = 0; j < numcards; j++) {
                x[j] += xDist[j] / steps;
                y[j] += yDist[j] / steps;

                standardDeck.get(j).getImage().setX((int) x[j]);
                standardDeck.get(j).getImage().setY((int) y[j]);
            }
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Bring certain cards to the front.
     */
    public void updateLayers() {

        for (int i = cardsInDeck.size() - 1; i >= 0; i--) {
            remove(cardsInDeck.get(i).getImage());
            add(cardsInDeck.get(i).getImage());
            showCard(cardsInDeck.get(i), false);
        }

        for (int i = 0; i < cardsInPlay.size(); i++) {
            remove(cardsInPlay.get(i).getImage());
            add(cardsInPlay.get(i).getImage());
            showCard(cardsInPlay.get(i), true);
        }

        for (int i = 0; i < cardsInHand.size(); i++) {
            remove(cardsInHand.get(i).getImage());
            add(cardsInHand.get(i).getImage());
            showCard(cardsInHand.get(i), true);
        }

        for (int i = cardsInOpponentHand.size() - 1; i >= 0; i--) {
            remove(cardsInOpponentHand.get(i).getImage());
            add(cardsInOpponentHand.get(i).getImage());
            showCard(cardsInOpponentHand.get(i), false);
        }
    }

    /**
     * Move peg a certain number of spaces.
     * 
     * @author Charlie Davidson
     * @param peg
     *            : peg to move
     * @param spaces
     *            : number of spaces to move
     */
    public void movePeg(int peg, int spaces) {

        if (spaces == 0) {
            return;
        }

        if (pegLocations[peg] + spaces < -1) {
            movePeg(peg, -1 - pegLocations[peg]);
            return;
        }

        if (pegLocations[peg] + spaces > 120) {
            movePeg(peg, 120 - pegLocations[peg]);
            return;
        }

        Point initialPoint = pegRenderer[peg].getLocation();
        Point destPoint;

        if (pegLocations[peg] + spaces == -1) {
            destPoint = initialSpots[1][peg].getLocation();
        } else if (pegLocations[peg] + spaces == 120) {
            destPoint = endSpot.getLocation();
        } else {
            destPoint =
                pegSpotLocations[pegLocations[peg] + spaces][peg].getLocation();
        }

        double x = initialPoint.getX();
        double y = initialPoint.getY();

        double destX = destPoint.getX();
        double destY = destPoint.getY();

        double xDist = destX - x;
        double yDist = destY - y;

        for (int i = 0; i < 50; i++) {
            x += xDist / 50;
            y += yDist / 50;

            pegRenderer[peg].setX((int) x);
            pegRenderer[peg].setY((int) y);

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        pegLocations[peg] = pegLocations[peg] + spaces;

    }

    /**
     * Show or hide one card.
     * 
     * @param card
     * @param showing
     */
    public void showCard(CardImage card, boolean showing) {

        if (showing == card.isShowing()) {
            return;
        }

        if (showing) {
            card.getImage().setImageFileName(fileNames[card.getCardID()]);
            card.getImage().setScaleFactor(0.25);
            card.setShowing(true);
        } else {
            card.getImage().setImageFileName("card.png");
            card.getImage().setScaleFactor(0.6);
            card.setShowing(false);
        }
    }

    /**
     * Method to show or hide the cards.
     * 
     * @param showing
     */
    public void showCards(boolean showing) {

        for (int i = 0; i < cardsInHand.size(); i++) {
            showCard(cardsInHand.get(i), showing);
        }

        for (int i = 0; i < cardsInOpponentHand.size(); i++) {
            showCard(cardsInOpponentHand.get(i), showing);
        }

        for (int i = 0; i < cardsInPlay.size(); i++) {
            showCard(cardsInPlay.get(i), showing);
        }

        for (int i = 0; i < cardsInDeck.size(); i++) {
            showCard(cardsInDeck.get(i), showing);
        }
    }

    /**
     * Animation to select a card.
     * 
     * @param index
     *            index of selected card
     */
    public void selectCard(int index) {
        int playSize = cardsInPlay.size();
        for (int i = 0; i < playSize; i++) {
            if (i == index) {
                cardsInPlay.get(i).setDestLocation(
                    new Point(550 + (i * 350) / playSize, 270));
            } else {
                cardsInPlay.get(i).setDestLocation(
                    new Point(550 + (i * 350) / playSize, 330));
            }
        }
        moveCards(50);
    }

    /**
     * Reset card positions.
     */
    public void resetCards() {

        if (gameManager.deckIsSorted()) {
            return;
        }

        gameManager.resetCards();
        updateCardPositions();

        moveCards(50);
    }

    /**
     * Shuffle the deck.
     */
    public void shuffleCards() {

        showCards(false);
        resetCards();

        gameManager.shuffleCards();
        updateCardPositions();

        moveCards(50);
    }

    /**
     * Deal the cards.
     */
    public void dealCards() {
        shuffleCards();

        for (int i = 0; i < 6; i++) {
            if (cardsInDeck.size() > 0) {
                gameManager.dealPlayerCards(1);
                updateCardPositions();
                moveCards(20);
            }
            if (cardsInDeck.size() > 0) {
                gameManager.dealOpponentCards(1);
                updateCardPositions();
                moveCards(20);
            }
        }
    }

    /**
     * Set a specific button to be clickable or not.
     * 
     * @param button
     * @param clickable
     */
    public void setButtonClickable(Text button, boolean clickable) {
        button.setClickable(clickable);
        button.setOpacity(clickable ? 1 : 0.5f);
    }

    /**
     * Set whether the cards are clickable to avoid conflicts.
     * 
     * @param clickable
     */
    public void setCardsClickable(boolean clickable) {
        for (int k = 0; k < standardDeck.size(); k++) {
            standardDeck.get(k).getImage().setClickable(clickable);
        }
    }

    /**
     * Check if a card has been clicked.
     * 
     * @param e
     */
    public void checkCardClick(Drawable e) {
        for (int i = 0; i < cardsInHand.size(); i++) {
            if (e == cardsInHand.get(i).getImage()) {
                setCardsClickable(false);
                gameManager.playCard(i);
                updateCardPositions();
                moveCards(50);
                System.out.println(cardsInHand.get(i).getCardID());
                gameManager.opponentPlayCard();
                updateCardPositions();
                moveCards(50);
                if (gameManager.getGame().getCardsInPlay().size() == 12) {

                    if (gameManager.getGame().getCardsInPlay()
                        .getCardsInHand().size() == 12) {
                        movePeg(0, 5);
                        movePeg(1, 5);
                        if (pegLocations[0] == 120) {
                            closeWindow();
                        }
                        dealCards();
                    }
                    setCardsClickable(true);
                    return;
                }
            }
        }
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("drawableMouseClick method in StartGamepage.java");

        if (e == startButton) {
            LOG.trace("Starting game");
            remove(startButton);
            dealCards();

        } else if (e == returnHomeButton) {
            LOG.trace("Return to previous screen");
            navPage = (NavigationPage) pageManager
                .createPage(PageType.NAVIGATION_PAGE);
            closeWindow();
        } else if (e == resizeButton) {
            LOG.trace("Resize window");
            gameArea.setDimension(
                new Dimension(1350, resizeWindow ? 800 : 720));
            startGamePage.setSize(1400, resizeWindow ? 940 : 860);
            resizeWindow = !resizeWindow;
            moveCards(10);
        }

        checkCardClick(e);

    }

    /**
     * Close window method from Page interface.
     */
    public void closeWindow() {
        startGamePage.dispose();
    }

}
