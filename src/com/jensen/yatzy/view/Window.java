package com.jensen.yatzy.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Window class is a JFrame that holds the currentPanel
 * @author Benjamin Rosman
 *
 */
public class Window extends JFrame {
    
    private JPanel currentPanel;
    
    /**
     * Constructor initialize super(), setTitle(),
     * setResizable() and setDefaultCloseOperation()
     */
    public Window() {
        super();
        this.setTitle("Yatzy");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        
    }
    
    /**
     * This method removes the panel if its not empty
     * and sets the currentPanel
     * @param newPanel
     */
    public void setCurrentPanel(JPanel newPanel) {
        if (this.currentPanel != null)
            this.remove(this.currentPanel);
        this.currentPanel = newPanel;
        this.add(this.currentPanel);
        this.repaint();
        this.pack();
    }
    
    /**
     *
     * @return the currentPanel
     */
    public JPanel getCurrentPanel() {
        return currentPanel;
    }
    
    /**
     * A window with an error message pop ups if the users input is incorrect
     * @param errorMessage
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
}
