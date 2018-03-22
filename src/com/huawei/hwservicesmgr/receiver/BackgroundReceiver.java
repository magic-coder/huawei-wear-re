package com.huawei.hwservicesmgr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

public class BackgroundReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2538c.m12680e("BackgroundReceiver", "intent is null");
            return;
        }
        try {
            C2538c.m12677c("BackgroundReceiver", "===EMUI=== iConnect's receive, intent.getAction() = " + intent.getAction());
            if ("com.huawei.iconnect.ACTION_RECONNECT_MSG".equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra("com.huawei.bone.extra.DEVICE_MAC_ADDRESS");
                C2538c.m12677c("BackgroundReceiver", "===EMUI=== iConnect's receive,macAddress----------" + stringExtra);
                Intent intent2 = new Intent(context, PhoneService.class);
                intent2.setAction("com.huawei.iconnect.ACTION_RECONNECT_MSG");
                context.startService(intent2);
                intent2 = new Intent();
                intent2.setPackage(WeChat.HEALTH_PACKAGE_NAME);
                intent2.setAction("com.huawei.iconnect.ACTION_RECONNECT_MSG");
                context.sendBroadcast(intent2);
            }
        } catch (Exception e) {
            C2538c.m12680e("BackgroundReceiver", "Exception e = " + e.getMessage());
        }
    }
}
