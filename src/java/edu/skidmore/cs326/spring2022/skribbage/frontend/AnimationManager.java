package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;
import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import us.daveread.edu.graphics.shape.VisibleObject;
import us.daveread.edu.graphics.shape.impl.Circle;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.LineSegment;
import us.daveread.edu.graphics.shape.impl.Rectangle;

/**
 * Class to store all the card and peg animations.
 * Edit this file if you need to.
 * 
 * @author cdavidso
 */
public class AnimationManager {

    /**
     * Logger.
     */
    private static final Logger LOG;

    /**
     * Singleton instance of this class.
     */
    private static final AnimationManager INSTANCE;

    /**
     * StartGamePage instance.
     */
    private StartGamePage startGamePage;

    /**
     * GameManager instance to manage the game.
     */
    private GameManager gameManager;

    /**
     * How many spaces each player moves.
     */
    @SuppressWarnings("unused")
    private int moveAmt;

    /**
     * Store whether the game currently running.
     */
    @SuppressWarnings("unused")
    private boolean running;

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
     * Lines displayed on the board which occur every 5 spaces.
     */
    private LineSegment[] boardLines;

    /**
     * Locations of the pegs on the board.
     */
    private int[] pegLocations;

    /**
     * Stores the file names of the 52 cards.
     */
    private String[] fileNames;

    /**
     * Number of cards displayed on the deck. This is only for visual purposes.
     */
    private final int numcards = 52;

    /**
     * Toggles the screen being resized.
     */
    private boolean resizeWindow;

    /**
     * Initialize the static instance.
     */
    static {
        LOG = Logger.getLogger(GameRenderManager.class);
        INSTANCE = new AnimationManager();
    }

    /**
     * Constructor method.
     */
    private AnimationManager() {
        LOG.debug("Instance created");
        gameManager = new GameManager(new Game(2));
        resizeWindow = false;
    }

    /**
     * getInstance method.
     * 
     * @return static instance of AnimationManager
     */
    public static AnimationManager getInstance() {
        return INSTANCE;
    }

    /**
     * Get StartGamePage instance.
     * 
     * @return startGamePage
     */
    public StartGamePage getStartGamePage() {
        return startGamePage;
    }

    /**
     * Set StartGamePage instance.
     * 
     * @param startGamePage
     */
    public void setStartGamePage(StartGamePage startGamePage) {
        this.startGamePage = startGamePage;
    }
    
    /**
     * Get the gameManager instance.
     * @return gameManager
     */
    public GameManager getGameManager() {
        return gameManager;
    }
    
    /**
     * Set the gameManager instace.
     * @param gameManager
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Get the peg locations.
     * @return pegLocations
     */
    public int[] getPegLocations() {
        return pegLocations;
    }
    
