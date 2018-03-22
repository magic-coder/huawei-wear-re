package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.cy;

public class C0452q {
    private static C0452q f466a;
    private final Context f467b;
    private final cx f468c = cy.m1181b(this.f467b);

    private C0452q(Context context) {
        this.f467b = context.getApplicationContext();
    }

    public static C0452q m785a(Context context) {
        C0424f.m649a((Object) context);
        synchronized (C0452q.class) {
            if (f466a == null) {
                C0408i.m494a(context);
                f466a = new C0452q(context);
            }
        }
        return f466a;
    }

    C0446j m786a(PackageInfo packageInfo, C0446j... c0446jArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C0447k c0447k = new C0447k(packageInfo.signatures[0].toByteArray());
        while (i < c0446jArr.length) {
            if (c0446jArr[i].equals(c0447k)) {
                return c0446jArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean m787a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m788a(packageInfo, false)) {
            return true;
        }
        if (!m788a(packageInfo, true)) {
            return false;
        }
        if (C0391p.m455d(this.f467b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    public boolean m788a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C0446j a;
            if (z) {
                a = m786a(packageInfo, C0449m.f465a);
            } else {
                a = m786a(packageInfo, C0449m.f465a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean m789a(PackageManager packageManager, PackageInfo packageInfo) {
        return m787a(packageInfo);
    }
}
