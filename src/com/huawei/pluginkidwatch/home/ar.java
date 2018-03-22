package com.huawei.pluginkidwatch.home;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.C1743x;

/* compiled from: HomeActivity */
class ar extends BroadcastReceiver {
    final /* synthetic */ HomeActivity f4185a;

    ar(HomeActivity homeActivity) {
        this.f4185a = homeActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        C1723d a = C1743x.m8322a(this.f4185a).m8323a();
        if (a != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "btAdapter.getState() = " + defaultAdapter.getState() + "action = " + action);
            if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                return;
            }
            if (10 == defaultAdapter.getState()) {
                if (4 == a.m8302i()) {
                    a.m8296e();
                }
                a.m8288b(0);
                a.m8292c(9);
                this.f4185a.runOnUiThread(new as(this));
            } else if (12 == defaultAdapter.getState()) {
                if (this.f4185a.bs) {
                    if (C1492l.m6913a(this.f4185a, C1466a.m6781e())) {
                        this.f4185a.m7468H();
                    } else {
                        this.f4185a.cc = true;
                        C1492l.m6910a(this.f4185a, C1466a.m6781e());
                    }
                }
                this.f4185a.bs = false;
            }
        }
    }
}
