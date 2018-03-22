package org.apache.log4j.lf5.viewer;

import java.awt.Adjustable;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class LF5SwingUtils {

    final class C27771 implements Runnable {
        private final JComponent val$component;

        C27771(JComponent jComponent) {
            this.val$component = jComponent;
        }

        public void run() {
            this.val$component.repaint();
        }
    }

    public static void selectRow(int i, JTable jTable, JScrollPane jScrollPane) {
        if (jTable != null && jScrollPane != null && contains(i, jTable.getModel())) {
            moveAdjustable(jTable.getRowHeight() * i, jScrollPane.getVerticalScrollBar());
            selectRow(i, jTable.getSelectionModel());
            repaintLater(jTable);
        }
    }

    public static void makeScrollBarTrack(Adjustable adjustable) {
        if (adjustable != null) {
            adjustable.addAdjustmentListener(new TrackingAdjustmentListener());
        }
    }

    public static void makeVerticalScrollBarTrack(JScrollPane jScrollPane) {
        if (jScrollPane != null) {
            makeScrollBarTrack(jScrollPane.getVerticalScrollBar());
        }
    }

    protected static boolean contains(int i, TableModel tableModel) {
        if (tableModel != null && i >= 0 && i < tableModel.getRowCount()) {
            return true;
        }
        return false;
    }

    protected static void selectRow(int i, ListSelectionModel listSelectionModel) {
        if (listSelectionModel != null) {
            listSelectionModel.setSelectionInterval(i, i);
        }
    }

    protected static void moveAdjustable(int i, Adjustable adjustable) {
        if (adjustable != null) {
            adjustable.setValue(i);
        }
    }

    protected static void repaintLater(JComponent jComponent) {
        SwingUtilities.invokeLater(new C27771(jComponent));
    }
}
