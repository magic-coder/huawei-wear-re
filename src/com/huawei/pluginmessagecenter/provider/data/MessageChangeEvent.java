package com.huawei.pluginmessagecenter.provider.data;

import java.util.ArrayList;
import java.util.List;

public class MessageChangeEvent {
    private List<String> modifyMessageObject = null;
    private List<String> removeMessageObject = null;

    public MessageChangeEvent(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.modifyMessageObject = arrayList;
        this.removeMessageObject = arrayList2;
    }

    public List<String> getModifyMessageObject() {
        return this.modifyMessageObject;
    }

    public void setModifyMessageObject(List<String> list) {
        this.modifyMessageObject = list;
    }

    public List<String> getRemoveMessageObject() {
        return this.removeMessageObject;
    }

    public void setRemoveMessageObject(List<String> list) {
        this.removeMessageObject = list;
    }
}
