package org.apache.log4j.lf5.viewer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogFactor5InputDialog extends LogFactor5Dialog {
    public static final int SIZE = 30;
    private JTextField _textField;

    class C27881 extends KeyAdapter {
        private final LogFactor5InputDialog this$0;

        C27881(LogFactor5InputDialog logFactor5InputDialog) {
            this.this$0 = logFactor5InputDialog;
        }

        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 10) {
                this.this$0.hide();
            }
        }
    }

    class C27892 implements ActionListener {
        private final LogFactor5InputDialog this$0;

        C27892(LogFactor5InputDialog logFactor5InputDialog) {
            this.this$0 = logFactor5InputDialog;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0.hide();
        }
    }

    class C27903 implements ActionListener {
        private final LogFactor5InputDialog this$0;

        C27903(LogFactor5InputDialog logFactor5InputDialog) {
            this.this$0 = logFactor5InputDialog;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0.hide();
            LogFactor5InputDialog.access$000(this.this$0).setText("");
        }
    }

    static JTextField access$000(LogFactor5InputDialog logFactor5InputDialog) {
        return logFactor5InputDialog._textField;
    }

    public LogFactor5InputDialog(JFrame jFrame, String str, String str2) {
        this(jFrame, str, str2, 30);
    }

    public LogFactor5InputDialog(JFrame jFrame, String str, String str2, int i) {
        super(jFrame, str, true);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        jPanel2.add(new JLabel(str2));
        this._textField = new JTextField(i);
        jPanel2.add(this._textField);
        addKeyListener(new C27881(this));
        JButton jButton = new JButton("Ok");
        jButton.addActionListener(new C27892(this));
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new C27903(this));
        jPanel.add(jButton);
        jPanel.add(jButton2);
        getContentPane().add(jPanel2, "Center");
        getContentPane().add(jPanel, "South");
        pack();
        centerWindow(this);
        show();
    }

    public String getText() {
        String text = this._textField.getText();
        if (text == null || text.trim().length() != 0) {
            return text;
        }
        return null;
    }
}
