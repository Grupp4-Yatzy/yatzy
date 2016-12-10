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
		for (int i = 0; i < Constant.INDEX_OF_SUM; i++) {
			sum += scoreList[i];
		}
		addScore(sum, Constant.INDEX_OF_SUM);
	}
    
    public void addBonus() {
		if (scoreList[Constant.INDEX_OF_SUM] >= Constant.REQUIRED_SCORE_FOR_BONUS) {
			addScore(Constant.BONUS, Constant.INDEX_OF_BONUS);
		} else {
			addScore(0, Constant.INDEX_OF_BONUS);
		}
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
