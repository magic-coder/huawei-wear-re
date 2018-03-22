package com.huawei.phoneserviceuni.common.p491a.p492a;

import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5768d;

/* compiled from: MTKMutilSim */
public class C5751b implements C5750a {
    private static final String f19524a = C5751b.class.getSimpleName();
    private Object f19525b = m26416b();

    public String mo5103a(int i) {
        String str;
        String str2 = "";
        try {
            str = (String) C5768d.m26481a(Class.forName("com.mediatek.telephony.TelephonyManagerEx"), this.f19525b, "getDeviceId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
            c.b(f19524a, "imei ClassNotFoundException exception:");
            str = str2;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public C5752c mo5102a() {
        return C5752c.MutiCardMTK;
    }

    private Object m26416b() {
        return C5768d.m26482a("com.mediatek.telephony.TelephonyManagerEx", "getDefault", new Class[0], new Object[0]);
    }
}
