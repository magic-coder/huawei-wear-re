package com.huawei.hwfitnessmgr.receiver;

import android.content.Intent;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwfitnessmgr.C1026q;

/* compiled from: SyncFitnessDetailDataBroadcastReceiver */
class C1030f implements Runnable {
    final /* synthetic */ SyncFitnessDetailDataBroadcastReceiver f1918a;

    C1030f(SyncFitnessDetailDataBroadcastReceiver syncFitnessDetailDataBroadcastReceiver) {
        this.f1918a = syncFitnessDetailDataBroadcastReceiver;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.bone.action.StartPhoneService");
        intent.setPackage(BaseApplication.m2632b().getPackageName());
        BaseApplication.m2632b().startService(intent);
        C1026q.m4018a(BaseApplication.m2632b());
    }
}
