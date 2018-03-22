package com.huawei.feedback.p033a.p035b;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.feedback.FeedbackApi;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SharedPreferencesStorage */
public final class C0808a {
    private static C0808a f1235a = null;

    public static synchronized C0808a m2700a() {
        C0808a c0808a;
        synchronized (C0808a.class) {
            if (f1235a == null) {
                f1235a = new C0808a();
            }
            c0808a = f1235a;
        }
        return c0808a;
    }

    private C0808a() {
    }

    public String m2709b() {
        SharedPreferences sharedPreferences = FeedbackApi.getApplicationcontext().getSharedPreferences("device_info_store", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("device_token_key", "");
        }
        return "";
    }

    public String m2714c() {
        String str = "";
        return m2709b();
    }

    public synchronized void m2707a(String str) {
        FeedbackApi.getApplicationcontext().getSharedPreferences("sys_setting", 0).edit().putString("packagePath", str).commit();
    }

    public synchronized String m2718d() {
        return FeedbackApi.getApplicationcontext().getSharedPreferences("sys_setting", 0).getString("packagePath", "");
    }

    public void m2721e() {
        SharedPreferences sharedPreferences = FeedbackApi.getApplicationcontext().getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("", C1372a.m6117c(FeedbackApi.getApplicationcontext())).commit();
        }
    }

    public String m2724f() {
        SharedPreferences sharedPreferences = FeedbackApi.getApplicationcontext().getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("", "");
        }
        return "";
    }

    public void m2703a(Context context, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("autocheck_starttime", j).commit();
        }
    }

    public long m2701a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("autocheck_starttime", -1);
        }
        return -1;
    }

    public void m2711b(Context context, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("autocheck_tenminstarttime", j).commit();
        }
    }

    public long m2708b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("autocheck_tenminstarttime", -1);
        }
        return -1;
    }

    public void m2702a(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("autocheck_month", i).commit();
        }
    }

    public int m2713c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("autocheck_month", -1);
        }
        return -1;
    }

    public void m2710b(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("autocheck_wlan", i).commit();
        }
    }

    public int m2717d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("autocheck_wlan", 0);
        }
        return 0;
    }

    public void m2715c(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("autocheck_mobile", i).commit();
        }
    }

    public int m2720e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("autocheck_mobile", 0);
        }
        return 0;
    }

    public void m2719d(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("autocheck_wlan_all", i).commit();
        }
    }

    public int m2723f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("autocheck_wlan_all", 0);
        }
        return 0;
    }

    public void m2722e(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("autocheck_mobile_all", i).commit();
        }
    }

    public int m2726g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("autocheck_mobile_all", 0);
        }
        return 0;
    }

    public void m2725f(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("autocheck_policy", i).commit();
        }
    }

    public int m2727h(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("autocheck_policy", -1);
        }
        return -1;
    }

    public void m2706a(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("autoupload_flag", z).commit();
        }
    }

    public boolean m2728i(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("autoupload_flag", false);
        }
        return false;
    }

    public void m2712b(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("unlimit_iploadsize_flag", z).commit();
        }
    }

    public boolean m2729j(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean("unlimit_iploadsize_flag", false);
            }
            return false;
        }
        C1373c.m6141d("getUnlimitSizeUpload", "getUnlimitSizeUpload context null");
        return false;
    }

    public void m2716c(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("immediate_upload_flag", z).commit();
        }
    }

    public boolean m2730k(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("immediate_upload_flag", false);
        }
        return false;
    }

    public void m2704a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("multi_packagename", str).commit();
        }
    }

    public String m2731l(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("multi_packagename", "");
        }
        return "";
    }

    public Set<String> m2732m(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getStringSet("js_Domains", null);
        }
        return null;
    }

    public void m2705a(Context context, HashSet<String> hashSet) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("feedback", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putStringSet("js_Domains", hashSet).commit();
        }
    }
}
