package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PluginMessageCenter */
class C5880s implements Runnable {
    final /* synthetic */ IBaseResponseCallback f20166a;
    final /* synthetic */ j f20167b;

    C5880s(j jVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f20167b = jVar;
        this.f20166a = iBaseResponseCallback;
    }

    public void run() {
        List arrayList = new ArrayList();
        List<MessageObject> a = j.a(this.f20167b, 0, 0);
        if (a != null && a.size() > 0) {
            for (MessageObject messageObject : a) {
                if (messageObject != null && (messageObject.getPosition() == 2 || messageObject.getPosition() == 3)) {
                    arrayList.add(messageObject);
                }
            }
        }
        if (this.f20166a != null) {
            this.f20166a.onResponse(0, arrayList);
        }
    }
}
