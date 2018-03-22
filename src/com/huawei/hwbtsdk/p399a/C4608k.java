package com.huawei.hwbtsdk.p399a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwbtsdk.p057b.p058a.C4623g;

/* compiled from: BTDeviceMgrUtil */
class C4608k extends BroadcastReceiver {
    final /* synthetic */ C4600d f16859a;

    C4608k(C4600d c4600d) {
        this.f16859a = c4600d;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) && this.f16859a.f16829c != null) {
            int state = this.f16859a.f16829c.getState();
            switch (state) {
                case 10:
                case 11:
                case 12:
                case 13:
                    synchronized (this.f16859a.f16841p) {
                        for (C4623g a : this.f16859a.f16841p) {
                            a.mo4550a(C4600d.m21907b(state));
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
