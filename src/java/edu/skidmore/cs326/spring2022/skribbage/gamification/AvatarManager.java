package edu.skidmore.cs326.spring2022.skribbage.gamification;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.common.Player;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Avatar Manager class.
 * 
 * @author Charlie Davidson
 */
public class AvatarManager {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(AvatarManager.class);
    }

    /**
     * Arraylist of players.
     */
    private ArrayList<Player> players;

    /**
     * Arraylist of avatars.
     */
    private ArrayList<Avatar> avatars;

    /**
     * Map which maps players to their avatar.
     */
    private HashMap<Player, Avatar> avatarMap;

    /**
     * No argument constructor.
     */
    public AvatarManager() {
        LOG.info("Initializing avatar manager");
        players = new ArrayList<>();
        avatars = new ArrayList<>();
        avatarMap = new HashMap<Player, Avatar>();
    }

    /**
     * Avatar
     * Initializes the avatar mapping.
     */
    public void initializeAvatarMap() {
        LOG.info("Clearing player-avatar map");
        avatarMap = new HashMap<Player, Avatar>();
    }

    /**
     * Assigns an avatar to a player then adds it to the mapping.
     * 
     * @param username
     *            Username of player
     * @param imageUrl
     *            ImageUrl of avatar
     */
    public void assignPlayerAvatar(String username, String imageUrl) {
        Player player = getPlayer(username);
        Avatar avatar = getAvatar(imageUrl);

        if (player == null) {
            createPlayer(username);
            player = getPlayer(username);
        }

        if (avatar == null) {
            createAvatar(imageUrl);
            avatar = getAvatar(imageUrl);
        }

        player.setAvatar(avatar);
        avatarMap.put(player, avatar);
        LOG.info("Assigned avatar " + avatar.getImageUrl() + " to player "
            + player.getUsername());
    }

    /**
     * Removes a player-avatar mapping.
     * 
     * @param username
     *            Username of player
     */
    public void removePlayerAvatar(String username) {
        Player player = getPlayer(username);
        if (player != null) {
            player.setAvatar(null);
        }
        if (avatarMap.containsKey(player)) {
            avatarMap.remove(player);
        }
        LOG.info("Removed avatar from player " + player.getUsername());
    }

    /**
     * Create a new player.
     * 
     * @param username
     *            Player username
     */
    public void createPlayer(String username) {
        Player player = new Player();
        player.setUsername(username);
        players.add(player);
    }

    /**
     * Create a new avatar.
     * 
     * @param imageUrl
     *            Avatar image url
     */
    public void createAvatar(String imageUrl) {
        Avatar avatar = new Avatar(imageUrl);
        avatars.add(avatar);
    }

    /**
     * Get player with specified username.
     * 
     * @param username
     *            Username of player
     * @return Player
     */
    private Player getPlayer(String username) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getUsername().equals(username)) {
                return players.get(i);
            }
        }
        return null;
    }

    /**
     * Get avatar with specified imageUrl.
     * 
     * @param imageUrl
     *            ImageUrl of avatar
     * @return Avatar
     */
    private Avatar getAvatar(String imageUrl) {
        for (int i = 0; i < players.size(); i++) {
            if (avatars.get(i).getImageUrl().equals(imageUrl)) {
                return avatars.get(i);
            }
        }
        return null;
    }

    /**
     * Get avatar associated with given player.
     * 
     * @param username
     *            Username of player
     * @return Image url of avatar
     */
    public String getAvatarFromMap(String username) {

        Player player = getPlayer(username);
        if (avatarMap.get(player) != null) {
            return avatarMap.get(player).getImageUrl();
        } else {
            return null;
        }
    }

    /**
     * Check if player with given username exists.
     * 
     * @param username
     *            Username of player
     * @return boolean
     */
    public boolean playerExists(String username) {
        return getPlayer(username) != null;
    }

    /**
     * Check if plaer with given imageUrl exists.
     * 
     * @param imageUrl
     *            ImageUrl of avatar
     * @return boolean
     */
    public boolean avatarExists(String imageUrl) {
        return getAvatar(imageUrl) != null;
    }

    /**
     * Checks if the map is empty.
     * 
     * @return boolean
     */
    public boolean isMapEmpty() {
        return avatarMap.isEmpty();
    }

}
