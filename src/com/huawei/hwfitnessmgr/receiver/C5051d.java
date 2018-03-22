package com.huawei.hwfitnessmgr.receiver;

import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;

/* compiled from: SendDataToDeviceBroadcastReceiver */
class C5051d implements C4694a {
    final /* synthetic */ b f18262a;

    C5051d(b bVar) {
        this.f18262a = bVar;
    }

    public void mo4558a(Bundle bundle) {
        C2538c.c("SendDataToDeviceBroadcastReceiver", new Object[]{"getUserInfofromHiHealth success"});
    }

    public void mo4557a(int i) {
        C2538c.c("SendDataToDeviceBroadcastReceiver", new Object[]{"getUserInfofromHiHealth failed"});
    }
}
