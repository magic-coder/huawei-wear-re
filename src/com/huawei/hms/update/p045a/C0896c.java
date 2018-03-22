package com.huawei.hms.update.p045a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: DownloadRecord */
class C0896c {
    private String f1456a;
    private int f1457b;
    private String f1458c;
    private int f1459d;

    C0896c() {
    }

    public void m3130a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD", 0);
        this.f1456a = sharedPreferences.getString("mUri", "");
        this.f1457b = sharedPreferences.getInt("mSize", 0);
        this.f1458c = sharedPreferences.getString("mHash", "");
        this.f1459d = sharedPreferences.getInt("mReceived", 0);
    }

    public void m3132a(String str, int i, String str2) {
        this.f1456a = str;
        this.f1457b = i;
        this.f1458c = str2;
        this.f1459d = 0;
    }

    public void m3131a(Context context, int i) {
        this.f1459d = i;
        m3128b(context);
    }

    private void m3128b(Context context) {
        Editor edit = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD", 0).edit();
        edit.putString("mUri", this.f1456a);
        edit.putInt("mSize", this.f1457b);
        edit.putString("mHash", this.f1458c);
        edit.putInt("mReceived", this.f1459d);
        edit.commit();
    }

    public int m3129a() {
        return this.f1457b;
    }

    public int m3133b() {
        return this.f1459d;
    }

    public boolean m3134b(String str, int i, String str2) {
        if (str == null || str2 == null || this.f1456a == null || !this.f1456a.equals(str) || this.f1457b != i || this.f1458c == null || !this.f1458c.equals(str2) || this.f1459d > this.f1457b) {
            return false;
        }
        return true;
    }
}
