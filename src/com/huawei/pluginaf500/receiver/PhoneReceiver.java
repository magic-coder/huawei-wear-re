package com.huawei.pluginaf500.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class PhoneReceiver extends BroadcastReceiver {
    private static a f19637a = a.a();

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                if ("android.intent.action.PHONE_STATE".equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra("state");
                    if (stringExtra != null && stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                        f19637a.b();
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
