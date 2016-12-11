package com.jensen.yatzy.view;

import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.YatzyTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class GameView extends JPanel{

	private JPanel westPanel;
	private JPanel centerPanel;
	private JButton rollButton = new JButton("Roll");
	private JButton doneButton = new JButton("Done");
	private DiceButton[] diceButtons = new DiceButton[5];
	private ArrayList<JLabel> playerNames = new ArrayList<>();
	private JTable table;
	private JPanel northGridPanel = new JPanel();
	private Dimension combinationLabelSize = new Dimension(100,100/10);


	public GameView (){

		this.setLayout(new BorderLayout());
		westPanel = new JPanel();
		GridLayout westGrid = new GridLayout(0,1);
		westGrid.setVgap(5);
		westPanel.setLayout(westGrid);
		westPanel.setBackground(Color.blue);

		JPanel northPanel = new JPanel();
		GridLayout northGrid = new GridLayout(1,0);       
		northPanel.setLayout(new BorderLayout());
		northPanel.setBackground(Color.BLACK);
		northGridPanel.setLayout(northGrid);
		northGrid.setHgap(2);
		northGridPanel.setBackground(Color.CYAN);

		centerPanel = new JPanel();
		centerPanel.setBackground(Color.yellow);

		JLabel label = new JLabel("Yatzy");
		northPanel.add(label, BorderLayout.WEST);
		northPanel.add(northGridPanel, BorderLayout.CENTER);
		label.setForeground(Color.white);
		label.setPreferredSize(combinationLabelSize);

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		JPanel southCenter = new JPanel();
		JPanel southEast = new JPanel();
		southPanel.setBackground(Color.ORANGE);
		southPanel.setPreferredSize(new Dimension(100,100));
		southCenter.setBackground(Color.GRAY);
		southEast.setBackground(Color.BLUE);
		southEast.add(rollButton);

		rollButton.setActionCommand("Roll");
		southEast.add(doneButton);
		southPanel.add(southCenter, BorderLayout.CENTER);
		southPanel.add(southEast, BorderLayout.EAST);

		for(int i=0; i<diceButtons.length; i++){

			DiceButton dice = new DiceButton(""+(i+1));
			diceButtons[i]= dice;
			southCenter.add(dice);
		}

		this.add(westPanel, BorderLayout.WEST);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
	}

	public void setPlayerNames(String[] names){
		for(int i=0; i<names.length; i++){

			JLabel label = new JLabel(names[i]);
			label.setBackground(Color.GREEN);
			label.setOpaque(true);
			label.setHorizontalAlignment(JLabel.CENTER);
			playerNames.add(label);
			label.setPreferredSize(new Dimension(Constant.COLUMN_WIDTH, 20));
			northGridPanel.add(label);
		}
	}

	public void initTable(YatzyTableModel model){
		this.table = new JTable(model){
		    // Källa på följande kodstycke taget från https://www.youtube.com/watch?v=iMBfneE2Ztg
			@Override
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		        Component c = super.prepareRenderer(renderer, row, column);
		        if (row % 2 == 0) {
		            c.setBackground(Color.LIGHT_GRAY);
		        } else {
		            c.setBackground(Color.WHITE);
		        }
		        return c;
		    }
		    // Slut på lånad kod
		};
		this.add(table, BorderLayout.CENTER);
	}

	public void setDiceButtons(Dice[] dices){
		for(int i=0; i<diceButtons.length; i++){
			diceButtons[i].setText(""+(dices[i].getValue()));

		}
	}

	public void setEnableDice(boolean enableDice)
	{
		for(int i=0; i<diceButtons.length; i++){
			diceButtons[i].setEnabled(enableDice);
		}
	}

	public DiceButton[] getDiceButtons() {
		return diceButtons;
	}


	public JButton getRollButton(){
		return rollButton;
	}

	public JButton getDoneButton(){
		return doneButton;
	}

	public void setCombinations(String[] combinations){
		for(int i=0; i<combinations.length; i++){
			JLabel label = new JLabel(combinations[i]);

			label.setPreferredSize(combinationLabelSize);
			label.setSize(combinationLabelSize);
			label.setBackground(Color.PINK);
			label.setOpaque(true);
			label.setHorizontalAlignment(JLabel.CENTER);
			westPanel.add(label);
		}
	}

	public void addDiceListener(ActionListener listener) {
		for(int i = 0; i<diceButtons.length; i++)
		{
			diceButtons[i].addActionListener(listener);
			diceButtons[i].setActionCommand("Dice"+i);
		}
	}
	public void addPlayListener(ActionListener listener) {
		rollButton.addActionListener(listener);
		doneButton.addActionListener(listener);
	}
}
