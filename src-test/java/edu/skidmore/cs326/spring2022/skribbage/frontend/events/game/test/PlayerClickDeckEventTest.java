package edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.apache.log4j.Logger;
import org.junit.Before;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.CardImage;
import edu.skidmore.cs326.spring2022.skribbage.frontend.CardPosition;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerClickDeckEvent;

/**
 * @author Sten Leinasaar
 */
public class PlayerClickDeckEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private PlayerClickDeckEvent testInstance;
    /**
     * User test instance.
     */
    private User userInstance;

    /**
     * Player instance to test with.
     */
    private Player player;
    /**
     * CardImage for testing.
     */
    private CardImage cardImage;

    /**
     * File path for the default card image.
     */
    private static final String CARD_IMAGE = "card.png";

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(PlayerClickDeckEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        userInstance = new User("sleinasa@skidmore.edu", "sleinasa",
            UserRole.UNAUTHORIZED);
        cardImage = new CardImage(CARD_IMAGE,
            new Point(0, 0), 0.6, null, 5, new Card(Rank.ACE, Suit.CLUBS),
            CardPosition.DECK);
        player = new Player(userInstance);
        testInstance = new PlayerClickDeckEvent(this, player, cardImage, 5);
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testPlayerClickDeckEvent() {
        LOG.trace("Testing the constructor");
        assertNotNull(testInstance);
        LOG.trace("constructor test completed");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventType() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(), EventType.PLAYER_CLICK_DECK);
        LOG.trace("Completed testing the getEventName method");
    }
    /**
     * Method to test get cardImage.
     */
    @Test
    public void testCardImage() {
        LOG.info("Test getCardImage method");
        assertEquals(testInstance.getCardImage(), cardImage);
        LOG.trace(" getCardImage method tested");
    }
    /**
     * Method to test getClickedCardIndex.
     */
    @Test
    public void testGetClickedCardIndex() {
        LOG.info("Get the index");
        assertEquals(testInstance.getClickedCardIndex(), 5);
        LOG.trace("Get index finished");
    }

}
