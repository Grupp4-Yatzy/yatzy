package youtube;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Table extends JFrame {
	
	private JTable table;
	private JPanel panel;
	private JFrame frame;

public Table() {
	
	
	
	String[][] data = {
			{"Ettor", " ", " ", " ", " "},
			{"Tvåor", " ", " ", " ", " "},
			{"Treor", " ", " ", " ", " "},
			{"Fyror", " ", " ", " ", " "},
			{"Femmor", " ", " ", " ", " "},
			{"Sexor", " ", " ", " ", " "},
			{"Sexor", " ", " ", " ", " "},
			
			{"Summa", " ", " ", " ", " "},
			{"Bounos", " ", " ", " ", " "},
			{"Ett par", " ", " ", " ", " "},
			{"Två par", " ", " ", " ", " "},
			{"Triss", " ", " ", " ", " "},
			{"Fyrtal", " ", " ", " ", " "},
			{"L.stege", " ", " ", " ", " "},
			{"S.stege", " ", " ", " ", " "},
			{"Kåk", " ", " ", " ", " "},
			{"Chans", " ", " ", " ", " "},
			{"Yatzy", " ", " ", " ", " "},
			{"Totalt", " ", " ", " ", " "},
			
	};
	String[] columnNames = {"Name", "Spelare1", 
			"Spelare2","Spelare3","Spelare4"};

	DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

	table= new JTable(tableModel);
	panel= new JPanel();
	frame = new JFrame("My table example");

	panel.setPreferredSize(new Dimension(500, 700));
	
	add(panel);
	panel.add(table);
	
	
	

}

}
