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
			sum += getScore(i);
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
		int total = getScore(Constant.INDEX_OF_SUM) + getScore(Constant.INDEX_OF_BONUS);
		for (int i = Constant.INDEX_OF_BONUS + 1; i < scoreList.length - 1; i++) {
			total += getScore(i);
		}
		addScore(total, scoreList[scoreList.length - 1]);
	}
    
    public int getFirstEmptyScoreIndex() {
    	for (int i = 0; i < scoreList.length; i++) {
			if (getScore(i) == null) {
				return i;
			}
		}
		return scoreList.length;
	}

    public boolean isEmpty(int index) {
        if (scoreList[index] == null) {
            return true;
        }
        return false;
    }

}
