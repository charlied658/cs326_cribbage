package edu.skidmore.cs326.spring2022.skribbage.frontend;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;
import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.VisibleObject;
import us.daveread.edu.graphics.shape.impl.Circle;
import us.daveread.edu.graphics.shape.impl.LineSegment;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Text;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to store all the card and peg animations.
 * Edit this file if you need to.
 * <<<<<<< HEAD
 * =======
 * >>>>>>> 92a128e0e4870f3bcf7bae306e1ca395cd72431b
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
     * GameRenderManager instance.
     */
    private GameRenderManager gameRenderManager;

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
     * standard Deck.
     */
    @SuppressWarnings("unused")
    private ArrayList<CardImage> standardDeck;

    /**
     * cardsInHand.
     */
    @SuppressWarnings("unused")
    private ArrayList<CardImage> cardsInHand;

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
     * Contains the order in which cards should be added to the screen.
     */
    private ArrayList<CardImage> layerStack;

    /**
     * Initialize the static instance.
     */
    static {
        LOG = Logger.getLogger(AnimationManager.class);
        INSTANCE = new AnimationManager();
    }

    /**
     * Constructor method.
     */
    private AnimationManager() {
        LOG.debug("Instance created");
        resizeWindow = false;
        layerStack = new ArrayList<>();
        gameRenderManager = GameRenderManager.getInstance();
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
     *            start game page to set
     */
    public void setStartGamePage(StartGamePage startGamePage) {
        this.startGamePage = startGamePage;
    }

    /**
     * Get the gameManager instance.
     *
     * @return gameManager
     */
    public GameManager getGameManager() {
        return gameManager;
    }

    /**
     * player points.
     */
    @SuppressWarnings("unused")
    private int pPoints;

    /**
     * computer points.
     */
    @SuppressWarnings("unused")
    private int cPoints;

    /**
     * setGameManager.
     * 
     * @param gameManager
     **/
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Get the peg locations.
     * 
     * @return pegLocations
     */
    public int[] getPegLocations() {
        return pegLocations;
    }

    /**
     * Renders the spots and pegs on the board.
     */
    public void renderSpots() {

        LOG.trace("Render spots on board");

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

        LOG.trace("Initialize and render cards on board");

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

        gameRenderManager.setStandardDeck(new ArrayList<>());
        gameRenderManager.setCardsInDeck(new ArrayList<>());
        gameRenderManager.setCardsInPlay(new ArrayList<>());
        gameRenderManager.setCardsInHand(new ArrayList<>());
        gameRenderManager.setCardsInOpponentHand(new ArrayList<>());
        gameRenderManager.setSelectedCardsForDiscarding(new ArrayList<>());

        for (int i = 0; i < numcards; i++) {
            fileNames[i] = "Playing Cards/" + fileNames[i];
            gameRenderManager.getStandardDeck()
                .add(new CardImage("card.png",
                    new Point(1150 + (i * 25) / numcards,
                        315 + (i * 25) / numcards),
                    0.6, null, i, cardDeck.get(i), CardPosition.DECK));
        }

        updateCardPositions();

        for (int i = gameRenderManager.getCardsInDeck().size() - 1; i >= 0;
            i--) {
            startGamePage.add(gameRenderManager.getCardsInDeck().get(i));
        }

    }

    /**
     * Update the card positions based on the data in the Game object.
     */
    public void updateCardPositions() {
        gameRenderManager.getCardsInDeck().clear();
        gameRenderManager.getCardsInPlay().clear();
        gameRenderManager.getCardsInHand().clear();
        gameRenderManager.getCardsInOpponentHand().clear();

        List<Card> gameCardsInDeck =
            gameManager.getGame().getDeck().getDeck();
        Card[] gameCardsInPlay =
            gameManager.getGame().getCardsInPlay().getCardsInHand();
        Card[] gameCardsInHand = gameManager.getGame()
            .getPlayerList().get(0).getHand().getCardsInHand();
        Card[] gameCardsInOpponentHand = gameManager.getGame()
            .getPlayerList().get(1).getHand().getCardsInHand();

        for (Card card : gameCardsInDeck) {
            CardImage cardImage =
                gameRenderManager.getStandardDeck().get(card.getCardID());
            gameRenderManager.getCardsInDeck().add(cardImage);
            cardImage.setCardPosition(CardPosition.DECK);
        }

        for (Card card : gameCardsInPlay) {
            CardImage cardImage =
                gameRenderManager.getStandardDeck().get(card.getCardID());
            gameRenderManager.getCardsInPlay().add(cardImage);
            cardImage.setCardPosition(CardPosition.IN_PLAY);
        }

        for (Card card : gameCardsInHand) {
            CardImage cardImage = gameRenderManager
                .getStandardDeck().get(card.getCardID());
            gameRenderManager.getCardsInHand().add(cardImage);
            cardImage.setCardPosition(CardPosition.PLAYER_HAND);
        }

        for (Card card : gameCardsInOpponentHand) {
            CardImage cardImage =
                gameRenderManager.getStandardDeck().get(card.getCardID());
            gameRenderManager.getCardsInOpponentHand().add(cardImage);
            cardImage.setCardPosition(CardPosition.OPPONENT_HAND);
        }

    }

    /**
     * Sets the destination location of cards within the given list along a
     * linear spread. This ensures that the cards will be spaced evenly along
     * the line defined by the x and y variables.
     * 
     * @param cardList
     *            List of cards that will have its destination locations updated
     * @param x
     *            Starting x position of the linear spread
     * @param y
     *            Starting y position of the linear spread
     * @param xDist
     *            Length of the linear spread in the x direction
     * @param yDist
     *            Length of the linear spread in the y direction
     */
    public void setDestinationOfCards(ArrayList<CardImage> cardList, int x,
        int y, int xDist, int yDist) {
        for (int i = 0; i < cardList.size(); i++) {
            cardList.get(i).setDestLocation(
                // When i = 0, the destination location will be (x,y)
                // When i = cardList.size() the destination location will be
                // (x + xDist, y + yDist)
                // All the cards in between will span this distance
                new Point(x + (i * xDist) / cardList.size(),
                    y + (i * yDist) / cardList.size()));
        }
    }

    /**
     * Sets the layering order of cards within the given list by adding them to
     * a stack. Cards will be added to the screen in the order that they enter.
     * 
     * @param cardList
     *            List of cards
     * @param reverse
     *            If the cards should be added in reverse order
     */
    public void setLayeringOfCards(ArrayList<CardImage> cardList,
        boolean reverse) {
        if (reverse) {
            for (int i = cardList.size() - 1; i >= 0; i--) {
                layerStack.add(cardList.get(i));
            }
        } else {
            for (int i = 0; i < cardList.size(); i++) {
                layerStack.add(cardList.get(i));
            }
        }
    }

    /**
     * Animation to select cards from the player's hand.
     */
    public void selectCards() {
        setStandardCardDestinations();
        for (CardImage card : gameRenderManager
            .getSelectedCardsForDiscarding()) {
            card.getDestLocation().setLocation(card.getDestLocation().getX(),
                card.getDestLocation().getY() - 20);
        }
        cardGlideAnimation(20);
    }

    /**
     * Animation to fan the deck out.
     */
    public void fanCards() {
        setStandardCardDestinations();
        setDestinationOfCards(gameRenderManager.getCardsInDeck(), 550, 330, 550,
            0);
        cardGlideAnimation(50);
    }

    /**
     * Set the standard destination of cards. Also sets the standard layering
     * and show status.
     */
    public void setStandardCardDestinations() {

        updateCardPositions();

        // These methods set the destination point of each card. The destination
        // point is the point that each card will glide to on the screen
        setDestinationOfCards(gameRenderManager.getCardsInDeck(), 1150, 315, 25,
            25);
        setDestinationOfCards(gameRenderManager.getCardsInPlay(), 550, 330, 350,
            0);
        setDestinationOfCards(gameRenderManager.getCardsInHand(), 550,
            resizeWindow ? 550 : 630, 350, 0);
        setDestinationOfCards(gameRenderManager.getCardsInOpponentHand(), 550,
            80, 350, 0);

        // Set the deafult layering of each card
        setLayeringOfCards(gameRenderManager.getCardsInDeck(), true);
        setLayeringOfCards(gameRenderManager.getCardsInPlay(), false);
        setLayeringOfCards(gameRenderManager.getCardsInHand(), false);
        setLayeringOfCards(gameRenderManager.getCardsInOpponentHand(), true);

        // Set whether each card list should be showing or not
        setCardsShowing(gameRenderManager.getCardsInDeck(), false);
        setCardsShowing(gameRenderManager.getCardsInPlay(), true);
        setCardsShowing(gameRenderManager.getCardsInHand(), true);
        setCardsShowing(gameRenderManager.getCardsInOpponentHand(), false);

    }

    /**
     * Moves the cards to the positions that they should be at on the board. For
     * example, cards in the hand should move the the bottom of the screen,
     * cards in the deck should move to the right, etc.
     * 
     * @param steps
     *            steps to pass in to cardGlideAnimation
     */
    public void moveCardsToStandardPositions(int steps) {

        // Sets standard destinations of cards
        setStandardCardDestinations();

        // cardGlideAnimation actually performs the glide animation
        cardGlideAnimation(steps);
    }

    /**
     * Moves the cards on the screen in a smooth animation. Before you call this
     * method you need to update the destination locations of all the cards you
     * want to move.
     *
     * @param steps
     *            number of steps that the glide animation should take. For
     *            example, 50 takes about 0.5 seconds, 10 takes 0.1 seconds, 200
     *            takes 2 seconds. Animation time = steps * 10 milliseconds
     */
    public void cardGlideAnimation(int steps) {

        setCardsClickable(false);
        
        // Declare variables
        double[] x = new double[numcards];
        double[] y = new double[numcards];

        double[] destX = new double[numcards];
        double[] destY = new double[numcards];

        double[] xDist = new double[numcards];
        double[] yDist = new double[numcards];

        // For every card, initialize the variables
        for (int i = 0; i < numcards; i++) {

            // The initial point is the point that the card is currently at
            Point initialPoint =
                gameRenderManager.getStandardDeck().get(i).getLocation();

            // The destination point is defined in the CardImage object
            Point destPoint =
                gameRenderManager.getStandardDeck().get(i).getDestLocation();

            // x and y represent the current x and y values
            x[i] = initialPoint.getX();
            y[i] = initialPoint.getY();

            // destX and destY represent the x and y values that the card will
            // glide to
            destX[i] = destPoint.getX();
            destY[i] = destPoint.getY();

            // xDist and yDist represent the x and y distance between the
            // initial point and the destination point
            xDist[i] = destX[i] - x[i];
            yDist[i] = destY[i] - y[i];
        }

        // Perform the animation according to the number of steps
        for (int i = 0; i < steps; i++) {

            // Halfway between the glide animation, update the layering of cards
            // and update which cards are showing
            if (i == steps / 2) {
                updateLayers();
                showCards();
            }

            // Update each card position by one step
            for (int j = 0; j < numcards; j++) {

                // Iterate the x and y position
                x[j] += xDist[j] / steps;
                y[j] += yDist[j] / steps;

                // Move the CardImage object to the new x and y position
                gameRenderManager.getStandardDeck().get(j).setX((int) x[j]);
                gameRenderManager.getStandardDeck().get(j).setY((int) y[j]);
            }

            // Wait for 10 milliseconds to ensure smooth animation
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        setCardsClickable(true);
    }

    /**
     * Add CardImages to the screen in the order they appear in layerStack.
     */
    public void updateLayers() {

        while (layerStack.size() > 0) {
            CardImage cardImage = layerStack.remove(0);
            startGamePage.remove(cardImage);
            startGamePage.add(cardImage);
        }

    }
    
    /**
     * Set a button to be clickable or not.
     * @param button
     * @param clickable
     */
    public void setButtonClickable(Text button, boolean clickable) {
        button.setClickable(clickable);
        button.setOpacity(clickable ? 1 : 0.3f);
    }

    /**
     * Move peg a certain number of spaces.
     *
     * @param peg
     *            peg to move
     * @param spaces
     *            number of spaces to move
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
     * Set whether the given card list should be showing.
     * 
     * @param cardList
     * @param showing
     */
    public void setCardsShowing(ArrayList<CardImage> cardList,
        boolean showing) {

        for (int i = 0; i < cardList.size(); i++) {
            cardList.get(i).setUpdateShowing(showing);
        }

    }

    /**
     * Show or hide cards according to the updateShowing variable in each
     * CardImage.
     */
    public void showCards() {
        for (int i = 0;
            i < gameRenderManager.getStandardDeck().size(); i++) {
            CardImage cardImage = gameRenderManager.getStandardDeck().get(i);
            if (cardImage.getUpdateShowing() != cardImage.isShowing()) {
                if (cardImage.getUpdateShowing()) {
                    cardImage
                        .setImageFileName(fileNames[cardImage.getCardID()]);
                    cardImage.setScaleFactor(0.25);
                    cardImage.setShowing(true);
                } else {
                    cardImage.setImageFileName("card.png");
                    cardImage.setScaleFactor(0.6);
                    cardImage.setShowing(false);
                }
            }
        }
    }

    /**
     * Reset card positions.
     */
    public void resetCards() {
        if (!gameManager.deckIsReset()) {
            gameManager.resetCards();
            moveCardsToStandardPositions(50);
        }
    }

    /**
     * Shuffle the deck.
     */
    public void shuffleCards() {
        resetCards();
        gameManager.shuffleCards();
        moveCardsToStandardPositions(50);
    }

    /**
     * Deal the cards.
     */
    public void dealCards() {
        shuffleCards();
        for (int i = 0; i < 6; i++) {
            if (gameRenderManager.getCardsInDeck().size() > 0) {
                gameManager.dealPlayerCards(1);
                moveCardsToStandardPositions(20);
            }
            if (gameRenderManager.getCardsInDeck().size() > 0) {
                gameManager.dealOpponentCards(1);
                moveCardsToStandardPositions(20);
            }
        }
    }

    /**
     * Set whether the cards are clickable to avoid conflicts.
     *
     * @param clickable
     *            clickable or not
     */
    public void setCardsClickable(boolean clickable) {
        for (int k = 0;
            k < gameRenderManager.getStandardDeck().size(); k++) {
            gameRenderManager.getStandardDeck().get(k).setClickable(clickable);

        }
    }

    /**
     * calculatePoints.
     * 
     * @param imageName
     *            card image
     * @return point value;
     */
    public int calculatePoints(String imageName) {
        if (imageName.contains("ace")) {
            return 1;
        } else if (imageName.contains("2")) {
            return 2;
        } else if (imageName.contains("3")) {
            return 3;
        } else if (imageName.contains("4")) {
            return 4;
        } else if (imageName.contains("5")) {
            return 5;
        } else if (imageName.contains("6")) {
            return 6;
        } else if (imageName.contains("7")) {
            return 7;
        } else if (imageName.contains("8")) {
            return 8;
        } else if (imageName.contains("9")) {
            return 9;
        } else if (imageName.contains("10") || imageName.contains("jack")
            || imageName.contains("queen") || imageName.contains("king")) {
            return 10;
        } else {
            return 0;
        }
    }

    /**
     * Resize the window.
     */
    public void resizeWindow() {
        resizeWindow = !resizeWindow;
    }

}