package com.huawei.ui.main.stories.about.p179a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import java.util.List;

/* compiled from: AppUpdateInteractor */
class C2282d implements IBaseResponseCallback {
    final /* synthetic */ C1971j f8283a;
    final /* synthetic */ C2422e f8284b;
    final /* synthetic */ C2279a f8285c;

    C2282d(C2279a c2279a, C1971j c1971j, C2422e c2422e) {
        this.f8285c = c2279a;
        this.f8283a = c1971j;
        this.f8284b = c2422e;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            try {
                obj = (List) obj;
            } catch (ClassCastException e) {
                C2538c.m12677c("AppUpdateInteractor", "makeMessage, " + e.getMessage());
                obj = null;
            }
            if (obj != null) {
                C2538c.m12677c("AppUpdateInteractor", "makeMessage, delete messageList, messageList.size() = " + obj.size());
                int i2 = 0;
                while (i2 < obj.size()) {
                    try {
                        this.f8283a.m10252b(((MessageObject) obj.get(i2)).getMsgId());
                        this.f8284b.m12174a(Integer.parseInt(((MessageObject) obj.get(i2)).getMsgId().substring(1)));
                        C2538c.m12677c("AppUpdateInteractor", "id:" + ((MessageObject) obj.get(i2)).getMsgId().substring(1));
                        i2++;
                    } catch (NumberFormatException e2) {
                        C2538c.m12677c("AppUpdateInteractor", "delete error" + e2.getMessage());
                        return;
                    }
                }
            }
        }
    }
}
