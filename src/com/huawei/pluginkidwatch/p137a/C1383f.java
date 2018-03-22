package com.huawei.pluginkidwatch.p137a;

import android.content.Context;
import com.huawei.ah.C0639a;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.home.HomeActivity;
import java.util.concurrent.Executors;

/* compiled from: PluginKidWatch */
public class C1383f extends C0639a {
    private static C1383f f2976a;
    private Context f2977b;
    private C1377a f2978c = C1377a.m6165a(this.f2977b);

    private C1383f(Context context) {
        this.f2977b = context.getApplicationContext();
    }

    public static C1383f m6188a(Context context) {
        if (f2976a == null) {
            f2976a = new C1383f(context);
        }
        return f2976a;
    }

    public void m6189a(int i) {
        if (C0969i.m3482a(1) && C0977d.m3535a(this.f2977b)) {
            C2538c.m12677c("KIDWATCH_PluginKidWatch", "===www=======current device type = " + i);
            C1467b.m6788c(this.f2977b, i);
            this.f2978c.m6177a(i);
        }
    }

    public void m6192b(int i) {
        if (C0969i.m3482a(1) && C0977d.m3535a(this.f2977b)) {
            C2538c.m12677c("KIDWATCH_PluginKidWatch", "deviceType = " + String.valueOf(i));
            C1467b.m6788c(this.f2977b, i);
            this.f2978c.m6181e();
        }
    }

    public boolean m6190a() {
        if (!C0969i.m3482a(1) || !C0977d.m3535a(this.f2977b)) {
            return false;
        }
        C1497q.m6945b(this.f2977b, "sharedpreferences_watch_device_code", "");
        C2538c.m12677c("KIDWATCH_PluginKidWatch", "K1 device type = ", Integer.valueOf(C1467b.m6783a(this.f2977b)));
        if (C1467b.m6783a(this.f2977b) == 0) {
            return false;
        }
        return true;
    }

    public Class<?> m6191b() {
        if (C0969i.m3482a(1) && C0977d.m3535a(this.f2977b)) {
            return HomeActivity.class;
        }
        return null;
    }

    public void m6193c() {
        if (C0969i.m3482a(1) && C0977d.m3535a(this.f2977b)) {
            Executors.newSingleThreadExecutor().execute(new C1384g(this));
            return;
        }
        C2538c.m12680e("KIDWATCH_PluginKidWatch", "getAllDeviceInfo not support");
    }

    public boolean m6194d() {
        C2538c.m12677c("KIDWATCH_PluginKidWatch", "isExistK1");
        if (C0969i.m3482a(1) && C0977d.m3535a(this.f2977b)) {
            return this.f2978c.m6178b();
        }
        C2538c.m12677c("KIDWATCH_PluginKidWatch", "isExistK1 not support 1");
        return false;
    }

    public boolean m6195e() {
        C2538c.m12677c("KIDWATCH_PluginKidWatch", "isExistK2");
        if (C0969i.m3482a(1) && C0977d.m3535a(this.f2977b)) {
            return this.f2978c.m6179c();
        }
        C2538c.m12677c("KIDWATCH_PluginKidWatch", "isExistK2 not support 1");
        return false;
    }
}
