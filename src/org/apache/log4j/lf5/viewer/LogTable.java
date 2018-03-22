package org.apache.log4j.lf5.viewer;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.log4j.lf5.util.DateFormatManager;

public class LogTable extends JTable {
    private static final long serialVersionUID = 4867085140195148458L;
    protected int _colCategory = 5;
    protected int _colDate = 0;
    protected int _colLevel = 3;
    protected int _colLocation = 7;
    protected int _colMessage = 6;
    protected int _colMessageNum = 2;
    protected int _colNDC = 4;
    protected LogTableColumn[] _colNames = LogTableColumn.getLogTableColumnArray();
    protected int _colThread = 1;
    protected int _colThrown = 8;
    protected int[] _colWidths = new int[]{40, 40, 40, 70, 70, 360, 440, 200, 60};
    protected DateFormatManager _dateFormatManager = null;
    protected JTextArea _detailTextArea;
    protected int _numCols = 9;
    protected int _rowHeight = 30;
    protected TableColumn[] _tableColumns = new TableColumn[this._numCols];

    class LogTableListSelectionListener implements ListSelectionListener {
        protected JTable _table;
        private final LogTable this$0;

        public LogTableListSelectionListener(LogTable logTable, JTable jTable) {
            this.this$0 = logTable;
            this._table = jTable;
        }

        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if (!listSelectionEvent.getValueIsAdjusting()) {
                ListSelectionModel listSelectionModel = (ListSelectionModel) listSelectionEvent.getSource();
                if (!listSelectionModel.isSelectionEmpty()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    int minSelectionIndex = listSelectionModel.getMinSelectionIndex();
                    int i = 0;
                    while (i < this.this$0._numCols - 1) {
                        String str = "";
                        Object valueAt = this._table.getModel().getValueAt(minSelectionIndex, i);
                        if (valueAt != null) {
                            str = valueAt.toString();
                        }
                        stringBuffer.append(new StringBuffer().append(this.this$0._colNames[i]).append(":").toString());
                        stringBuffer.append("\t");
                        if (i == this.this$0._colThread || i == this.this$0._colMessage || i == this.this$0._colLevel) {
                            stringBuffer.append("\t");
                        }
                        if (i == this.this$0._colDate || i == this.this$0._colNDC) {
                            stringBuffer.append("\t\t");
                        }
                        stringBuffer.append(str);
                        stringBuffer.append("\n");
                        i++;
                    }
                    stringBuffer.append(new StringBuffer().append(this.this$0._colNames[this.this$0._numCols - 1]).append(":\n").toString());
                    Object valueAt2 = this._table.getModel().getValueAt(minSelectionIndex, this.this$0._numCols - 1);
                    if (valueAt2 != null) {
                        stringBuffer.append(valueAt2.toString());
                    }
                    this.this$0._detailTextArea.setText(stringBuffer.toString());
                }
            }
        }
    }

    public LogTable(JTextArea jTextArea) {
        init();
        this._detailTextArea = jTextArea;
        setModel(new FilteredLogTableModel());
        Enumeration columns = getColumnModel().getColumns();
        int i = 0;
        while (columns.hasMoreElements()) {
            TableColumn tableColumn = (TableColumn) columns.nextElement();
            tableColumn.setCellRenderer(new LogTableRowRenderer());
            tableColumn.setPreferredWidth(this._colWidths[i]);
            this._tableColumns[i] = tableColumn;
            i++;
        }
        getSelectionModel().addListSelectionListener(new LogTableListSelectionListener(this, this));
    }

    public DateFormatManager getDateFormatManager() {
        return this._dateFormatManager;
    }

    public void setDateFormatManager(DateFormatManager dateFormatManager) {
        this._dateFormatManager = dateFormatManager;
    }

    public synchronized void clearLogRecords() {
        getFilteredLogTableModel().clear();
    }

    public FilteredLogTableModel getFilteredLogTableModel() {
        return (FilteredLogTableModel) getModel();
    }

    public void setDetailedView() {
        int i = 0;
        TableColumnModel columnModel = getColumnModel();
        for (int i2 = 0; i2 < this._numCols; i2++) {
            columnModel.removeColumn(this._tableColumns[i2]);
        }
        while (i < this._numCols) {
            columnModel.addColumn(this._tableColumns[i]);
            i++;
        }
        sizeColumnsToFit(-1);
    }

    public void setView(List list) {
        TableColumnModel columnModel = getColumnModel();
        for (int i = 0; i < this._numCols; i++) {
            columnModel.removeColumn(this._tableColumns[i]);
        }
        Vector columnNameAndNumber = getColumnNameAndNumber();
        for (Object indexOf : list) {
            columnModel.addColumn(this._tableColumns[columnNameAndNumber.indexOf(indexOf)]);
        }
        sizeColumnsToFit(-1);
    }

    public void setFont(Font font) {
        super.setFont(font);
        Graphics graphics = getGraphics();
        if (graphics != null) {
            int height = graphics.getFontMetrics(font).getHeight();
            this._rowHeight = height + (height / 3);
            setRowHeight(this._rowHeight);
        }
    }

    protected void init() {
        setRowHeight(this._rowHeight);
        setSelectionMode(0);
    }

    protected Vector getColumnNameAndNumber() {
        Vector vector = new Vector();
        for (int i = 0; i < this._colNames.length; i++) {
            vector.add(i, this._colNames[i]);
        }
        return vector;
    }
}
