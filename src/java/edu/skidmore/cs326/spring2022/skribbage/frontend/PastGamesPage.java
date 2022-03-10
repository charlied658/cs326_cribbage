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

/***
 * This is the page that allows the player to load old games.
 * 
 * @author Jonah Marcus
 *         Last Update: March 10 2022
 */

public class PastGamesPage extends DrawingSurface implements ActionListener {
    private int mainframeWidth = 650;

    private int mainframeHeight = 1500;

    private MainFrame mf;

    private JButton returnToMainMenu;

    private ArrayList<ActiveGame> allGames = new ArrayList<>();

    private ArrayList<ActiveGame> completeGames = new ArrayList<>();

    private ArrayList<ActiveGame> incompleteGames = new ArrayList<>();

    // Examples of games that show proof of concept
    private ActiveGame one =
        new ActiveGame(11, 7, 2021, "Jonah", "Sten", "CS326", true);

    private ActiveGame two = new ActiveGame(12, 31, 2021, "Chris Cornell",
        "Ben Shepherd", "Soundgarden", true);

    private ActiveGame three =
        new ActiveGame(1, 17, 2022, "Hugh Jass", "Tess T Culls", "", false);

    public PastGamesPage() {
        mf = new MainFrame(this, "Past Games Page", mainframeWidth,
            mainframeHeight, false);
        addGamesToList();
        setup();
    }

    public void addGamesToList() {
        allGames.add(one);
        allGames.add(two);
        allGames.add(three);
    }

    public void setup() {
        setLayout(null);
        Rectangle background = new Rectangle(new Point(0, 0),
            new Dimension(mainframeWidth, mainframeHeight),
            Color.DARK_GRAY, Color.DARK_GRAY);
        Text header =
            new Text("Load Previous Game", new Point(120, 70), 40, Color.WHITE);
        returnToMainMenu = new JButton("Main Menu");
        returnToMainMenu.setBounds(20, 80, 120, 25);
        returnToMainMenu.setBackground(Color.LIGHT_GRAY);
        returnToMainMenu.addActionListener(this);

        add(background);
        add(header);
        add(returnToMainMenu);

        // There is a boolean field in each ActiveGame class that shows whether
        // or not
        // a game is completed. This will place each game into the appropriate
        // ArrayList
        // for later organization. For now, this just adds the test cases. In
        // the future,
        // there will be a list of all active games that is a bit more
        // sophisticated.
        for (int i = 0; i < allGames.size(); i++) {
            ActiveGame game = allGames.get(i);
            if (game.isCompleted())
                completeGames.add(game);
            else
                incompleteGames.add(game);
        }

        // For now, all of the incomplete games will be red, and all
        // of the complete games will be green This can be changed
        // to look a bit nicer later, but again, this is just a proof
        // of concept. Additionally, as the client requested, all
        // of the incomplete games will be above the games that
        // have been completed.
        int buttonYPosition = 150;
        for (int i = 0; i < incompleteGames.size(); i++) {
            String[] gameInfo = incompleteGames.get(i).getGameInfo();

            String timestamp = gameInfo[0];
            String name = gameInfo[1];
            String player1 = gameInfo[2];
            String player2 = gameInfo[3];
            JButton gameButton = new JButton(
                name + "   " + timestamp + "   " + player1 + "   " + player2);
            gameButton.setBounds(50, buttonYPosition, 550, 40);
            buttonYPosition += 50;
            gameButton.setBackground(Color.RED);
            add(gameButton);

        }
        for (int i = 0; i < completeGames.size(); i++) {
            String[] gameInfo = completeGames.get(i).getGameInfo();

            String timestamp = gameInfo[0];
            String name = gameInfo[1];
            String player1 = gameInfo[2];
            String player2 = gameInfo[3];
            JButton gameButton = new JButton(
                name + "   " + timestamp + "   " + player1 + "   " + player2);
            gameButton.setBounds(50, buttonYPosition, 550, 40);
            buttonYPosition += 50;
            gameButton.setBackground(Color.GREEN);
            add(gameButton);

        }

    }

    // This is a placeholder. In the final product, the "Main Menu" button
    // will, as the label suggests, take the user back to the main menu.
    @Override
    public void actionPerformed(ActionEvent e) {
        // mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
        if (e.getSource().equals(returnToMainMenu)) {
            mf.dispose();
            RulesPage rules = new RulesPage();
            rules.setVisible(true);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new PastGamesPage();
    }
}
