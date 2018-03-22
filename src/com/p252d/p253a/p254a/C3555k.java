package com.p252d.p253a.p254a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: LogHandler */
public class C3555k implements C3554l {
    boolean f13561a = true;
    int f13562b = 2;

    public boolean m17877a() {
        return this.f13561a;
    }

    public boolean m17878a(int i) {
        return i >= this.f13562b;
    }

    public void m17873a(int i, String str, String str2) {
        m17874a(i, str, str2, null);
    }

    public void m17874a(int i, String str, String str2, Throwable th) {
        if (m17877a() && m17878a(i)) {
            switch (i) {
                case 2:
                    Log.v(str, str2, th);
                    return;
                case 3:
                    Log.d(str, str2, th);
                    return;
                case 4:
                    Log.i(str, str2, th);
                    return;
                case 5:
                    Log.w(str, str2, th);
                    return;
                case 6:
                    Log.e(str, str2, th);
                    return;
                case 8:
                    if (Integer.valueOf(VERSION.SDK).intValue() > 8) {
                        m17872c(str, str2, th);
                        return;
                    } else {
                        Log.e(str, str2, th);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @TargetApi(8)
    private void m17872c(String str, String str2, Throwable th) {
        Log.wtf(str, str2, th);
    }

    public void mo4207a(String str, String str2) {
        m17873a(2, str, str2);
    }

    public void mo4209b(String str, String str2) {
        m17873a(2, str, str2);
    }

    public void mo4211c(String str, String str2) {
        m17873a(5, str, str2);
    }

    public void mo4208a(String str, String str2, Throwable th) {
        m17874a(5, str, str2, th);
    }

    public void mo4212d(String str, String str2) {
        m17873a(6, str, str2);
    }

    public void mo4210b(String str, String str2, Throwable th) {
        m17874a(6, str, str2, th);
    }
}
