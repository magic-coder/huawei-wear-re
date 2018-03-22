package com.tencent.open.p532d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;

/* compiled from: ProGuard */
public final class C6395h {
    private static Context f22228a;

    public static final Context m29184a() {
        if (f22228a == null) {
            return null;
        }
        return f22228a;
    }

    public static final void m29185a(Context context) {
        f22228a = context;
    }

    public static final String m29186b() {
        if (C6395h.m29184a() == null) {
            return "";
        }
        return C6395h.m29184a().getPackageName();
    }

    public static final File m29187c() {
        if (C6395h.m29184a() == null) {
            return null;
        }
        return C6395h.m29184a().getFilesDir();
    }

    public static void m29188d() {
        Context a = C6395h.m29184a();
        if (a != null) {
            try {
                PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
                if (packageInfo != null) {
                    Editor edit = a.getSharedPreferences("openSdk.pref", 0).edit();
                    edit.putInt("app.vercode", packageInfo.versionCode);
                    edit.commit();
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
