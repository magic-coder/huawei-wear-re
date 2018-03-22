package com.huawei.pay.p484c.p485a;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.pay.p486d.p487a.C5725a;
import com.huawei.wallet.utils.PackageUtil;
import com.huawei.wallet.utils.log.LogC;

/* compiled from: UserCenterPreferences */
public final class C5724a {
    private static C5724a f19504a = null;
    private static final byte[] f19505b = new byte[0];
    private SharedPreferences f19506c = null;

    private C5724a(Context context) {
        this.f19506c = context.getSharedPreferences("payInitParams", 0);
        m26387b(context);
    }

    private void m26387b(Context context) {
        int b = PackageUtil.m28462b(context);
        int i = this.f19506c.getInt("apk_version", 0);
        if (i == 0) {
            m26391b("apk_version", b);
        } else if (b > i) {
            LogC.m28530b("updateApkVerison. lastVersion = " + i + ", currentVersion = " + b, false);
            m26391b("apk_version", b);
            m26390a("is_know_alipay_withhold_agreement");
            m26390a("is_first_remind_alipay_withhold_agreement");
        }
    }

    public static C5724a m26386a(Context context) {
        C5724a c5724a;
        if (context == null) {
            context = C5725a.m26393a().m26395b();
        }
        synchronized (f19505b) {
            if (f19504a == null) {
                f19504a = new C5724a(context.getApplicationContext());
            }
            c5724a = f19504a;
        }
        return c5724a;
    }

    public String m26389a(String str, String str2) {
        return this.f19506c.getString(str, str2);
    }

    public int m26388a(String str, int i) {
        return this.f19506c.getInt(str, i);
    }

    public void m26392b(String str, String str2) {
        this.f19506c.edit().putString(str, str2).commit();
    }

    public void m26391b(String str, int i) {
        this.f19506c.edit().putInt(str, i).commit();
    }

    public void m26390a(String str) {
        this.f19506c.edit().remove(str).commit();
    }
}
