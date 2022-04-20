package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
//import java.util.Random;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Board;
import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Spot;
import edu.skidmore.cs326.spring2022.skribbage.common.SpotType;
import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.VisibleObject;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DialogPosition;
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
     * navPage - NavigationPage window.
     */
    @SuppressWarnings("unused")
    private NavigationPage navPage;

    /**
     * spots - Array of spots.
     */
    @SuppressWarnings("unused")
    private Spot[][] spots;

    /**
     * startGamePage - Mainframe window.
     */
    private MainFrame startGamePage;

    /**
     * gameBoard - Image to hold the game board.
     */
    @SuppressWarnings("unused")
    private Image boardImage;

    /**
     * beginGame - Text variable to hold the start game button.
     */
    private Text beginGame;

    /**
     * cardDeck - Image to hold card deck.
     */
    @SuppressWarnings("unused")
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
     * Buttons to move players. Temp proof of concept.
     */
    private Text[] movePlayers;

    /**
     * How many spaces each player moves.
     */
    private int moveAmt;

    /**
     * Store whether the game currently running.
     */
    private boolean running;

    /**
     * State of the cards animation.
     */
    private boolean cardState;

    /**
     * Holds the cards of the deck as images.
     */
    private Image[] cards;

    /**
     * returnHome -Text variable to represent back button.
     */
    private Text returnHome;

    /**
     * PageManager instance for page management.
     */
    private PageManager pageManager;

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
        pageManager = PageManager.getInstance();
        LOG.trace("StartGamePage constructor");
        startGamePage = new MainFrame(
            this, "Start Game Page", 1400, 900, false);
        setup();
    }

    /**
     * setup method.
     */
    public void setup() {
        LOG.trace("setup method in StartGamePage.java");

        board = new Rectangle(new Point(35, 50), new Dimension(350, 700),
            Color.black, new Color(180, 110, 30));
        gameArea = new Rectangle(new Point(25, 40),
            new Dimension(1350, 800), Color.black, new Color(43, 176, 19));
        beginGame = new Text("Start", new Point(35, 880), 20, Color.black,
            Color.blue);
        player1Score = new Text("temp player 1:", new Point(35, 790), 20,
            Color.black);
        player2Score = new Text("temp player 2: ", new Point(35, 810), 20,
            Color.black);
        returnHome = new Text("Return to home", new Point(10, 25), 20,
            Color.black, Color.blue);
        movePlayers = new Text[5];
        movePlayers[0] = new Text("Move P1", new Point(100, 880), 20,
            Color.black, Color.blue);
        movePlayers[1] = new Text("Move P2", new Point(200, 880), 20,
            Color.black, Color.blue);
        movePlayers[2] = new Text("Move P3", new Point(300, 880), 20,
            Color.black, Color.blue);
        movePlayers[3] = new Text("Set move amt.", new Point(400, 880), 20,
            Color.black, Color.blue);
        movePlayers[4] = new Text("Reset", new Point(560, 880), 20,
            Color.black, Color.blue);
        cards = new Image[20];
        for (int i = 0; i < 20; i++) {
            cards[i] = new Image("card.png",
                new Point(700 + 2 * i, 315 + 2 * i), .6, null);
        }
        add(gameArea);
        add(beginGame);
        add(player2Score);
        add(player1Score);
        add(returnHome);
        add(board);
        add(movePlayers[0]);
        add(movePlayers[1]);
        add(movePlayers[2]);
        add(movePlayers[3]);
        add(movePlayers[4]);
        for (int i = 19; i >= 0; i--) {
            add(cards[i]);
        }
        moveAmt = 5;
        running = false;
        cardState = true;
        createGrid();
        assignSpots();
        renderSpots();
    }

    /**
     * createGrid method creates the board grid.
     */
    public void createGrid() {
        LOG.trace("createGrid method in StartGamePage.java");
        BoardManager.getInstance().getBoard().initializeGrid();
    }

    /**
     * assignSpots method assigns all the special spots.
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
                beginGame.setMessage("Start");
            }
        }
    }

    /**
     * Animate the cards.
     */
    public void moveCards() {

        double[] x = new double[20];
        double[] y = new double[20];

        double[] destX = new double[20];
        double[] destY = new double[20];

        double[] xDist = new double[20];
        double[] yDist = new double[20];

        for (int i = 0; i < 20; i++) {

            Point initialPoint = cards[i].getLocation();
            Point destPoint;

            if (cardState) {
                destPoint = new Point(600 + 15 * i, 330);
            } else {
                destPoint = new Point(700 + 2 * i, 315 + 2 * i);
            }

            x[i] = initialPoint.getX();
            y[i] = initialPoint.getY();

            destX[i] = destPoint.getX();
            destY[i] = destPoint.getY();

            xDist[i] = destX[i] - x[i];
            yDist[i] = destY[i] - y[i];
        }

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                x[j] += xDist[j] / 50;
                y[j] += yDist[j] / 50;

                cards[j].setX((int) x[j]);
                cards[j].setY((int) y[j]);
            }
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        cardState = !cardState;
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

        // spaces");

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

        // Glide to new position smoothly
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

        // pegRenderer[peg].setLocation(destPoint);

        pegLocations[peg] = pegLocations[peg] + spaces;

    }

    /**
     * Animation to select a card.
     * 
     * @param index
     *            index of selected card
     */
    public void selectCard(int index) {
        double[] x = new double[20];
        double[] y = new double[20];

        double[] destX = new double[20];
        double[] destY = new double[20];

        double[] xDist = new double[20];
        double[] yDist = new double[20];

        for (int i = 0; i < 20; i++) {

            Point initialPoint = cards[i].getLocation();
            Point destPoint;

            if (i == index) {
                destPoint = new Point(600 + 15 * i, 300);
            } else {
                destPoint = new Point(600 + 15 * i, 330);
            }

            x[i] = initialPoint.getX();
            y[i] = initialPoint.getY();

            destX[i] = destPoint.getX();
            destY[i] = destPoint.getY();

            xDist[i] = destX[i] - x[i];
            yDist[i] = destY[i] - y[i];
        }

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                x[j] += xDist[j] / 50;
                y[j] += yDist[j] / 50;

                cards[j].setX((int) x[j]);
                cards[j].setY((int) y[j]);
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
     * Set which buttons are clickable to avoid button conflicts.
     * 
     * @param clickable
     */
    public void setClickable(boolean[] clickable) {

        beginGame.setOpacity(clickable[0] ? 1 : 0.5f);
        beginGame.setClickable(clickable[0]);

        for (int i = 0; i < 5; i++) {
            movePlayers[i].setOpacity(clickable[i + 1] ? 1 : 0.5f);
            movePlayers[i].setClickable(clickable[i + 1]);
        }
    }

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("drawableMouseClick method in StartGamepage.java");

        if (e == beginGame) {
            setClickable(
                new boolean[] { true, false, false, false, false, false });
            if (!running) {
                LOG.trace("Going to start the game");
                // start game
                running = true;
                beginGame.setMessage("Stop");
                animatePegs();
                setClickable(
                    new boolean[] { true, true, true, true, true, true });

            } else {
                // stop game
                running = false;
                beginGame.setMessage("Start");
                setClickable(
                    new boolean[] { false, false, false, false, false, false });
            }

        } else if (e == returnHome) {
            navPage = (NavigationPage) pageManager
                .createPage(PageType.NAVIGATION_PAGE);
            // NavigationPageManager.getInstance().getNavPage();
            closeWindow();
        } else if (e == movePlayers[0]) {
            setClickable(
                new boolean[] { false, false, false, false, false, false });
            movePeg(0, moveAmt);
            setClickable(new boolean[] { true, true, true, true, true, true });
        } else if (e == movePlayers[1]) {
            setClickable(
                new boolean[] { false, false, false, false, false, false });
            movePeg(1, moveAmt);
            setClickable(new boolean[] { true, true, true, true, true, true });
        } else if (e == movePlayers[2]) {
            setClickable(
                new boolean[] { false, false, false, false, false, false });
            movePeg(2, moveAmt);
            setClickable(new boolean[] { true, true, true, true, true, true });
        } else if (e == movePlayers[3]) {
            setClickable(
                new boolean[] { false, false, false, false, false, false });

            int userInput;
            try {
                userInput = Integer.parseInt(getUserInput("Move Amount",
                    "How many spaces? (Current = " + moveAmt + ")",
                    DialogPosition.CENTER_ALL));
            }
            catch (Exception e1) {
                setClickable(
                    new boolean[] { true, true, true, true, true, true });
                return;
            }

            if (userInput <= 0) {
                moveAmt = 1;
            } else {
                moveAmt = userInput;
            }

            setClickable(new boolean[] { true, true, true, true, true, true });
        } else if (e == movePlayers[4]) {
            setClickable(
                new boolean[] { false, false, false, false, false, false });
            movePeg(0, -1 - pegLocations[0]);
            movePeg(1, -1 - pegLocations[1]);
            movePeg(2, -1 - pegLocations[2]);
            setClickable(new boolean[] { true, true, true, true, true, true });
            if (!cardState) {
                moveCards();
            }
        }
        for (int i = 0; i < 20; i++) {
            if (e == cards[i]) {
                for (int j = 0; j < 20; j++) {
                    cards[j].setClickable(false);
                }
                if (i == 0 && cardState) {
                    moveCards();
                } else if (!cardState) {
                    selectCard(i);
                }
                for (int j = 0; j < 20; j++) {
                    cards[j].setClickable(true);
                }
            }
        }
    }

    /**
     * Close window method from Page interface.
     */
    public void closeWindow() {
        startGamePage.dispose();
    }

}
