package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Point;
import java.util.Objects;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import us.daveread.edu.graphics.shape.impl.Image;

/**
 * Card Image object to be rendered on the screen.
 * @author Charlie Davidson
 *         Code review by Jonah Marcus on 22 April 2022
 *
 */
public class CardImage {
    
    /**
     * Image of card.
     */
    private Image image;
    
    /**
     * Point to which card will glide on the screen.
     */
    private Point destLocation;
    
    /**
     * Card object which is represented by the CardImage.
     */
    private Card card;
    
    /**
     * Unique ID of card, ranging from 0 to 51.
     */
    private int cardID;
    
    /**
     * Stores whether the card face is showing or not.
     */
    private boolean showing;

    /**
     * Where the card is on the board (not pixel location)
     * corresponds to ArrayList of other cards in the same position.
     */
    private CardPosition cardPosition;
    
    /**
     * Constructor method.
     * @param image
     * @param cardID
     * @param card
     */
    public CardImage(Image image, int cardID, Card card) {
        this.image = image;
        this.cardID = cardID;
        this.setCard(card);
        this.showing = false;
    }
    
    /**
     * Get the image.
     * @return image
     */
    public Image getImage() {
        return this.image;
    }
    
    /**
     * Get the destination location.
     * @return destination
     */
    public Point getDestLocation() {
        return this.destLocation;
    }
    
    /**
     * Get the card ID.
     * @return cardID
     */
    public int getCardID() {
        return this.cardID;
    }
    
    /**
     * Get whether the card is showing.
     * @return boolean
     */
    public boolean isShowing() {
        return this.showing;
    }
    
    /**
     * Set the image.
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    /**
     * Set the destination location.
     * @param destLocation
     */
    public void setDestLocation(Point destLocation) {
        this.destLocation = destLocation;
    }
    
    /**
     * Set the card ID.
     * @param cardID
     */
    public void setCardID(int cardID) {
        this.cardID = cardID;
    }
    
    /**
     * Set whether the card is showing.
     * @param showing
     */
    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    /**
     * Move card to a different position.
     * @param cardPosition new position.
     */
    public void setCardPosition(
        CardPosition cardPosition) {
        this.cardPosition = cardPosition;
    }

    /**
     * Get current card position.
     * @return CardPosition type.
     */
    public CardPosition getCardPosition() {
        return cardPosition;
    }

    /**
     * Get card object.
     * @return card
     */
    public Card getCard() {
        return card;
    }

    /**
     * Set card object.
     * @param card
     */
    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardImage cardImage = (CardImage) o;
        return cardID == cardImage.cardID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardID);
    }
}