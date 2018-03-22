package org.apache.log4j.chainsaw;

import com.amap.api.maps.model.WeightedLatLng;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

class ControlPanel extends JPanel {
    private static final Logger LOG;
    static Class class$org$apache$log4j$chainsaw$ControlPanel;

    class C27671 implements ActionListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;
        private final JComboBox val$priorities;

        C27671(ControlPanel controlPanel, MyTableModel myTableModel, JComboBox jComboBox) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
            this.val$priorities = jComboBox;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.val$aModel.setPriorityFilter((Priority) this.val$priorities.getSelectedItem());
        }
    }

    class C27682 implements DocumentListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;
        private final JTextField val$threadField;

        C27682(ControlPanel controlPanel, MyTableModel myTableModel, JTextField jTextField) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
            this.val$threadField = jTextField;
        }

        public void insertUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setThreadFilter(this.val$threadField.getText());
        }

        public void removeUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setThreadFilter(this.val$threadField.getText());
        }

        public void changedUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setThreadFilter(this.val$threadField.getText());
        }
    }

    class C27693 implements DocumentListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;
        private final JTextField val$catField;

        C27693(ControlPanel controlPanel, MyTableModel myTableModel, JTextField jTextField) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
            this.val$catField = jTextField;
        }

        public void insertUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setCategoryFilter(this.val$catField.getText());
        }

        public void removeUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setCategoryFilter(this.val$catField.getText());
        }

        public void changedUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setCategoryFilter(this.val$catField.getText());
        }
    }

    class C27704 implements DocumentListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;
        private final JTextField val$ndcField;

        C27704(ControlPanel controlPanel, MyTableModel myTableModel, JTextField jTextField) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
            this.val$ndcField = jTextField;
        }

        public void insertUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setNDCFilter(this.val$ndcField.getText());
        }

        public void removeUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setNDCFilter(this.val$ndcField.getText());
        }

        public void changedUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setNDCFilter(this.val$ndcField.getText());
        }
    }

    class C27715 implements DocumentListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;
        private final JTextField val$msgField;

        C27715(ControlPanel controlPanel, MyTableModel myTableModel, JTextField jTextField) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
            this.val$msgField = jTextField;
        }

        public void insertUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setMessageFilter(this.val$msgField.getText());
        }

        public void removeUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setMessageFilter(this.val$msgField.getText());
        }

        public void changedUpdate(DocumentEvent documentEvent) {
            this.val$aModel.setMessageFilter(this.val$msgField.getText());
        }
    }

    class C27726 implements ActionListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;

        C27726(ControlPanel controlPanel, MyTableModel myTableModel) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.val$aModel.clear();
        }
    }

    class C27737 implements ActionListener {
        private final ControlPanel this$0;
        private final MyTableModel val$aModel;
        private final JButton val$toggleButton;

        C27737(ControlPanel controlPanel, MyTableModel myTableModel, JButton jButton) {
            this.this$0 = controlPanel;
            this.val$aModel = myTableModel;
            this.val$toggleButton = jButton;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.val$aModel.toggle();
            this.val$toggleButton.setText(this.val$aModel.isPaused() ? "Resume" : "Pause");
        }
    }

    static {
        Class class$;
        if (class$org$apache$log4j$chainsaw$ControlPanel == null) {
            class$ = class$("org.apache.log4j.chainsaw.ControlPanel");
            class$org$apache$log4j$chainsaw$ControlPanel = class$;
        } else {
            class$ = class$org$apache$log4j$chainsaw$ControlPanel;
        }
        LOG = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    ControlPanel(MyTableModel myTableModel) {
        setBorder(BorderFactory.createTitledBorder("Controls: "));
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = 13;
        gridBagConstraints.gridy = 0;
        JLabel jLabel = new JLabel("Filter Level:");
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        add(jLabel);
        gridBagConstraints.gridy++;
        jLabel = new JLabel("Filter Thread:");
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        add(jLabel);
        gridBagConstraints.gridy++;
        jLabel = new JLabel("Filter Logger:");
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        add(jLabel);
        gridBagConstraints.gridy++;
        jLabel = new JLabel("Filter NDC:");
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        add(jLabel);
        gridBagConstraints.gridy++;
        jLabel = new JLabel("Filter Message:");
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        add(jLabel);
        gridBagConstraints.weightx = WeightedLatLng.DEFAULT_INTENSITY;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = 17;
        gridBagConstraints.gridy = 0;
        Level[] levelArr = new Level[]{Level.FATAL, Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG, Level.TRACE};
        JComboBox jComboBox = new JComboBox(levelArr);
        Priority priority = levelArr[levelArr.length - 1];
        jComboBox.setSelectedItem(priority);
        myTableModel.setPriorityFilter(priority);
        gridBagLayout.setConstraints(jComboBox, gridBagConstraints);
        add(jComboBox);
        jComboBox.setEditable(false);
        jComboBox.addActionListener(new C27671(this, myTableModel, jComboBox));
        gridBagConstraints.fill = 2;
        gridBagConstraints.gridy++;
        JTextField jTextField = new JTextField("");
        jTextField.getDocument().addDocumentListener(new C27682(this, myTableModel, jTextField));
        gridBagLayout.setConstraints(jTextField, gridBagConstraints);
        add(jTextField);
        gridBagConstraints.gridy++;
        jTextField = new JTextField("");
        jTextField.getDocument().addDocumentListener(new C27693(this, myTableModel, jTextField));
        gridBagLayout.setConstraints(jTextField, gridBagConstraints);
        add(jTextField);
        gridBagConstraints.gridy++;
        jTextField = new JTextField("");
        jTextField.getDocument().addDocumentListener(new C27704(this, myTableModel, jTextField));
        gridBagLayout.setConstraints(jTextField, gridBagConstraints);
        add(jTextField);
        gridBagConstraints.gridy++;
        jTextField = new JTextField("");
        jTextField.getDocument().addDocumentListener(new C27715(this, myTableModel, jTextField));
        gridBagLayout.setConstraints(jTextField, gridBagConstraints);
        add(jTextField);
        gridBagConstraints.weightx = 0.0d;
        gridBagConstraints.fill = 2;
        gridBagConstraints.anchor = 13;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        JButton jButton = new JButton("Exit");
        jButton.setMnemonic('x');
        jButton.addActionListener(ExitAction.INSTANCE);
        gridBagLayout.setConstraints(jButton, gridBagConstraints);
        add(jButton);
        gridBagConstraints.gridy++;
        jButton = new JButton("Clear");
        jButton.setMnemonic('c');
        jButton.addActionListener(new C27726(this, myTableModel));
        gridBagLayout.setConstraints(jButton, gridBagConstraints);
        add(jButton);
        gridBagConstraints.gridy++;
        jButton = new JButton("Pause");
        jButton.setMnemonic('p');
        jButton.addActionListener(new C27737(this, myTableModel, jButton));
        gridBagLayout.setConstraints(jButton, gridBagConstraints);
        add(jButton);
    }
}
