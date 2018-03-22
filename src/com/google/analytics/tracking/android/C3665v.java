package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: GANetworkReceiver */
class C3665v extends BroadcastReceiver {
    static final String f14199a = C3665v.class.getName();
    private final bd f14200b;

    C3665v(bd bdVar) {
        this.f14200b = bdVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            bd bdVar = this.f14200b;
            if (!booleanExtra) {
                z = true;
            }
            bdVar.a(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(f14199a)) {
            this.f14200b.e();
        }
    }

    public void m18378a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
    }

    public static void m18377b(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f14199a, true);
        context.sendBroadcast(intent);
    }
}
