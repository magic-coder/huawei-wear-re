package com.huawei.appmarket.sdk.service.p372b;

import android.content.Context;
import android.net.ConnectivityManager;
import com.huawei.appmarket.sdk.foundation.p354a.p355a.C4238a;

public class C4292a {
    private static C4292a f15979b = null;
    private Context f15980a;
    private ConnectivityManager f15981c;
    private C4238a f15982d;

    public static synchronized C4292a m20708a() {
        C4292a c4292a;
        synchronized (C4292a.class) {
            c4292a = f15979b;
        }
        return c4292a;
    }

    public Context m20709b() {
        return this.f15980a;
    }

    public ConnectivityManager m20710c() {
        if (this.f15981c == null) {
            this.f15981c = (ConnectivityManager) this.f15980a.getSystemService("connectivity");
        }
        return this.f15981c;
    }

    public String m20711d() {
        return this.f15980a.getFilesDir().getAbsolutePath();
    }

    public C4238a m20712e() {
        return this.f15982d;
    }
}
