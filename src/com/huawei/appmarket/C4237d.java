package com.huawei.appmarket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.appmarket.p348a.p352d.C4231n;

class C4237d extends BroadcastReceiver {
    final /* synthetic */ C4234a f15884a;

    C4237d(C4234a c4234a) {
        this.f15884a = c4234a;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (intent.getDataString() != null) {
            String substring = intent.getDataString().substring(8);
            if ("android.intent.action.PACKAGE_ADDED".equals(action) && substring != null && substring.equals("com.huawei.appmarket")) {
                this.f15884a.f15878e.sendMessage(this.f15884a.f15878e.obtainMessage(7));
                C4231n.m20511a(substring);
            }
        }
    }
}
