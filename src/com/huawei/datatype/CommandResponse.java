package com.huawei.datatype;

import java.util.Map;

public class CommandResponse {
    private Map<Integer, Boolean> flags;
    private int serviceID;

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int i) {
        this.serviceID = i;
    }

    public Map<Integer, Boolean> getFlags() {
        return this.flags;
    }

    public void setFlags(Map<Integer, Boolean> map) {
        this.flags = map;
    }
}
