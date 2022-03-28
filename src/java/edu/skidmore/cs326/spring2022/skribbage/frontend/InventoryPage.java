package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
import java.awt.Dimension;
//import java.awt.Graphics2D;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.util.*;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Circle;

/***
 * The page that shows the player's inventory. Players can 
 * send and receive tokens and items to and from other players.
 * @author Jonah Marcus
 *         Last Update: March 27, 2022
 *         Last Edited by Jonah Marcus
 */
public class InventoryPage extends DrawingSurface implements ActionListener {
    
    /**
     * mf - Holds reference to the window.
     */
    private MainFrame mf;
    
    /**
     * STACKSIZE - Constant that holds the maximum size any
     * given stack of items can be.
     * Ex: In Minecraft, a stack of cannot exceed 64 items.
     */
    private int stackSize;
    
    /**
     * mainframeHeight - int variable to hold main frame height.
     */
    private int mainframeHeight = 750;
    
    /**
     * mainframeWidth - int variable to hold main frame width.
     */
    private int mainframeWidth = 750;
    
    /**
     * closeWindow - Text object that closes the window when clicked.
     */
    private Text closeWindow;
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PastGamesPage.class);
    }
    
    /**
     * InventoryPage constructor.
     */
    public InventoryPage() {
        LOG.trace("Entered InventoryPage Constructor.");
        mf = new MainFrame(this, "Inventory", mainframeWidth,
            mainframeHeight, false);
        setup(); 
    }
    
    /**
     * setup method - sets up the window.
     */
    private void setup() {
        LOG.trace("Entered setup (InventoryPage)");
        setLayout(null);
        closeWindow = new Text("Close",
            new Point(20, 40), 25, Color.BLUE, Color.BLACK);
    
        add(closeWindow);
    }
    
    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        LOG.trace("Entered main method");
        new InventoryPage();
    }
    
    @Override
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in InventoryPage.java");
        if (e == closeWindow) {
            closeWindow.setBorderColor(Color.CYAN);
            Utility.pause(100);
            closeWindow.setBorderColor(Color.BLACK);
            mf.dispose();
        }
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
