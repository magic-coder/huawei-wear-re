package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PluginMessageCenter */
class C5881t implements Runnable {
    final /* synthetic */ IBaseResponseCallback f20168a;
    final /* synthetic */ j f20169b;

    C5881t(j jVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f20169b = jVar;
        this.f20168a = iBaseResponseCallback;
    }

    public void run() {
        List arrayList = new ArrayList();
        List<MessageObject> a = j.a(this.f20169b, 0, 0);
        if (a != null && a.size() > 0) {
            for (MessageObject messageObject : a) {
                if (messageObject != null && messageObject.getMsgPosition() == 31 && messageObject.getReadFlag() == 0) {
                    arrayList.add(messageObject);
                }
            }
        }
        if (this.f20168a != null) {
            this.f20168a.onResponse(0, arrayList);
        }
    }
}
