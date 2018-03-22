package com.huawei.pluginmessagecenter.service;

import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageObserverController {
    private static String TAG = "MessageObserverController";
    private List<MessageObserver> mObservers = new ArrayList();

    public void addObservers(MessageObserver messageObserver) {
        if (messageObserver == null) {
            C5861g.m27024c(TAG, "addObservers ==> observer == null");
        } else {
            this.mObservers.add(messageObserver);
        }
    }

    public void deleteObservers(MessageObserver messageObserver) {
        if (messageObserver == null) {
            C5861g.m27024c(TAG, "deleteObservers ==> observer == null");
            return;
        }
        C5861g.m27024c(TAG, "deleteObservers ==> observer == " + messageObserver);
        this.mObservers.remove(messageObserver);
    }

    public void notifyAllObservers(int i, MessageChangeEvent messageChangeEvent) {
        if (this.mObservers != null) {
            Iterator it = new ArrayList(this.mObservers).iterator();
            while (it.hasNext()) {
                ((MessageObserver) it.next()).onChange(i, messageChangeEvent);
            }
        }
    }

    public void clear() {
        if (this.mObservers != null) {
            this.mObservers.clear();
        }
    }
}
