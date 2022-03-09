package edu.skidmore.cs326.spring2022.skribbage.frontend.demo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.*;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.utilities.Utility;
import us.daveread.edu.graphics.shape.impl.Rectangle;

public class PastGamesPage extends DrawingSurface implements ActionListener {
    private int mainframeWidth = 650;
    private int mainframeHeight = 1500;
    private MainFrame mf;
    private JButton returnToMainMenu;
    
    public PastGamesPage() {
        mf = new MainFrame(this, "Past Games Page", mainframeWidth, mainframeHeight, false);
        setup();
    }
    
    public void setup() {
        mf.setLayout(null);
        Rectangle background = new Rectangle(new Point(0,0), new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        Text header = new Text("Load Previous Game", new Point(120, 70), 40, Color.WHITE);
        returnToMainMenu = new JButton("Return to Main Menu");
        returnToMainMenu.setBounds(20, 80, 140, 25);
        returnToMainMenu.setBackground(Color.LIGHT_GRAY);
        returnToMainMenu.addActionListener(this);
        
        add(background);
        add(header);
        add(returnToMainMenu);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
        if (e.getSource().equals(returnToMainMenu)) {
            mf.dispose();
            RulesPage rules = new RulesPage();
            rules.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new PastGamesPage();
    }
}
