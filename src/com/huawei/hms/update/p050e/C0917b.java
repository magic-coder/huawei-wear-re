package com.huawei.hms.update.p050e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.C0887a;

/* compiled from: AbstractDialog */
public abstract class C0917b {
    private AlertDialog f1510a;
    private C0916a f1511b;

    protected abstract AlertDialog mo2276a();

    public void m3208a(C0916a c0916a) {
        this.f1511b = c0916a;
        if (m3213f() == null || m3213f().isFinishing()) {
            C0887a.m3098d("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        this.f1510a = mo2276a();
        this.f1510a.setCanceledOnTouchOutside(false);
        this.f1510a.setOnCancelListener(new C0918c(this));
        this.f1510a.show();
    }

    public void m3209b() {
        if (this.f1510a != null) {
            this.f1510a.cancel();
        }
    }

    public void m3210c() {
        if (this.f1510a != null) {
            this.f1510a.dismiss();
        }
    }

    protected void m3211d() {
        if (this.f1511b != null) {
            this.f1511b.mo2281a(this);
        }
    }

    protected void m3212e() {
        if (this.f1511b != null) {
            this.f1511b.mo2282b(this);
        }
    }

    protected Activity m3213f() {
        if (this.f1511b != null) {
            return this.f1511b.mo2283c();
        }
        return null;
    }

    protected int m3214g() {
        if (C0917b.m3206a(m3213f()) == 0 || VERSION.SDK_INT < 16) {
            return 3;
        }
        return 0;
    }

    private static int m3206a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }
}
