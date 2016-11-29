package com.jensen.yatzy.view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame {

	private JPanel currentPanel;
	
	public Window() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Yatzy");
	}
	
	
	public void setCurrentPanel(JPanel newPanel) {
		if (this.currentPanel != null)
			this.remove(this.currentPanel);
		this.currentPanel = newPanel;
		this.add(this.currentPanel);
		this.repaint();
		this.pack();
	}
	
	public JPanel getCurrentPanel() {
		return currentPanel;
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
