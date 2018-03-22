package com.huawei.whitebox;

import com.huawei.hwcommonmodel.application.BaseApplication;

/* compiled from: WhiteBoxManager */
public class C6169a {
    private static final Object f21622a = new Object();
    private static C6169a f21623b;
    private NdkJniUtils f21624c = new NdkJniUtils();

    private C6169a() {
    }

    public static C6169a m28546a() {
        C6169a c6169a;
        synchronized (f21622a) {
            if (f21623b == null) {
                f21623b = new C6169a();
            }
            c6169a = f21623b;
        }
        return c6169a;
    }

    public byte[] m28547a(String str) {
        if (!this.f21624c.isAuthChecked()) {
            this.f21624c.executeAuth(BaseApplication.b());
        }
        return this.f21624c.encrypt(str);
    }

    public byte[] m28548a(byte[] bArr) {
        if (!this.f21624c.isAuthChecked()) {
            this.f21624c.executeAuth(BaseApplication.b());
        }
        return this.f21624c.decrypt(bArr);
    }

    public String m28549b() {
        if (!this.f21624c.isAuthChecked()) {
            this.f21624c.executeAuth(BaseApplication.b());
        }
        return this.f21624c.getD58c0();
    }
}