    /**
     * Renders the spots and pegs on the board.
     */
    public void renderSpots() {

        boardLines = new LineSegment[24];
        for (int i = 0; i < 24; i++) {
            if (i < 6 || i >= 12 && i < 18) {
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
            startGamePage.add(boardLines[i]);
        }

        initialSpots = new Circle[2][3];

        for (int i = 0; i < initialSpots.length; i++) {
            for (int j = 0; j < initialSpots[0].length; j++) {
                initialSpots[i][j] = new Circle(
                    new Point(60 + j * 20, 720 - i * 20),
                    16, Color.black, Color.black);
                startGamePage.add(initialSpots[i][j]);
            }
        }

        endSpot = new Circle(new Point(320, 700),
            16, Color.black, Color.black);
        startGamePage.add(endSpot);

        spotLocations = new Point[120][3];
        for (int i = 0; i < spotLocations.length; i++) {
            for (int j = 0; j < spotLocations[0].length; j++) {
                if (i < 30 || i >= 60 && i < 90) {
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
                startGamePage.add(spotRenderer[i][j]);
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

        startGamePage.add(pegRenderer[0]);
        startGamePage.add(pegRenderer[1]);
        startGamePage.add(pegRenderer[2]);
    }

    /**
     * Initialize the cards.
     */
    public void createCards() {

        fileNames = new String[52];
        for (int i = 0; i < 4; i++) {
            String suit;
            if (i == 0) {
                suit = "hearts";
            } else if (i == 1) {
                suit = "clubs";
            } else if (i == 2) {
                suit = "diamonds";
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

        List<Card> cardDeck = gameManager.getGame().getDeck().getDeck();

        GameRenderManager.getInstance()
            .setStandardDeck(new ArrayList<CardImage>());
        GameRenderManager.getInstance()
            .setCardsInDeck(new ArrayList<CardImage>());
        GameRenderManager.getInstance()
            .setCardsInPlay(new ArrayList<CardImage>());
        GameRenderManager.getInstance()
            .setCardsInHand(new ArrayList<CardImage>());
        GameRenderManager.getInstance()
            .setCardsInOpponentHand(new ArrayList<CardImage>());

        for (int i = 0; i < numcards; i++) {
            fileNames[i] = "Playing Cards/" + fileNames[i];
            GameRenderManager.getInstance()
                .getStandardDeck().add(new CardImage(new Image(
                    "card.png", new Point(
                        1150 + (i * 25) / numcards,
                        315 + (i * 25) / numcards),
                    0.6, null), i, cardDeck.get(i)));
        }

        updateCardPositions();

        for (int i = GameRenderManager.getInstance()
            .getCardsInDeck().size() - 1; i >= 0; i--) {
            startGamePage.add(GameRenderManager.getInstance()
                .getCardsInDeck().get(i).getImage());
        }

    }

    /**
     * Update the card positions based on the data in the Game object.
     */
    public void updateCardPositions() {
        GameRenderManager.getInstance()
            .getCardsInDeck().clear();
        GameRenderManager.getInstance()
            .getCardsInPlay().clear();
        GameRenderManager.getInstance()
            .getCardsInHand().clear();
        GameRenderManager.getInstance()
            .getCardsInOpponentHand().clear();

        List<Card> gameCardsInDeck =
            gameManager.getGame().getDeck().getDeck();
        List<Card> gameCardsInPlay =
            gameManager.getGame().getCardsInPlay().getCardsInHand();
        List<Card> gameCardsInHand = gameManager.getGame()
            .getPlayerList().get(0).getHand().getCardsInHand();
        List<Card> gameCardsInOpponentHand = gameManager.getGame()
            .getPlayerList().get(1).getHand().getCardsInHand();
        for (Card card : gameCardsInDeck) {
            GameRenderManager.getInstance()
                .getCardsInDeck().add(
                    GameRenderManager.getInstance()
                        .getStandardDeck().get(
                            card.getCardID()));
        }

        for (int i = 0; i < gameCardsInPlay.size(); i++) {
            GameRenderManager.getInstance()
                .getCardsInPlay().add(
                    GameRenderManager.getInstance()
                        .getStandardDeck().get(
                            gameCardsInPlay.get(i).getCardID()));
        }

        for (int i = 0; i < gameCardsInHand.size(); i++) {
            GameRenderManager.getInstance()
                .getCardsInHand().add(
                    GameRenderManager.getInstance()
                        .getStandardDeck().get(
                            gameCardsInHand.get(i).getCardID()));
        }

        for (int i = 0; i < gameCardsInOpponentHand.size(); i++) {
            GameRenderManager.getInstance()
                .getCardsInOpponentHand().add(
                    GameRenderManager.getInstance()
                        .getStandardDeck().get(
                            gameCardsInOpponentHand.get(i).getCardID()));
        }

    }

    /**
     * Set the destination location of cards in the deck.
     */
    public void setDesintationOfDeck() {
        int deckSize = GameRenderManager.getInstance()
            .getCardsInDeck().size();
        for (int i = 0; i < deckSize; i++) {
            GameRenderManager.getInstance()
                .getCardsInDeck().get(i).setDestLocation(
                    new Point(1150 + i * 25 / deckSize,
                        315 + i * 25 / deckSize));
        }
    }

    /**
     * Set the destination location of cards in the play area.
     */
    public void setDestinationOfPlayCards() {
        int playSize = GameRenderManager.getInstance()
            .getCardsInPlay().size();
        for (int i = 0; i < playSize; i++) {
            GameRenderManager.getInstance()
                .getCardsInPlay().get(i).setDestLocation(
                    new Point(550 + (i * 350) / playSize, 330));
        }
    }

    /**
     * Set the destination location of cards in the player's hand.
     */
    public void setDestinationOfHandCards() {
        int handSize = GameRenderManager.getInstance()
            .getCardsInHand().size();
        for (int i = 0; i < handSize; i++) {
            GameRenderManager.getInstance()
                .getCardsInHand().get(i).setDestLocation(
                    new Point(550 + (i * 350) / handSize,
                        resizeWindow ? 550 : 630));
        }
    }

    /**
     * Set the destination location of cards in the opponent's hand.
     */
    public void setDestinationOfOpponentHandCards() {
        int opponentHandSize = GameRenderManager.getInstance()
            .getCardsInOpponentHand().size();
        for (int i = 0; i < opponentHandSize; i++) {
            GameRenderManager.getInstance()
                .getCardsInOpponentHand().get(i).setDestLocation(
                    new Point(550 + (i * 350) / opponentHandSize, 80));
        }
    }

    /**
     * Move the cards.
     * 
     * @param steps
     */
    public void moveCards(int steps) {

        setDesintationOfDeck();
        setDestinationOfPlayCards();
        setDestinationOfHandCards();
        setDestinationOfOpponentHandCards();

        double[] x = new double[numcards];
        double[] y = new double[numcards];

        double[] destX = new double[numcards];
        double[] destY = new double[numcards];

        double[] xDist = new double[numcards];
        double[] yDist = new double[numcards];

        for (int i = 0; i < numcards; i++) {

            Point initialPoint = GameRenderManager.getInstance()
                .getStandardDeck().get(i).getImage().getLocation();
            Point destPoint = GameRenderManager.getInstance()
                .getStandardDeck().get(i).getDestLocation();

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

                GameRenderManager.getInstance()
                    .getStandardDeck().get(j).getImage().setX((int) x[j]);
                GameRenderManager.getInstance()
                    .getStandardDeck().get(j).getImage().setY((int) y[j]);
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

        for (int i = GameRenderManager.getInstance()
            .getCardsInDeck().size() - 1; i >= 0; i--) {
            startGamePage.remove(GameRenderManager.getInstance()
                .getCardsInDeck().get(i).getImage());
            startGamePage.add(GameRenderManager.getInstance()
                .getCardsInDeck().get(i).getImage());
            showCard(GameRenderManager.getInstance()
                .getCardsInDeck().get(i), false);
        }

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInPlay().size(); i++) {
            startGamePage.remove(GameRenderManager.getInstance()
                .getCardsInPlay().get(i).getImage());
            startGamePage.add(GameRenderManager.getInstance()
                .getCardsInPlay().get(i).getImage());
            showCard(GameRenderManager.getInstance()
                .getCardsInPlay().get(i), true);
        }

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInHand().size(); i++) {
            startGamePage.remove(GameRenderManager.getInstance()
                .getCardsInHand().get(i).getImage());
            startGamePage.add(GameRenderManager.getInstance()
                .getCardsInHand().get(i).getImage());
            showCard(GameRenderManager.getInstance()
                .getCardsInHand().get(i), true);
        }

        for (int i = GameRenderManager.getInstance()
            .getCardsInOpponentHand().size() - 1; i >= 0; i--) {
            startGamePage.remove(GameRenderManager.getInstance()
                .getCardsInOpponentHand().get(i).getImage());
            startGamePage.add(GameRenderManager.getInstance()
                .getCardsInOpponentHand().get(i).getImage());
            showCard(GameRenderManager.getInstance()
                .getCardsInOpponentHand().get(i), false);
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

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInHand().size(); i++) {
            showCard(GameRenderManager.getInstance()
                .getCardsInHand().get(i), showing);
        }

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInOpponentHand().size(); i++) {
            showCard(GameRenderManager.getInstance()
                .getCardsInOpponentHand().get(i), showing);
        }

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInPlay().size(); i++) {
            showCard(GameRenderManager.getInstance()
                .getCardsInPlay().get(i), showing);
        }

        for (int i = 0; i < GameRenderManager.getInstance()
            .getCardsInDeck().size(); i++) {
            showCard(GameRenderManager.getInstance()
                .getCardsInDeck().get(i), showing);
        }
    }

    /**
     * Reset card positions.
     */
    public void resetCards() {

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
            if (GameRenderManager.getInstance()
                .getCardsInDeck().size() > 0) {
                gameManager.dealPlayerCards(1);
                updateCardPositions();
                moveCards(20);
            }
            if (GameRenderManager.getInstance()
                .getCardsInDeck().size() > 0) {
                gameManager.dealOpponentCards(1);
                updateCardPositions();
                moveCards(20);
            }
        }
    }

    /**
     * Set whether the cards are clickable to avoid conflicts.
     * 
     * @param clickable
     */
    public void setCardsClickable(boolean clickable) {
        for (int k = 0; k < GameRenderManager.getInstance()
            .getStandardDeck().size(); k++) {
            GameRenderManager.getInstance()
                .getStandardDeck().get(k).getImage().setClickable(clickable);

        }
    }

    /**
     * Resize the window.
     */
    public void resizeWindow() {
        resizeWindow = !resizeWindow;
    }

}