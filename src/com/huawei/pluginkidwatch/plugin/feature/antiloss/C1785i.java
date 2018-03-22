package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.service.C1798c;

/* compiled from: AntilossActivity */
class C1785i implements ServiceConnection {
    final /* synthetic */ AntilossActivity f4934a;

    C1785i(AntilossActivity antilossActivity) {
        this.f4934a = antilossActivity;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f4934a.f4903v = null;
        C2538c.m12674b("AntilossActivity", "onServiceDisconnected... ");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4934a.f4903v = ((C1798c) iBinder).m8589a();
        C2538c.m12674b("AntilossActivity", "onServiceConnected... kidWatchService = " + this.f4934a.f4903v);
        this.f4934a.runOnUiThread(new C1786j(this));
    }
}
