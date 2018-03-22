package com.huawei.ui.homewear21.card.p176a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.List;

/* compiled from: NotificationCardInteractors */
class C2256n implements IBaseResponseCallback {
    final /* synthetic */ C2255m f8204a;

    C2256n(C2255m c2255m) {
        this.f8204a = c2255m;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            List<MessageObject> list = (List) obj;
            if (!list.isEmpty()) {
                for (MessageObject a : list) {
                    this.f8204a.f8203a.m11651b(a);
                }
            }
            this.f8204a.f8203a.f8195d.sendEmptyMessage(1019);
            C2538c.m12677c("NotificationCardInteractors", "MessageObserver onChange end");
        }
    }
}
