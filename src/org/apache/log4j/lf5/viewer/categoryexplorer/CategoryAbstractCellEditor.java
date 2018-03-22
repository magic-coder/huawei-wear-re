package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;

public class CategoryAbstractCellEditor implements TableCellEditor, TreeCellEditor {
    static Class class$javax$swing$event$CellEditorListener;
    protected ChangeEvent _changeEvent = null;
    protected int _clickCountToStart = 1;
    protected EventListenerList _listenerList = new EventListenerList();
    protected Object _value;

    public Object getCellEditorValue() {
        return this._value;
    }

    public void setCellEditorValue(Object obj) {
        this._value = obj;
    }

    public void setClickCountToStart(int i) {
        this._clickCountToStart = i;
    }

    public int getClickCountToStart() {
        return this._clickCountToStart;
    }

    public boolean isCellEditable(EventObject eventObject) {
        if (!(eventObject instanceof MouseEvent) || ((MouseEvent) eventObject).getClickCount() >= this._clickCountToStart) {
            return true;
        }
        return false;
    }

    public boolean shouldSelectCell(EventObject eventObject) {
        if (!isCellEditable(eventObject) || (eventObject != null && ((MouseEvent) eventObject).getClickCount() < this._clickCountToStart)) {
            return false;
        }
        return true;
    }

    public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }

    public void cancelCellEditing() {
        fireEditingCanceled();
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void addCellEditorListener(CellEditorListener cellEditorListener) {
        Class class$;
        EventListenerList eventListenerList = this._listenerList;
        if (class$javax$swing$event$CellEditorListener == null) {
            class$ = class$("javax.swing.event.CellEditorListener");
            class$javax$swing$event$CellEditorListener = class$;
        } else {
            class$ = class$javax$swing$event$CellEditorListener;
        }
        eventListenerList.add(class$, cellEditorListener);
    }

    public void removeCellEditorListener(CellEditorListener cellEditorListener) {
        Class class$;
        EventListenerList eventListenerList = this._listenerList;
        if (class$javax$swing$event$CellEditorListener == null) {
            class$ = class$("javax.swing.event.CellEditorListener");
            class$javax$swing$event$CellEditorListener = class$;
        } else {
            class$ = class$javax$swing$event$CellEditorListener;
        }
        eventListenerList.remove(class$, cellEditorListener);
    }

    public Component getTreeCellEditorComponent(JTree jTree, Object obj, boolean z, boolean z2, boolean z3, int i) {
        return null;
    }

    public Component getTableCellEditorComponent(JTable jTable, Object obj, boolean z, int i, int i2) {
        return null;
    }

    protected void fireEditingStopped() {
        Object[] listenerList = this._listenerList.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            Class class$;
            Class cls = listenerList[length];
            if (class$javax$swing$event$CellEditorListener == null) {
                class$ = class$("javax.swing.event.CellEditorListener");
                class$javax$swing$event$CellEditorListener = class$;
            } else {
                class$ = class$javax$swing$event$CellEditorListener;
            }
            if (cls == class$) {
                if (this._changeEvent == null) {
                    this._changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listenerList[length + 1]).editingStopped(this._changeEvent);
            }
        }
    }

    protected void fireEditingCanceled() {
        Object[] listenerList = this._listenerList.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            Class class$;
            Class cls = listenerList[length];
            if (class$javax$swing$event$CellEditorListener == null) {
                class$ = class$("javax.swing.event.CellEditorListener");
                class$javax$swing$event$CellEditorListener = class$;
            } else {
                class$ = class$javax$swing$event$CellEditorListener;
            }
            if (cls == class$) {
                if (this._changeEvent == null) {
                    this._changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listenerList[length + 1]).editingCanceled(this._changeEvent);
            }
        }
    }
}
