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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
     * Number of cards displayed in the deck.
     */
    private static final int NUM_CARDS = 52;

    /**
     * File path for the default card image.
     */
    private static final String CARD_IMAGE = "card.png";

    /**
     * File path containing the file names for the card images.
     */
    private static final String FILENAMES = "filenames.txt";

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
        try {
            Scanner scanner = new Scanner(new File(FILENAMES));

            for (int i = 0; i < NUM_CARDS; i++) {
                String fileName = scanner.nextLine();
                fileNames[i] = fileName;
            }

            scanner.close();
        }
        catch (Exception e) {
            LOG.trace("File not found " + e);
        }

        List<Card> cardDeck = gameManager.getGame().getDeck().getDeck();

        gameRenderManager.initializeCards();

        for (int i = 0; i < NUM_CARDS; i++) {
            fileNames[i] = "Playing Cards/" + fileNames[i];
            gameRenderManager.getStandardDeck()
                .add(new CardImage(CARD_IMAGE,
                    new Point(1150 + (i * 25) / NUM_CARDS,
                        315 + (i * 25) / NUM_CARDS),
                    0.6, null, i, cardDeck.get(i), CardPosition.DECK));
        }

        gameRenderManager.updateCardPositions();

        for (int i = gameRenderManager.getCardsInDeck().size() - 1; i >= 0;
            i--) {
            startGamePage.add(gameRenderManager.getCardsInDeck().get(i));
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

        gameRenderManager.updateCardPositions();

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

        // Set the default layering of each card
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
        double[] x = new double[NUM_CARDS];
        double[] y = new double[NUM_CARDS];

        double[] destX = new double[NUM_CARDS];
        double[] destY = new double[NUM_CARDS];

        double[] xDist = new double[NUM_CARDS];
        double[] yDist = new double[NUM_CARDS];

        // For every card, initialize the variables
        for (int i = 0; i < NUM_CARDS; i++) {

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
            for (int j = 0; j < NUM_CARDS; j++) {

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

        // Go through the stack in order
        while (layerStack.size() > 0) {
            CardImage cardImage = layerStack.remove(0);

            // Remove and add the CardImage. This essentially brings the card to
            // the top layer of the screen.
            startGamePage.remove(cardImage);
            startGamePage.add(cardImage);
        }

    }

    /**
     * Set a button to be clickable or not.
     * 
     * @param button
     * @param clickable
     */
    public void setButtonClickable(Text button, boolean clickable) {

        // If the button is not clickable, set the opacity to 0.3
        button.setClickable(clickable);
        button.setOpacity(clickable ? 1 : 0.3f);
    }

    /**
     * Move a peg on the screen a certain number of spaces in a smooth
     * animation.
     *
     * @param peg
     *            peg to move
     * @param spaces
     *            number of spaces to move
     */
    public void movePegGlideAnimation(int peg, int spaces) {

        // Input validation. Don't move if spaces = 0
        if (spaces == 0) {
            return;
        }

        // If the peg would move before the first spot, instead move it to the
        // first spot
        if (pegLocations[peg] + spaces < -1) {
            movePegGlideAnimation(peg, -1 - pegLocations[peg]);
            return;
        }

        // If the peg would move beyond the final spot, instead move it to the
        // final spot
        if (pegLocations[peg] + spaces > 120) {
            movePegGlideAnimation(peg, 120 - pegLocations[peg]);
            return;
        }

        // Declare variables
        Point initialPoint = pegRenderer[peg].getLocation();
        Point destPoint;

        // Set the destination location depending on if the spot it moves to is
        // an initial spot, end spot, or regular spot
        if (pegLocations[peg] + spaces == -1) {
            destPoint = initialSpots[1][peg].getLocation();
        } else if (pegLocations[peg] + spaces == 120) {
            destPoint = endSpot.getLocation();
        } else {
            destPoint =
                pegSpotLocations[pegLocations[peg] + spaces][peg].getLocation();
        }

        // x and y represent the current x and y position of the peg
        double x = initialPoint.getX();
        double y = initialPoint.getY();

        // destX and destY represent the destination x and y positions that the
        // peg will glide to
        double destX = destPoint.getX();
        double destY = destPoint.getY();

        // xDist and yDist are the distance between the initial and destination
        // x and y positions
        double xDist = destX - x;
        double yDist = destY - y;

        // Iterate 50 times
        for (int i = 0; i < 50; i++) {

            // Iterate the x and y variables
            x += xDist / 50;
            y += yDist / 50;

            // Set the x and y position on the board
            pegRenderer[peg].setX((int) x);
            pegRenderer[peg].setY((int) y);

            // Wait 10 milliseconds to ensure smooth animation
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Update the locations of the pegs
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
                    cardImage.setImageFileName(CARD_IMAGE);
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