package com.jensen.yatzy.model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class YatzyTableModel extends AbstractTableModel {
    private Object[][] data = new Object[3][3];

    //Källa på följande kodstycke taget från https://www.youtube.com/watch?v=iMBfneE2Ztg
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /*@Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (row % 2 == 0) {
            c.setBackground(Color.LIGHT_GRAY);
        } else {
            c.setBackground(Color.WHITE);
        }
        return c;
    }*/
     //Slut på lånad kod
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return data[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return data[rowIndex][columnIndex];
    }
    
    public void update(Object[][] data){
        this.data = data;
        
        this.fireTableDataChanged();
    }

}
