package com.huawei.ui.homewear21.card.p176a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.List;

/* compiled from: NotificationCardInteractors */
class C2257o implements IBaseResponseCallback {
    final /* synthetic */ C2254l f8205a;

    C2257o(C2254l c2254l) {
        this.f8205a = c2254l;
    }

    public void onResponse(int i, Object obj) {
        this.f8205a.f8199i = false;
        if (i == 0 && obj != null) {
            List list = (List) obj;
            if (!list.isEmpty() && list.size() > 0) {
                this.f8205a.m11656a((MessageObject) list.get(0));
            }
        }
    }
}
