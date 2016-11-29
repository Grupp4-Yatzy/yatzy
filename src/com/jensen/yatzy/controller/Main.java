package com.jensen.yatzy.controller;

import javax.swing.JFrame;

import youtube.Table;
import package view;

public class Main {

	public static void main(String[] args) {
		GameView window =new GameView();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setSize(800,700);
		window.setVisible(true);
	}

}
