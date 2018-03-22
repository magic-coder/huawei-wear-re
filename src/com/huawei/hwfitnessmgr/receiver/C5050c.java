package com.huawei.hwfitnessmgr.receiver;

import android.os.Bundle;
import com.huawei.up.p404b.C4694a;
import com.huawei.p190v.C2538c;

/* compiled from: SendDataToDeviceBroadcastReceiver */
class C5050c implements C4694a {
    final /* synthetic */ b f18261a;

    C5050c(b bVar) {
        this.f18261a = bVar;
    }

    public void mo4558a(Bundle bundle) {
        C2538c.c("SendDataToDeviceBroadcastReceiver", new Object[]{"downloadUserInfo success"});
    }

    public void mo4557a(int i) {
        C2538c.c("SendDataToDeviceBroadcastReceiver", new Object[]{"downloadUserInfo onfail"});
    }
}
