package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PluginMessageCenter */
class C5874n implements Runnable {
    final /* synthetic */ String f20147a;
    final /* synthetic */ IBaseResponseCallback f20148b;
    final /* synthetic */ j f20149c;

    C5874n(j jVar, String str, IBaseResponseCallback iBaseResponseCallback) {
        this.f20149c = jVar;
        this.f20147a = str;
        this.f20148b = iBaseResponseCallback;
    }

    public void run() {
        List arrayList = new ArrayList();
        List<MessageObject> c = C5862a.m27025a(j.a(this.f20149c)).m27044c(this.f20147a);
        if (c != null && c.size() > 0) {
            for (MessageObject messageObject : c) {
                C5861g.m27024c("PluginMessageCenter", "getMessageCenterListMessageForHealth " + (messageObject == null ? "" : messageObject.toString()));
                if (messageObject != null && ((messageObject.getPosition() == 1 || messageObject.getPosition() == 3) && (messageObject.getMsgPosition() == 11 || messageObject.getMsgPosition() == 0))) {
                    arrayList.add(messageObject);
                }
            }
        }
        if (this.f20148b != null) {
            this.f20148b.onResponse(0, arrayList);
        }
    }
}
