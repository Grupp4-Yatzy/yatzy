package com.jensen.yatzy.controller;

import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

public class Main {

    public static final String[] combinations = {"Ettor", "Tvåor","Treor","Fyror","Femmor","Sexor",
                            					"Summa","Bonus","Ett par","Två par","Tretal","Fyrtal",
                            					"L.Stege","S.Stege","Kåk","Chans","¨Yatzy","Totalt"};
    
    
	public static void main(String[] args) {
		Window window = new Window();
                GameView game = new GameView();
                window.setCurrentPanel(game);
                window.setVisible(true);
                System.out.println(game.getHeight());
                
                String[] names = {"Benjamin", "Robin", "Roberto", "Kami"};
                game.setPlayerNames(names);
                game.setCombinations(combinations);
                Integer[][] data = new Integer[combinations.length][names.length];
                game.setTable(data, names);
                window.pack();
	}

}
