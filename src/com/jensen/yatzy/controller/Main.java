package com.jensen.yatzy.controller;

import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.NewGamePanel;
import com.jensen.yatzy.view.Window;

public class Main {

    /**
     * 
     * @param args
     */

	public static void main(String[] args) {
		Window window = new Window();
		new Controller(window);
<<<<<<< HEAD
=======
                window.setLocationRelativeTo(null);
>>>>>>> Roberto
                window.pack();
		window.setVisible(true);
                
	}

}
