package org.apache.log4j.lf5.viewer;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LogFactor5ErrorDialog extends LogFactor5Dialog {

    class C27871 implements ActionListener {
        private final LogFactor5ErrorDialog this$0;

        C27871(LogFactor5ErrorDialog logFactor5ErrorDialog) {
            this.this$0 = logFactor5ErrorDialog;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            this.this$0.hide();
        }
    }

    public LogFactor5ErrorDialog(JFrame jFrame, String str) {
        super(jFrame, "Error", true);
        JButton jButton = new JButton("Ok");
        jButton.addActionListener(new C27871(this));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jButton);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridBagLayout());
        wrapStringOnPanel(str, jPanel2);
        getContentPane().add(jPanel2, "Center");
        getContentPane().add(jPanel, "South");
        show();
    }
}
