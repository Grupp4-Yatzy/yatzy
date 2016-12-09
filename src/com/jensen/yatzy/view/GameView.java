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
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class GameView extends JPanel{
	
    //JPanel eastPanel = new JPanel();
    private JPanel westPanel;
    //JPanel northPanel = new JPanel();
    //JPanel southPanel = new JPanel();
    private JPanel centerPanel;
    private JButton rollButton = new JButton("Roll");
    private JButton doneButton = new JButton("Done");
    private JButton[] diceButtons = new JButton[5];
    private ArrayList<JLabel> playerNames = new ArrayList<>();
    private String[] combinations;
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
        //westPanel.setPreferredSize(new Dimension(100,100));
        
        JPanel northPanel = new JPanel();
        
        GridLayout northGrid = new GridLayout(1,0);       
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.BLACK);
        northGridPanel.setLayout(northGrid);
        northGrid.setHgap(2);
        northGridPanel.setBackground(Color.CYAN);
        
        ArrayList<JLabel> labels = new ArrayList<>();
        
        
        
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.yellow);
        //centerPanel.setPreferredSize(new Dimension(200,200));
        //table= new JTable(18,5);
        //centerPanel.add(table);

        
         table = new JTable(new YatzyTableModel());
        
          TableColumnModel columnModel = table.getColumnModel();
        for(int i=0; i<columnModel.getColumnCount();i++){
            columnModel.getColumn(i).setPreferredWidth(Constant.COLUMN_WIDTH);
        }
        this.add(table, BorderLayout.CENTER);
        
        
        JLabel label = new JLabel("Yatzy");
        //label.setPreferredSize(new Dimension(westPanel.getWidth(), 20));
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
            JButton dice = new DiceButton(""+(i+1));
            diceButtons[i]= dice;
            southCenter.add(dice);
        }
        
        //this.add(centerPanel, BorderLayout.CENTER);       
        //this.add(centerPanel, BorderLayout.CENTER);
        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        
    }
    
    public void setPlayerNames(String[] names){
        for(int i=0; i<names.length; i++){
            
            JLabel label = new JLabel(names[i]);
            
            //label.setPreferredSize(new Dimension(200,100/10));
            label.setBackground(Color.GREEN);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            playerNames.add(label);
            label.setPreferredSize(new Dimension(Constant.COLUMN_WIDTH, 20));
            northGridPanel.add(label);
            
        
        }
    }
    
    public void setTable(YatzyTableModel model){
        this.table = new JTable(model);
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
    
    public JButton getRollButton(){
        return this.rollButton;
    }
    
    public JButton getDoneButton(){
        return this.doneButton;
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
		// TODO Implement addDiceListener(ActionListener)
                for(int i = 0; i<diceButtons.length; i++)
                {
                  diceButtons[i].addActionListener(listener);
                  diceButtons[i].setActionCommand("Dice "+i);
                 
                }
	}
    
    public void addPlayListener(ActionListener listener) {
		rollButton.addActionListener(listener);
		doneButton.addActionListener(listener);
	}
    
}
