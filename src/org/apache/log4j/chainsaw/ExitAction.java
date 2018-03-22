package org.apache.log4j.chainsaw;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.apache.log4j.Logger;

class ExitAction extends AbstractAction {
    public static final ExitAction INSTANCE = new ExitAction();
    private static final Logger LOG;
    static Class class$org$apache$log4j$chainsaw$ExitAction;

    static {
        Class class$;
        if (class$org$apache$log4j$chainsaw$ExitAction == null) {
            class$ = class$("org.apache.log4j.chainsaw.ExitAction");
            class$org$apache$log4j$chainsaw$ExitAction = class$;
        } else {
            class$ = class$org$apache$log4j$chainsaw$ExitAction;
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

    private ExitAction() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        LOG.info("shutting down");
        System.exit(0);
    }
}
