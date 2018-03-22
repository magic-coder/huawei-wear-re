package com.huawei.multisimsdk.multidevicemanager.p106d;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.multisimsdk.multidevicemanager.common.InProgressData;
import com.huawei.multisimsdk.multidevicemanager.p102a.C1131b;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;

/* compiled from: SignWebPresenter */
public class C1172a {
    private static final String f2568a = C1172a.class.getSimpleName();
    private C1131b f2569b;
    private Activity f2570c;
    private InProgressData f2571d;
    private Uri f2572e;

    public C1172a(C1131b c1131b, Activity activity) {
        this.f2569b = c1131b;
        this.f2570c = activity;
    }

    public void m5240a() {
        C1183h.m5282b(f2568a, "start");
        if (this.f2570c != null) {
            Intent intent = this.f2570c.getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                this.f2572e = intent.getData();
                if (extras != null) {
                    this.f2571d = (InProgressData) extras.getParcelable("sms_data");
                }
            }
            m5242b();
        }
    }

    public void m5241a(int i) {
        if (this.f2570c != null && this.f2571d != null) {
            C1185k.m5294a(i, this.f2571d);
        }
    }

    public void m5242b() {
        if (this.f2572e != null) {
            this.f2569b.loadWebUrl(this.f2572e.toString());
        } else {
            C1183h.m5282b(f2568a, " uri is null");
        }
    }
}
