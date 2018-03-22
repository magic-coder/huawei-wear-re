package com.huawei.phoneserviceuni.common.p491a.p492a;

import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5768d;

/* compiled from: NormalMutilSim */
public class C5753d implements C5750a {
    private Object f19529a;

    public C5753d() {
        this.f19529a = null;
        this.f19529a = m26419b();
    }

    public C5752c mo5102a() {
        return C5752c.MutiCardHw;
    }

    private Object m26419b() {
        return C5768d.m26482a("android.telephony.MSimTelephonyManager", "getDefault", new Class[0], new Object[0]);
    }

    public String mo5103a(int i) {
        String str;
        String str2 = "";
        try {
            str = (String) C5768d.m26481a(Class.forName("android.telephony.MSimTelephonyManager"), this.f19529a, "getDeviceId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
            c.d("NormalMutilSim", "imei ClassNotFoundException exception:");
            str = str2;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
