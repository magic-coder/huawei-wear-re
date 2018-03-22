package com.huawei.ui.device.p170a;

import android.content.Context;
import android.content.Intent;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationPushInteractor */
public class ae {
    private C1035a f6860a = C1035a.m4176b();

    public ae(Context context) {
    }

    public int m10300a(String str) {
        return this.f6860a.m4177a(str);
    }

    public void m10302a(String str, int i) {
        this.f6860a.m4178a(str, i);
    }

    public boolean m10304a() {
        return this.f6860a.m4187c();
    }

    public boolean m10305b() {
        return this.f6860a.m4191g();
    }

    public void m10303a(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("NotificationPushUtil", "setRotateSwitchScreenSwitchStatus() Status " + z);
        this.f6860a.m4180a(z, iBaseResponseCallback);
    }

    public void m10301a(Context context) {
        context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }
}
