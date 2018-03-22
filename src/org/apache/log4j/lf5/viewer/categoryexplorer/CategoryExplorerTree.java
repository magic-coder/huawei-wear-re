package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.tree.TreePath;

public class CategoryExplorerTree extends JTree {
    private static final long serialVersionUID = 8066257446951323576L;
    protected CategoryExplorerModel _model;
    protected boolean _rootAlreadyExpanded;

    class C27921 extends TreeModelAdapter {
        private final CategoryExplorerTree this$0;

        C27921(CategoryExplorerTree categoryExplorerTree) {
            this.this$0 = categoryExplorerTree;
        }

        public void treeNodesInserted(TreeModelEvent treeModelEvent) {
            this.this$0.expandRootNode();
        }
    }

    public CategoryExplorerTree(CategoryExplorerModel categoryExplorerModel) {
        super(categoryExplorerModel);
        this._rootAlreadyExpanded = false;
        this._model = categoryExplorerModel;
        init();
    }

    public CategoryExplorerTree() {
        this._rootAlreadyExpanded = false;
        this._model = new CategoryExplorerModel(new CategoryNode("Categories"));
        setModel(this._model);
        init();
    }

    public CategoryExplorerModel getExplorerModel() {
        return this._model;
    }

    public String getToolTipText(MouseEvent mouseEvent) {
        try {
            return super.getToolTipText(mouseEvent);
        } catch (Exception e) {
            return "";
        }
    }

    protected void init() {
        putClientProperty("JTree.lineStyle", "Angled");
        CategoryNodeRenderer categoryNodeRenderer = new CategoryNodeRenderer();
        setEditable(true);
        setCellRenderer(categoryNodeRenderer);
        setCellEditor(new CategoryImmediateEditor(this, new CategoryNodeRenderer(), new CategoryNodeEditor(this._model)));
        setShowsRootHandles(true);
        setToolTipText("");
        ensureRootExpansion();
    }

    protected void expandRootNode() {
        if (!this._rootAlreadyExpanded) {
            this._rootAlreadyExpanded = true;
            expandPath(new TreePath(this._model.getRootCategoryNode().getPath()));
        }
    }

    protected void ensureRootExpansion() {
        this._model.addTreeModelListener(new C27921(this));
    }
}
