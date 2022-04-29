package edu.skidmore.cs326.spring2022.skribbage.frontend;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageProperty;
import us.daveread.edu.graphics.surface.DrawingSurface;

/**
 * A DrawingSurface for Skribbage screens. Adds additional GUI functionality
 * used by the game's UI.
 * 
 * @author readda
 */
public class SkribbageDrawingSurface extends DrawingSurface {

    /**
     * The serial verison id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(SkribbageDrawingSurface.class);
    }

    /**
     * Stores the current window position in the application's properties and
     * closes the window.
     */
    public void closeWindow() {
        LOG.info(
            "Save window position: "
                + SwingUtilities.getWindowAncestor(this).getLocationOnScreen().x
                + "," + SwingUtilities.getWindowAncestor(this)
                    .getLocationOnScreen().y);
        // Store the current X,Y location of the window
        SkribbageProperty.GUI_WINDOW_X
            .setPropertyValue(
                SwingUtilities.getWindowAncestor(this).getLocationOnScreen().x
                    + "");
        SkribbageProperty.GUI_WINDOW_Y
            .setPropertyValue(
                SwingUtilities.getWindowAncestor(this).getLocationOnScreen().y
                    + "");
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    /**
     * Set the window position to match that of the previously displayed window.
     */
    public void positionWindow() {
        try {
            int x = Integer
                .parseInt(SkribbageProperty.GUI_WINDOW_X.getPropertyValue("0"));
            int y = Integer
                .parseInt(SkribbageProperty.GUI_WINDOW_Y.getPropertyValue("0"));
            LOG.info(
                "Previous window position: " + x + "," + y);
            SwingUtilities.getWindowAncestor(this).setLocation(x, y);
        }
        catch (Throwable t) {
            LOG.warn("Unable to set window position", t);
        }
    }

}
