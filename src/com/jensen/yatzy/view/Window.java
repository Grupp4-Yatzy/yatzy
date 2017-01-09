package com.jensen.yatzy.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Window class is a JFrame that holds the currentPanel
 *
 * @author Benjamin Rosman
 * @see JFrame
 */
public class Window extends JFrame {

  private JPanel currentPanel;

  /**
   * Creates a new window with the title "Yatzy" and the default close operation set to exit on
   * close.
   */
  public Window() {
    super();
    this.setTitle("Yatzy");
    //this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //this.setLocationRelativeTo(null);

  }

  /**
   * This method removes the current panel, sets the currentPanel to newPanel, repaints and packs.
   *
   * @param newPanel The new panel to be displayed.
   */
  public void setCurrentPanel(JPanel newPanel) {
    if (this.currentPanel != null) {
      this.remove(this.currentPanel);
    }
    this.currentPanel = newPanel;
    this.add(this.currentPanel);
    this.repaint();
    this.pack();
  }

  /**
   * Returns the current panel, which displays the content of the window.
   *
   * @return The current panel.
   */
  public JPanel getCurrentPanel() {
    return currentPanel;
  }

  /**
   * Displays a pop up containing a error message.
   *
   * @param errorMessage The message to be displayed.
   */
  public void displayErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(this, errorMessage);
  }

}
