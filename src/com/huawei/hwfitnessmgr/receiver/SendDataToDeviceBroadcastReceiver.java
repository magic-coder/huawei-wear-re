package com.huawei.hwfitnessmgr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.p190v.C2538c;
import java.util.concurrent.Executors;

public class SendDataToDeviceBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("SendDataToDeviceBroadcastReceiver", "SendDataToDeviceBroadcastReceiver onReceive action() = " + intent.getAction());
        if ("com.huawei.bone.ACTION_RECEIVE_SEND_HEART_CONFIG".equals(intent.getAction())) {
            C1026q.m4018a(context).m4122a(new C1027a(this), true);
        } else if ("com.huawei.bone.ACTION_RECEIVE_SEND_SPORT_GOAL".equals(intent.getAction())) {
            C1026q.m4018a(context).m4128b();
        } else if ("com.huawei.bone.ACTION_RECEIVE_SEND_HEIGHT_WEIGHT".equals(intent.getAction())) {
            C2538c.m12677c("SendDataToDeviceBroadcastReceiver", "action ACTION_RECEIVE_SEND_HEIGHT_WEIGHT");
            Executors.newSingleThreadExecutor().execute(new C1028b(this, context.getApplicationContext()));
        }
    }
}
