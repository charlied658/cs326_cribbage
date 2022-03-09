package us.daveread.edu.graphics.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import us.daveread.edu.graphics.shape.Drawable;
import us.daveread.edu.graphics.shape.impl.Rectangle;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;
import us.daveread.edu.graphics.surface.WindowMode;

/**
 * Simple demonstration of using JGF and Swing components on a DrawingSurface.
 * @author readda
 */
public class SwingWidgets extends DrawingSurface {
  /**
   * Serial version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Text display Drawable from base JGF framework. Need to reference so mouse
   * clicks can be identified.
   * @see #drawableMouseClick(Drawable)
   */
  private Text buttonAddText;

  /**
   * Text area from base Swing framework.
   */
  private JTextArea area;

  /**
   * Place both JGF and Swing components on the DrawingSurface.
   */
  public SwingWidgets() {
    new MainFrame(this,
      "Demo of JGF and Swing Components", 400, 400,
      WindowMode.FIXED_SIZE);

    // Disable the FlowLayout (default layout for a JPanel, superclass of
    // DrawingSurface
    setLayout(null);

    // Create a Swing text area with predefine row/column sizing
    // Configured for auto-wrapping, and wrapping by word
    // Disabled for editing (e.g. display only)
    area = new JTextArea("", 15, 30);
    area.setLineWrap(true);
    area.setWrapStyleWord(true);
    area.setEditable(false);

    // Create a Swing scroll pane and place the text area within it
    // Place it at location 10, 20 with sizing based on the wrapped text area
    // Add it to the DrawingSurface
    JScrollPane scrollPane =
      new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(10, 20, area.getPreferredSize().width,
      area.getPreferredSize().height);
    add(scrollPane);

    // Create a Swing button
    // Place it at location 10, 300 with dimensions 120, 25
    // Configure the mouse click event to call the addText() method
    // Add it to the DrawingSurface
    JButton button = new JButton("Insert Text");
    button.setBounds(10, 300, 120, 25);
    button.addActionListener((e) -> {
      addText();
    });
    add(button);

    // Create a Swing button
    // Place it at location 150, 300 with dimensions 80, 25
    // Configure the mouse click event to call the closeWindow() method
    // Add it to the DrawingSurface
    button = new JButton("Exit");
    button.setBounds(150, 300, 80, 25);
    button.addActionListener((e) -> {
      closeWindow();
    });
    add(button);

    // Add a JGF rectangle drawable to the DrawingSurface
    // Create the Text drawable for the buttonAddText attribute
    // Add the text to the DrawingSurface
    add(new Rectangle(new Point(100, 350), new Dimension(100, 25), Color.black,
      Color.yellow));
    buttonAddText = new Text("Add Text", new Point(106, 371), 20, Color.black);
    add(buttonAddText);

    // Set text in the text area
    area.setText("Hello, World!\nAnother line of text\nAnd another");
  }

  @Override
  public void drawableMouseClick(Drawable e) {
    addMessage("Clicked: " + e);
    if (e == buttonAddText) {
      addText();
    }

  }

  /**
   * Add text to the text area.
   */
  private void addText() {
    area.setText(area.getText() + "\nClicked at " + new Date());
  }

  /**
   * Start the program.
   * @param args
   *          Command line arguments, not used
   */
  public static final void main(String[] args) {
    new SwingWidgets();
  }
}
