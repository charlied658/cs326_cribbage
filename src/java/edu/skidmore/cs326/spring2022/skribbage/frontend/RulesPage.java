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

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Rectangle;

public class RulesPage extends DrawingSurface implements ActionListener{
    int mainframeWidth = 650;
    int mainframeHeight = 1500;
    MainFrame mf;
    private static final Logger LOG;
    
    static {
        LOG = Logger.getLogger(RulesPage.class);
    }
    

/**
 * Sets up mainframe in which rules will be displayed.
 */
    public RulesPage(){
        mf = new MainFrame(this, "Rules Page", mainframeWidth, mainframeHeight, false);
        LOG.info("Calling setup method from the public RulesPage constructor");
        setup();
    }
    
    private void setup() {
        LOG.debug("Beginning the setup in setup method");
        mf.setLayout(null);
        Rectangle background = new Rectangle(new Point(0,0), new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        Text header = new Text("Skribbage Battle Royale Rules", new Point(20, 60), 40, Color.WHITE);
        JButton returnToMainMenu = new JButton("Return to Main Menu");
        returnToMainMenu.setBounds(20, 80, 140, 25);
        returnToMainMenu.setBackground(Color.LIGHT_GRAY);
        returnToMainMenu.addActionListener(this);
        
        

        /*
        JTextArea intro = new JTextArea("The objective in Cribbage is to be the first player to get 121 points. "
            + "The gameplay is divided into three distinct parts, The Deal, The Play and The Show.");
        
        String intro1 = "The objective of Skribbage Battle Royale is to be the first player to"; 
        String intro2 = "reach 121 points. The gameplay is divided intro 3 distinct parts: the";
        String intro3 = "Deal, the Play, and the Show.";
        String dealHeader = "The Deal";

        Color introColor = Color.WHITE;
        int introFontSize = 18;
        Text intro1Text = new Text(intro1, new Point(10, 110), introFontSize, introColor);
        Text intro2Text = new Text(intro2, new Point(10, 135), introFontSize, introColor);
        Text intro3Text = new Text(intro3, new Point(10, 160), introFontSize, introColor);
        Text dealHeaderText = new Text(dealHeader, new Point(250, 210), 30, Color.WHITE);

        add(background);
        add(header);
        add(intro1Text);
        add(intro2Text);
        add(intro3Text);
        add(dealHeaderText);
        */
        add(background);
        add(header);
        add(returnToMainMenu);
        
        
        /*
        String[] introSplit = intro.split(" ");
        int introFontSize = 18;
        int introXPosition = 10;
        int introYPosition = 100;
        for(int i = 0; i < introSplit.length; i++) {
            if(introXPosition + introSplit[i].length() * introFontSize > mainframeWidth - 10) {
                introXPosition = 10;
                introYPosition += 10;
            }
            add(new Text(introSplit[i], new Point(introXPosition, introYPosition), introFontSize, Color.WHITE));
            introXPosition += introSplit[i].length() * introFontSize;
        }
        */
    }
    /**
     * 
     * @param rec
     * @return
     */
    public boolean detectsMouseClick(Rectangle rec) {
        for (int i = 0; i < rec.getDimension().width; i++) {
            for (int j = 0; j < rec.getDimension().height; j++) {
                if(rec.mouseClickDetected(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 
     * @param rec
     */
    public void closeWindow(Rectangle rec) {
        mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        new RulesPage();
    }
    /**
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));

    }
}
