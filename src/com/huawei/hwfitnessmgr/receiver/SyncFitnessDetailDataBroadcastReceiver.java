package com.huawei.hwfitnessmgr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.p190v.C2538c;
import java.util.concurrent.Executors;

public class SyncFitnessDetailDataBroadcastReceiver extends BroadcastReceiver {
    public static final String f1909a = SyncFitnessDetailDataBroadcastReceiver.class.getSimpleName();

    public static boolean m4149a() {
        return SyncFitnessPrivateBroadcastReceiver.m4154b();
    }

    public static void m4148a(boolean z) {
        SyncFitnessPrivateBroadcastReceiver.m4153b(z);
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c(f1909a, "onReceive(): intent.getAction() = " + intent.getAction());
        if ("com.huawei.hihealth.action_receive_push_remote".equals(intent.getAction())) {
            C1026q.m4018a(BaseApplication.m2632b()).m4130b(new C1029e(this));
        } else if ("com.huawei.hihealth.action_receive_push_restart".equals(intent.getAction())) {
            C2538c.m12677c(f1909a, "starting phoneservice~~~~~~~~~~~~~~~~~");
            Executors.newFixedThreadPool(1).execute(new C1030f(this));
        } else if ("com.huawei.bone.action.ACTION_HEALTH_MANUAL_DROP_DO_REFRESH".equals(intent.getAction())) {
            SyncFitnessPrivateBroadcastReceiver.m4151a(true);
            C2538c.m12677c(f1909a, "ACTION_HEALTH_MANUAL_DROP_DO_REFRESH received~~~");
        }
    }

    public static void m4150b() {
        C2538c.m12677c(f1909a, " sending broadcast to notify UI thread ...");
        Intent intent = new Intent("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_COMPLETED");
        intent.setPackage("com.huawei.bone");
        BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
    }
}
