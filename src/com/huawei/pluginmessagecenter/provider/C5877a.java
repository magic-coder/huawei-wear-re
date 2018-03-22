package com.huawei.pluginmessagecenter.provider;

import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.pluginmessagecenter.service.MessageObserverController;

/* compiled from: MessageObserverAdapter */
public class C5877a {
    private static String f20157a = "MessageObserverAdapter";
    private static C5877a f20158c;
    private MessageObserverController f20159b = new MessageObserverController();

    private C5877a() {
    }

    public static C5877a m27072a() {
        C5877a c5877a;
        synchronized (C5877a.class) {
            if (f20158c == null) {
                f20158c = new C5877a();
            }
            c5877a = f20158c;
        }
        return c5877a;
    }

    public void m27073a(int i, MessageChangeEvent messageChangeEvent) {
        if (this.f20159b != null) {
            this.f20159b.notifyAllObservers(i, messageChangeEvent);
        }
    }

    public void m27074a(MessageObserver messageObserver) {
        if (messageObserver == null) {
            C5861g.m27024c(f20157a, "Observer object maybe not create.");
        } else {
            this.f20159b.addObservers(messageObserver);
        }
    }

    public void m27076b(MessageObserver messageObserver) {
        if (messageObserver == null) {
            C5861g.m27024c(f20157a, "Observer object maybe not create.");
        } else {
            this.f20159b.deleteObservers(messageObserver);
        }
    }

    public void m27075b() {
        C5861g.m27024c(f20157a, "release()");
        if (this.f20159b != null) {
            this.f20159b.clear();
        }
    }
}
