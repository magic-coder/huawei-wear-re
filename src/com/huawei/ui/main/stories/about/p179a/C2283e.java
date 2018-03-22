package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import com.huawei.ab.C0630m;
import com.huawei.p190v.C2538c;

/* compiled from: CloudServiceInteractor */
public class C2283e {
    private Context f8286a;
    private C0630m f8287b;

    public C2283e(Context context) {
        this.f8286a = context;
        if (this.f8286a != null) {
            this.f8287b = C0630m.m2297a(this.f8286a);
        }
    }

    public String m11744a() {
        String str = null;
        if (this.f8287b != null) {
            str = this.f8287b.m2303a("cloud_switch");
        }
        C2538c.m12674b("CloudServiceInteractor", "getCloudServiceStatus status = " + str);
        return str;
    }

    public void m11745a(String str) {
    }

    public void m11746b(String str) {
        C2538c.m12674b("CloudServiceInteractor", "setCloudServiceStatusToCloud status = " + str);
        if (this.f8287b != null) {
            this.f8287b.m2309a("cloud_switch", str, new C2284f(this));
        }
    }
}
