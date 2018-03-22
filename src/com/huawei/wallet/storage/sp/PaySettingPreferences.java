package com.huawei.wallet.storage.sp;

import android.content.Context;
import android.content.SharedPreferences;

public final class PaySettingPreferences {
    private static PaySettingPreferences f21335a = null;
    private static final byte[] f21336c = new byte[0];
    private SharedPreferences f21337b = null;

    private PaySettingPreferences(Context context) {
        this.f21337b = context.getSharedPreferences("pay_setting", 0);
    }

    public static PaySettingPreferences m28145a(Context context) {
        PaySettingPreferences paySettingPreferences;
        synchronized (f21336c) {
            if (f21335a == null) {
                f21335a = new PaySettingPreferences(context.getApplicationContext());
            }
            paySettingPreferences = f21335a;
        }
        return paySettingPreferences;
    }

    public String m28146a(String str, String str2) {
        return this.f21337b.getString(str, str2);
    }

    public void m28147b(String str, String str2) {
        this.f21337b.edit().putString(str, str2).commit();
    }
}
