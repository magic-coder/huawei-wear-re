package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class CategoryNode extends DefaultMutableTreeNode {
    private static final long serialVersionUID = 5958994817693177319L;
    protected boolean _hasFatalChildren = false;
    protected boolean _hasFatalRecords = false;
    protected int _numberOfContainedRecords = 0;
    protected int _numberOfRecordsFromChildren = 0;
    protected boolean _selected = true;

    public CategoryNode(String str) {
        setUserObject(str);
    }

    public String getTitle() {
        return (String) getUserObject();
    }

    public void setSelected(boolean z) {
        if (z != this._selected) {
            this._selected = z;
        }
    }

    public boolean isSelected() {
        return this._selected;
    }

    public void setAllDescendantsSelected() {
        Enumeration children = children();
        while (children.hasMoreElements()) {
            CategoryNode categoryNode = (CategoryNode) children.nextElement();
            categoryNode.setSelected(true);
            categoryNode.setAllDescendantsSelected();
        }
    }

    public void setAllDescendantsDeSelected() {
        Enumeration children = children();
        while (children.hasMoreElements()) {
            CategoryNode categoryNode = (CategoryNode) children.nextElement();
            categoryNode.setSelected(false);
            categoryNode.setAllDescendantsDeSelected();
        }
    }

    public String toString() {
        return getTitle();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CategoryNode) {
            if (getTitle().toLowerCase().equals(((CategoryNode) obj).getTitle().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return getTitle().hashCode();
    }

    public void addRecord() {
        this._numberOfContainedRecords++;
        addRecordToParent();
    }

    public int getNumberOfContainedRecords() {
        return this._numberOfContainedRecords;
    }

    public void resetNumberOfContainedRecords() {
        this._numberOfContainedRecords = 0;
        this._numberOfRecordsFromChildren = 0;
        this._hasFatalRecords = false;
        this._hasFatalChildren = false;
    }

    public boolean hasFatalRecords() {
        return this._hasFatalRecords;
    }

    public boolean hasFatalChildren() {
        return this._hasFatalChildren;
    }

    public void setHasFatalRecords(boolean z) {
        this._hasFatalRecords = z;
    }

    public void setHasFatalChildren(boolean z) {
        this._hasFatalChildren = z;
    }

    protected int getTotalNumberOfRecords() {
        return getNumberOfRecordsFromChildren() + getNumberOfContainedRecords();
    }

    protected void addRecordFromChild() {
        this._numberOfRecordsFromChildren++;
        addRecordToParent();
    }

    protected int getNumberOfRecordsFromChildren() {
        return this._numberOfRecordsFromChildren;
    }

    protected void addRecordToParent() {
        TreeNode parent = getParent();
        if (parent != null) {
            ((CategoryNode) parent).addRecordFromChild();
        }
    }
}
