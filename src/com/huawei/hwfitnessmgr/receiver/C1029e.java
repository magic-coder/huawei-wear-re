package com.huawei.hwfitnessmgr.receiver;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: SyncFitnessDetailDataBroadcastReceiver */
class C1029e implements IBaseResponseCallback {
    final /* synthetic */ SyncFitnessDetailDataBroadcastReceiver f1917a;

    C1029e(SyncFitnessDetailDataBroadcastReceiver syncFitnessDetailDataBroadcastReceiver) {
        this.f1917a = syncFitnessDetailDataBroadcastReceiver;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(SyncFitnessDetailDataBroadcastReceiver.f1909a, "syncFitnessDetailData received~~~");
    }
}
