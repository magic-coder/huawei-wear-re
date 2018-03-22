package com.huawei.hwfitnessmgr.receiver;

import android.content.Intent;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.p190v.C2538c;

/* compiled from: SyncFitnessPrivateBroadcastReceiver */
class C1032h implements IBaseResponseCallback {
    final /* synthetic */ SyncFitnessPrivateBroadcastReceiver f1920a;

    C1032h(SyncFitnessPrivateBroadcastReceiver syncFitnessPrivateBroadcastReceiver) {
        this.f1920a = syncFitnessPrivateBroadcastReceiver;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(SyncFitnessPrivateBroadcastReceiver.f1910a, "toSyncStressDetailData end. err_code = " + i + ",objData = " + obj);
        if (400001 == i) {
            C2538c.m12677c(SyncFitnessPrivateBroadcastReceiver.f1910a, "saveStressAndRelaxData finished broadcast to health");
            BaseApplication.m2632b().sendBroadcast(new Intent("com.huawei.health.stress_relax_save_finish"));
            C2538c.m12677c(SyncFitnessPrivateBroadcastReceiver.f1910a, "************sync success.Notify health APP to fresh UI.*****************");
        }
        C2538c.m12677c(SyncFitnessPrivateBroadcastReceiver.f1910a, "start to sync coreSleep.");
        SyncFitnessPrivateBroadcastReceiver.f1911b = false;
        Intent intent = new Intent("com.huawei.bone.core_sleep_sync");
        intent.setPackage("com.huawei.bone");
        BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
    }
}
