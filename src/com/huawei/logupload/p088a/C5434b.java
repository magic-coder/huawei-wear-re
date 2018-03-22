package com.huawei.logupload.p088a;

import android.content.SharedPreferences;
import com.huawei.logupload.c.b;
import com.huawei.logupload.c.f;

/* compiled from: SharedPreferencesStorage */
public final class C5434b {
    private static C5434b f19265e = null;
    private String f19266a = "sys_setting";
    private String f19267b = "feedback";
    private String f19268c = "autocheck_policy";
    private String f19269d = "autocheck_starttime";

    public static synchronized C5434b m26067a() {
        C5434b c5434b;
        synchronized (C5434b.class) {
            if (f19265e == null) {
                f19265e = new C5434b();
            }
            c5434b = f19265e;
        }
        return c5434b;
    }

    private C5434b() {
    }

    public void m26068a(int i) {
        SharedPreferences sharedPreferences = b.a().b().getSharedPreferences(this.f19267b, 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(this.f19268c, i).commit();
        }
    }

    public void m26069a(long j) {
        SharedPreferences sharedPreferences = b.a().b().getSharedPreferences(this.f19267b, 4);
        if (sharedPreferences != null) {
            f.c("AppLogApi", "setAutoCheckTime日志分setAutoCheckTime" + j);
            sharedPreferences.edit().putLong(this.f19269d, j).commit();
        }
    }
}
