package com.huawei.pluginkidwatch.home.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;

public class LoopVoiceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("LoopVoiceReceiver_KidWatchPushReceiver", "========Enter onReceive");
        if (intent != null && "com.huawei.pluginkidwatch.receiver.LoopVoiceReceiver".equals(intent.getAction())) {
            m7833a(context);
        }
    }

    public void m7833a(Context context) {
        try {
            C1462f.m6719a(C1093a.m4739a(context).m4753f());
            C1462f.m6729c(C1093a.m4739a(context).m4750c());
            if ("".equals(C1462f.m6746j())) {
                C2538c.m12674b("LoopVoiceReceiver_KidWatchPushReceiver", "=========deviceCode is null,return");
                return;
            }
            new C1668a(this, context).start();
        } catch (Exception e) {
            C2538c.m12680e("LoopVoiceReceiver_KidWatchPushReceiver", "====processReceive  Error ===" + e.getMessage());
        }
    }
}
