package com.huawei.hms.update.p045a.p046a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: UpdateInfo */
public class C0892c {
    public int f1435a = 0;
    public String f1436b = "";
    public int f1437c = 0;
    public String f1438d = "";

    public C0892c(int i, String str, int i2, String str2) {
        this.f1435a = i;
        this.f1436b = str;
        this.f1437c = i2;
        this.f1438d = str2;
    }

    public void m3119a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.huawei.hms.update.UPDATE_INFO", 0);
        this.f1435a = sharedPreferences.getInt("mNewVersionCode", 0);
        this.f1436b = sharedPreferences.getString("mUri", "");
        this.f1437c = sharedPreferences.getInt("mSize", 0);
        this.f1438d = sharedPreferences.getString("mHash", "");
    }

    public void m3121b(Context context) {
        Editor edit = context.getSharedPreferences("com.huawei.hms.update.UPDATE_INFO", 0).edit();
        edit.putInt("mNewVersionCode", this.f1435a);
        edit.putString("mUri", this.f1436b);
        edit.putInt("mSize", this.f1437c);
        edit.putString("mHash", this.f1438d);
        edit.commit();
    }

    public void m3122c(Context context) {
        Editor edit = context.getSharedPreferences("com.huawei.hms.update.UPDATE_INFO", 0).edit();
        edit.clear();
        edit.commit();
    }

    public boolean m3120a() {
        return this.f1435a > 0 && this.f1437c > 0 && this.f1436b != null && !this.f1436b.isEmpty();
    }
}
