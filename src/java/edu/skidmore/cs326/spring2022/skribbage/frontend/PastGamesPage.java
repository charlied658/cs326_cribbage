package edu.skidmore.cs326.spring2022.skribbage.frontend;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.*;
import java.util.*;

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
    private ArrayList<ActiveGame> gamesList = new ArrayList<>();
    
    private ActiveGame one = new ActiveGame(11, 7, 2021, "Jonah", "Sten", "CS326", true);
    private ActiveGame two = new ActiveGame(12, 31, 2021, "Chris Cornell", "Ben Shepherd", "Soundgarden", true);
    private ActiveGame three = new ActiveGame(1, 17, 2022, "Hugh Jass", "Tess T Culls", "", false);
    
    public PastGamesPage() {
        mf = new MainFrame(this, "Past Games Page", mainframeWidth, mainframeHeight, false);
        setup();
    }
    
    public void setup() {
        setLayout(null);
        Rectangle background = new Rectangle(new Point(0,0), new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        Text header = new Text("Load Previous Game", new Point(120, 70), 40, Color.WHITE);
        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.setBounds(20, 80, 120, 25);
        returnToMainMenu.setBackground(Color.LIGHT_GRAY);
        returnToMainMenu.addActionListener(this);
        
        JButton gameOne = new JButton(one.getDate());
        JButton gameTwo = new JButton(two.getDate());
        JButton gameThree = new JButton(three.getDate());
        
        gameOne.setBounds(220, 150, 200, 40);
        gameTwo.setBounds(220, 200, 200, 40);
        gameThree.setBounds(220, 250, 200, 40);
        
        add(gameOne);
        add(gameTwo);
        add(gameThree);
        
        
        
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
