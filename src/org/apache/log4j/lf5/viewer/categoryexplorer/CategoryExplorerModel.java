package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.apache.log4j.lf5.LogRecord;

public class CategoryExplorerModel extends DefaultTreeModel {
    private static final long serialVersionUID = -3413887384316015901L;
    protected ActionEvent _event = new ActionEvent(this, 1001, "Nodes Selection changed");
    protected ActionListener _listener = null;
    protected boolean _renderFatal = true;

    class C27911 implements Runnable {
        private final CategoryExplorerModel this$0;
        private final CategoryNode val$node;

        C27911(CategoryExplorerModel categoryExplorerModel, CategoryNode categoryNode) {
            this.this$0 = categoryExplorerModel;
            this.val$node = categoryNode;
        }

        public void run() {
            this.this$0.nodeChanged(this.val$node);
        }
    }

    public CategoryExplorerModel(CategoryNode categoryNode) {
        super(categoryNode);
    }

    public void addLogRecord(LogRecord logRecord) {
        CategoryPath categoryPath = new CategoryPath(logRecord.getCategory());
        addCategory(categoryPath);
        CategoryNode categoryNode = getCategoryNode(categoryPath);
        categoryNode.addRecord();
        if (this._renderFatal && logRecord.isFatal()) {
            TreeNode[] pathToRoot = getPathToRoot(categoryNode);
            int length = pathToRoot.length;
            for (int i = 1; i < length - 1; i++) {
                CategoryNode categoryNode2 = (CategoryNode) pathToRoot[i];
                categoryNode2.setHasFatalChildren(true);
                nodeChanged(categoryNode2);
            }
            categoryNode.setHasFatalRecords(true);
            nodeChanged(categoryNode);
        }
    }

    public CategoryNode getRootCategoryNode() {
        return (CategoryNode) getRoot();
    }

    public CategoryNode getCategoryNode(String str) {
        return getCategoryNode(new CategoryPath(str));
    }

    public CategoryNode getCategoryNode(CategoryPath categoryPath) {
        CategoryNode categoryNode = (CategoryNode) getRoot();
        for (int i = 0; i < categoryPath.size(); i++) {
            Object obj;
            CategoryElement categoryElementAt = categoryPath.categoryElementAt(i);
            Enumeration children = categoryNode.children();
            while (children.hasMoreElements()) {
                CategoryNode categoryNode2 = (CategoryNode) children.nextElement();
                if (categoryNode2.getTitle().toLowerCase().equals(categoryElementAt.getTitle().toLowerCase())) {
                    categoryNode = categoryNode2;
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                return null;
            }
        }
        return categoryNode;
    }

    public boolean isCategoryPathActive(CategoryPath categoryPath) {
        int i = 0;
        CategoryNode categoryNode = (CategoryNode) getRoot();
        boolean z = false;
        while (i < categoryPath.size()) {
            boolean z2;
            CategoryNode categoryNode2;
            CategoryElement categoryElementAt = categoryPath.categoryElementAt(i);
            Enumeration children = categoryNode.children();
            while (children.hasMoreElements()) {
                CategoryNode categoryNode3 = (CategoryNode) children.nextElement();
                if (categoryNode3.getTitle().toLowerCase().equals(categoryElementAt.getTitle().toLowerCase())) {
                    if (categoryNode3.isSelected()) {
                        z2 = true;
                        categoryNode2 = categoryNode3;
                        z = true;
                    } else {
                        z2 = false;
                        categoryNode2 = categoryNode3;
                        z = true;
                    }
                    if (!z2 && r0) {
                        i++;
                        z = z2;
                        categoryNode = categoryNode2;
                    }
                }
            }
            z = false;
            categoryNode2 = categoryNode;
            z2 = false;
            return !z2 ? false : false;
        }
        return z;
    }

    public CategoryNode addCategory(CategoryPath categoryPath) {
        CategoryNode categoryNode = (CategoryNode) getRoot();
        for (int i = 0; i < categoryPath.size(); i++) {
            CategoryNode categoryNode2;
            Object obj;
            CategoryElement categoryElementAt = categoryPath.categoryElementAt(i);
            Enumeration children = categoryNode.children();
            while (children.hasMoreElements()) {
                categoryNode2 = (CategoryNode) children.nextElement();
                if (categoryNode2.getTitle().toLowerCase().equals(categoryElementAt.getTitle().toLowerCase())) {
                    obj = 1;
                    break;
                }
            }
            categoryNode2 = categoryNode;
            obj = null;
            if (obj == null) {
                categoryNode = new CategoryNode(categoryElementAt.getTitle());
                insertNodeInto(categoryNode, categoryNode2, categoryNode2.getChildCount());
                refresh(categoryNode);
            } else {
                categoryNode = categoryNode2;
            }
        }
        return categoryNode;
    }

    public void update(CategoryNode categoryNode, boolean z) {
        if (categoryNode.isSelected() != z) {
            if (z) {
                setParentSelection(categoryNode, true);
            } else {
                setDescendantSelection(categoryNode, false);
            }
        }
    }

    public void setDescendantSelection(CategoryNode categoryNode, boolean z) {
        Enumeration depthFirstEnumeration = categoryNode.depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            CategoryNode categoryNode2 = (CategoryNode) depthFirstEnumeration.nextElement();
            if (categoryNode2.isSelected() != z) {
                categoryNode2.setSelected(z);
                nodeChanged(categoryNode2);
            }
        }
        notifyActionListeners();
    }

    public void setParentSelection(CategoryNode categoryNode, boolean z) {
        TreeNode[] pathToRoot = getPathToRoot(categoryNode);
        int length = pathToRoot.length;
        for (int i = 1; i < length; i++) {
            CategoryNode categoryNode2 = (CategoryNode) pathToRoot[i];
            if (categoryNode2.isSelected() != z) {
                categoryNode2.setSelected(z);
                nodeChanged(categoryNode2);
            }
        }
        notifyActionListeners();
    }

    public synchronized void addActionListener(ActionListener actionListener) {
        this._listener = AWTEventMulticaster.add(this._listener, actionListener);
    }

    public synchronized void removeActionListener(ActionListener actionListener) {
        this._listener = AWTEventMulticaster.remove(this._listener, actionListener);
    }

    public void resetAllNodeCounts() {
        Enumeration depthFirstEnumeration = getRootCategoryNode().depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            CategoryNode categoryNode = (CategoryNode) depthFirstEnumeration.nextElement();
            categoryNode.resetNumberOfContainedRecords();
            nodeChanged(categoryNode);
        }
    }

    public TreePath getTreePathToRoot(CategoryNode categoryNode) {
        if (categoryNode == null) {
            return null;
        }
        return new TreePath(getPathToRoot(categoryNode));
    }

    protected void notifyActionListeners() {
        if (this._listener != null) {
            this._listener.actionPerformed(this._event);
        }
    }

    protected void refresh(CategoryNode categoryNode) {
        SwingUtilities.invokeLater(new C27911(this, categoryNode));
    }
}
