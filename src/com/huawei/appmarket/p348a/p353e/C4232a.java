package com.huawei.appmarket.p348a.p353e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.appmarket.C4234a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public class C4232a {
    protected SharedPreferences f15872a = C4234a.m20519a().m20523b().getSharedPreferences("is_flag", 0);

    public void m20515a(String str, String str2) {
        try {
            Editor edit = this.f15872a.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Throwable e) {
            C4241a.m20530a("BaseSharedPref", "putString error!!key:" + str, e);
        }
    }

    public String m20516b(String str, String str2) {
        try {
            str2 = this.f15872a.getString(str, str2);
        } catch (Exception e) {
            this.f15872a.edit().remove(str).commit();
        }
        return str2;
    }
}
