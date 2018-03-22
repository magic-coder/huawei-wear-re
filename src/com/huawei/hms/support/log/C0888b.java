package com.huawei.hms.support.log;

import android.content.Context;
import com.huawei.hms.support.log.p044a.C0884a;
import com.huawei.hms.support.log.p044a.C0884a.C0883a;

/* compiled from: LogAdaptor */
public class C0888b {
    private static final C0882c f1422a = new C0883a(new C0884a());
    private int f1423b = 4;
    private String f1424c;

    public void m3102a(Context context, int i, String str) {
        this.f1423b = i;
        this.f1424c = str;
        f1422a.mo2262a(context, "HMSCore");
    }

    public boolean m3104a(int i) {
        if (i < this.f1423b) {
            return false;
        }
        return true;
    }

    public void m3101a(int i, String str, String str2) {
        if (m3104a(i)) {
            C0889d a = m3100a(i, str, str2, null);
            f1422a.mo2263a(a.m3111a() + a.m3112b(), i, str, str2);
        }
    }

    public void m3103a(String str, String str2) {
        C0889d a = m3100a(4, str, str2, null);
        f1422a.mo2263a(a.m3111a() + '\n' + a.m3112b(), 4, str, str2);
    }

    private C0889d m3100a(int i, String str, String str2, Throwable th) {
        C0889d c0889d = new C0889d(8, this.f1424c, i, str);
        c0889d.m3109a((Object) str2);
        c0889d.m3110a(th);
        return c0889d;
    }
}
