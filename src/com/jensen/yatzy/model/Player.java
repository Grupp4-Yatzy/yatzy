package com.jensen.yatzy.model;

public class Player {

    private String name;
    private Integer[] scoreList;

    public Player(String name) {
        this.name = name;
        scoreList = new Integer[Constant.COMBINATIONS.length];
    }

    public Integer[] getScoreList() {
        return scoreList;
    }

    public Integer getScore(int index) {
        return scoreList[index];
    }

    public String getName() {
        return name;
    }

    public void addScore(int score, int index) {
        scoreList[index] = score;
    }
    
    public void addSum() {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += scoreList[i];
		}
		addScore(sum, 6);
	}
    
    public void addBonus() {
		
	}
    
    public void addTotal() {
		
	}
    
    public int getFirstEmptyScoreIndex() {
		return 0;
	}

    public boolean isEmpty(int index) {
        if (scoreList[index] == null) {
            return true;
        }
        return false;
    }

}
