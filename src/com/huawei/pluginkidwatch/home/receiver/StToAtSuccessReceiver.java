package com.huawei.pluginkidwatch.home.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.p137a.C1383f;

public class StToAtSuccessReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("StToAtSuccessReceiver_KidWatchPushReceiver", "========Enter onReceive");
        if (intent != null && "com.huawei.plugin.account.login.st.to.at".equals(intent.getAction())) {
            C1383f.m6188a(context).m6193c();
        }
    }
}
