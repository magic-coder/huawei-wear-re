package com.huawei.datatype;

import java.util.List;

public class CommandSend {
    private List<Integer> commandIDs;
    private int serviceID;

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int i) {
        this.serviceID = i;
    }

    public List<Integer> getCommandIDs() {
        return this.commandIDs;
    }

    public void setCommandIDs(List<Integer> list) {
        this.commandIDs = list;
    }
}
