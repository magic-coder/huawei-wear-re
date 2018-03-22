package com.huawei.hwfitnessmgr.receiver;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: SyncFitnessPrivateBroadcastReceiver */
class C1031g implements IBaseResponseCallback {
    final /* synthetic */ SyncFitnessPrivateBroadcastReceiver f1919a;

    C1031g(SyncFitnessPrivateBroadcastReceiver syncFitnessPrivateBroadcastReceiver) {
        this.f1919a = syncFitnessPrivateBroadcastReceiver;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(SyncFitnessPrivateBroadcastReceiver.f1910a, "core sleep sync has been done");
        SyncFitnessPrivateBroadcastReceiver.m4155c();
    }
}
