package org.apache.log4j.lf5.viewer.categoryexplorer;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

public class CategoryNodeEditor extends CategoryAbstractCellEditor {
    protected CategoryExplorerModel _categoryModel;
    protected JCheckBox _checkBox = this._renderer.getCheckBox();
    protected CategoryNode _lastEditedNode;
    protected CategoryNodeEditorRenderer _renderer = new CategoryNodeEditorRenderer();
    protected JTree _tree;

    class C27931 implements ActionListener {
        private final CategoryNodeEditor this$0;

        C27931(CategoryNodeEditor categoryNodeEditor) {
            this.this$0 = categoryNodeEditor;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0._categoryModel.update(this.this$0._lastEditedNode, this.this$0._checkBox.isSelected());
            this.this$0.stopCellEditing();
        }
    }

    class C27942 extends MouseAdapter {
        private final CategoryNodeEditor this$0;

        C27942(CategoryNodeEditor categoryNodeEditor) {
            this.this$0 = categoryNodeEditor;
        }

        public void mousePressed(MouseEvent mouseEvent) {
            if ((mouseEvent.getModifiers() & 4) != 0) {
                this.this$0.showPopup(this.this$0._lastEditedNode, mouseEvent.getX(), mouseEvent.getY());
            }
            this.this$0.stopCellEditing();
        }
    }

    class C27953 implements ActionListener {
        private final CategoryNodeEditor this$0;
        private final CategoryNode val$node;

        C27953(CategoryNodeEditor categoryNodeEditor, CategoryNode categoryNode) {
            this.this$0 = categoryNodeEditor;
            this.val$node = categoryNode;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0.showPropertiesDialog(this.val$node);
        }
    }

    class C27964 implements ActionListener {
        private final CategoryNodeEditor this$0;
        private final CategoryNode val$node;

        C27964(CategoryNodeEditor categoryNodeEditor, CategoryNode categoryNode) {
            this.this$0 = categoryNodeEditor;
            this.val$node = categoryNode;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0._categoryModel.setDescendantSelection(this.val$node, true);
        }
    }

    class C27975 implements ActionListener {
        private final CategoryNodeEditor this$0;
        private final CategoryNode val$node;

        C27975(CategoryNodeEditor categoryNodeEditor, CategoryNode categoryNode) {
            this.this$0 = categoryNodeEditor;
            this.val$node = categoryNode;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0._categoryModel.setDescendantSelection(this.val$node, false);
        }
    }

    class C27986 implements ActionListener {
        private final CategoryNodeEditor this$0;
        private final CategoryNode val$node;

        C27986(CategoryNodeEditor categoryNodeEditor, CategoryNode categoryNode) {
            this.this$0 = categoryNodeEditor;
            this.val$node = categoryNode;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0.expandDescendants(this.val$node);
        }
    }

    class C27997 implements ActionListener {
        private final CategoryNodeEditor this$0;
        private final CategoryNode val$node;

        C27997(CategoryNodeEditor categoryNodeEditor, CategoryNode categoryNode) {
            this.this$0 = categoryNodeEditor;
            this.val$node = categoryNode;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0.collapseDescendants(this.val$node);
        }
    }

    class C28008 implements ActionListener {
        private final CategoryNodeEditor this$0;

        C28008(CategoryNodeEditor categoryNodeEditor) {
            this.this$0 = categoryNodeEditor;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            do {
            } while (this.this$0.removeUnusedNodes() > 0);
        }
    }

    public CategoryNodeEditor(CategoryExplorerModel categoryExplorerModel) {
        this._categoryModel = categoryExplorerModel;
        this._checkBox.addActionListener(new C27931(this));
        this._renderer.addMouseListener(new C27942(this));
    }

    public Component getTreeCellEditorComponent(JTree jTree, Object obj, boolean z, boolean z2, boolean z3, int i) {
        this._lastEditedNode = (CategoryNode) obj;
        this._tree = jTree;
        return this._renderer.getTreeCellRendererComponent(jTree, obj, z, z2, z3, i, true);
    }

    public Object getCellEditorValue() {
        return this._lastEditedNode.getUserObject();
    }

    protected JMenuItem createPropertiesMenuItem(CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Properties");
        jMenuItem.addActionListener(new C27953(this, categoryNode));
        return jMenuItem;
    }

