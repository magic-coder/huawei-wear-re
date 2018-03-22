package com.huawei.membercenter.sdk.membersdklibrary.p092a.p470b.p471a;

import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5482d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5486h;

/* compiled from: MTKMutilSim */
public class C5469b implements C5468a {
    private Object f19322a = m26151b();

    public String mo4698a(int i) {
        String str;
        String str2 = "";
        try {
            str = (String) C5486h.m26193a(Class.forName("com.mediatek.telephony.TelephonyManagerEx"), this.f19322a, "getDeviceId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
            C5482d.m26183a("MTKMutilSim", "imei ClassNotFoundException exception:");
            str = str2;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public C5470c mo4697a() {
        return C5470c.MutiCardMTK;
    }

    private Object m26151b() {
        return C5486h.m26194a("com.mediatek.telephony.TelephonyManagerEx", "getDefault", new Class[0], new Object[0]);
    }
}
