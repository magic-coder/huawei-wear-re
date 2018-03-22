package com.huawei.hwid.update.p449a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: DownloadRecord */
class C5258c {
    private String f18910a;
    private int f18911b;
    private String f18912c;
    private int f18913d;

    C5258c() {
    }

    public void m25484a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.huawei.hwid.update.DOWNLOAD_RECORD", 0);
        this.f18910a = sharedPreferences.getString("mUri", "");
        this.f18911b = sharedPreferences.getInt("mSize", 0);
        this.f18912c = sharedPreferences.getString("mHash", "");
        this.f18913d = sharedPreferences.getInt("mReceived", 0);
    }

    public void m25486a(String str, int i, String str2) {
        this.f18910a = str;
        this.f18911b = i;
        this.f18912c = str2;
        this.f18913d = 0;
    }

    public void m25485a(Context context, int i) {
        this.f18913d = i;
        m25482b(context);
    }

    private void m25482b(Context context) {
        Editor edit = context.getSharedPreferences("com.huawei.hwid.update.DOWNLOAD_RECORD", 0).edit();
        edit.putString("mUri", this.f18910a);
        edit.putInt("mSize", this.f18911b);
        edit.putString("mHash", this.f18912c);
        edit.putInt("mReceived", this.f18913d);
        edit.commit();
    }

    public int m25483a() {
        return this.f18911b;
    }

    public int m25487b() {
        return this.f18913d;
    }

    public boolean m25488b(String str, int i, String str2) {
        if (str == null || str2 == null || this.f18910a == null || !this.f18910a.equals(str) || this.f18911b != i || this.f18912c == null || !this.f18912c.equals(str2) || this.f18913d > this.f18911b) {
            return false;
        }
        return true;
    }
}