    protected void showPropertiesDialog(CategoryNode categoryNode) {
        JOptionPane.showMessageDialog(this._tree, getDisplayedProperties(categoryNode), new StringBuffer().append("Category Properties: ").append(categoryNode.getTitle()).toString(), -1);
    }

    protected Object getDisplayedProperties(CategoryNode categoryNode) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StringBuffer().append("Category: ").append(categoryNode.getTitle()).toString());
        if (categoryNode.hasFatalRecords()) {
            arrayList.add("Contains at least one fatal LogRecord.");
        }
        if (categoryNode.hasFatalChildren()) {
            arrayList.add("Contains descendants with a fatal LogRecord.");
        }
        arrayList.add(new StringBuffer().append("LogRecords in this category alone: ").append(categoryNode.getNumberOfContainedRecords()).toString());
        arrayList.add(new StringBuffer().append("LogRecords in descendant categories: ").append(categoryNode.getNumberOfRecordsFromChildren()).toString());
        arrayList.add(new StringBuffer().append("LogRecords in this category including descendants: ").append(categoryNode.getTotalNumberOfRecords()).toString());
        return arrayList.toArray();
    }

    protected void showPopup(CategoryNode categoryNode, int i, int i2) {
        JPopupMenu jPopupMenu = new JPopupMenu();
        jPopupMenu.setSize(150, HttpStatus.SC_BAD_REQUEST);
        if (categoryNode.getParent() == null) {
            jPopupMenu.add(createRemoveMenuItem());
            jPopupMenu.addSeparator();
        }
        jPopupMenu.add(createSelectDescendantsMenuItem(categoryNode));
        jPopupMenu.add(createUnselectDescendantsMenuItem(categoryNode));
        jPopupMenu.addSeparator();
        jPopupMenu.add(createExpandMenuItem(categoryNode));
        jPopupMenu.add(createCollapseMenuItem(categoryNode));
        jPopupMenu.addSeparator();
        jPopupMenu.add(createPropertiesMenuItem(categoryNode));
        jPopupMenu.show(this._renderer, i, i2);
    }

    protected JMenuItem createSelectDescendantsMenuItem(CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Select All Descendant Categories");
        jMenuItem.addActionListener(new C27964(this, categoryNode));
        return jMenuItem;
    }

    protected JMenuItem createUnselectDescendantsMenuItem(CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Deselect All Descendant Categories");
        jMenuItem.addActionListener(new C27975(this, categoryNode));
        return jMenuItem;
    }

    protected JMenuItem createExpandMenuItem(CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Expand All Descendant Categories");
        jMenuItem.addActionListener(new C27986(this, categoryNode));
        return jMenuItem;
    }

    protected JMenuItem createCollapseMenuItem(CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Collapse All Descendant Categories");
        jMenuItem.addActionListener(new C27997(this, categoryNode));
        return jMenuItem;
    }

    protected JMenuItem createRemoveMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Remove All Empty Categories");
        jMenuItem.addActionListener(new C28008(this));
        return jMenuItem;
    }

    protected void expandDescendants(CategoryNode categoryNode) {
        Enumeration depthFirstEnumeration = categoryNode.depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            expand((CategoryNode) depthFirstEnumeration.nextElement());
        }
    }

    protected void collapseDescendants(CategoryNode categoryNode) {
        Enumeration depthFirstEnumeration = categoryNode.depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            collapse((CategoryNode) depthFirstEnumeration.nextElement());
        }
    }

    protected int removeUnusedNodes() {
        Enumeration depthFirstEnumeration = this._categoryModel.getRootCategoryNode().depthFirstEnumeration();
        int i = 0;
        while (depthFirstEnumeration.hasMoreElements()) {
            int i2;
            CategoryNode categoryNode = (CategoryNode) depthFirstEnumeration.nextElement();
            if (categoryNode.isLeaf() && categoryNode.getNumberOfContainedRecords() == 0 && categoryNode.getParent() != null) {
                this._categoryModel.removeNodeFromParent(categoryNode);
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    protected void expand(CategoryNode categoryNode) {
        this._tree.expandPath(getTreePath(categoryNode));
    }

    protected TreePath getTreePath(CategoryNode categoryNode) {
        return new TreePath(categoryNode.getPath());
    }

    protected void collapse(CategoryNode categoryNode) {
        this._tree.collapsePath(getTreePath(categoryNode));
    }
}
