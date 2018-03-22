package com.huawei.hwid.update.p449a.p450a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: UpdateInfo */
public class C5254c {
    public int f18889a = 0;
    public String f18890b = "";
    public int f18891c = 0;
    public String f18892d = "";

    public C5254c(int i, String str, int i2, String str2) {
        this.f18889a = i;
        this.f18890b = str;
        this.f18891c = i2;
        this.f18892d = str2;
    }

    public void m25473a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.huawei.hwid.update.UPDATE_INFO", 0);
        this.f18889a = sharedPreferences.getInt("mNewVersionCode", 0);
        this.f18890b = sharedPreferences.getString("mUri", "");
        this.f18891c = sharedPreferences.getInt("mSize", 0);
        this.f18892d = sharedPreferences.getString("mHash", "");
    }

    public void m25475b(Context context) {
        Editor edit = context.getSharedPreferences("com.huawei.hwid.update.UPDATE_INFO", 0).edit();
        edit.putInt("mNewVersionCode", this.f18889a);
        edit.putString("mUri", this.f18890b);
        edit.putInt("mSize", this.f18891c);
        edit.putString("mHash", this.f18892d);
        edit.commit();
    }

    public void m25476c(Context context) {
        Editor edit = context.getSharedPreferences("com.huawei.hwid.update.UPDATE_INFO", 0).edit();
        edit.clear();
        edit.commit();
    }

    public boolean m25474a() {
        return this.f18889a > 0 && this.f18891c > 0 && this.f18890b != null && !this.f18890b.isEmpty();
    }
}
