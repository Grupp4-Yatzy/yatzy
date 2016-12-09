package com.jensen.yatzy.model;

public class Player {

	private String name;
	private Integer[] upperScore;
	private int upperSum;
	private boolean bonus;
	private Integer[] lowerScore;
	private Integer[] scoreList;
        
	public Player() {
            scoreList = new Integer[Constant.COMBINATIONS.length];
	}
        
        public Integer[] getScore(){
            return scoreList;
        }
        
        public void addScore(int score, int index){
            scoreList[index] = score;
        }
            
        public String getName(){
            return name;
        } 
        
        public boolean isEmpty(int index){
            if(scoreList[index]==null)
                return true;
            return false;
        }
	
}
