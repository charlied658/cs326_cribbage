package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import edu.skidmore.cs326.spring2022.skribbage.common.BoardManager;
import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.GameController;
import edu.skidmore.cs326.spring2022.skribbage.common.GameState;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerClickStartGameEvent;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
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
 *         Code review by Jonah Marcus on 17 April 2022
 */
@SuppressWarnings("serial")
public class StartGamePage extends DrawingSurface implements Page {

    /**
     * startGamePage - Mainframe window.
     */
    private MainFrame startGamePage;

    /**
     * GameManager instance to manage the game.
     */
    private GameManager gameManager;

    /**
     * PageManager instance for page management.
     */
    private PageManager pageManager;

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
     * Toggles the screen being resized.
     */
    private boolean resizeWindow;

    /**
     * Event factory instance for handling events.
     */
    private final EventFactory eventFactory;

    /**
     * Game Render Manager instance.
     */
    private final GameRenderManager gameRenderManager;

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
        eventFactory = EventFactory.getInstance();
        AnimationManager.getInstance().setStartGamePage(this);
        AnimationManager.getInstance().setGameManager(gameManager);
        GameController.getInstance().setCurrentGameState(GameState.START_GAME);
        gameRenderManager = GameRenderManager.getInstance();
        gameRenderManager
            .setGameManager(AnimationManager.getInstance().getGameManager());

        LOG.trace("StartGamePage constructor");
        startGamePage = new MainFrame(
            this, "Start Game Page", 1400, 900, false);
        setup();
    }
    
    /**
     * get player points.
     * @return points.
     */
    public int getPlayerPoints() {
        return playerPoints;
    }
    
    /**
     * get computer points.
     * @return points.
     */
    public int getComputerPoints() {
        return computerPoints;
    }
    
    /**
     * addPlayerPoints.
     * @param pointsToAdd
     */
    public void addPlayerPoints(int pointsToAdd) {
        playerPoints += pointsToAdd;
    }
    
    /**
     * addComputerPoints.
     * @param pointsToAdd
     */
    public void addComputerPoints(int pointsToAdd) {
        computerPoints += pointsToAdd;
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

        add(arrows[0]);
        add(arrows[1]);
        add(arrows[2]);

        moveAmt = 5;
        running = false;
        resizeWindow = false;

        startButton.setClickable(false);
        startButton.setOpacity(0.5f);
        
        createGrid();
        assignSpots();
        AnimationManager.getInstance().renderSpots();
        AnimationManager.getInstance().createCards();
        
        startButton.setClickable(true);
        startButton.setOpacity(1);
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

    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("drawableMouseClick method in StartGamepage.java");

        if (e == startButton) {
            LOG.trace("Clicked start button");
            remove(startButton);
            Player newGamePlayer = new Player(pageManager.getLoggedInUser());
            PlayerClickStartGameEvent event =
                (PlayerClickStartGameEvent) eventFactory
                    .createEvent(EventType.PLAYER_CLICK_START_GAME,
                        this, newGamePlayer);
            eventFactory.fireEvent(event);
            GameRenderManager.getInstance().setActivePlayer(newGamePlayer);

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
            AnimationManager.getInstance().resizeWindow();
            AnimationManager.getInstance().moveCardsToStandardPositions(10);
        }

        // Gets the card that has been clicked on
//        if (e instanceof CardImage) {
//
//            CardImage cardImage = (CardImage) e;
//            LOG.debug("Clicked on a card image " + cardImage);
//
//            CardPosition currentPosition = cardImage.getCardPosition();
//
//            switch (currentPosition) {
//                case DECK:
//                    eventFactory.createEvent(
//                        EventType.PLAYER_CLICK_DECK, this,
//                        gameRenderManager.getActivePlayer());
//                    break;
//                case PLAYER_HAND:
//                    eventFactory.createEvent(EventType.PLAYER_PLAY_CARD, this,
//                        gameRenderManager.getActivePlayer(), cardImage);
//                default:
//                    break;
//
//            }
//
//        }

        // Manage what happens when you click a card
        GameRenderManager.getInstance().manageClickedCard(e);

    }
    
    /**
     * method to update points for computer and player.
     */
    public void updatePoints() {
        
    }

    /**
     * Close window method from Page interface.
     */
    public void closeWindow() {
        startGamePage.dispose();
    }

}
