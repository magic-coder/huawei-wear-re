package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import java.util.List;

/* compiled from: UpdateInteractors */
class ap implements IBaseResponseCallback {
    final /* synthetic */ boolean f6893a;
    final /* synthetic */ C1971j f6894b;
    final /* synthetic */ C2422e f6895c;
    final /* synthetic */ ah f6896d;

    ap(ah ahVar, boolean z, C1971j c1971j, C2422e c2422e) {
        this.f6896d = ahVar;
        this.f6893a = z;
        this.f6894b = c1971j;
        this.f6895c = c2422e;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            try {
                obj = (List) obj;
            } catch (ClassCastException e) {
                C2538c.m12677c("UpdateInteractors", "ClassCastException :" + e.getMessage());
                obj = null;
            }
            if (obj != null) {
                C2538c.m12677c("UpdateInteractors", "makeMessage, delete messageList, messageList.size() = " + obj.size());
                int i2 = 0;
                while (i2 < obj.size()) {
                    try {
                        C2538c.m12677c("UpdateInteractors", "msgID:" + ((MessageObject) obj.get(i2)).getMsgId());
                        if (!this.f6893a) {
                            this.f6894b.m10252b(((MessageObject) obj.get(i2)).getMsgId());
                        }
                        this.f6895c.m12174a(this.f6895c.m12171a((MessageObject) obj.get(i2)));
                        C2538c.m12677c("UpdateInteractors", "id:" + r0);
                        i2++;
                    } catch (NumberFormatException e2) {
                        C2538c.m12677c("UpdateInteractors", "delete error" + e2.getMessage());
                        return;
                    }
                }
            }
        }
    }
}
