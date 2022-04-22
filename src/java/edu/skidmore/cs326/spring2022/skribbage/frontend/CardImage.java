package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Point;

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
     * Unique ID of card, ranging from 0 to 51.
     */
    private int cardID;
    
    /**
     * Constructor method.
     * @param image
     * @param cardID
     */
    public CardImage(Image image, int cardID) {
        this.image = image;
        this.cardID = cardID;
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
    
}