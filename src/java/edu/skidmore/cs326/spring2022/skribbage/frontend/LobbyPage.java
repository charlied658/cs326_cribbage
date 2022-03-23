package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
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
 * The "lobby," or the page that the player(s) see immediately before starting a new game.
 * @author Jonah Marcus
 * Last Update: March 23, 2022
 *
 */

public class LobbyPage extends DrawingSurface implements ActionListener{
    private String loggedInPlayer1;
    private String loggedInPlayer2;
    private String loggedInPlayer3;
    private int mainframeWidth = 650;
    private int mainframeHeight = 1500;
    private MainFrame mf;
    private Text returnToMainMenu;
    private Circle player1Ready;
    private Circle player2Ready;
    private Circle player3Ready;
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    
    static {
        LOG = Logger.getLogger(PastGamesPage.class);
    }
    
    public LobbyPage() {
        mf = new MainFrame(this, "Past Games Page", mainframeWidth,
            mainframeHeight, false);
        setup();
    }
    
    public void setup() {
        LOG.trace("LobbyPage setup");
        setLayout(null);
        Rectangle background = new Rectangle(new Point(0, 0),
            new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        
        returnToMainMenu = new Text("Main Menu",
            new Point(20, 40), 25, Color.WHITE, Color.CYAN);
        
        Text player1LoginSection = new Text("Walter \"Fuse\" Fitzroy", 
            new Point(35, 80), 16, Color.WHITE);
        Text player2LoginSection = new Text("Elliot \"Mirage\" Witt", 
            new Point(35, 100), 16, Color.WHITE);
        Text player3LoginSection = new Text("[REDACTED] \"Crypto\" [REDACTED]", 
            new Point(35, 120), 16, Color.WHITE);
        
        player1Ready = new Circle(new Point(10, 67), 15, Color.RED, Color.RED);
        player2Ready = new Circle(new Point(10, 87), 15, Color.RED, Color.RED);
        player3Ready = new Circle(new Point(10, 107), 15, Color.RED, Color.RED);
        
        
        add(background);
        add(returnToMainMenu);
        add(player1LoginSection);
        add(player2LoginSection);
        add(player3LoginSection);
        add(player1Ready);
        add(player2Ready);
        add(player3Ready);
    }
    
    private void setReadyButtonColor(Circle c) {
        if (c.getBorderColor().equals(Color.RED)) {
            c.setBorderColor(Color.GREEN);
            c.setFillColor(Color.GREEN);
        }
        else {
            c.setBorderColor(Color.RED);
            c.setFillColor(Color.RED);
        }
    }
    
    public void drawableMouseClick(Drawable e) {
        LOG.trace("DrawableMosuceClick in HomeScreen.java");
        if (e == returnToMainMenu) {
            new HomeScreen();
            mf.dispose();
        }
        else if (e == player1Ready) {
            setReadyButtonColor(player1Ready);
        }
        else if (e == player2Ready) {
            setReadyButtonColor(player2Ready);
        }
        else if (e == player3Ready) {
            setReadyButtonColor(player3Ready);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public static void main(String[] args) {
        new LobbyPage();
    }
}
