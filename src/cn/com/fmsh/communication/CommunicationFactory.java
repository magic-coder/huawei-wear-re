package cn.com.fmsh.communication;

import cn.com.fmsh.communication.core.TerminalCommunicationHandler;
import cn.com.fmsh.communication.core.TerminalCommunicationListImpl;

public class CommunicationFactory {
    private static /* synthetic */ TerminalCommunication f9318a;
    private static /* synthetic */ TerminalCommunicationList f9319b;

    public static TerminalCommunication getTerminalCommunication() {
        if (f9318a == null) {
            f9318a = new TerminalCommunicationHandler();
        }
        return f9318a;
    }

    public static TerminalCommunicationList getTerminalCommunicationList() {
        if (f9319b == null) {
            f9319b = new TerminalCommunicationListImpl();
        }
        return f9319b;
    }
}
