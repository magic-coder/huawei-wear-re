package cn.com.fmsh.communication.core;

import cn.com.fmsh.communication.TerminalCommunication;
import cn.com.fmsh.communication.TerminalCommunicationList;
import cn.com.fmsh.communication.exception.SocketException;
import java.util.HashMap;
import java.util.Map;

public class TerminalCommunicationListImpl implements TerminalCommunicationList {
    private volatile /* synthetic */ Map<String, TerminalCommunication> f9392a = new HashMap();

    public void disConnect() throws SocketException {
        for (Object obj : (String[]) this.f9392a.keySet().toArray(new String[0])) {
            TerminalCommunication terminalCommunication = (TerminalCommunication) this.f9392a.get(obj);
            if (terminalCommunication != null && terminalCommunication.isConnect()) {
                terminalCommunication.disconnect();
            }
        }
    }

    public void disConnect(String str) throws SocketException {
        TerminalCommunication terminalCommunication = (TerminalCommunication) this.f9392a.get(str);
        if (terminalCommunication != null && terminalCommunication.isConnect()) {
            terminalCommunication.disconnect();
        }
    }

    public String[] getNames() {
        return (String[]) this.f9392a.keySet().toArray(new String[0]);
    }

    public TerminalCommunication getTerminalCommunication(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        TerminalCommunication terminalCommunication = (TerminalCommunication) this.f9392a.get(str);
        if (terminalCommunication != null) {
            return terminalCommunication;
        }
        terminalCommunication = new TerminalCommunicationHandler();
        this.f9392a.put(str, terminalCommunication);
        return terminalCommunication;
    }

    public void removeTerminalCommunication(String str) {
        this.f9392a.remove(str);
    }
}
