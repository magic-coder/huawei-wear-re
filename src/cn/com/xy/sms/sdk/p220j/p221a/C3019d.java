package cn.com.xy.sms.sdk.p220j.p221a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class C3019d extends BroadcastReceiver {
    C3019d() {
    }

    public final void onReceive(Context context, Intent intent) {
        if ("cn.com.xy.sms.iccidinfo.action".equals(intent.getAction())) {
            C3017b.m13546a(intent);
        }
    }
}
