package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PluginMessageCenter */
class C5879r implements Runnable {
    final /* synthetic */ IBaseResponseCallback f20164a;
    final /* synthetic */ j f20165b;

    C5879r(j jVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f20165b = jVar;
        this.f20164a = iBaseResponseCallback;
    }

    public void run() {
        List arrayList = new ArrayList();
        List<MessageObject> a = j.a(this.f20165b, 0, 0);
        if (a != null && a.size() > 0) {
            for (MessageObject messageObject : a) {
                if (messageObject != null && ((messageObject.getPosition() == 1 || messageObject.getPosition() == 3) && (messageObject.getMsgPosition() == 11 || messageObject.getMsgPosition() == 0))) {
                    arrayList.add(messageObject);
                }
            }
        }
        if (this.f20164a != null) {
            this.f20164a.onResponse(0, arrayList);
        }
    }
}
