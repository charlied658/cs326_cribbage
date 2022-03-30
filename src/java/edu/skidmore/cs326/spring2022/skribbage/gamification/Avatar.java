package edu.skidmore.cs326.spring2022.skribbage.gamification;

/**
 * Generic Avatar class.
 * 
 * @author Charlie Davidson
 */
public class Avatar {

    /**
     * URL for image.
     */
    private String imageUrl;

    /**
     * Avatar which can be attached to a specific player.
     * 
     * @param imageUrl
     *            URL of the image used
     */
    public Avatar(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Get Image URL.
     * 
     * @return image URL
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Set Image URL.
     * 
     * @param imageUrl
     *            image URL
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Check if avatars are equal.
     * 
     * @param avatar
     *            Other avatar
     * @return boolean
     */
    public boolean equals(Avatar avatar) {
        return this.getImageUrl().equals(avatar.getImageUrl());
    }
}
