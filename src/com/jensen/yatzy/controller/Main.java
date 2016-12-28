package com.jensen.yatzy.controller;

import com.jensen.yatzy.view.Window;

/**
 * Main class only use is to run the application
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public class Main {

  public static void main(String[] args) {
    Window window = new Window();
    new Controller(window);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);
  }
}
