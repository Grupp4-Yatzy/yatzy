package com.jensen.yatzy.model;

import javax.swing.table.AbstractTableModel;

/**
 * Is a model of a yatzy score board
 *
 * @author Benjamin Rosman, Robin Nilsson
 *
 */
public class YatzyTableModel extends AbstractTableModel {

  private Object[][] data;

  /**
   * Creates a new 2-dimensional Object array with the specified size from the parameters.
   *
   * @param rowCount Number of rows
   * @param colCount Number of columns
   */
  public void initTable(int rowCount, int colCount) {
    data = new Object[rowCount][colCount];
  }
  //Källa på följande kodstycke taget från https://www.youtube.com/watch?v=iMBfneE2Ztg

  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
  }

  @Override
  public int getRowCount() {
    return data.length;
  }

  @Override
  public int getColumnCount() {
    return data[0].length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return data[rowIndex][columnIndex];
  }

  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    data[rowIndex][columnIndex] = value;
    fireTableCellUpdated(rowIndex, columnIndex);
  }

}
