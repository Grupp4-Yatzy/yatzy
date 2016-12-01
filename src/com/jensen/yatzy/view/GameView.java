package com.jensen.yatzy.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class GameView extends JPanel{
    //JPanel eastPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JButton rollButton = new JButton("Roll");
    JButton doneButton = new JButton("Done");
    JButton[] diceButtons = new JButton[5];
    ArrayList<String> playerNames = new ArrayList<>();
    String[] combinations = {"Ettor", "Tvåor","Treor","Fyror","Femmor","Sexor",
                            "Summa","Bonus","Ett par","Två par","Tretal","Fyrtal",
                             "L.Stege","S.Stege","Kåk","Chans","¨Yatzy","Totalt"};
    JTable table;
    private static final int COLUMN_WIDTH=100;
    
    
    public GameView (){
        
        this.setLayout(new BorderLayout());
        
        
        GridLayout grid = new GridLayout(0,1);
        grid.setVgap(5);
        westPanel.setLayout(grid);
        westPanel.setBackground(Color.blue);
        //westPanel.setPreferredSize(new Dimension(100,100));
        Dimension size = new Dimension(100,100/10);
        for(int i=0; i<combinations.length; i++){
            JLabel label = new JLabel(combinations[i]);
            
            label.setPreferredSize(size);
            label.setSize(size);
            label.setBackground(Color.PINK);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            westPanel.add(label);
             
        }
        
        JPanel northGridPanel = new JPanel();
        GridLayout northGrid = new GridLayout(1,0);
        //northGrid.setHgap(50);
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.BLACK);
        northGridPanel.setBackground(Color.CYAN);
        ArrayList<JLabel> labels = new ArrayList<>();
        //northPanel.setPreferredSize(new Dimension(600,100));
        String[] names = {"Benjamin", "Robin", "Roberto", "Kami"};
        System.out.println(names.toString());
        setPlayerNames(names);
        for(String playerName: playerNames){
            JLabel label = new JLabel(playerName);
            
            //label.setPreferredSize(new Dimension(200,100/10));
            label.setBackground(Color.GREEN);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            labels.add(label);
            label.setPreferredSize(new Dimension(COLUMN_WIDTH, 20));
            northGridPanel.add(label);
            
        }
        
        centerPanel.setBackground(Color.yellow);
        //centerPanel.setPreferredSize(new Dimension(200,200));
        
        Integer[][] data = new Integer[combinations.length][playerNames.size()];
        //Källa på följande kodstycke taget från https://www.youtube.com/watch?v=iMBfneE2Ztg
        table = new JTable(data, playerNames.toArray()){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
                Component c = super.prepareRenderer(renderer, row, column);
                if(row % 2 == 0)
                    c.setBackground(Color.LIGHT_GRAY);
                else
                    c.setBackground(Color.WHITE);
                return c;
            }
        };
        //Slut på lånad kod
        TableColumnModel columnModel = table.getColumnModel();
        for(int i=0; i<columnModel.getColumnCount();i++){
            columnModel.getColumn(i).setPreferredWidth(COLUMN_WIDTH);
        }
        
        centerPanel.add(table);
        
        
        JLabel label = new JLabel("Yatzy");
        //label.setPreferredSize(new Dimension(westPanel.getWidth(), 20));
        northPanel.add(label, BorderLayout.WEST);
        northPanel.add(northGridPanel, BorderLayout.CENTER);
        label.setForeground(Color.white);
        label.setPreferredSize(size);
        
        southPanel.setLayout(new BorderLayout());
        JPanel southCenter = new JPanel();
        JPanel southEast = new JPanel();
        southPanel.setBackground(Color.ORANGE);
        southPanel.setPreferredSize(new Dimension(100,100));
        southCenter.setBackground(Color.GRAY);
        southEast.setBackground(Color.BLUE);
        southEast.add(rollButton);
        southEast.add(doneButton);
        southPanel.add(southCenter, BorderLayout.CENTER);
        southPanel.add(southEast, BorderLayout.EAST);
        
        for(int i=0; i<diceButtons.length; i++){
            JButton dice = new JButton(""+(i+1));
            diceButtons[i]= dice;
            southCenter.add(dice);
            
        }
        
        this.add(table);       
        //this.add(centerPanel, BorderLayout.CENTER);
        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        
    }
    public void setPlayerNames(String[] names){
        for(int i=0; i<names.length; i++){
            playerNames.add(names[i]);
        }
    }
}
